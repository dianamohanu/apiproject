package com.myproject.service;

import com.myproject.dao.ReservationDAO;
import com.myproject.dao.RoomDAO;
import com.myproject.domain.Client;
import com.myproject.domain.Reservation;
import com.myproject.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationDAO reservationDAO;

    @Autowired
    private RoomDAO roomDAO;

    public List<Reservation> getAllReservationsForHotel(Integer hotelId) {
        return reservationDAO.getAllReservationsForHotel(hotelId);
    }

    public List<Reservation> getAllReservationsForHotelStartingOnDate(Integer hotelId, Date date) {
        return reservationDAO.getAllReservationsForHotelStartingOnDate(hotelId, date);
    }

    public List<Reservation> getAllReservationsForHotelEndingOnDate(Integer hotelId, Date date) {
        return reservationDAO.getAllReservationsForHotelEndingOnDate(hotelId, date);
    }

    public Integer makeReservation(Integer hotelId, Date startDate, Date endDate, Integer capacity, Client client) {
        List<Room> availableRooms = roomDAO.getAvailableRooms(hotelId, startDate, endDate, capacity);

        if (CollectionUtils.isEmpty(availableRooms)) {
            return 0;
        }

        reservationDAO.makeReservation(startDate, endDate, client, availableRooms.get(0));
        return availableRooms.get(0).getRoomId();
    }

    public List<Reservation> getAllReservationsForHotelByFilters(Integer hotelId, String firstName, String lastName) {
        return reservationDAO.getAllReservationsForHotelByFilters(hotelId, firstName, lastName);
    }

}
