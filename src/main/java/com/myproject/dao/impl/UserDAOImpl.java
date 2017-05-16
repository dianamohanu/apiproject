package com.myproject.dao.impl;

import com.myproject.dao.UserDAO;
import com.myproject.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Integer getHotelIdForUser(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM User as U WHERE U.username = :username");
        query.setParameter("username", username);
        List<User> users = query.list();
        if (users.size() > 0) {
            return users.get(0).getHotel().getHotelId();
        }
        return null;
    }
}
