package com.example.hci_prototyp_ws23.Models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class RoomType implements Parcelable {
    private String name;
    private int size;
    private int maxAdultNumber;
    private int maxChildrenNumber;
    private int numberOfAvailableRooms;
    private ArrayList<String> services;
    private double pricePerNight;

    protected RoomType(Parcel in) {
        name = in.readString();
        size = in.readInt();
        maxAdultNumber = in.readInt();
        maxChildrenNumber = in.readInt();
        numberOfAvailableRooms = in.readInt();
        services = in.createStringArrayList();
        pricePerNight = in.readDouble();
    }

    public static final Creator<RoomType> CREATOR = new Creator<RoomType>() {
        @Override
        public RoomType createFromParcel(Parcel in) {
            return new RoomType(in);
        }

        @Override
        public RoomType[] newArray(int size) {
            return new RoomType[size];
        }
    };

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
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

    public ArrayList<String> getServices() {
        return services;
    }
    public double getPricePerNight() { return pricePerNight; }

    public void setPricePerNight(double pricePerNight) { this.pricePerNight = pricePerNight; }

    public RoomType(String name, int size, int maxAdultNumber, int maxChildrenNumber, int numberOfAvailableRooms, double pricePerNight) {
        services = new ArrayList<>();
        this.name = name;
        this.size = size;
        this.maxAdultNumber = maxAdultNumber;
        this.maxChildrenNumber = maxChildrenNumber;
        this.numberOfAvailableRooms = numberOfAvailableRooms;
        this.pricePerNight = pricePerNight;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(size);
        dest.writeInt(maxAdultNumber);
        dest.writeInt(maxChildrenNumber);
        dest.writeInt(numberOfAvailableRooms);
        dest.writeStringList(services);
        dest.writeDouble(pricePerNight);
    }
}
