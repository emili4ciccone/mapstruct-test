package com.example.mapper.service;

import com.example.mapper.config.MapperSpringConfig;
import com.example.mapper.data.dto.CarDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.extensions.spring.converter.ConverterScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
@ExtendWith(SpringExtension.class)
class CarServiceTest {

    @Configuration
    @ComponentScan("org.mapstruct.extensions.spring")
    @ComponentScan("com.example.mapper.mapper")
    @ConverterScan(basePackageClasses = MapperSpringConfig.class)
    static class AdditionalBeanConfiguration {
        @Bean
        ConfigurableConversionService myConversionService() {
            return new DefaultConversionService();
        }
    }

    @Autowired
    @Qualifier("mvcConversionService")
    private ConversionService myConversionService;

    private CarService carService;

    @BeforeEach
    void setUp() {
        carService = new CarService(myConversionService);
    }

    @Test
    void retrieveDefaultCarTest() {

        CarDto carDto = carService.retrieveDefaultCar();

        assertEquals("economy car", carDto.getModel());
        assertEquals("AB123CD", carDto.getPlate());
        assertEquals(2024, carDto.getYear());
    }
}
