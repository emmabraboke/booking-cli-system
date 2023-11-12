package com.emmabraboke.Booking;

import java.util.List;

public interface BookingDAO {
    Booking createBooking(Booking booking);
    void getUserBookings(String userID);
    List<Booking> getBookings();
}

