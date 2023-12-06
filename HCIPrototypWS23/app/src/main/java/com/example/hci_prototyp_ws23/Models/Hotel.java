package com.example.hci_prototyp_ws23.Models;

import java.util.ArrayList;

public class Hotel {
    private String hotelName;
    private Address hotelAddress;
    private ArrayList<RoomType> roomTypeTypes;
    private String description;
    private ArrayList<String> facilities;
    public String getHotelName() {
        return hotelName;
    }

    public Address getHotelAddress() {
        return hotelAddress;
    }

    public ArrayList<RoomType> getRoomTypes() {
        return roomTypeTypes;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getFacilities() {
        return facilities;
    }

    public Hotel(String hotelName, Address hotelAddress, String description) {
        facilities = new ArrayList<>();
        roomTypeTypes = new ArrayList<>();
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.description = description;
    }
}
