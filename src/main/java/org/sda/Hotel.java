package org.sda;

import java.time.LocalDate;

public class Hotel {
    private String hotelName;
    private int[] availableRooms;
    private Booking[] bookings;
    private int bookingCounter;

    public Hotel(String hotelName, int totalAvailableRooms) {
        this.hotelName = hotelName;
        this.availableRooms = new int[totalAvailableRooms];
        this.bookingCounter = 0;
    }

    private boolean checkAvailability(int roomNumber) {
        boolean isAvailable = false;
        for (int availableRoom : this.availableRooms) {
            if (availableRoom == roomNumber) {
                isAvailable = true;
                break;
            }
        }
        return isAvailable;
    }

    public void createBooking(Guest guest, int roomNumber, LocalDate checkIn, LocalDate checkOut) {
        if (checkAvailability(roomNumber)) {
            Booking booking = new Booking(guest.getName(), roomNumber, checkIn, checkOut);
            this.bookings[bookingCounter] = booking;
            bookingCounter++;

        } else {
            System.out.println("Room is not available");
        }
    }

    public void cancelBooking(int bookingID) {
        for (int i = 0; i < bookings.length; i++) {
            if (bookingID == bookings[i].getBookingId()) {
                this.bookings[i] = null;

            }
        }
    }

    public void listAllBookings() {
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int[] getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int[] availableRooms) {
        this.availableRooms = availableRooms;
    }

    public Booking[] getBookings() {
        return bookings;
    }

    public void setBookings(Booking[] bookings) {
        this.bookings = bookings;
    }
}
