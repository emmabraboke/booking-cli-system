package com.emmabraboke;

import com.emmabraboke.Booking.Booking;
import com.emmabraboke.Booking.BookingService;
import com.emmabraboke.Car.Car;
import com.emmabraboke.Car.CarService;
import com.emmabraboke.User.User;
import com.emmabraboke.User.UserService;

import javax.naming.NameNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] ags) {
        System.out.println("Welcome to Booking");

        User user = new User("Emmanuel", "Braboke");
        User user1 = new User("Joshua", "Braboke");
        UserService userSrv = new UserService();

        userSrv.createUser(user);
        userSrv.createUser(user1);

        Car car = new Car("toyota",  50.0, false);
        Car car1 = new Car("bmw", 70.0, false);
        CarService carSrv = new CarService();
        carSrv.createCar(car);
        carSrv.createCar(car1);

        BookingService bookSrv = new BookingService();


        int quit = 1;
        while (quit != 0) {
            String activity = """
                1 - Book Car
                2 - View All User Booked Cars
                3 - View All Bookings
                4 - View Available Car
                5 - View Available Electric Cars
                6 - View all users
                7 - Exit""";
            System.out.println(activity);
            Scanner value = new Scanner(System.in);
            String option = value.nextLine();

            switch (option) {
                case "1":
                    bookCar(carSrv, bookSrv);
                    break;
                case "2":
                    viewUserBookedCar(bookSrv);
                    break;
                case "3":
                    viewAllBookings(bookSrv);
                    break;
                case "4":
                    viewAvailableCars(carSrv);
                    break;
                case "5":
                    viewAvailableElectricCars(carSrv);
                    break;
                case "6":
                    viewAllUsers(userSrv);
                    break;
                case "7":
                    System.out.println("Exited Successfully");
                    quit = 0;
                    break;
                default:
                    System.out.println("select a valid number");
            }

        }
    }

    public static void bookCar(CarService carSrv, BookingService bookSrv){
        Scanner bookingValue = new Scanner(System.in);
        carSrv.printCars();
        System.out.println("Enter userId");
        String userId = bookingValue.nextLine();
        System.out.println("Enter carId");
        String carId = bookingValue.nextLine();

        Booking book = new  Booking(carId, userId);

        Booking booking1 = bookSrv.createBooking(book);
        System.out.println(booking1);
    }

    public static void viewUserBookedCar(BookingService bookSrv){
        Scanner userValue = new Scanner(System.in);
        System.out.println("Enter userId");
        String userId = userValue.nextLine();
        bookSrv.getUserBookings(userId);
    }

    public static void viewAllBookings(BookingService bookSrv){
        bookSrv.printBooking();
    }

    public static void viewAvailableCars(CarService carSrv){
        carSrv.printCars();
    }

    public static  void viewAvailableElectricCars(CarService carSrv){
        carSrv.printElectricCars();
    }

    public static  void viewAllUsers(UserService userSrv){
        userSrv.printUsers();
    }

}


