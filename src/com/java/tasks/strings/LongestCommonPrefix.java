package com.java.tasks.strings;

/**
 * Поиск наибольшего общего префикса
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] arrayOfStrings = {"abc", "abcd", "abcde", "ab", "abcdef"};

        System.out.println(findPrefix(arrayOfStrings));
    }

    private static String findPrefix(String[] strings) {
        if (strings.length == 1) {
            return strings[0];
        }

        int firstLength = strings[0].length();

        for (int prefixLength = 0; prefixLength < firstLength; prefixLength++) {
            char ch = strings[0].charAt(prefixLength);
            for (int i = 1; i < strings.length; i++) {
                if (prefixLength >= strings[i].length() || strings[i].charAt(prefixLength) != ch) {
                    return strings[i].substring(0, prefixLength);
                }
            }
        }
        return strings[0];
    }
}
