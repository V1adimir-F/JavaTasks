package com.java.tasks.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Алгоритм удаления нескольких рядом стоящих элементов из середины ArrayList.
 * Нужно удалить n элементов с позиции m в списке.
 * Вместо выполнения удаления одного элемента n раз (каждый раз смещая на 1 позицию элементы, стоящие «правее» в списке),
 * нужно выполнить смещение всех элементов, стоящих «правее» n + m позиции на n элементов «левее» к началу списка.
 * Таким образом, вместо выполнения n итераций перемещения элементов списка, все выполняется за 1 проход.
 * Но если говорить об общей эффективности - то самый быстрый способ будет с использованием System.arraycopy(),
 * и получить к нему доступ можно через метод - subList(int fromIndex, int toIndex)
 */
public class RemovingSomeElements {

    public static void main(String[] args) {
        ArrayList<Integer> initList = generateInitialList(10_000_000);
        ArrayList<Integer> copyList = new ArrayList<>(initList);
        ArrayList<Integer> anotherCopyList = new ArrayList<>(initList);

        removeElements(initList, 120, 50);
        removeElementsByOverwriting(copyList, 120, 50);
        removeElementsBySubList(anotherCopyList, 120, 50);
    }

    private static ArrayList<Integer> generateInitialList(int elementsCount) {
        ArrayList<Integer> integerList = new ArrayList<>(elementsCount);
        for (int i = 0; i < elementsCount; i++) {
            integerList.add(i);
        }
        return integerList;
    }

    private static void removeElements(List<Integer> integerList, int fromIndex, int elementsCount) {
        System.out.println("Выполняем удаление вызовом remove()...");
        long start = System.currentTimeMillis();

        for (int i = fromIndex; i < fromIndex + elementsCount; i++) {
            integerList.remove(i);
        }

        long finish = System.currentTimeMillis() - start;
        System.out.println("Время удаления с помощью вызова remove(): " + finish);
        System.out.println("Размер исходного списка после удаления: " + integerList.size());
    }

    private static void removeElementsByOverwriting(ArrayList<Integer> integerList, int fromIndex, int elementsCount) {
        long start = System.currentTimeMillis();

        int size = integerList.size();
        // если необходимо удалить все элементы, начиная с указанного, то удаляем элементы с конца до fromIndex
        if (fromIndex + elementsCount >= size){
            int i = size - 1;
            while (i != fromIndex - 1){
                integerList.remove(i);
                i--;
            }
        } else {
            //переменная k необходима для отсчёта сдвига начиная от места вставки fromIndex
            for (int i = fromIndex + elementsCount, k = 0; i < integerList.size(); i++, k++) {
                integerList.set(fromIndex + k, integerList.get(i));
            }

            // удаляем ненужные элементы в конце списка
            int i = size - 1;
            while (i != size - elementsCount - 1) {
                integerList.remove(i);
                i--;
            }
            integerList.trimToSize();
        }

        long finish = System.currentTimeMillis() - start;
        System.out.println("Время удаления путем смещения: " + finish);
        System.out.println("Размер списка после удаления: " + integerList.size());
    }

    private static void removeElementsBySubList(ArrayList<Integer> integerList, int fromIndex, int elementsCount) {
        long start = System.currentTimeMillis();

        integerList.subList(fromIndex, fromIndex + elementsCount).clear();

        long finish = System.currentTimeMillis() - start;
        System.out.println("Время удаления через subList: " + finish);
        System.out.println("Размер списка после удаления: " + integerList.size());
    }
}
