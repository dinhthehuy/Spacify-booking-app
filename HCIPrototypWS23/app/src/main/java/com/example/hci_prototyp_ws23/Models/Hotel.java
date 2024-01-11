package com.example.hci_prototyp_ws23.Models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Hotel implements Parcelable {
    private final String hotelName;
    private final Address hotelAddress;
    private final String description;
    private final double pricePerNight;
    private final String imageURL;
    private final ArrayList<String> facilities;

    private Hotel(Parcel in) {
        hotelName = in.readString();
        hotelAddress = in.readParcelable(Address.class.getClassLoader());
        description = in.readString();
        pricePerNight = in.readDouble();
        facilities = in.createStringArrayList();
        imageURL = in.readString();
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
    public String getDescription() {
        return description;
    }
    public ArrayList<String> getFacilities() {
        return facilities;
    }
    public double getPricePerNight() {
        return pricePerNight;
    }
    public Hotel(String hotelName, Address hotelAddress, String description, double pricePerNight, String imageURL) {
        this.imageURL = imageURL;
        facilities = new ArrayList<>();
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.description = description;
        this.pricePerNight = pricePerNight;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(hotelName);
        dest.writeParcelable(hotelAddress, flags);
        dest.writeString(description);
        dest.writeDouble(pricePerNight);
        dest.writeStringList(facilities);
        dest.writeString(getImageURL());
    }

    public String getImageURL() {
        return imageURL;
    }
}
