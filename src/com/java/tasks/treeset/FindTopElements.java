package com.java.tasks.treeset;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Поиск верхних K элементов в массиве.
 * Временная сложность этого решения равна O (n * log n).
 * Решение работает только для входного массива с различными значениями.
 */
public class FindTopElements {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>(Arrays.asList(1,9,4,7,6,5,8,3));

        System.out.println(find(integerList, 3));
    }

    private static List<Integer> find(List<Integer> input, int count) {
        Set<Integer> sortedSet = new TreeSet<>(Comparator.reverseOrder());
        sortedSet.addAll(input);

        return sortedSet.stream()
                .limit(count)
                .collect(Collectors.toList());
    }
}
