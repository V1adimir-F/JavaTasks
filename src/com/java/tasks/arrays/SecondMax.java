package com.java.tasks.arrays;

/**
 * Найти второе по величине число в массиве
 */
public class SecondMax {

    public static void main(String[] args) {
        int[] numbersArray = {10, 15, 32, 100, 16, 100, 11, 98, 36, 95, 33};

        System.out.println(getSecondMax(numbersArray));
    }

    private static int getSecondMax(int[] array) {
        int biggest = array[0];
        int secondBiggest = array[0];

        for (int number : array) {
            if (number > biggest) {
                secondBiggest = biggest;
                biggest = number;
            } else if (number > secondBiggest && number != biggest) {
                secondBiggest = number;
            }
        }
        return secondBiggest;
    }
}
