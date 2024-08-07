package com.example.mapper.config;

import org.mapstruct.MapperConfig;
import org.mapstruct.extensions.spring.SpringMapperConfig;
import org.mapstruct.extensions.spring.converter.ConversionServiceAdapter;

@MapperConfig(componentModel = "spring", uses = ConversionServiceAdapter.class)
@SpringMapperConfig(generateConverterScan = true, conversionServiceBeanName = "mvcConversionService", conversionServiceAdapterPackage = "org.mapstruct.extensions.spring.converter")
public interface MapperSpringConfig {

}
