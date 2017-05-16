package com.myproject.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservation")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Reservation {

    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservationId;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Embedded
    private Client client;

    @ManyToOne
    @JoinColumn(name="room_id", nullable = false)
    private Room room;

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

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

    @ManyToOne
    @JoinColumn(name="room_id", nullable = false)
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
