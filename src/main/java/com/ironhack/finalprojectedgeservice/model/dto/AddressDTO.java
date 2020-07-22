package com.ironhack.finalprojectedgeservice.model.dto;

public class AddressDTO {

    private String street;
    private Integer portal;
    private Integer number;

    public AddressDTO() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getPortal() {
        return portal;
    }

    public void setPortal(Integer portal) {
        this.portal = portal;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

}
