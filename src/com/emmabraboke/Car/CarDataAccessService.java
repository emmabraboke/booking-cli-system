package com.emmabraboke.Car;

import com.emmabraboke.User.User;

import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

public class CarDataAccessService implements CarDAO{
    private static Car[] cars = new Car[0];
    public CarDataAccessService() {
    }

    public void createCar(Car car) {
        cars = append(car, cars);
    }

    public Car[] getCars() {
        return cars;
    }

    public Car[] getAvailableCars() {
        Car[] result = new Car[0];
        for(Car car : cars){
            if(car != null && car.getAvailable()){
                result = append(car, result);
            }
        }

        if(result.length == 0) {
            System.out.println("no car available");
        }

        return result;
    }

    public Car[] getAvailableElectricCars() {
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

    public void updateCarStatus(String id, Boolean status){
        Car car  = getCar(id);
        if(car !=null) {
            car.setAvailable(status);
        }

    }
    public Car getCar(String id) {
        for (Car car : cars) {
            if (car != null && car.getId().equals(id)) {
                return car;
            }
        }

        return null;
    }

    public void cars(String path){
        File file = new File(path);
        try(FileReader fileData = new FileReader(file);) {
            Scanner readFile = new Scanner(fileData);

            while (readFile.hasNext()){
                String line =  readFile.nextLine();

                String[] item = line.split(",");


                Car car = new Car(item[0],item[1], Double.parseDouble(item[2]), Boolean.parseBoolean(item[3]));

                cars = append(car, cars);
            }


        }catch (Exception FileNotFoundException){
            System.out.println(FileNotFoundException.toString());
        }

    }

    public Car[] append(Car car, Car[] cars){
        Car[] temp = cars;
        int size = temp.length;
        cars = new Car[size+1];

        System.arraycopy(temp, 0,cars, 0, temp.length);
        cars[temp.length] = car;

        return cars;
    }
}
