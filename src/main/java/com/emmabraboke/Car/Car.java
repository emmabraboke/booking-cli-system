package com.emmabraboke.Car;

public class Car {
    private final String id;
    private final String name;
    private Boolean isAvailable;
    private final Boolean isElectricCar;
    private final double rentalPrice;

    public String getId() {
        return id;
    }


    public Car(String id, String name, double rentalPrice, Boolean isElectricCar) {
        this.name = name;
        this.isElectricCar = isElectricCar;
        this.rentalPrice = rentalPrice;
        this.id = id;
        this.isAvailable = true;
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
