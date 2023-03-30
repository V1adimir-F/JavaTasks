package com.java.tasks.arrays;

/**
 * Дан упорядоченный массив arr и число X,
 * нужно найти индекс максимального элемента arr, не превосходящего X.
 * Если такого элемента не существует, вернуть -1.
 */
public class MaxLowerOrEqual {

    public static void main(String[] args) {
        int[] array = new int[] {1,3,5,7,9,11,13,15};
        System.out.println(calculate(array, 12));
    }

    private static int calculate(int[] sortedArray, int element) {
        if (sortedArray.length == 0 || sortedArray[0] > element) {
            return -1;
        }

        int leftIndex = 0;
        int rightIndex = sortedArray.length;
        while (leftIndex + 1 < rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            if (sortedArray[middleIndex] <= element) {
                leftIndex = middleIndex;
            } else {
                rightIndex = middleIndex;
            }
        }
        return leftIndex;
    }
}
