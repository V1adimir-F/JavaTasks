package com.java.tasks.arrays;

import java.util.stream.IntStream;

/**
 * Проверить, отсортирован ли массив
 */
public class CheckIfSorted {

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5 };

        System.out.println(isSorted(a));
        System.out.println(isSortedWithStreamApi(a));
        System.out.println(isSortedWithRecursion(a, a.length));
    }

    private static boolean isSorted(int[] array) {
        if (array == null || array.length <= 1) {
            return true;
        }

        for (int i = 0; i < array.length - 1; i++)
        {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }

        return true;
    }

    private static boolean isSortedWithStreamApi(int[] array) {
        if (array == null || array.length <= 1) {
            return true;
        }

        return IntStream
                .range(0, array.length - 1)
                .noneMatch(i -> array[i] > array[i + 1]);
    }

    private static boolean isSortedWithRecursion(int[] array, int index) {
        if (array == null || array.length <= 1 || index == 1) {
            return true;
        }

        if (array[index - 1] < array[index - 2]) {
            return false;
        }

        return isSortedWithRecursion(array, index - 1);
    }
}
