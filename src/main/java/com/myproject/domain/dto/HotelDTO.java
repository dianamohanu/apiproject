package com.myproject.domain.dto;

import com.myproject.domain.Address;
import com.myproject.domain.Room;

import java.sql.Time;
import java.util.List;

public class HotelDTO {

    private Integer hotelId;

    private String name;

    private Address address;

    private String description;

    private String contactPhoneNumber;

    private Integer numberOfStars;

    private Time checkInHours;

    private Time checkOutHours;

    private List<String> hotelFeatures;

    private List<String> roomFeatures;

    private List<Room> roomsList;

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public Integer getNumberOfStars() {
        return numberOfStars;
    }

    public void setNumberOfStars(Integer numberOfStars) {
        this.numberOfStars = numberOfStars;
    }

    public Time getCheckInHours() {
        return checkInHours;
    }

    public void setCheckInHours(Time checkInHours) {
        this.checkInHours = checkInHours;
    }

    public Time getCheckOutHours() {
        return checkOutHours;
    }

    public void setCheckOutHours(Time checkOutHours) {
        this.checkOutHours = checkOutHours;
    }

    public List<String> getHotelFeatures() {
        return hotelFeatures;
    }

    public void setHotelFeatures(List<String> hotelFeatures) {
        this.hotelFeatures = hotelFeatures;
    }

    public List<String> getRoomFeatures() {
        return roomFeatures;
    }

    public void setRoomFeatures(List<String> roomFeatures) {
        this.roomFeatures = roomFeatures;
    }

    public List<Room> getRoomsList() {
        return roomsList;
    }

    public void setRoomsList(List<Room> roomsList) {
        this.roomsList = roomsList;
    }
}
