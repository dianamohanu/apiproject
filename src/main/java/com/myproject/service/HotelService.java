package com.myproject.service;

import com.myproject.dao.HotelDAO;
import com.myproject.domain.Hotel;
import com.myproject.domain.dto.HotelDTO;
import com.myproject.util.HBStringUtils;
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

    public HotelDTO getHotelInfo(Integer hotelId) {
        return hotelPopulator(hotelDAO.getHotelInfo(hotelId));
    }

    private HotelDTO hotelPopulator(Hotel hotel) {
        HotelDTO hotelDTO = new HotelDTO();
        if (hotel != null) {
            hotelDTO.setName(hotel.getName());
            hotelDTO.setAddress(hotel.getAddress());
            hotelDTO.setDescription(hotel.getDescription());
            hotelDTO.setContactPhoneNumber(hotel.getContactPhoneNumber());
            hotelDTO.setNumberOfStars(hotel.getNumberOfStars());
            hotelDTO.setCheckInHours(hotel.getCheckInHours());
            hotelDTO.setCheckOutHours(hotel.getCheckOutHours());
            hotelDTO.setHotelFeatures(HBStringUtils.splitStringOnSymbol(hotel.getHotelFeatures(), ";"));
            hotelDTO.setRoomFeatures(HBStringUtils.splitStringOnSymbol(hotel.getRoomFeatures(), ";"));
            hotelDTO.setRoomsList(hotel.getRoomsList());
        }
        return hotelDTO;
    }

}
