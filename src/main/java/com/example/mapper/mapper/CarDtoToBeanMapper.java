package com.example.mapper.mapper;


import com.example.mapper.config.MapperSpringConfig;
import com.example.mapper.data.bean.Car;
import com.example.mapper.data.dto.CarDto;
import jakarta.annotation.Nullable;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

@Mapper(config = MapperSpringConfig.class)
public interface CarDtoToBeanMapper extends Converter<CarDto, Car> {
    @Override
    @Mapping(source = "year", target = "year")
    @Mapping(source = "model", target = "model")
    @Mapping(source = "plate", target = "plate")
    Car convert(@Nullable CarDto carDto);



}
