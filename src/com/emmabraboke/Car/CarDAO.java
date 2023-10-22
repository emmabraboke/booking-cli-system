package com.emmabraboke.Car;

import com.emmabraboke.User.User;

import java.util.UUID;

public class CarDAO {
    private static Car[] cars = new Car[0];


    public static void createCar(  Car car) {
        String id = UUID.randomUUID().toString();
        car.setId(id);
        car.setAvailable(true);
        cars = append(car, cars);
    }

    public static Car[] getCars() {
        return cars;
    }

    public static Car[] getAvailableCars() {
        Car[] result = new Car[0];
        for(Car car : cars){
            if(car !=null && car.getAvailable()){
                result = append(car, result);
            }
        }

        if(result.length == 0) {
            System.out.println("no car available");
        }

        return result;
    }

    public static Car[] getAvailableElectricCars() {
        Car[] result = new Car[0];
        for(Car car : cars){
            if(car !=null && car.getAvailable() && car.getElectricCar()){
                result = append(car, result);
            }
        }

        if(result.length == 0) {
            System.out.println("no electric car available");
        }

        return result;
    }

    public static Boolean updateCarStatus(String id, Boolean status){
        Car car  = getCar(id);
        if(car !=null) {
            car.setAvailable(status);
            return true;
        }

        return false;

    }
    public static Car getCar(String id) {
        for (Car car : cars) {
            if (car != null && car.getId().equals(id)) {
                return car;
            }
        }

        return null;
    }

    public static Car[] append(Car car, Car[] cars){
        Car[] temp = cars;
        int size = temp.length;
        cars = new Car[size+1];

        System.arraycopy(temp, 0,cars, 0, temp.length);
        cars[temp.length] = car;

        return cars;
    }
}
