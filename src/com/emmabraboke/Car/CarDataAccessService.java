package com.emmabraboke.Car;

import com.emmabraboke.User.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class CarDataAccessService implements CarDAO{
    private static final List<Car> cars = new ArrayList<>();
    public CarDataAccessService() {
    }

    public void createCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public  List<Car> getAvailableCars() {
        List<Car> result = cars.stream()
                .filter(Car::getAvailable)
                .collect(Collectors.toList());
        if(result.isEmpty()) {
            System.out.println("no car available");
        }

        return result;
    }

    public  List<Car> getAvailableElectricCars() {
        List<Car> result = cars.stream()
                .filter(car -> car.getAvailable() && car.getElectricCar())
                .collect(Collectors.toList());

        if(result.isEmpty()) {
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

        try(BufferedReader fileData = new BufferedReader( new FileReader(path))) {

            String line;
            while ((line = fileData.readLine()) != null){

                String[] item = line.split(",");

                Car car = new Car(item[0],item[1], Double.parseDouble(item[2]), Boolean.parseBoolean(item[3]));

                cars.add(car);
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
