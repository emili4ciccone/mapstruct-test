package com.example.mapper.config;


import org.mapstruct.extensions.spring.converter.ConverterScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConverterScan(basePackageClasses = MapperSpringConfig.class)
public class ControllerTestSliceConfiguration {

}
