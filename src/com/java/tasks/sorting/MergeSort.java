package com.java.tasks.sorting;

import java.util.Arrays;

/**
 * Сортировка слиянием
 * Изначальный массив делится пополам до тех пор, пока длина подмассивов не станет равна 1.
 * Это - базовый случай. Затем элементы двух подмассивов сравниваются и заносятся в результирующий массив в порядке возрастания.
 * Сложность: O(N * logN)
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] initialArray = {3, 6, 1, 4, 2, 8, 5, 9, 7};

        System.out.println(Arrays.toString(mergeSortByRecursion(initialArray)));
    }

    public static int[] mergeSortByRecursion(int[] sourceArray) {
        if (sourceArray.length <= 1) return sourceArray;
        int[] leftSubArray = Arrays.copyOfRange(sourceArray, 0, sourceArray.length / 2);
        int[] rightSubArray = Arrays.copyOfRange(sourceArray, leftSubArray.length, sourceArray.length);
        return merge(mergeSortByRecursion(leftSubArray), mergeSortByRecursion(rightSubArray));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int k = 0, i = 0, j = 0; k < result.length; k++)
            result[k] = i < left.length && (j == right.length || left[i] < right[j]) ? left[i++] : right[j++];
        return result;
    }
}
