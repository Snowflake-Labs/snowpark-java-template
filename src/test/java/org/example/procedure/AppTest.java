package org.example.procedure;

import static org.junit.Assert.assertEquals;

import org.example.util.LocalSession;
import org.junit.Before;
import org.junit.Test;

import com.snowflake.snowpark_java.Session;

public class AppTest {
    Session session;

    @Before
    public void intialize() {
        this.session = LocalSession.getSession();
    }

    @Test
    public void shouldreturn2()
    {
        Long expected = 2L;
        Long actual = App.run(session);
        assertEquals(expected, actual);
    }
}
