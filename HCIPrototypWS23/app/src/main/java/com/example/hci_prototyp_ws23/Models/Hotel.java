package com.example.hci_prototyp_ws23.Models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Hotel implements Parcelable {
    private String hotelName;
    private Address hotelAddress;
    private ArrayList<RoomType> roomTypeTypes;
    private String description;
    private ArrayList<String> facilities;

    protected Hotel(Parcel in) {
        hotelName = in.readString();
        hotelAddress = in.readParcelable(Address.class.getClassLoader());
        roomTypeTypes = in.createTypedArrayList(RoomType.CREATOR);
        description = in.readString();
        facilities = in.createStringArrayList();
    }

    public static final Creator<Hotel> CREATOR = new Creator<Hotel>() {
        @Override
        public Hotel createFromParcel(Parcel in) {
            return new Hotel(in);
        }

        @Override
        public Hotel[] newArray(int size) {
            return new Hotel[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(hotelName);
        dest.writeParcelable(hotelAddress, flags);
        dest.writeTypedList(roomTypeTypes);
        dest.writeString(description);
        dest.writeStringList(facilities);
    }
}
