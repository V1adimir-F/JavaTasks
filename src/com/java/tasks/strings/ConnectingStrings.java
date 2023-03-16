package com.java.tasks.strings;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * Соединение нескольких строк с помощью разделителя
 */
public class ConnectingStrings {

    public static void main(String[] args) {
        System.out.println(joinByDelimiter('-', "one", "two", "three"));
        System.out.println(joinByDelimiterWithStringJoiner('-', "one", "two", "three"));
        System.out.println(joinByDelimiterWithStreamApi('-', "one", "two", "three"));
    }

    private static String joinByDelimiter(char delimiter, String...args) {
        StringBuilder result = new StringBuilder();
        int i;
        for (i = 0; i < args.length - 1; i++) {
            result.append(args[i]).append(delimiter);
        }
        result.append(args[i]);
        return result.toString();
    }

    private static String joinByDelimiterWithStringJoiner(char delimiter, String...args) {
        StringJoiner joiner = new StringJoiner(String.valueOf(delimiter));
        for (String arg: args) {
            joiner.add(arg);
        }
        return joiner.toString();
    }

    private static String joinByDelimiterWithStreamApi(char delimiter, String...args) {
        return Arrays.stream(args, 0, args.length)
                .collect(Collectors.joining(String.valueOf(delimiter)));
    }
}
