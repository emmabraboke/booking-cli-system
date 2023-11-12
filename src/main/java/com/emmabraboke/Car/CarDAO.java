package com.emmabraboke.Car;

import java.util.List;

public interface CarDAO {
    void createCar(Car car);
    List<Car> getAvailableCars();
    List<Car> getCars();

    List<Car> getAvailableElectricCars();

    void updateCarStatus(String id, Boolean status);

    Car getCar(String id);

    void cars(String path);
}
