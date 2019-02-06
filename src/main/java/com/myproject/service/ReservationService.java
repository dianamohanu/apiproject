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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationDAO reservationDAO;

    @Autowired
    private RoomDAO roomDAO;

    public List<ReservationDTO> getAllReservationsForHotel(Integer hotelId) {
        List<ReservationDTO> reservationsDTO = new ArrayList<>();

        List<Reservation> reservations = reservationDAO.getAllReservationsForHotel(hotelId);
        if (!CollectionUtils.isEmpty(reservations)) {
            for (Reservation r : reservations) {
                reservationsDTO.add(reservationPopulator(r));
            }
        }

        return reservationsDTO;
    }

    public Integer makeReservation(Integer hotelId, Date startDate, Date endDate, Integer capacity, Client client) {
        List<Room> availableRooms = roomDAO.getAvailableRooms(hotelId, startDate, endDate, capacity);

        if (CollectionUtils.isEmpty(availableRooms)) {
            return 0;
        }

        reservationDAO.makeReservation(startDate, endDate, client, availableRooms.get(0));
        return availableRooms.get(0).getRoomNumber();
    }

    public boolean checkRoomAvailability(Integer hotelId, Date startDate, Date endDate, Integer capacity) {
        List<Room> availableRooms = roomDAO.getAvailableRooms(hotelId, startDate, endDate, capacity);

        if (CollectionUtils.isEmpty(availableRooms)) {
            return false;
        }

        return true;
    }

    public void cancelReservation(Integer reservationId) {
        reservationDAO.cancelReservation(reservationId);
    }

    private ReservationDTO reservationPopulator(Reservation reservation) {
        ReservationDTO reservationDTO = new ReservationDTO();
        if (reservation != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            reservationDTO.setReservationId(reservation.getReservationId());
            reservationDTO.setStartDate(reservation.getStartDate());
            reservationDTO.setEndDate(reservation.getEndDate());
            reservationDTO.setClient(reservation.getClient());
            reservationDTO.setRoom(reservation.getRoom());
            reservationDTO.setStartDateFormatted(simpleDateFormat.format(reservation.getStartDate()));
            reservationDTO.setEndDateFormatted(simpleDateFormat.format(reservation.getEndDate()));
        }
        return reservationDTO;
    }
}
