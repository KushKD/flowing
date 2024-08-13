package com.mis.education.Education.MIS.modules.customer_address;

import java.io.Serializable;

public class AddressForm implements Serializable {

    private String country;
    private String state;
    private String city;
    private String defaultAddress;
    private String address;
    private String pincode;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(String defaultAddress) {
        this.defaultAddress = defaultAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "AddressForm{" +
                "country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", defaultAddress='" + defaultAddress + '\'' +
                ", address='" + address + '\'' +
                ", pincode='" + pincode + '\'' +
                '}';
    }
}
