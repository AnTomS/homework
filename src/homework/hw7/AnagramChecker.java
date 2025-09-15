package homework.hw7;

import java.util.Arrays;
import java.util.Scanner;

public class AnagramChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первую строку: ");
        String s = scanner.nextLine().toLowerCase().replaceAll("\\s+", "");

        System.out.print("Введите вторую строку: ");
        String t = scanner.nextLine().toLowerCase().replaceAll("\\s+", "");

        boolean result = isAnagram(s, t);
        System.out.println(result);

        scanner.close();
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }


        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);


        return Arrays.equals(sArray, tArray);
    }
}