package com.wipro.hms.util;
public class RoomNotAvailableException extends Exception {
    @Override
    public String toString() {
        return "RoomNotAvailableException: Room is already occupied or unavailable.";
    }
}
