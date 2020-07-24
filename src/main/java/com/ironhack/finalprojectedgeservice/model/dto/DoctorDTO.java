package com.ironhack.finalprojectedgeservice.model.dto;

import java.time.LocalDate;

public class DoctorDTO {

    private Long id;
    private String name;
    private String surnames;
    private String schoolNumber;
    private LocalDate birthday;
    private String street;
    private Integer portal;
    private Integer number;

    public DoctorDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getSchoolNumber() {
        return schoolNumber;
    }

    public void setSchoolNumber(String schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
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

    @Override
    public String toString() {
        return "DoctorDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surnames='" + surnames + '\'' +
                ", schoolNumber='" + schoolNumber + '\'' +
                ", birthday=" + birthday +
                ", street='" + street + '\'' +
                ", portal=" + portal +
                ", number=" + number +
                '}';
    }
}
