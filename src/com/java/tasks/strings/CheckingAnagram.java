package com.java.tasks.strings;

/**
 * Проверка, являются ли две строки анаграммами.
 * Две строки, имеющие одинаковые символы, но расположенные в другом порядке, являются анаграммами.
 */
public class CheckingAnagram {

    private static final int EXTENDED_ASCII_CODES = 256;

    public static void main(String[] args) {
        String firstStr = "Hello";
        String secondStr = "oehll";

        System.out.println(isAnagram(firstStr, secondStr));
    }

    private static boolean isAnagram(String stringFirst, String stringSecond) {
        int[] charCounts = new int[EXTENDED_ASCII_CODES];
        char[] stringFirstChars = stringFirst.replaceAll("\\s", "").toLowerCase().toCharArray();
        char[] stringSecondChars = stringSecond.replaceAll("\\s", "").toLowerCase().toCharArray();

        if (stringFirstChars.length != stringSecondChars.length) {
            return false;
        }
        for (int i = 0; i < stringFirstChars.length; i++) {
            charCounts[stringFirstChars[i]]++;
            charCounts[stringSecondChars[i]]--;
        }
        for (int charCount : charCounts) {
            if (charCount != 0) {
                return false;
            }
        }
        return true;
    }
}
