package org.sda;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Guest {
    private String name;
    private String contactNumber;
    private String email;
    private Booking[] bookingHistory;
    private int bookingCounter;
    private final int maxNumberOfBookings = 100;

    public Guest(String name, String contactNumber, String email) {
        Pattern pattern = Pattern.compile(".+@.+\\..+");
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            System.out.println("Not valid email");
            return;
        }
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
        this.bookingHistory = new Booking[maxNumberOfBookings];
        this.bookingCounter = 0;
    }

    public void addBooking(Booking booking) {
        this.bookingHistory[bookingCounter] = booking;
        this.bookingCounter++;
    }

    public void viewBookingHistory() {
        for (Booking booking : bookingHistory) {
            System.out.println(booking);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Booking[] getBookingHistory() {
        return bookingHistory;
    }

    public void setBookingHistory(Booking[] bookingHistory) {
        this.bookingHistory = bookingHistory;
    }
}
