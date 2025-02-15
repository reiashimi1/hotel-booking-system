package org.sda;

import java.time.LocalDate;
import java.time.Period;

public class Booking {
    private String guestName;
    private int roomNumber;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int stayDuration;
    private int bookingId;
    private static int totalBookings;

    public Booking(String guestName, int roomNumber, LocalDate checkInDate, LocalDate checkOutDate) {
        if (checkInDate.isAfter(checkOutDate)) {
            System.out.println("Check out date cannot be before checkin date");
            return;
        }
        this.guestName = guestName;
        this.roomNumber = roomNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    private int calculateStayDuration() {
        int nights = Period.between(checkInDate, checkOutDate).getDays();
        nights = checkOutDate.minusYears(checkInDate.getYear())
                .minusMonths(checkInDate.getMonthValue())
                .minusDays(checkInDate.getDayOfYear()).getDayOfYear();

        return nights;
    }

    public void confirmBooking() {
        this.bookingId = (int) Math.random();
        totalBookings++;
        this.stayDuration = calculateStayDuration();
        System.out.println(this.toString());
    }

    public void modifyDates(LocalDate newCheckIn, LocalDate newCheckOut) {
        this.checkInDate = newCheckIn;
        this.checkOutDate = newCheckOut;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getStayDuration() {
        return stayDuration;
    }

    public void setStayDuration(int stayDuration) {
        this.stayDuration = stayDuration;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public static int getTotalBookings() {
        return totalBookings;
    }

    public static void setTotalBookings(int totalBookings) {
        Booking.totalBookings = totalBookings;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "guestName='" + guestName + '\'' +
                ", roomNumber=" + roomNumber +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", stayDuration=" + stayDuration +
                ", bookingId=" + bookingId +
                '}';
    }
}
