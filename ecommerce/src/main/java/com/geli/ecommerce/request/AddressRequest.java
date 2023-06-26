package com.geli.ecommerce.request;

import jakarta.persistence.Column;

public class AddressRequest {
    private String addressLineOne;

    private String apartmentInformation;

    private String postalCode;

    private String state;

    private String city;

    private Integer customerId;

    public String getAddressLineOne() {
        return addressLineOne;
    }

    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }

    public String getApartmentInformation() {
        return apartmentInformation;
    }

    public void setApartmentInformation(String apartmentInformation) {
        this.apartmentInformation = apartmentInformation;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
