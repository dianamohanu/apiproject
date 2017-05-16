package com.myproject.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Client {

    @Column(insertable = false, updatable = false)
    private String firstName;

    @Column(insertable = false, updatable = false)
    private String lastName;

    @Column(insertable = false, updatable = false)
    private String phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
