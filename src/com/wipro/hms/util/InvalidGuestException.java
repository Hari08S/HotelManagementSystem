package com.wipro.hms.util;
public class InvalidGuestException extends Exception {
    @Override
    public String toString() {
        return "InvalidGuestException: Guest ID does not exist.";
    }
}
