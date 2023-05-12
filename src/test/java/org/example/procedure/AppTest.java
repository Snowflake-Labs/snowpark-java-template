package org.example.procedure;

import static org.junit.Assert.assertEquals;

import org.example.util.LocalSession;
import org.junit.Before;
import org.junit.Test;

import com.snowflake.snowpark_java.DataFrame;
import com.snowflake.snowpark_java.Row;
import com.snowflake.snowpark_java.Session;
import com.snowflake.snowpark_java.types.DataTypes;
import com.snowflake.snowpark_java.types.StructField;
import com.snowflake.snowpark_java.types.StructType;

public class AppTest {
    Session session;

    @Before
    public void intialize() {
        this.session = LocalSession.getSession();
    }

    @Test
    public void testApp()
    {
        DataFrame expected = session.createDataFrame(
            new Row[]{
                Row.create("Welcome to Snowflake!"),
                Row.create("Learn more: https://www.snowflake.com/snowpark/")
            },
            StructType.create(
                new StructField("hello_world", DataTypes.StringType))
        );

        DataFrame actual = App.run(session);

        assertEquals(expected.collect()[0], actual.collect()[0]);  // Assert first rows are equal
    }
}
