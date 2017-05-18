package com.myproject.dao;

import com.myproject.domain.Reservation;

import java.util.Date;
import java.util.List;

public interface ReservationDAO {

    List<Reservation> getAllReservationsForHotel(Integer hotelId);

    List<Reservation> getAllReservationsForHotelStartingOnDate(Integer hotelId, Date date);

    List<Reservation> getAllReservationsForHotelEndingOnDate(Integer hotelId, Date date);

}
