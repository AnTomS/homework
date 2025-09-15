package homework.hw7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class UniqueElements {


    public static <T> Set<T> getUniqueElementsSafe(ArrayList<T> list) {
        if (list == null) {
            return new HashSet<>();
        }
        return new HashSet<>(list);
    }


    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(2);
        numbers.add(1);
        numbers.add(4);
        numbers.add(5);
        numbers.add(3);

        System.out.println("Исходный список: " + numbers);


        Set<Integer> uniqueNumbers = getUniqueElementsSafe(numbers);
        System.out.println("Уникальные элементы: " + uniqueNumbers);


        ArrayList<String> words = new ArrayList<>();
        words.add("apple");
        words.add("banana");
        words.add("apple");
        words.add("orange");
        words.add("banana");

        System.out.println("\nИсходный список строк: " + words);
        Set<String> uniqueWords = getUniqueElementsSafe(words);
        System.out.println("Уникальные строки: " + uniqueWords);
    }
}