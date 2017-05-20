package com.myproject.service;

import com.myproject.dao.ReservationDAO;
import com.myproject.domain.Reservation;
import com.myproject.domain.dto.ReservationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationDAO reservationDAO;

    public List<Reservation> getAllReservationsForHotel(Integer hotelId) {
        return reservationDAO.getAllReservationsForHotel(hotelId);
    }

    public List<Reservation> getAllReservationsForHotelStartingOnDate(Integer hotelId, Date date) {
        return reservationDAO.getAllReservationsForHotelStartingOnDate(hotelId, date);
    }

    public List<Reservation> getAllReservationsForHotelEndingOnDate(Integer hotelId, Date date) {
        return reservationDAO.getAllReservationsForHotelEndingOnDate(hotelId, date);
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
