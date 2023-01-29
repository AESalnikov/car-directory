package ru.embedika.cardirectory.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.embedika.cardirectory.pojo.entity.Car;

import java.time.LocalDateTime;
import java.util.List;

public interface CarRepository extends CrudRepository<Car, String> {

    List<Car> findAllByBrand(String brand);

    List<Car> findAllByColor(String color);

    List<Car> findAllByYearOfIssue(Integer yearOfIssue);

    List<Car> findAllByBrandAndColor(String brand, String color);

    List<Car> findAllByBrandAndYearOfIssue(String brand, Integer yearOfIssue);

    List<Car> findAllByColorAndYearOfIssue(String color, Integer yearOfIssue);

    List<Car> findAllByBrandAndColorAndYearOfIssue(String brand, String color, Integer yearOfIssue);

    @Query(value = "SELECT MAX(DATE_ADDED) FROM CARS", nativeQuery = true)
    LocalDateTime findMaxDate();

    @Query(value = "SELECT MIN(DATE_ADDED) FROM CARS", nativeQuery = true)
    LocalDateTime findMinDate();

}
