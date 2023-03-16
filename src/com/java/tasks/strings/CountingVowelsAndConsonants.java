package com.java.tasks.strings;

import java.util.*;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.partitioningBy;

/**
 * Подсчет гласных и согласных английского алфавита в заданной строке
 */
public class CountingVowelsAndConsonants {

    private static final Set<Character> ALL_VOWELS = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));


    public static void main(String[] args) {
        String testString = "abbefffio";

        System.out.println(getCountVowelsAndConsonants(testString));
        System.out.println(getCountVowelsAndConsonantsWithStreamApi(testString));
        System.out.println(getCountVowelsAndConsonantsWithPartitioningBy(testString));
    }

    private static Map<String, Integer> getCountVowelsAndConsonants(String str) {
        str = str.toLowerCase();
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ALL_VOWELS.contains(ch)) {
                vowels++;
            } else if (ch >= 'a' && ch <= 'z') {
                consonants++;
            }
        }

        return Map.of("vowels", vowels, "consonants", consonants);
    }

    private static Map<String, Long> getCountVowelsAndConsonantsWithStreamApi(String str) {
        str = str.toLowerCase();

        long vowels = str.chars()
                .filter(c -> ALL_VOWELS.contains((char) c))
                .count();

        long consonants = str.chars()
                .filter(c -> !ALL_VOWELS.contains((char) c))
                .filter(ch -> (ch >= 'a' && ch<= 'z'))
                .count();

        return Map.of("vowels", vowels, "consonants", consonants);
    }

    private static Map<String, Long> getCountVowelsAndConsonantsWithPartitioningBy(String str) {
        Map<Boolean, Long> result = str.chars()
                .mapToObj(c -> (char) c)
                .filter(ch -> (ch >= 'a' && ch <= 'z'))
                .collect(partitioningBy(ALL_VOWELS::contains, counting()));

        return Map.of("vowels", result.get(true), "consonants", result.get(false));
    }
}
