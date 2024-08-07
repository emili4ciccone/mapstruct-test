package com.example.mapper.service;

import com.example.mapper.data.dto.CarDto;
import com.example.mapper.data.entity.CarEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private final ConversionService conversionService;

    @Autowired
    public CarService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    public CarDto retrieveDefaultCar() {
        return conversionService.convert(new CarEntity(2024, "AB123CD", "economy car"), CarDto.class);
    }
}
