package com.myproject.dao.impl;

import com.myproject.dao.ReservationDAO;
import com.myproject.domain.Client;
import com.myproject.domain.Reservation;
import com.myproject.domain.Room;
import com.myproject.util.DateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository("reservationDAO")
@Transactional
public class ReservationDAOImpl implements ReservationDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Reservation> getAllReservationsForHotel(Integer hotelId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT RE FROM Reservation AS RE, Room AS RO WHERE RE.room.roomId = RO.roomId AND RO.hotel.hotelId = :hotelId");
        query.setParameter("hotelId", hotelId);
        List<Reservation> reservations = query.list();
        return reservations;
    }

    @Override
    public List<Reservation> getAllReservationsForHotelStartingOnDate(Integer hotelId, Date date) {
        Date dayBeginning = DateUtils.getDayBeginning(date);
        Date dayEnding = DateUtils.getDayEnding(date);

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT RE FROM Reservation AS RE, Room AS RO WHERE (RE.startDate BETWEEN :dayBeginning AND :dayEnding) AND RE.room.roomId = RO.roomId AND RO.hotel.hotelId = :hotelId");
        query.setParameter("hotelId", hotelId);
        query.setParameter("dayBeginning", dayBeginning);
        query.setParameter("dayEnding", dayEnding);
        List<Reservation> reservations = query.list();
        return reservations;
    }

    @Override
    public List<Reservation> getAllReservationsForHotelEndingOnDate(Integer hotelId, Date date) {
        Date dayBeginning = DateUtils.getDayBeginning(date);
        Date dayEnding = DateUtils.getDayEnding(date);

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT RE FROM Reservation AS RE, Room AS RO WHERE (RE.endDate BETWEEN :dayBeginning AND :dayEnding) AND RE.room.roomId = RO.roomId AND RO.hotel.hotelId = :hotelId");
        query.setParameter("hotelId", hotelId);
        query.setParameter("dayBeginning", dayBeginning);
        query.setParameter("dayEnding", dayEnding);
        List<Reservation> reservations = query.list();
        return reservations;
    }

    @Override
    public void makeReservation(Date startDate, Date endDate, Client client, Room room) {
        Session session = sessionFactory.getCurrentSession();

        Reservation reservation = new Reservation();
        reservation.setStartDate(startDate);
        reservation.setEndDate(endDate);
        reservation.setClient(client);
        reservation.setRoom(room);

        session.save(reservation);
    }

    @Override
    public List<Reservation> getAllReservationsForHotelByFilters(Integer hotelId, String firstName, String lastName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT RE FROM Reservation AS RE, Room AS RO WHERE (RE.client.firstName = :firstName AND RE.client.lastName = :lastName) AND RE.room.roomId = RO.roomId AND RO.hotel.hotelId = :hotelId");
        query.setParameter("hotelId", hotelId);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        List<Reservation> reservations = query.list();
        return reservations;
    }


}
