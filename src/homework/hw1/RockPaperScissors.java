package homework.hw1;

import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {

        Random random = new Random();


        int vasyaChoice = random.nextInt(3);
        int petyaChoice = random.nextInt(3);


        System.out.println("Вася выбрал: " + getChoiceName(vasyaChoice));
        System.out.println("Петя выбрал: " + getChoiceName(petyaChoice));

        int result = determineWinner(vasyaChoice, petyaChoice);


        if (result == 0) {
            System.out.println("Ничья!");
        } else if (result == 1) {
            System.out.println("Вася выиграл!");
        } else {
            System.out.println("Петя выиграл!");
        }
    }

    private static int determineWinner(int choice1, int choice2) {
        if (choice1 == choice2) {
            return 0;
        }


        if ((choice1 == 0 && choice2 == 1) ||
                (choice1 == 1 && choice2 == 2) ||
                (choice1 == 2 && choice2 == 0)) {
            return 1;
        } else {
            return -1;
        }
    }

    private static String getChoiceName(int choice) {
        return switch (choice) {
            case 0 -> "Камень";
            case 1 -> "Ножницы";
            case 2 -> "Бумага";
            default -> "Неизвестно";
        };
    }
}