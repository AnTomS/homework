package homework.hw7;

import java.util.HashSet;
import java.util.Set;

public class PowerfulSet {

    /**
     * Возвращает пересечение двух наборов (элементы, которые есть в обоих наборах)
     * @param set1 первый набор
     * @param set2 второй набор
     * @return пересечение set1 и set2
     */
    public <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    /**
     * Возвращает объединение двух наборов (все элементы из обоих наборов без дубликатов)
     * @param set1 первый набор
     * @param set2 второй набор
     * @return объединение set1 и set2
     */
    public <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    /**
     * Возвращает относительное дополнение (элементы первого набора без тех, которые есть во втором)
     * @param set1 первый набор
     * @param set2 второй набор
     * @return элементы set1, которых нет в set2
     */
    public <T> Set<T> relativeComplement(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.removeAll(set2);
        return result;
    }

    public static void main(String[] args) {
        PowerfulSet powerfulSet = new PowerfulSet();

        Set<Integer> set1 = Set.of(1, 2, 3);
        Set<Integer> set2 = Set.of(0, 1, 2, 4);

        System.out.println("Пересечение: " + powerfulSet.intersection(set1, set2));
        System.out.println("Объединение: " + powerfulSet.union(set1, set2));
        System.out.println("Относительное дополнение: " + powerfulSet.relativeComplement(set1, set2));
    }
}