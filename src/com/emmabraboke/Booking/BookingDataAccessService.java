package com.emmabraboke.Booking;

import com.emmabraboke.Car.CarDataAccessService;

import java.util.UUID;

public class BookingDataAccessService implements BookingDAO {
    public static Booking[] bookings = new Booking[0];
    private final CarDataAccessService carDataAccessService;

    public BookingDataAccessService(CarDataAccessService carDataAccessService) {
        this.carDataAccessService = carDataAccessService;
    }

    public Booking createBooking(Booking booking){
        String id = UUID.randomUUID().toString();

        booking.setId(id);
         carDataAccessService.updateCarStatus(booking.getCarId(), false);
         bookings = append(booking, bookings);

        return booking;

    }
    public Booking[] getBookings(){
        return bookings;
    }

    public Booking[] getUserBookings(String userID){
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


    public Booking[] append(Booking book, Booking[] bookings){
        Booking[] temp = bookings;
        int size = temp.length;
        bookings = new Booking[size+1];

        System.arraycopy(temp,0,bookings, 0, temp.length);

        bookings[temp.length] = book;

        return  bookings;
    }
}
