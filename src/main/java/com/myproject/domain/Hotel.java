package com.myproject.domain;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.sql.Time;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "hotel")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Hotel {

    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hotelId;

    @Column(nullable = false)
    private String name;

    @Embedded
    private Address address;

    @OneToMany(targetEntity = Room.class, mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Room> roomsList;

    @OneToMany(mappedBy = "hotel")
    private Set<User> users = new HashSet<User>();

    @Column(nullable = false)
    private String contactPhoneNumber;

    @Column
    private String email;

    @Lob
    @Column( length = 100000 )
    private String description;

    @Column
    private Integer numberOfStars;

    @Column
    private Time checkInHours;

    @Column
    private Time checkOutHours;

    @Column
    private String hotelFeatures;

    @Column
    private String roomFeatures;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity = Image.class, mappedBy = "hotelForImage")
    private List<Image> images;

    @Column
    private Integer builtYear;

    @Column
    private Integer numberOfFloors;

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

    public List<Room> getRoomsList() {
        return roomsList;
    }

    public void setRoomsList(List<Room> roomsList) {
        this.roomsList = roomsList;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
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

    public String getHotelFeatures() {
        return hotelFeatures;
    }

    public void setHotelFeatures(String hotelFeatures) {
        this.hotelFeatures = hotelFeatures;
    }

    public String getRoomFeatures() {
        return roomFeatures;
    }

    public void setRoomFeatures(String roomFeatures) {
        this.roomFeatures = roomFeatures;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Integer getBuiltYear() {
        return builtYear;
    }

    public void setBuiltYear(Integer builtYear) {
        this.builtYear = builtYear;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}

