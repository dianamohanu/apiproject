package com.myproject.service;

import com.myproject.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public Integer getHotelIdForUser(String username) {
        return userDAO.getHotelIdForUser(username);
    }
}
