package org.ic4j.samples.android.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import org.ic4j.agent.*
import org.ic4j.agent.http.ReplicaApacheHttpTransport

import org.ic4j.agent.http.ReplicaOkHttpTransport
import org.ic4j.agent.identity.AnonymousIdentity
import org.ic4j.agent.identity.Identity
import org.ic4j.candid.parser.IDLArgs
import org.ic4j.candid.parser.IDLValue
import org.ic4j.types.Principal
import java.util.*
import kotlin.concurrent.thread

const val EXTRA_MESSAGE = "org.ic4j.samples.android.helloworld.MESSAGE"

class MainActivity : AppCompatActivity() {
    lateinit var name : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        thread(start = true)
        {
            val url: String = getString(R.string.url)
            val canister: String = getString(R.string.canister)

            val identity: Identity = AnonymousIdentity()
            val transport: ReplicaTransport =
                ReplicaOkHttpTransport.create(url)

            val agent: Agent = AgentBuilder().identity(identity).transport(transport).build()

            val buf = IDLArgs.create(ArrayList<IDLValue>()).toBytes()

            val principal = Principal.fromString(canister);

            val response = QueryBuilder.create(
                        agent,
                        principal,
                        "peek"
                    ).arg(buf).call()

            val output = response.get()

            val outArgs = IDLArgs.fromBytes(output)

            name = outArgs.args[0].getValue<String>()

            println("Query peek result:$name")
        }
    }


    /** Called when the user taps the Send button */
    fun sendMessage(view: View) {
        val editText = findViewById<EditText>(R.id.editTextTextPersonName)
        val message = editText.text.toString()

        thread(start = true)
        {
            val url : String = getString(R.string.url)
            val canister : String = getString(R.string.canister)

            val identity : Identity = AnonymousIdentity()
            val transport: ReplicaTransport =
                ReplicaOkHttpTransport.create(url)
            val agent: Agent = AgentBuilder().identity(identity).transport(transport).build()

            val arg : IDLValue = IDLValue.create(message)
            var args : ArrayList<IDLValue> = ArrayList<IDLValue>()

            args.add(arg)

            val buf = IDLArgs.create(args).toBytes()


            val response = UpdateBuilder.create(
                        agent,
                        Principal.fromString(canister),
                        "greet"
                    ).arg(buf).callAndWait(Waiter.create(60, 5))

            val output = response.get()

            val outArgs = IDLArgs.fromBytes(output)

            val outputMessage = outArgs.args[0].getValue<String>()

            println("Update greet result:$outputMessage")


            val intent = Intent(this, DisplayMessageActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, outputMessage)
            }
            startActivity(intent)

        }

    }
}