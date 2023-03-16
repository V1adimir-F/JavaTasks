package com.java.tasks.strings;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Инвертирование букв и слов
 */
public class InvertingLettersAndWords {

    private static final String WHITESPACE = " ";
    private static final Pattern PATTERN = Pattern.compile(" +");

    public static void main(String[] args) {
        String initialString = "some testing string";

        System.out.println(reverseWords(initialString));
        System.out.println(reverseString(initialString));
        System.out.println(reverseWordsWithStreamApi(initialString));
        System.out.println(reverseWordsAndCharactersWithStreamApi(initialString));
    }

    private static String reverseWords(String str) {
        String[] words = str.split(WHITESPACE);

        StringBuilder reversedString = new StringBuilder();
        for (String word: words) {
            StringBuilder reverseWord = new StringBuilder();
            for (int i = word.length() - 1; i >= 0; i--) {
                reverseWord.append(word.charAt(i));
            }
            reversedString.append(reverseWord).append(WHITESPACE);
        }
        return reversedString.toString();
    }

    private static String reverseString(String str) {
        String[] words = str.split(WHITESPACE);

        StringBuilder reversedString = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversedString.append(words[i]).append(WHITESPACE);
        }
        return reversedString.toString();
    }

    private static String reverseWordsWithStreamApi(String str) {
        return PATTERN.splitAsStream(str)
                .map(word -> new StringBuilder(word).reverse())
                .collect(Collectors.joining (" "));
    }

    private static String reverseWordsAndCharactersWithStreamApi(String str) {
        return new StringBuilder(str).reverse().toString ();
    }
}
