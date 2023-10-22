package com.emmabraboke.Booking;

import com.emmabraboke.Car.Car;
import com.emmabraboke.Car.CarDAO;

import javax.naming.NameNotFoundException;

public class BookingService {

    public  Booking createBooking(Booking booking) {
        Car car = CarDAO.getCar(booking.getCarId());
        if (car == null || !car.getAvailable()){
            System.out.println("car not avaible");
            return null;
        }

        return BookingDAO.createBooking(booking);
    }

    public Booking[] getBookings(){
        Booking[] booking = BookingDAO.getBookings();

        if(booking.length == 0){
            System.out.println("no bookings");
        }

       return booking;
    }

    public Booking[] getUserBookings(String userID){
        return BookingDAO.getUserBookings(userID);
    }


    public void printBooking(){
        Booking[] bookings = getBookings();

        for(Booking booking: bookings){
            System.out.println(booking);
        }

    }
}
