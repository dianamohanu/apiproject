package com.myproject.dao.impl;

import com.myproject.dao.HotelDAO;
import com.myproject.domain.Hotel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("hotelDAO")
@Transactional
public class HotelDAOImpl implements HotelDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Hotel> getAllHotels() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Hotel as H").list();
    }

    @Override
    public List<Hotel> getHotelsForFilters(String city) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Hotel as H WHERE H.address.city = :city");
        query.setParameter("city", city);
        List<Hotel> hotels = query.list();
        if(hotels.size() > 0){
            return hotels;
        }
        return null;
    }

    @Override
    public Hotel getHotelInfo(Integer hotelId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Hotel as H WHERE H.hotelId = :id");
        query.setParameter("id", hotelId);
        List<Hotel> hotels = query.list();
        if(hotels.size() > 0){
            return hotels.get(0);
        }
        return null;
    }

}
