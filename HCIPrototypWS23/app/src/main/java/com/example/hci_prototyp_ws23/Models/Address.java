package com.example.hci_prototyp_ws23.Models;

public class Address {
    private String country;
    private String city;
    private String streetAddress;
    private int postalCode;

    public Address(String country, String city, String streetAddress, int postalCode) {
        this.country = country;
        this.city = city;
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
}
