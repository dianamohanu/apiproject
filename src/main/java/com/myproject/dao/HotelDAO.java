package com.myproject.dao;

import com.myproject.domain.Hotel;

import java.util.List;

public interface HotelDAO {

    List<Hotel> getAllHotels();

    List<Hotel> getHotelsForFilters(String city);

    Hotel getHotelInfo(Integer hotelId);
}
