package com.java.tasks.arrays;

/**
 * Дан массив целых чисел arr и целое число X.
 * Определите, существует ли в массиве такой непрерывный подмассив, что сумма его элементов равна X.
 */
public class SumOfElementsInSubarray {

    public static void main(String[] args) {
        int[] testArray = new int[] {1, 2, 3, 4, 6};
        int testSum = 9;
        System.out.println(isSubarrayExists(testArray, testSum));
    }

    private static boolean isSubarrayExists(int[] array, int sum) {
        int rightIndex = 0;
        int currentSum = 0;

        for (int leftIndex = 0; leftIndex < array.length; leftIndex++) {
            if (leftIndex > 0) {
                currentSum -= array[leftIndex - 1];
            }
            while (rightIndex < array.length && currentSum < sum) {
                currentSum += array[rightIndex];
                rightIndex++;
            }
            if (currentSum == sum) {
                return true;
            }
        }
        return false;
    }
}
