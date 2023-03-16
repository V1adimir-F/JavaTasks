package com.java.tasks.strings;

/**
 * Удаление пробелов из строки
 * \s удаляет все пробелы, включая невидимые, такие как \t, \n и \r:
 */
public class RemovingSpaces {

    public static void main(String[] args) {
        String testString = " some test string with spaces ";

        System.out.println(removeWhitespaces(testString));
    }

    private static String removeWhitespaces(String str) {
        return str.replaceAll("\\s", "");
    }

}
