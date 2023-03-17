package org.example.udf;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import static org.example.udf.Function.combineStrings;

public class FunctionTest {

    @Test
    public void shouldCombineStrings() {
        String expected = "Hello world";
        String actual = combineStrings("Hello ", "world");
        assertEquals(expected, actual);
    }

}
