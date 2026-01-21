package com.wipro.hms.entity;
public class Guest {
    private String guestId;
    private String guestName;
    private String contactNumber;
    public Guest(String guestId, String guestName, String contactNumber) {
        this.guestId = guestId;
        this.guestName = guestName;
        this.contactNumber = contactNumber;
    }
    public String getGuestId() {
        return guestId;
    }
    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }
    public String getGuestName() {
        return guestName;
    }
    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
