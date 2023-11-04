package com.emmabraboke.Booking;

public interface BookingDAO {
    Booking createBooking(Booking booking);
    Booking[] getUserBookings(String userID);
    Booking[] getBookings();
    Booking[] append(Booking book, Booking[] bookings);
}

