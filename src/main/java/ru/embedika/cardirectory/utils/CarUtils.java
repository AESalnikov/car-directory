package ru.embedika.cardirectory.utils;

import lombok.experimental.UtilityClass;
import ru.embedika.cardirectory.pojo.entity.Car;
import ru.embedika.cardirectory.pojo.model.CarModel;

import java.time.ZonedDateTime;
import java.util.List;

@UtilityClass
public class CarUtils {

    public static Car createCar(final String carNumber,
                                final String brand,
                                final String color,
                                final Integer yearOfIssue,
                                final ZonedDateTime dateAdded) {
        Car car = new Car();
        car.setCarNumber(carNumber);
        car.setBrand(brand);
        car.setColor(color);
        car.setYearOfIssue(yearOfIssue);
        car.setDateAdded(dateAdded);
        return car;
    }

    public static Car convertCarModelToCar(CarModel carModel) {
        return createCar(carModel.getCarNumber(),
                carModel.getBrand(),
                carModel.getColor(),
                carModel.getYearOfIssue(),
                ZonedDateTime.now());
    }

    public static CarModel convertCarToCarModel(Car car) {
        CarModel carModel = new CarModel();
        carModel.setCarNumber(car.getCarNumber());
        carModel.setBrand(car.getBrand());
        carModel.setColor(car.getColor());
        carModel.setYearOfIssue(car.getYearOfIssue());
        return carModel;
    }

    public static List<CarModel> convertCarListToCarModelList(List<Car> carList) {
        return carList.stream().map(CarUtils::convertCarToCarModel).toList();
    }

}
