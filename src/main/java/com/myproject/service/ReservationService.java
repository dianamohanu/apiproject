package com.myproject.service;

import com.myproject.dao.ReservationDAO;
import com.myproject.domain.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationDAO reservationDAO;

    public List<Reservation> getAllReservationsForHotel(Integer hotelId) {
        return reservationDAO.getAllReservationsForHotel(hotelId);
    }

}