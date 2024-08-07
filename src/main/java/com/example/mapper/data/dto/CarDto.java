package com.example.mapper.data.dto;


public class CarDto {

    private Integer year;
    private String plate;
    private String model;

    public CarDto(Integer year, String plate, String model) {
        this.year = year;
        this.model = model;
        this.plate = plate;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getYear() {
        return year;
    }

    public String getModel() {
        return model;
    }

    public String getPlate() {
        return plate;
    }
}
