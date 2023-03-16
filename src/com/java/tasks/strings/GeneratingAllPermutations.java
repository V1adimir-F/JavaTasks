package com.java.tasks.strings;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Генерирование всех перестановок
 */
public class GeneratingAllPermutations {
    public static void main(String[] args) {
        permuteAndPrint("", "ABC");
        System.out.println();
        System.out.println(permuteAndStore("", "TEST"));
        System.out.println(permuteAndPrintWithStream("", "TEST"));
    }

    private static void permuteAndPrint(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            System.out.print(prefix + " ");
        } else {
            for (int i = 0; i < n; i++) {
                permuteAndPrint(prefix + str.charAt(i), str.substring(i + 1, n) + str.substring(0, i));
            }
        }
    }

    private static Set<String> permuteAndStore(String prefix, String str) {
        Set<String> permutations = new HashSet<>();
        int n = str.length();
        if (n == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutations.addAll(permuteAndStore(prefix + str.charAt(i), str.substring(i + 1, n) + str.substring(0, i)));
            }
        }
        return permutations;
    }

    private static Set<String> permuteAndPrintWithStream(String prefix, String str) {
        Set<String> permutations = new HashSet<>();
        int n = str.length();
        if (n == 0) {
            permutations.add(prefix);
        } else {
            IntStream.range(0, n)
                    .parallel()
                    .forEach(i -> permutations.addAll(permuteAndPrintWithStream(prefix + str.charAt(i), str.substring(i + 1, n) + str.substring(0, i))));
        }
        return permutations;
    }
}
