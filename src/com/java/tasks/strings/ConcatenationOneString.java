package com.java.tasks.strings;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Конкатенация одной и той же строки n раз
 */
public class ConcatenationOneString {

    public static void main(String[] args) {
        String testString = "test";
        final int joinCount = 3;

        System.out.println(concatString(testString, joinCount));
        System.out.println(concatStringWithJoin(testString, joinCount));
        System.out.println(concatStringWithStreamApi(testString, joinCount));
        System.out.println(concatStringWithStringFormat(testString, joinCount));
        System.out.println(concatStringWithCharArray(testString, joinCount));
    }

    private static String concatString(String str, int count) {
        return str.repeat(count);
    }

    private static String concatStringWithJoin(String str, int count) {
        return String.join("", Collections.nCopies(count, str));
    }

    private static String concatStringWithStreamApi(String str, int count) {
        return Stream.generate(() -> str)
                .limit(count)
                .collect(Collectors.joining());
    }

    private static String concatStringWithStringFormat(String str, int count) {
        return String.format("%0" + count + "d", 0).replace("0", str);
    }

    private static String concatStringWithCharArray(String str, int count) {
        return String.valueOf(new char[count]).replace("\0", str);
    }
}
