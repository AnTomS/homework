package homework.hw2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        TV tv1 = new TV("Sony", 55.0, 2160, 89999.99);
        TV tv2 = new TV();
        TV tv3 = createTvFromUserInput();


        System.out.println("\n=== Список телевизоров ===");
        System.out.println("1. " + tv1);
        System.out.println("2. " + tv2);
        System.out.println("3. " + tv3);
    }


    private static TV createTvFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nВведите параметры телевизора:");

        System.out.print("Бренд: ");
        String brand = scanner.nextLine();

        System.out.print("Диагональ (дюймы): ");
        double screenSize = scanner.nextDouble();

        System.out.print("Разрешение (1080/2160): ");
        int resolution = scanner.nextInt();

        System.out.print("Цена (руб): ");
        double price = scanner.nextDouble();

        return new TV(brand, screenSize, resolution, price);
    }
}