package com.myproject.service;

import com.myproject.dao.ReservationDAO;
import com.myproject.dao.RoomDAO;
import com.myproject.domain.Client;
import com.myproject.domain.Reservation;
import com.myproject.domain.Room;
import com.myproject.domain.dto.ReservationDTO;
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

    public boolean makeReservation(Integer hotelId, Date startDate, Date endDate, Integer capacity, Client client) {
        List<Room> availableRooms = roomDAO.getAvailableRooms(hotelId, startDate, endDate, capacity);

        if (CollectionUtils.isEmpty(availableRooms)) {
            return false;
        }

        reservationDAO.makeReservation(startDate, endDate, client, availableRooms.get(0));
        return true;
    }

    private ReservationDTO reservationPopulator(Reservation reservation) {
        ReservationDTO reservationDTO = new ReservationDTO();
        if (reservation != null) {
            reservationDTO.setReservationId(reservation.getReservationId());
            reservationDTO.setStartDate(reservation.getStartDate());
            reservationDTO.setEndDate(reservation.getEndDate());
            reservationDTO.setClient(reservation.getClient());
        }
        return reservationDTO;
    }
}
