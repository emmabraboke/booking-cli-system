package com.emmabraboke;

import com.emmabraboke.Booking.Booking;
import com.emmabraboke.Booking.BookingDataAccessService;
import com.emmabraboke.Booking.BookingService;
import com.emmabraboke.Car.CarDataAccessService;
import com.emmabraboke.Car.CarService;
import com.emmabraboke.User.User;
import com.emmabraboke.User.UserDataAccessService;
import com.emmabraboke.User.UserFakerDataAccessService;
import com.emmabraboke.User.UserService;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] ags) {
        System.out.println("Welcome to Booking");

        // Data Access services
        UserDataAccessService userDataSrv = new UserDataAccessService();
        CarDataAccessService carDataSrv = new CarDataAccessService();
        BookingDataAccessService bookingDataSrv = new BookingDataAccessService(carDataSrv);

        // Initialize Data
        carDataSrv.cars("cars.csv");
        userDataSrv.users("users.csv");

        // Services
        UserService userSrv = new UserService(userDataSrv);
        CarService carSrv = new CarService(carDataSrv);
        BookingService bookSrv = new BookingService(bookingDataSrv, carDataSrv);
        Faker fakerSrv = new Faker();

        //create 20 users
        int limit = 20;
        List<User> users= new ArrayList<>(limit);
        // Create and add 20 instances of the User class to the list
        for (int i = 0; i < 20; i++) {
            User user = new User();
            users.add(user);
        }
        UserFakerDataAccessService userFakerSrv = new UserFakerDataAccessService(fakerSrv, userDataSrv, users);


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
                    bookSrv.bookCar(carSrv, userSrv, new Booking());
                    break;
                case "2":
                    bookSrv.viewUserBookedCar(bookSrv);
                    break;
                case "3":
                    bookSrv.viewAllBookings(bookSrv);
                    break;
                case "4":
                    carSrv.viewAvailableCars(carSrv);
                    break;
                case "5":
                    carSrv.viewAvailableElectricCars(carSrv);
                    break;
                case "6":
                    userSrv.viewAllUsers();
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
}


