package ru.embedika.cardirectory.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.embedika.cardirectory.Utils.CarUtils;
import ru.embedika.cardirectory.repository.CarRepository;

import java.time.ZonedDateTime;

@Configuration
public class AppConfiguration {

    @Autowired
    private CarRepository carRepository;

    @Bean
    public void fillingCarsTable() {
        carRepository.save(CarUtils.createCar("AA123A23", "Ford", "Blue", 1999, ZonedDateTime.now().minusSeconds(10)));
        carRepository.save(CarUtils.createCar("BB456B56", "Lada", "White", 2020, ZonedDateTime.now().minusSeconds(9)));
        carRepository.save(CarUtils.createCar("AB324A96", "Ferrari", "Red", 1990, ZonedDateTime.now().minusSeconds(8)));
        carRepository.save(CarUtils.createCar("EE430B63", "Mercedes", "Silver", 2021, ZonedDateTime.now().minusSeconds(7)));
        carRepository.save(CarUtils.createCar("EK326X05", "Renault", "Yellow", 2022, ZonedDateTime.now().minusSeconds(6)));
        carRepository.save(CarUtils.createCar("AH884C45", "Hyundai", "Black", 2023, ZonedDateTime.now().minusSeconds(5)));
        carRepository.save(CarUtils.createCar("BB010A66", "Honda", "Pink", 2020, ZonedDateTime.now().minusSeconds(4)));
        carRepository.save(CarUtils.createCar("AO111O44", "Jeep", "Green", 1995, ZonedDateTime.now().minusSeconds(3)));
        carRepository.save(CarUtils.createCar("OA496O95", "Nissan", "Orange", 2000, ZonedDateTime.now().minusSeconds(2)));
        carRepository.save(CarUtils.createCar("OA993M96", "Kia", "Blue", 2007, ZonedDateTime.now().minusSeconds(1)));
    }

}
