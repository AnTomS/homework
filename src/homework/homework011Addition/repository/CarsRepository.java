package homework.homework011Addition.repository;

import homework.homework011Addition.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarsRepository {
    List<Car> loadCarsFromFile(String filename);
    void saveReportToFile(String filename, String report);
    List<Car> findAll();
    Optional<Car> findByNumber(String number);
    List<Car> findByColor(String color);
    List<Car> findByModel(String model);
    List<Car> findByPriceRange(long minPrice, long maxPrice);
    List<String> findNumbersByColorOrMileage(String color, long mileage);
    Optional<String> findColorOfCarWithMinPrice();
    long countUniqueModelsInPriceRange(long minPrice, long maxPrice);
    double calculateAveragePriceByModel(String model);
}