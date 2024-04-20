package org.ic4j.samples.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;

import org.ic4j.agent.Agent;
import org.ic4j.agent.AgentBuilder;
import org.ic4j.agent.ReplicaTransport;
import org.ic4j.agent.UpdateBuilder;
import org.ic4j.agent.Waiter;
import org.ic4j.agent.http.ReplicaJavaHttpTransport;
import org.ic4j.candid.jdbc.JDBCSerializer;
import org.ic4j.candid.parser.IDLArgs;
import org.ic4j.candid.parser.IDLValue;
import org.ic4j.types.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	static String PROPERTIES_FILE_NAME = "application.properties";
	static String urlConnection = "jdbc:derby:dfinity;create=true";
	static Connection connection;

	static Logger LOG = LoggerFactory.getLogger(Main.class);

	static void setup() {
		try {
			connection = DriverManager.getConnection(urlConnection);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e);
		}
		try {
			Statement statement = connection.createStatement();
			String sql = "DROP TABLE data";
			statement.execute(sql);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e);
		}

		try {
			Statement statement = connection.createStatement();
			String sql = "CREATE TABLE data (ssn VARCHAR(11) PRIMARY KEY,rating INT)";
			statement.execute(sql);
			sql = "INSERT INTO data VALUES ('111-11-1111',550)";
			statement.execute(sql);
			sql = "INSERT INTO data VALUES ('222-22-2222',650)";
			statement.execute(sql);
			sql = "INSERT INTO data VALUES ('333-33-3333',750)";
			statement.execute(sql);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e);
		}
	}

	public static void main(String[] args) {
		try {
			InputStream propInputStream = Main.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME);

			Properties env = new Properties();
			env.load(propInputStream);

			setup();

			PreparedStatement statement = connection.prepareStatement("SELECT ssn, rating FROM data WHERE ssn = ?");

			String ssn = "222-22-2222";
			statement.setString(1, ssn);
			ResultSet result = statement.executeQuery();

			String icLocation = env.getProperty("ic.location");
			String icCanister = env.getProperty("ic.canister");

			ReplicaTransport transport = ReplicaJavaHttpTransport.create(icLocation);
			Agent agent = new AgentBuilder().transport(transport).build();

			IDLValue idlValue = IDLValue.create(result, JDBCSerializer.create().array(false));
			List<IDLValue> idlArgs = new ArrayList<IDLValue>();
			idlArgs.add(idlValue);

			byte[] buf = IDLArgs.create(idlArgs).toBytes();

			CompletableFuture<byte[]> response = UpdateBuilder.create(agent, Principal.fromString(icCanister), "setCredit").arg(buf)
					.callAndWait(Waiter.create(60, 5));

			byte[] output = response.get();

			Short rating = result.getShort("rating");
			LOG.info("Rating is set to " + rating);

		} catch (Throwable e) {
			LOG.error(e.getLocalizedMessage(), e);
		}
	}

}
