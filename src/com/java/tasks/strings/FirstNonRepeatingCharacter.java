package com.java.tasks.strings;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Отыскание первого неповторяющегося символа
 */
public class FirstNonRepeatingCharacter {

    private static final int EXTENDED_ASCII_CODES = 256;

    public static void main(String[] args) {
        String characters = "aagccdeef";

        char nonRepeatedChar = firstNonRepeatedCharacter(characters);
        System.out.println(nonRepeatedChar);

        nonRepeatedChar = firstNonRepeatedCharacterWithLinkedHashMap(characters);
        System.out.println(nonRepeatedChar);

        String nonRepeatedCharAsString = firstNonRepeatedCharacterWithStreamApi(characters);
        System.out.println(nonRepeatedCharAsString);
    }

    private static char firstNonRepeatedCharacter(String str) {
        int[] flags = new int[EXTENDED_ASCII_CODES];
        Arrays.fill(flags, -1);

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (flags[ch] == -1) {
                flags[ch] = i;
            } else {
                flags[ch] = -2;
            }
        }

        int position = Integer.MAX_VALUE;

        for (int i = 0; i < EXTENDED_ASCII_CODES; i++) {
            if (flags[i] >= 0) {
                position = Math.min(position, flags[i]);
            }
        }

        return position == Integer.MAX_VALUE ?
                Character.MIN_VALUE : str.charAt(position);
    }

    private static char firstNonRepeatedCharacterWithLinkedHashMap(String str) {
        Map<Character, Integer> chars = new LinkedHashMap<>() ;

        for (char ch: str.toCharArray()) {
            chars.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }

        for (Map.Entry<Character, Integer> entry: chars.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return Character.MIN_VALUE;
    }

    private static String firstNonRepeatedCharacterWithStreamApi(String str) {
        Map<Integer, Long> characters = str.codePoints()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new, Collectors.counting()));

        int cp = characters.entrySet().stream()
                .filter(e -> e.getValue() == 1L)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse((int) Character.MIN_VALUE);

        return String.valueOf(Character.toChars(cp));
    }
}
