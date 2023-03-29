package com.java.tasks.numbers;

/**
 * Необходимо проверить, является ли введенное число - числом Армстронга
 * Число Армстронга это число, значение которого равно сумме цифр, из которых оно состоит, возведенных в степень, равную количеству цифр в этом числе.
 * Пример - число 371: 371 = 3*3*3 + 7*7*7 + 1*1*1 = 27 + 343 + 1 = 371
 * число 8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8 = 4096 + 16 + 0 + 4096 = 8208
 */
public class ArmstrongNumber {

    public static void main(String[] args) {
        System.out.println(isArmstrongNumber(371));
    }

    private static boolean isArmstrongNumber(int value) {
        int result = 0;
        int digit;
        int tempNumber = value;

        while (tempNumber > 0) {
            digit = tempNumber % 10;
            tempNumber = tempNumber / 10;
            result += digit * digit * digit;
        }

        return value == result;
    }
}
