package com.myproject.dao.impl;

import com.myproject.dao.HotelDAO;
import com.myproject.domain.Hotel;
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
}
