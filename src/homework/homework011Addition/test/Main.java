package homework.homework011Addition.test;

import homework.homework011Addition.model.Car;
import homework.homework011Addition.repository.CarsRepository;
import homework.homework011Addition.repository.CarsRepositoryImpl;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CarsRepository repository = new CarsRepositoryImpl();


        String inputFile = "src/homework/homework011Addition/data/cars_input.txt";
        String outputFile = "src/homework/homework011Addition/cars_report.txt";


        File inputFileObj = new File(inputFile);
        if (!inputFileObj.exists()) {
            System.err.println("Ошибка: Входной файл не найден: " + inputFile);
            System.err.println("Текущая рабочая директория: " + System.getProperty("user.dir"));
            return;
        }

        System.out.println("Загружаем данные из файла: " + inputFile);
        List<Car> cars = repository.loadCarsFromFile(inputFile);
        
        if (cars.isEmpty()) {
            System.err.println("Ошибка: Не удалось загрузить данные из файла");
            return;
        }
        
        System.out.println("Загружено автомобилей: " + cars.size());

        // Создание полного отчета
        StringBuilder report = new StringBuilder();

        report.append("ОТЧЕТ ПО АВТОМОБИЛЯМ\n");
        report.append("=".repeat(50)).append("\n\n");

        // Все автомобили
        report.append("Автомобили в базе:\n");
        report.append("Number Model Color Mileage Cost\n");
        cars.forEach(car -> report.append(car.toString()).append("\n"));
        report.append("\n");

        // 1) Номера автомобилей по цвету или пробегу
        String colorToFind = "Black";
        long mileageToFind = 0L;

        List<String> numbersList = repository.findNumbersByColorOrMileage(colorToFind, mileageToFind);
        String numbersString = String.join(" ", numbersList);

        report.append("Номера автомобилей по цвету или пробегу: ").append(numbersString).append("\n\n");

        // 2) Количество уникальных моделей в ценовом диапазоне
        long minPrice = 700000L;
        long maxPrice = 800000L;

        long uniqueModelsCount = repository.countUniqueModelsInPriceRange(minPrice, maxPrice);
        report.append("Уникальные автомобили: ").append(uniqueModelsCount).append(" шт.\n\n");

        // 3) Цвет автомобиля с минимальной стоимостью
        String minPriceColor = repository.findColorOfCarWithMinPrice().orElse("Не найден");
        report.append("Цвет автомобиля с минимальной стоимостью: ").append(minPriceColor).append("\n\n");

        // 4) Средняя стоимость искомых моделей
        String modelToFind1 = "Toyota";
        String modelToFind2 = "Volvo";

        double toyotaAvgPrice = repository.calculateAveragePriceByModel(modelToFind1);
        double volvoAvgPrice = repository.calculateAveragePriceByModel(modelToFind2);

        report.append("Средняя стоимость модели ").append(modelToFind1).append(": ").append(String.format("%.2f", toyotaAvgPrice)).append("\n");
        report.append("Средняя стоимость модели ").append(modelToFind2).append(": ").append(String.format("%.2f", volvoAvgPrice)).append("\n");

        // Сохранение отчета в файл
        repository.saveReportToFile(outputFile, report.toString());

        System.out.println("Обработка завершена. Отчет сохранен в: " + outputFile);
        System.out.println("Данные загружены из: " + inputFile);
    }
}