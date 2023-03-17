package org.example.udf;

import java.io.Serializable;

public class Function implements Serializable {

    /**
     * A simple user-defined function which concatenates two strings.
     * @param a String a
     * @param b String b
     * @return a concatenated with b
     */
    public static String combineStrings(String a, String b) {
        return a.concat(b);
    }
}
