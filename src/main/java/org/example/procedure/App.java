package org.example.procedure;

import org.example.util.LocalSession;
import com.snowflake.snowpark_java.*;
import com.snowflake.snowpark_java.types.*;
import org.example.udf.Function;


public class App {

    /**
     * A simple stored procedure which creates a 2x2 DataFrame, prints it
     * to the console, and returns the row count.
     * @param session A Snowflake Session
     * @return The count of the DataFrame
     */
    public static Long run(Session session) {

        DataFrame df = session.createDataFrame(
            new Row[]{
                Row.create("Welcome to ", "Snowflake!"),
                Row.create("Learn more: ", "https://www.snowflake.com/snowpark/")
            },
            StructType.create(
                new StructField("Hello", DataTypes.StringType),
                new StructField("World", DataTypes.StringType))
        );

        UserDefinedFunction combine = session.udf().registerTemporary(
            (String a, String b) -> Function.combineStrings(a,b),
            new DataType[]{DataTypes.StringType, DataTypes.StringType},
            DataTypes.StringType);

        DataFrame df2 = df.select(
            combine.apply(
                Functions.col("Hello"),
                Functions.col("World")).as("Hello world")
            ).sort(Functions.col("Hello world").desc());

        df2.show();

        return df.count();
    }

    /**
     * Main entrypoint. Runs the stored procedure locally for development.
     * @param args
     */
    public static void main(String[] args) {
        Session session = LocalSession.getSession();

        App.run(session);
    }
}
