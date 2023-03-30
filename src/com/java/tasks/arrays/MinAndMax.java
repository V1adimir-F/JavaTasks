package com.java.tasks.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Найти минимальный и максимальный элементы в массиве
 */
public class MinAndMax {

    public static void main(String[] args) {
        int[] array = {6, 8, 3, 5, 1, 9};

        System.out.println(getMinWithStreamApi(array));
        System.out.println(getMaxWithIntStream(array));
        System.out.println(getMaxWithSummaryStatistics(array));
    }

    private static int getMinWithStreamApi(int[] array) {
        return Arrays.stream(array)
                .min()
                .orElseThrow();
    }

    private static int getMaxWithIntStream(int[] array) {
        return IntStream.range(0, array.length)
                .map(i -> array[i])
                .max()
                .orElseThrow();
    }

    private static int getMaxWithSummaryStatistics(int[] array) {
        return Arrays.stream(array)
                .summaryStatistics()
                .getMax();
    }
}
