package com.example.mapper.service;

import com.example.mapper.config.ServiceTestSliceConfiguration;
import com.example.mapper.data.dto.CarDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
@ContextConfiguration(classes = {CarService.class, ServiceTestSliceConfiguration.class})
class CarServiceTest {

    @Autowired
    private CarService carService;

    @Test
    void retrieveDefaultCarTest() {

        CarDto carDto = carService.retrieveDefaultCar();

        assertEquals("economy car", carDto.getModel());
        assertEquals("AB123CD", carDto.getPlate());
        assertEquals(2024, carDto.getYear());
    }
}
