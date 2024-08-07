package com.example.mapper.controller;


import com.example.mapper.data.bean.Car;
import com.example.mapper.data.dto.CarDto;
import com.example.mapper.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
@CrossOrigin
public class CarController {

    private final CarService carService;

    private final ConversionService conversionService;

    @Autowired
    public CarController(CarService carService, ConversionService conversionService) {
        this.carService = carService;
        this.conversionService = conversionService;
    }

    @GetMapping
    public ResponseEntity<Car> getCar() {
        CarDto carDto = carService.retrieveDefaultCar();
        return new ResponseEntity<>(conversionService.convert(carDto, Car.class), HttpStatus.OK);
    }

}
