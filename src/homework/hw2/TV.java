package homework.hw2;

import java.util.Random;

public class TV {

    private String brand;
    private double screenSize;
    private int resolution;
    private double price;


    public TV(String brand, double screenSize, int resolution, double price) {
        this.brand = brand;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.price = price;
    }


    public TV() {
        Random random = new Random();
        String[] brands = {"Samsung", "LG", "Sony", "Xiaomi", "Philips"};
        this.brand = brands[random.nextInt(brands.length)];
        this.screenSize = 32 + random.nextInt(65 - 32 + 1);
        this.resolution = random.nextBoolean() ? 1080 : 2160;
        this.price = 20000 + random.nextInt(180000);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getResolution() {
        return resolution;
    }

    public void setResolution(int resolution) {
        this.resolution = resolution;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format(
                "Телевизор %s (%.1f\"), %dp, цена: %.2f руб.",
                brand, screenSize, resolution, price
        );
    }
}
