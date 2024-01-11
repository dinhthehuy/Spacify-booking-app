package com.example.hci_prototyp_ws23.Models;

import java.util.Date;

public class SavedHotel {
    private final String username;
    private final String hotelName;
    private final Address hotelAddress;
    private final Date checkInDate;
    private final Date checkOutDate;
    private final int adultNumber;
    private final int childrenNumber;
    private final double totalPrice;
    private String imageURL; // TODO: Implement later

    public SavedHotel(String username, String hotelName, Address hotelAddress, Date checkInDate, Date checkOutDate, int adultNumber, int childrenNumber, double totalPrice, String imageURL) {
        this.username = username;
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.adultNumber = adultNumber;
        this.childrenNumber = childrenNumber;
        this.totalPrice = totalPrice;
        this.imageURL = imageURL;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public int getAdultNumber() {
        return adultNumber;
    }

    public int getChildrenNumber() {
        return childrenNumber;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Address getHotelAddress() {
        return hotelAddress;
    }
}
