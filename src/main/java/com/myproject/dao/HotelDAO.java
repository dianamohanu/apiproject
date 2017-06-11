package com.myproject.dao;

import com.myproject.domain.Hotel;

import java.util.List;

public interface HotelDAO {

    List<Hotel> getAllHotels();

    Hotel getHotelInfo(Integer hotelId);
}
