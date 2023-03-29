package com.java.tasks.numbers;

/**
 * В маленьком городке население р0 = 1000 в начале года.
 * Население регулярно увеличивается на 2 процента в год, и более 50 новых жителей ежегодно переезжают в город.
 * Сколько лет нужно городу, чтобы его население стало больше или равно p = 1200 жителей?
 */
public class TownPopulation {

    public static void main(String[] args) {
        System.out.println(getCountOfYears(1000, 2, 50, 1200));
    }

    private static int getCountOfYears(int initialPopulation, double percent, int arrived, int requiredPopulation) {
        int years = 0;
        int inhabitants = initialPopulation;
        while(inhabitants < requiredPopulation) {
            inhabitants = (int)(inhabitants + (inhabitants * (float)(percent/100)) + arrived);
            years++;
        }
        return years;

    }
}
