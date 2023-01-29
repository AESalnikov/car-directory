package ru.embedika.cardirectory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.embedika.cardirectory.utils.CarUtils;
import ru.embedika.cardirectory.pojo.Stats;
import ru.embedika.cardirectory.pojo.entity.Car;
import ru.embedika.cardirectory.pojo.model.CarModel;
import ru.embedika.cardirectory.pojo.response.GetCarListResponse;
import ru.embedika.cardirectory.exception.CarAlreadyExistException;
import ru.embedika.cardirectory.exception.CarNotExistException;
import ru.embedika.cardirectory.repository.CarRepository;
import ru.embedika.cardirectory.service.CarService;

import java.util.List;

import static ru.embedika.cardirectory.utils.CarUtils.convertCarListToCarModelList;
import static ru.embedika.cardirectory.utils.CarUtils.convertCarModelToCar;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(final CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public GetCarListResponse getCarList(String carNumber, String brand, String color, Integer yearOfIssue) {
        GetCarListResponse response = new GetCarListResponse();
        if (carNumber != null) {
            response.setCarList(carRepository.findById(carNumber).stream().map(CarUtils::convertCarToCarModel).toList());
            return response;
        }
        if (brand != null && color != null && yearOfIssue != null) {
            response.setCarList(convertCarListToCarModelList(carRepository.findAllByBrandAndColorAndYearOfIssue(brand, color, yearOfIssue)));
            return response;
        }
        if (brand != null && color != null) {
            response.setCarList(convertCarListToCarModelList(carRepository.findAllByBrandAndColor(brand, color)));
            return response;
        }
        if (brand != null && yearOfIssue != null) {
            response.setCarList(convertCarListToCarModelList(carRepository.findAllByBrandAndYearOfIssue(brand, yearOfIssue)));
            return response;
        }
        if (color != null && yearOfIssue != null) {
            response.setCarList(convertCarListToCarModelList(carRepository.findAllByColorAndYearOfIssue(color, yearOfIssue)));
            return response;
        }
        if (brand != null) {
            response.setCarList(convertCarListToCarModelList(carRepository.findAllByBrand(brand)));
            return response;
        }
        if (color != null) {
            response.setCarList(convertCarListToCarModelList(carRepository.findAllByColor(color)));
            return response;
        }
        if (yearOfIssue != null) {
            response.setCarList(convertCarListToCarModelList(carRepository.findAllByYearOfIssue(yearOfIssue)));
            return response;
        }
        response.setCarList(convertCarListToCarModelList((List<Car>) carRepository.findAll()));
        return response;
    }

    @Override
    public void addCar(CarModel request) {
        if (carRepository.findById(request.getCarNumber()).isPresent())
            throw new CarAlreadyExistException("Автомобиль с таким номером уже существует!");
        carRepository.save(convertCarModelToCar(request));
    }

    @Override
    public void deleteCar(String carNumber) {
        if (carRepository.findById(carNumber).isEmpty())
            throw new CarNotExistException("Автомобиля с таким номером не существует!");
        carRepository.deleteById(carNumber);
    }

    @Override
    public Stats getStats() {
        Stats stats = new Stats();
        stats.setNumberOfRecords(carRepository.count());
        stats.setFirstDataRecord(carRepository.findMinDate());
        stats.setLastDataRecord(carRepository.findMaxDate());
        return stats;
    }

}
