package com.example.hci_prototyp_ws23.Models;

import java.util.ArrayList;

public class RoomType {
    private String name;
    private Hotel hotel;
    private int size;
    private ArrayList<String> services;
    private int maxAdultNumber;
    private int maxChildrenNumber;
    private int numberOfAvailableRooms;

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public ArrayList<String> getServices() {
        return services;
    }

    public int getMaxAdultNumber() {
        return maxAdultNumber;
    }

    public int getMaxChildrenNumber() {
        return maxChildrenNumber;
    }

    public int getNumberOfAvailableRooms() {
        return numberOfAvailableRooms;
    }

    public Hotel getHotel() {
        return hotel;
    }

    RoomType(String name, Hotel hotel, int size, int maxAdultNumber, int maxChildrenNumber, int numberOfAvailableRooms) {
        services = new ArrayList<>();
        this.name = name;
        this.hotel = hotel;
        this.size = size;
        this.maxAdultNumber = maxAdultNumber;
        this.maxChildrenNumber = maxChildrenNumber;
        this.numberOfAvailableRooms = numberOfAvailableRooms;
    }

}
