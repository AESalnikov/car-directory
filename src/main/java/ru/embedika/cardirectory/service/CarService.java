package ru.embedika.cardirectory.service;

import ru.embedika.cardirectory.pojo.Stats;
import ru.embedika.cardirectory.pojo.model.CarModel;
import ru.embedika.cardirectory.pojo.response.GetCarListResponse;

public interface CarService {

    GetCarListResponse getCarList(String carNumber, String brand, String color, Integer yearOfIssue);

    void addCar(CarModel request);

    void deleteCar(String request);

    Stats getStats();

}
