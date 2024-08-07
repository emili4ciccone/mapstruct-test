package com.example.mapper.data.bean;




public class Car {
    private String plate;
    private String model;
    private Integer year;

    public Car(Integer year, String plate, String model) {
        this.year = year;
        this.model = model;
        this.plate = plate;
    }

    public Car() {}

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
