package ru.embedika.cardirectory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.embedika.cardirectory.pojo.Stats;
import ru.embedika.cardirectory.pojo.model.CarModel;
import ru.embedika.cardirectory.pojo.response.GetCarListResponse;
import ru.embedika.cardirectory.service.CarService;

@RestController
@RequestMapping("/api")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(final CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/car/list")
    public ResponseEntity<GetCarListResponse> getCarList(@RequestParam(name = "car_number", required = false) String carNumber,
                                                         @RequestParam(name = "brand", required = false) String brand,
                                                         @RequestParam(name = "color", required = false) String color,
                                                         @RequestParam(name = "year_of_issue", required = false) Integer yearOfIssue) {
        GetCarListResponse response = carService.getCarList(carNumber, brand, color, yearOfIssue);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/car/stats")
    public ResponseEntity<Stats> getStats() {
        Stats response = carService.getStats();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/car/add")
    public ResponseEntity<GetCarListResponse> addCar(@RequestBody CarModel request) {
        carService.addCar(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/car/delete/{id}")
    public ResponseEntity<GetCarListResponse> deleteCar(@PathVariable("id") String carNumber) {
        carService.deleteCar(carNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
