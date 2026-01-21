package com.wipro.hms.main;
import java.util.ArrayList;
import com.wipro.hms.entity.*;
import com.wipro.hms.service.HotelService;
import com.wipro.hms.util.*;
public class Main {
    public static void main(String[] args) {
        ArrayList<Guest> guests = new ArrayList<>();
        guests.add(new Guest("G001", "Rohan Verma", "9876543210"));
        guests.add(new Guest("G002", "Sneha Patel", "9123456780"));
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room("R101", "Standard", 1500.0, true));
        rooms.add(new Room("R102", "Deluxe", 2500.0, true));
        ArrayList<Booking> bookings = new ArrayList<>();
        HotelService service = new HotelService(guests, rooms, bookings);
        try {
            Booking b = service.bookRoom("G001", "R101", 3);
            System.out.println("Room Booked Successfully!");
            System.out.println("Booking ID : " + b.getBookingId());
            System.out.println("Room ID : " + b.getRoomId());
            System.out.println("Total Amount: Rs." + b.getTotalAmount());
            System.out.println("\n--- Guest Booking Summary ---");
            service.printGuestBookings("G001");
            service.checkout(b.getBookingId());
            System.out.println("\nCheckout Completed Successfully.");
        } catch (InvalidGuestException ige) {
            System.out.println(ige.toString());
        } catch (RoomNotAvailableException rna) {
            System.out.println(rna.toString());
        } catch (BookingException be) {
            System.out.println(be.toString());
        } catch (Exception ex) {
            System.out.println("Unexpected Error: " + ex.toString());
        }
    }
}
