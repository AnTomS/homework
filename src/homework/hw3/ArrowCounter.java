package homework.hw3;

import java.util.Scanner;

public class ArrowCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sequence = scanner.next();
        int count = 0;
        int i = 0;
        while (i <= sequence.length() - 5) {
            String substring = sequence.substring(i, i + 5);
            if (substring.equals(">>-->") || substring.equals("<--<<")) {
                count++;
                i += 5;
            } else {
                i++;
            }
        }
        System.out.println(count);
    }
}