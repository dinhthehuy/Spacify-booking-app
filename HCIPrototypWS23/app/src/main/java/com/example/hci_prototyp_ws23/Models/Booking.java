package com.example.hci_prototyp_ws23.Models;

import java.util.Date;

public class Booking {
    private User user;
    private Hotel hotel;
    private RoomType roomType;
    private Date checkInDate;
    private Date checkOutDate;
    private int adultNumber;
    private int childrenNumber;
    private double totalPrice;
    private PaymentMethod paymentMethod;

    public enum PaymentMethod {
        PAYPAL, ONSITE, BANKING;
    }
}
