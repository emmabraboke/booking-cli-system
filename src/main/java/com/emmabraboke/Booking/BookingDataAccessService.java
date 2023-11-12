package com.emmabraboke.Booking;

import com.emmabraboke.Car.CarDataAccessService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookingDataAccessService implements BookingDAO {
    public static List<Booking> bookings = new ArrayList<>();
    private final CarDataAccessService carDataAccessService;

    public BookingDataAccessService(CarDataAccessService carDataAccessService) {
        this.carDataAccessService = carDataAccessService;
    }

    public Booking createBooking(Booking booking){
        String id = UUID.randomUUID().toString();

        booking.setId(id);
         carDataAccessService.updateCarStatus(booking.getCarId(), false);
        bookings.add(booking);

        return booking;

    }
    public List<Booking> getBookings(){
        return bookings;
    }

    public void getUserBookings(String userID){
        List<Booking> userBookings = new ArrayList<>();

        for(Booking book: bookings){
            if(book != null && book.getUserId().equals(userID)){
                System.out.println(book);
                userBookings.add(book);
            }
        }

        if(userBookings.isEmpty()){
            System.out.println("user doesn't have any booking");
        }

    }


    public Booking[] append(Booking book, Booking[] bookings){
        Booking[] temp = bookings;
        int size = temp.length;
        bookings = new Booking[size+1];

        System.arraycopy(temp,0,bookings, 0, temp.length);

        bookings[temp.length] = book;

        return  bookings;
    }
}
