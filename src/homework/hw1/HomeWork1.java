package homework.hw1;

import java.util.Scanner;

import static java.lang.System.in;

public class HomeWork1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String textRequest = "Напишите Ваше имя пользователя";

        System.out.println(textRequest);

        String name = scanner.next();

        System.out.println("Привет, "  + name);

        scanner.close();
    }
}

