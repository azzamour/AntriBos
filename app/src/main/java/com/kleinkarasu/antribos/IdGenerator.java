package com.kleinkarasu.antribos;

/**
 * Created by Muhammad Azzam on 23/10/2017.
 */

public class IdGenerator {
    private static String result;

    public static String generate(String identifier, Long number) {
        result = identifier + String.format("%03d", number);
        return result;
    }
}
