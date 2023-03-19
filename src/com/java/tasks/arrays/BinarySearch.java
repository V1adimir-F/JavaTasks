package com.java.tasks.arrays;

/**
 * Бинарный поиск
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] testArray = new int[] {1,2,3,4,5,6,7,8};
        int testNumber = 7;

        System.out.println(isExists(testArray, testNumber));
    }

    private static boolean isExists(int[] array, int element) {
        int leftIndex = 0;
        int rightIndex = array.length;

        while (leftIndex < rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            if (array[middleIndex] == element) {
                return true;
            } else if (array[middleIndex] < element) {
                leftIndex = middleIndex + 1;
            } else {
                rightIndex = middleIndex;
            }
        }
        return false;
    }
}
