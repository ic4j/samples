package org.ic4j.samples.helloworld;

import static org.junit.Assert.*;
import java.lang.reflect.Method;
import org.ic4j.agent.annotations.UPDATE;
import org.ic4j.agent.annotations.Argument;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.junit.Test;

public class HelloWorldProxyOfflineTest {
    @Test public void greetIsWireMappedAsTextUpdate() throws Exception {
        Method greet = HelloWorldProxy.class.getMethod("greet", String.class);
        assertNotNull(greet.getAnnotation(UPDATE.class));
        assertEquals("greet", greet.getAnnotation(Name.class).value());
        Argument argument = greet.getParameterAnnotations()[0].length == 0 ? null
                : (Argument) greet.getParameterAnnotations()[0][0];
        assertNotNull(argument);
        assertEquals(Type.TEXT, argument.value());
    }
}
