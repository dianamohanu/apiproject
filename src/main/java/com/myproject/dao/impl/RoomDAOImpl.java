package com.myproject.dao.impl;

import com.myproject.dao.RoomDAO;
import com.myproject.domain.Room;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository("roomDAO")
@Transactional
public class RoomDAOImpl implements RoomDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Room> getAvailableRooms(Integer hotelId, Date startDate, Date endDate, Integer capacity) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select R from Room AS R " +
                "where R.capacity = :capacity and R.hotel.hotelId = :hotelId and R.roomId not in " +
                "(select RE.roomId from Room as RE, Reservation as RES where RES.room.roomId = RE.roomId and RE.capacity = :capacity and RE.hotel.hotelId = :hotelId " +
                "and ((RES.startDate BETWEEN :startDatePram AND :endDateParam) " +
                "or (RES.endDate BETWEEN :startDatePram AND :endDateParam) " +
                "or (RES.startDate < :startDatePram AND RES.endDate > :endDateParam)) )");
        query.setParameter("hotelId", hotelId);
        query.setParameter("startDatePram", startDate);
        query.setParameter("endDateParam", endDate);
        query.setParameter("capacity", capacity);
        List<Room> reservations = query.list();
        return reservations;
    }

}
