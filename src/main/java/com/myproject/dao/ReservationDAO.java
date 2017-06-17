package com.myproject.dao;

import com.myproject.domain.Client;
import com.myproject.domain.Reservation;
import com.myproject.domain.Room;

import java.util.Date;
import java.util.List;

public interface ReservationDAO {

    List<Reservation> getAllReservationsForHotel(Integer hotelId);

    List<Reservation> getAllReservationsForHotelStartingOnDate(Integer hotelId, Date date);

    List<Reservation> getAllReservationsForHotelEndingOnDate(Integer hotelId, Date date);

    void makeReservation(Date startDate, Date endDate, Client client, Room room);

    List<Reservation> getAllReservationsForHotelByFilters(Integer hotelId, String firstName, String lastName);
}
