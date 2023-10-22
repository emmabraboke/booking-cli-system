package com.emmabraboke.Booking;

public class Booking {
    private String id;
    private String carId;

    private String userId;

    public String getCarId() {
        return carId;
    }
    public void setId(String id) {
        this.id = id;
    }

    public Booking(String carId, String userId) {
        this.carId = carId;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id='" + id + '\'' +
                ", carId='" + carId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

}
