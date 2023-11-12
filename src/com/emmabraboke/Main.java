package com.emmabraboke;

import com.emmabraboke.Booking.Booking;
import com.emmabraboke.Booking.BookingDataAccessService;
import com.emmabraboke.Booking.BookingService;
import com.emmabraboke.Car.CarDataAccessService;
import com.emmabraboke.Car.CarService;
import com.emmabraboke.User.UserDataAccessService;
import com.emmabraboke.User.UserService;
import java.util.Scanner;

public class Main{
    public static void main(String[] ags) {
        System.out.println("Welcome to Booking");

        // Data Access services
        UserDataAccessService userDataSrv = new UserDataAccessService();
        CarDataAccessService carDataSrv = new CarDataAccessService();
        BookingDataAccessService bookingDataSrv = new BookingDataAccessService(carDataSrv);

        // Initialize Data
        carDataSrv.cars("src/com/emmabraboke/cars.csv");
        userDataSrv.users("src/com/emmabraboke/users.csv");

        // Services
        UserService userSrv = new UserService(userDataSrv);
        CarService carSrv = new CarService(carDataSrv);
        BookingService bookSrv = new BookingService(bookingDataSrv, carDataSrv);

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
                    userSrv.viewAllUsers(userSrv);
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


