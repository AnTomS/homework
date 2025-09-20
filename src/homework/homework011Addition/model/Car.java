package homework.homework011Addition.model;

public class Car {
    private String number;
    private String model;
    private String color;
    private long mileage;
    private long price;

    public Car(String number, String model, String color, long mileage, long price) {
        this.number = number;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.price = price;
    }

    public String getNumber() { return number; }
    public String getModel() { return model; }
    public String getColor() { return color; }
    public long getMileage() { return mileage; }
    public long getPrice() { return price; }

    public void setNumber(String number) { this.number = number; }
    public void setModel(String model) { this.model = model; }
    public void setColor(String color) { this.color = color; }
    public void setMileage(long mileage) { this.mileage = mileage; }
    public void setPrice(long price) { this.price = price; }

    @Override
    public String toString() {
        return String.format("%-8s %-10s %-8s %8d %12d",
                number, model, color, mileage, price);
    }
}