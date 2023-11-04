package com.emmabraboke.Car;

public interface CarDAO {
    void createCar(Car car);
    Car[] getAvailableCars();
    Car[] getCars();

    Car[] getAvailableElectricCars();

    void updateCarStatus(String id, Boolean status);

    Car getCar(String id);

    Car[] append(Car car, Car[] cars);

    void cars(String path);
}
