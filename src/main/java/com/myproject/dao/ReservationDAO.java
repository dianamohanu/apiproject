package com.myproject.dao;

import com.myproject.domain.Reservation;

import java.util.List;

public interface ReservationDAO {

    List<Reservation> getAllReservationsForHotel(Integer hotelId);

}
