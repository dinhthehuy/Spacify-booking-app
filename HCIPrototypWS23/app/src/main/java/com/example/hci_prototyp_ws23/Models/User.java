package com.example.hci_prototyp_ws23.Models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Date;

public class User implements Parcelable {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Address userAddress;
    private Date dateOfBirth;
    private Gender gender;
    private ArrayList<Booking> userBookings;
    private ArrayList<Hotel> savedHotels;

    protected User(Parcel in) {
        username = in.readString();
        firstName = in.readString();
        lastName = in.readString();
        email = in.readString();
        phoneNumber = in.readString();
        userAddress = in.readParcelable(Address.class.getClassLoader());
        dateOfBirth = new Date(in.readLong());
        gender = Gender.valueOf(in.readString());
        in.readTypedList(userBookings, Booking.CREATOR);
        in.readTypedList(savedHotels, Hotel.CREATOR);
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

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

    public ArrayList<Hotel> getSavedHotels() {
        return savedHotels;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(email);
        dest.writeString(phoneNumber);
        dest.writeParcelable(userAddress, flags);
        dest.writeLong(dateOfBirth.getTime());
        dest.writeString(gender.name());
        dest.writeTypedList(userBookings);
        dest.writeTypedList(savedHotels);
    }

    public enum Gender {
        MALE, FEMALE, OTHER
    }

    public User(String username, String firstName, String lastName, String email, String phoneNumber, Address userAddress, Date dateOfBirth, Gender gender) {
        this.userBookings = new ArrayList<>();
        this.savedHotels = new ArrayList<>();
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
