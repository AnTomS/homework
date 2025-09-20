package homework.homework011Addition.repository;

import homework.homework011Addition.model.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarsRepositoryImpl implements CarsRepository {
    private List<Car> cars = new ArrayList<>();

    @Override
    public List<Car> loadCarsFromFile(String filename) {
        cars.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                line = line.trim();
                
                // Пропускаем пустые строки и заголовки
                if (line.isEmpty() || line.startsWith("[")) continue;

                String[] parts = line.split("\\|");
                if (parts.length == 5) {
                    try {
                        String number = parts[0].trim();
                        String model = parts[1].trim();
                        String color = parts[2].trim();
                        long mileage = Long.parseLong(parts[3].trim());
                        long price = Long.parseLong(parts[4].trim());

                        cars.add(new Car(number, model, color, mileage, price));
                        System.out.println("Загружен автомобиль: " + number + " " + model);
                    } catch (NumberFormatException e) {
                        System.err.println("Ошибка в строке " + lineNumber + ": неверный формат чисел - " + line);
                    }
                } else {
                    System.err.println("Ошибка в строке " + lineNumber + ": неверное количество полей - " + line);
                }
            }
            System.out.println("Всего загружено автомобилей: " + cars.size());
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + filename);
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
        return new ArrayList<>(cars);
    }

    @Override
    public void saveReportToFile(String filename, String report) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.print(report);
            System.out.println("Отчет сохранен в файл: " + filename);
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    @Override
    public List<Car> findAll() {
        return new ArrayList<>(cars);
    }

    @Override
    public Optional<Car> findByNumber(String number) {
        return cars.stream()
                .filter(car -> car.getNumber().equals(number))
                .findFirst();
    }

    @Override
    public List<Car> findByColor(String color) {
        return cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase(color))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> findByModel(String model) {
        return cars.stream()
                .filter(car -> car.getModel().equalsIgnoreCase(model))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> findByPriceRange(long minPrice, long maxPrice) {
        return cars.stream()
                .filter(car -> car.getPrice() >= minPrice && car.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findNumbersByColorOrMileage(String color, long mileage) {
        return cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase(color) || car.getMileage() == mileage)
                .map(Car::getNumber)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<String> findColorOfCarWithMinPrice() {
        return cars.stream()
                .min(Comparator.comparingLong(Car::getPrice))
                .map(Car::getColor);
    }

    @Override
    public long countUniqueModelsInPriceRange(long minPrice, long maxPrice) {
        return cars.stream()
                .filter(car -> car.getPrice() >= minPrice && car.getPrice() <= maxPrice)
                .map(Car::getModel)
                .distinct()
                .count();
    }

    @Override
    public double calculateAveragePriceByModel(String model) {
        return cars.stream()
                .filter(car -> car.getModel().equalsIgnoreCase(model))
                .mapToLong(Car::getPrice)
                .average()
                .orElse(0.0);
    }
}