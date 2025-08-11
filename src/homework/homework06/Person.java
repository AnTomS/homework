package homework.homework06;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {
    private String name;
    private int money;
    private List<homework.homework06.Product> bag = new ArrayList<>();

    public Person(String name, int money) {
        setName(name);
        setMoney(money);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (name.length() < 3) {
            throw new IllegalArgumentException("Имя не может быть короче 3 символов");
        }
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        }
        this.money = money;
    }

    public List<homework.homework06.Product> getBag() {
        return bag;
    }

    public boolean buy(Product product) {
        if (money >= product.getPrice()) {
            money -= product.getPrice();
            bag.add(product);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (bag.isEmpty()) {
            return name + " - Ничего не куплено";
        }
        StringBuilder sb = new StringBuilder(name + " - ");
        for (int i = 0; i < bag.size(); i++) {
            sb.append(bag.get(i).getName());
            if (i < bag.size() - 1) sb.append(", ");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return money == person.getMoney() && name.equals(person.getName()) && bag.equals(person.getBag());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money, bag);
    }
}