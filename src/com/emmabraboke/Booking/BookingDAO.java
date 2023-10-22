package com.emmabraboke.Booking;

import com.emmabraboke.Car.CarDAO;

import java.awt.print.Book;
import java.util.UUID;

public class BookingDAO {
    public static Booking[] bookings = new Booking[0];


    public static Booking createBooking(Booking booking){
        String id = UUID.randomUUID().toString();

        booking.setId(id);
         CarDAO.updateCarStatus(booking.getCarId(), false);
         bookings = append(booking, bookings);

        return booking;

    }
    public static Booking[] getBookings(){
        return bookings;
    }

    public static Booking[] getUserBookings(String userID){
        Booking[] userBookings = new Booking[0];

        for(Booking book: bookings){
            if(book != null && book.getUserId().equals(userID)){
                System.out.println(book);
                userBookings = append(book, userBookings);
            }
        }

        if(userBookings.length == 0){
            System.out.println("user doesn't have any booking");
        }

        return userBookings;
    }

    public static Booking[] append(Booking book, Booking[] bookings){
        Booking[] temp = bookings;
        int size = temp.length;
        bookings = new Booking[size+1];

        System.arraycopy(temp,0,bookings, 0, temp.length);

        bookings[temp.length] = book;

        return  bookings;
    }
}
