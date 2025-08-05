package homework.attestation01;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        Map<String, Person> personMap = new HashMap<>();
        Map<String, Product> productMap = new HashMap<>();


        System.out.println("Введите покупателей в формате: Имя = сумма. После окончания ввода нажмите Enter на пустой строке.");
        while (true) {
            String line = scanner.nextLine();
            if (line.trim().isEmpty()) break;
            try {
                String[] parts = line.split("=");
                String name = parts[0].trim();
                int money = Integer.parseInt(parts[1].trim());
                Person person = new Person(name, money);
                people.add(person);
                personMap.put(name, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            } catch (Exception e) {
                System.out.println("Ошибка ввода");
                return;
            }
        }


        System.out.println("Введите продукты в формате: Название = цена. После окончания ввода нажмите Enter на пустой строке.");
        while (true) {
            String line = scanner.nextLine();
            if (line.trim().isEmpty()) break;
            try {
                String[] parts = line.split("=");
                String name = parts[0].trim();
                int price = Integer.parseInt(parts[1].trim());
                Product product = new Product(name, price);
                products.add(product);
                productMap.put(name, product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            } catch (Exception e) {
                System.out.println("Ошибка ввода");
                return;
            }
        }


        System.out.println("Введите покупки в формате: Имя - Название продукта. После окончания ввода введите END.");
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("END")) break;
            String[] parts = line.split(" - ");
            if (parts.length != 2) continue;
            String personName = parts[0].trim();
            String productName = parts[1].trim();
            Person person = personMap.get(personName);
            Product product = productMap.get(productName);
            if (person == null || product == null) continue;
            if (person.buy(product)) {
                System.out.println(personName + " купил " + productName);
            } else {
                System.out.println(personName + " не может позволить себе " + productName);
            }
        }


        for (Person person : people) {
            System.out.println(person);
        }
    }
}