package com.wipro.hms.service;
import java.util.ArrayList;
import com.wipro.hms.entity.*;
import com.wipro.hms.util.*;
public class HotelService {
    private ArrayList<Guest> guests;
    private ArrayList<Room> rooms;
    private ArrayList<Booking> bookings;
    public HotelService(ArrayList<Guest> guests, ArrayList<Room> rooms, ArrayList<Booking> bookings) {
        this.guests = guests;
        this.rooms = rooms;
        this.bookings = bookings;
    }
    public boolean validateGuest(String guestId) throws InvalidGuestException {
        for (Guest g : guests) {
            if (g.getGuestId().equals(guestId)) {
                return true;
            }
        }
        throw new InvalidGuestException();
    }
    public boolean checkRoomAvailability(String roomId) throws RoomNotAvailableException {
        for (Room r : rooms) {
            if (r.getRoomId().equals(roomId)) {
                if (r.isAvailable()) {
                    return true;
                } else {
                    throw new RoomNotAvailableException();
                }
            }
        }
        throw new RoomNotAvailableException();
    }
    public Booking bookRoom(String guestId, String roomId, int nights) throws Exception {
        validateGuest(guestId);
        checkRoomAvailability(roomId);
        Room selectedRoom = null;
        for (Room r : rooms) {
            if (r.getRoomId().equals(roomId)) {
                selectedRoom = r;
                break;
            }
        }
        Booking booking = new Booking();
        booking.setBookingId("B" + (bookings.size() + 1));
        booking.setGuestId(guestId);
        booking.setRoomId(roomId);
        booking.setNumberOfNights(nights);
        booking.setTotalAmount(selectedRoom.getPricePerNight() * nights);
        selectedRoom.setAvailable(false);
        bookings.add(booking);
        return booking;
    }
    public boolean checkout(String bookingId) throws BookingException {
        for (Booking b : bookings) {
            if (b.getBookingId().equals(bookingId)) {
                for (Room r : rooms) {
                    if (r.getRoomId().equals(b.getRoomId())) {
                        r.setAvailable(true);
                        return true;
                    }
                }
            }
        }
        throw new BookingException();
    }
    public void printGuestBookings(String guestId) {
        for (Booking b : bookings) {
            if (b.getGuestId().equals(guestId)) {
                System.out.println("Booking ID : " + b.getBookingId());
                System.out.println("Room ID : " + b.getRoomId());
                System.out.println("Nights : " + b.getNumberOfNights());
                System.out.println("Total Amount : Rs." + b.getTotalAmount());
                System.out.println("---------------------------");
            }
        }
    }
}
