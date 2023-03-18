package com.java.tasks.strings;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Сортировка массива строк по длине
 */
public class SortingStringsByLength {

    private enum Sort {
        ASC,
        DESC
    }

    public static void main(String[] args) {
        String[] testStringArray = new String[] {"Some", "testing", "string"};

        sortArrayByLength(testStringArray, Sort.ASC);
        System.out.println(Arrays.toString(testStringArray));

        testStringArray = new String[] {"Some", "testing", "string"};
        sortArrayByLengthWithComparingInt(testStringArray, Sort.ASC);
        System.out.println(Arrays.toString(testStringArray));

        testStringArray = new String[] {"Some", "testing", "string"};
        System.out.println(Arrays.toString(sortArrayByLengthWithStreamApi(testStringArray, Sort.ASC)));
    }

    private static void sortArrayByLength(String[] stringArray, Sort direction) {
        if (direction.equals(Sort.ASC)) {
            Arrays.sort(stringArray, (String s1, String s2) -> Integer.compare(s1.length(), s2.length()));
        } else {
            Arrays.sort(stringArray, (String si, String s2) -> (-1) * Integer.compare(si.length(), s2.length()));
        }
    }

    private static void sortArrayByLengthWithComparingInt(String[] stringArray, Sort direction) {
        switch (direction) {
            case ASC -> Arrays.sort(stringArray, Comparator.comparingInt(String::length));
            case DESC -> Arrays.sort(stringArray, Comparator.comparingInt(String::length).reversed());
        }
    }

    private static String[] sortArrayByLengthWithStreamApi(String[] stringArray, Sort direction) {
        return switch (direction) {
            case ASC -> Arrays.stream(stringArray)
                    .sorted(Comparator.comparingInt(String::length))
                    .toArray(String[]::new);
            case DESC -> Arrays.stream(stringArray)
                    .sorted(Comparator.comparingInt(String::length).reversed())
                    .toArray(String[]::new);
        };
    }
}
