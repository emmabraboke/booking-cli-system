package com.emmabraboke.Booking;

import com.emmabraboke.Car.Car;
import com.emmabraboke.Car.CarDataAccessService;
import com.emmabraboke.Car.CarService;
import com.emmabraboke.User.User;
import com.emmabraboke.User.UserService;

import java.util.Scanner;

public class BookingService {

    private final BookingDataAccessService bookingDataAccessService;
    private final CarDataAccessService carDataAccessService;

    public BookingService(BookingDataAccessService bookingDataAccessService, CarDataAccessService carDataAccessService ){
        this.bookingDataAccessService = bookingDataAccessService;
        this.carDataAccessService = carDataAccessService;
    }
    public  Booking createBooking(Booking booking) {
        Car car = carDataAccessService.getCar(booking.getCarId());
        if (car == null || !car.getAvailable()){
            System.out.println("car not available");
            return null;
        }

        return bookingDataAccessService.createBooking(booking);
    }

    public Booking[] getBookings(){
        Booking[] booking = bookingDataAccessService.getBookings();

        if(booking.length == 0){
            System.out.println("no bookings");
        }

       return booking;
    }

    public void bookCar(CarService carSrv, UserService userSrv, Booking book){
        Scanner bookingValue = new Scanner(System.in);
        carSrv.printCars();
        userSrv.printUsers();
        System.out.println("Enter userId");
        String userId = bookingValue.nextLine();

        User user = userSrv.getUser(userId);

        if (user == null){
            return;
        }

        System.out.println("Enter carId");
        String carId = bookingValue.nextLine();

        book.setCarId(carId);
        book.setUserId(userId);

        Booking booking = createBooking(book);

        if(booking != null){
            System.out.println(booking);
        }
    }

    public void viewUserBookedCar(BookingService bookSrv){
        Scanner userValue = new Scanner(System.in);
        System.out.println("Enter userId");
        String userId = userValue.nextLine();
        bookSrv.getUserBookings(userId);
    }



    public Booking[] getUserBookings(String userID){
        return bookingDataAccessService.getUserBookings(userID);
    }


    public void printBooking(){
        Booking[] bookings = getBookings();

        for(Booking booking: bookings){
            System.out.println(booking);
        }

    }

    public void viewAllBookings(BookingService bookSrv){
        bookSrv.printBooking();
    }
}
