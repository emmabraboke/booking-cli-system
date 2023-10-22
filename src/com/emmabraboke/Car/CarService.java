package com.emmabraboke.Car;

import java.util.Arrays;
import java.util.UUID;

public class CarService {
    public void createCar(Car car) {
       CarDAO.createCar(car);
    }

    public Car[] getCars() {
        return CarDAO.getCars();
    }

    public Car[] getAvailableCars() {
      return CarDAO.getAvailableCars();
    }

    public Car[] getAvailableElectricCars() {
     return CarDAO.getAvailableElectricCars();
    }

    public  Car getCar(String id) {
        return  CarDAO.getCar(id);
    }

    public void printCars(){
        Car[] cars = getAvailableCars();
        for(Car car: cars){
                System.out.println(car);
        }
    }

    public void printElectricCars(){
        Car[] cars = getAvailableElectricCars();
        for(Car car: cars){
            System.out.println(car);
        }
    }
}
