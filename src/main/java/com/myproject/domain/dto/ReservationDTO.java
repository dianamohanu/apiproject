package com.myproject.domain.dto;

import com.myproject.domain.Client;

import java.util.Date;

public class ReservationDTO {

    private Date startDate;

    private Date endDate;

    private Client client;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
