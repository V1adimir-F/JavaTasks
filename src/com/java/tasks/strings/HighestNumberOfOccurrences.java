package com.java.tasks.strings;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Отыскание символа с наибольшим числом появлений
 */
public class HighestNumberOfOccurrences {

    private static final int EXTENDED_ASCII_CODES = 256;

    public static void main(String[] args) {
        String testString = "aaabbXXXXde";
        System.out.println(maxOccurrenceCharacter(testString));
        System.out.println(maxOccurrenceCharacterWithASCIICodes(testString));
        System.out.println(maxOccurrenceCharacterWithStreamApi(testString));
    }

    public static Map.Entry<Character, Integer> maxOccurrenceCharacter(String str) {
        Map<Character, Integer> counter = new HashMap<>();
        char[] charArray = str.toCharArray();
        for (char currentChar : charArray) {
            if (!Character.isWhitespace(currentChar)) { // игнорирование пробелов
                Integer charCount = counter.get(currentChar);
                if (charCount == null) {
                    counter.put(currentChar, 1);
                } else {
                    counter.put(currentChar, ++charCount);
                }
            }
        }

        int maxOccurrences = Collections.max(counter.values());
        char maxCharacter = Character.MIN_VALUE;

        for (Map.Entry<Character, Integer> entry: counter.entrySet()) {
            if (entry.getValue() == maxOccurrences) {
                maxCharacter = entry.getKey();
            }
        }

        return Map.entry(maxCharacter, maxOccurrences);
    }

    public static Map.Entry<Character, Integer> maxOccurrenceCharacterWithASCIICodes(String str) {
        int maxOccurrences = -1;
        char maxCharacter = Character.MIN_VALUE;
        char[] charArray = str.toCharArray();
        int[] asciiCodes = new int[EXTENDED_ASCII_CODES];
        for (char currentChar : charArray) {
            if (!Character.isWhitespace(currentChar)) { // игнорирование пробела
                asciiCodes[currentChar]++;
                if (asciiCodes[currentChar] > maxOccurrences) {
                    maxOccurrences = asciiCodes[currentChar];
                    maxCharacter = currentChar;
                }
            }
        }
        return Map.entry(maxCharacter, maxOccurrences);
    }

    public static Map.Entry<Character, Long> maxOccurrenceCharacterWithStreamApi(String str) {
        return str.chars()
                .filter(c -> !Character.isWhitespace(c)) // игнорирование пробела
                .mapToObj(c -> (char) c)
                .collect(groupingBy(c -> c, counting()))
                .entrySet()
                .stream()
                .max(comparingByValue())
                .map(entry -> Map.entry(entry.getKey(), entry.getValue()))
                .orElse(Map.entry(Character.MIN_VALUE, -1L));
    }
}
