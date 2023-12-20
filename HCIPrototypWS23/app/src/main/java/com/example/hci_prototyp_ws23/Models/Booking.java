package com.example.hci_prototyp_ws23.Models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Date;

public class Booking implements Parcelable {
    private User user;
    private Hotel hotel;
    private RoomType roomType;
    private int numberOfRooms;
    private Date checkInDate;
    private Date checkOutDate;
    private int adultNumber;
    private int childrenNumber;
    private double totalPrice;
    private PaymentMethod paymentMethod;
    private State state;

    protected Booking(Parcel in) {
        user = in.readParcelable(User.class.getClassLoader());
        hotel = in.readParcelable(Hotel.class.getClassLoader());
        roomType = in.readParcelable(RoomType.class.getClassLoader());
        numberOfRooms = in.readInt();
        checkInDate = new Date(in.readLong());
        checkOutDate = new Date(in.readLong());
        adultNumber = in.readInt();
        childrenNumber = in.readInt();
        totalPrice = in.readDouble();
        paymentMethod = PaymentMethod.valueOf(in.readString());
        state = State.valueOf(in.readString());
    }

    public static final Creator<Booking> CREATOR = new Creator<Booking>() {
        @Override
        public Booking createFromParcel(Parcel in) {
            return new Booking(in);
        }

        @Override
        public Booking[] newArray(int size) {
            return new Booking[size];
        }
    };

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }
    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getAdultNumber() {
        return adultNumber;
    }

    public void setAdultNumber(int adultNumber) {
        this.adultNumber = adultNumber;
    }

    public int getChildrenNumber() {
        return childrenNumber;
    }

    public void setChildrenNumber(int childrenNumber) {
        this.childrenNumber = childrenNumber;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeParcelable(user, flags);
        dest.writeParcelable(hotel, flags);
        dest.writeParcelable(roomType, flags);
        dest.writeInt(numberOfRooms);
        dest.writeLong(checkInDate.getTime());
        dest.writeLong(checkOutDate.getTime());
        dest.writeInt(adultNumber);
        dest.writeInt(childrenNumber);
        dest.writeDouble(totalPrice);
        dest.writeString(paymentMethod.name());
        dest.writeString(state.name());
    }

    public enum PaymentMethod {
        PAYPAL, ONSITE, BANKING
    }
    private enum State {
        ENDED, BOOKED, CANCELED
    }
    public Booking(User user, Hotel hotel, RoomType roomType, int numberOfRooms, Date checkInDate, Date checkOutDate, int adultNumber, int childrenNumber, double totalPrice, PaymentMethod paymentMethod) {
        this.user = user;
        this.hotel = hotel;
        this.roomType = roomType;
        this.numberOfRooms = numberOfRooms;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.adultNumber = adultNumber;
        this.childrenNumber = childrenNumber;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.state = State.BOOKED;
    }
}
