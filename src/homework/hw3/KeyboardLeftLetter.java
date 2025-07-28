package homework.hw3;

import java.util.Scanner;

public class KeyboardLeftLetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String keyboard = "qwertyuiopasdfghjklzxcvbnm";
        char input = scanner.next().charAt(0);

        int index = keyboard.indexOf(input);
        if (index == -1) {
            System.out.println("Введен недопустимый символ!");
            return;
        }

        int leftIndex = (index - 1 + keyboard.length()) % keyboard.length();
        char leftChar = keyboard.charAt(leftIndex);

        System.out.println(leftChar);
    }
}