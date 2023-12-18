package com.example.hci_prototyp_ws23.Models;

import java.util.ArrayList;
import java.util.Date;

public class User {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Address userAddress;
    private Date dateOfBirth;
    private Gender gender;
    private ArrayList<Booking> userBookings;
    private ArrayList<Booking> savedBookings;

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getUserAddress() {
        return userAddress;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public ArrayList<Booking> getUserBookings() {
        return userBookings;
    }

    public ArrayList<Booking> getSavedBookings() {
        return savedBookings;
    }

    public enum Gender {
        MALE, FEMALE, OTHER
    }

    public User(String username, String firstName, String lastName, String email, String phoneNumber, Address userAddress, Date dateOfBirth, Gender gender) {
        this.userBookings = new ArrayList<>();
        this.savedBookings = new ArrayList<>();
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userAddress = userAddress;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }
}
