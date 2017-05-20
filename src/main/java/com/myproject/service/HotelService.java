package com.myproject.service;

import com.myproject.dao.HotelDAO;
import com.myproject.domain.Hotel;
import com.myproject.domain.dto.HotelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelDAO hotelDAO;

    public List<HotelDTO> getAllHotels() {
        List<HotelDTO> hotels = new ArrayList<>();
        for (Hotel h : hotelDAO.getAllHotels()) {
            hotels.add(hotelPopulator(h));
        }
        return hotels;
    }

    private HotelDTO hotelPopulator(Hotel hotel) {
        HotelDTO hotelDTO = new HotelDTO();
        if (hotel != null) {
            hotelDTO.setHotelId(hotel.getHotelId());
            hotelDTO.setName(hotel.getName());
            hotelDTO.setAddress(hotel.getAddress());
        }
        return hotelDTO;
    }

}
