package com.emmabraboke.Car;

import java.util.List;

public class CarService {
    private final CarDataAccessService carDataAccessService;
    public CarService(CarDataAccessService carDataAccessService) {
        this.carDataAccessService = carDataAccessService;
    }

    public void createCar(Car car) {
       carDataAccessService.createCar(car);
    }

    public List<Car> getCars() {
        return carDataAccessService.getCars();
    }

    public  List<Car> getAvailableCars() {
      return carDataAccessService.getAvailableCars();
    }

    public  List<Car> getAvailableElectricCars() {
     return carDataAccessService.getAvailableElectricCars();
    }

    public  Car getCar(String id) {
        return  carDataAccessService.getCar(id);
    }

    public void printCars(){
        List<Car> cars = getAvailableCars();
        for(Car car: cars){
                System.out.println(car);
        }
    }

    public void viewAvailableCars(CarService carSrv){
        carSrv.printCars();
    }
    public void printElectricCars(){
        List<Car> cars = getAvailableElectricCars();
        for(Car car: cars){
            System.out.println(car);
        }
    }

    public void viewAvailableElectricCars(CarService carSrv){
        carSrv.printElectricCars();
    }
}
