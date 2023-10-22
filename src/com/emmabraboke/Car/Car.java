package com.emmabraboke.Car;

import java.math.BigDecimal;

public class Car {
    private  String id;
    private String name;
    private Boolean isAvailable;
    private Boolean isElectricCar;

    private double rentalPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Car(String name, double rentalPrice, Boolean isElectricCar) {
        this.name = name;
        this.isElectricCar = isElectricCar;
        this.rentalPrice = rentalPrice;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isAvailable=" + isAvailable +
                ", isElectricCar=" + isElectricCar +
                ", rentalPrice=" + rentalPrice +
                '}';
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public Boolean getElectricCar() {
        return isElectricCar;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}
