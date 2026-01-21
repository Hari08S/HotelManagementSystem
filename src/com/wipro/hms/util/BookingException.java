package com.wipro.hms.util;
public class BookingException extends Exception {
    @Override
    public String toString() {
        return "BookingException: Invalid booking operation.";
    }
}
