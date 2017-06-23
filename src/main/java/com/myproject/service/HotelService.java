package com.myproject.service;

import com.myproject.dao.HotelDAO;
import com.myproject.domain.Hotel;
import com.myproject.domain.Image;
import com.myproject.domain.dto.HotelDTO;
import com.myproject.util.HBStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelDAO hotelDAO;

//    ------------------------------------------- REST -------------------------------------------

    public List<HotelDTO> getAllHotelsForREST() {
        List<HotelDTO> hotels = new ArrayList<>();
        List<Hotel> allHotels = hotelDAO.getAllHotels();
        if (!CollectionUtils.isEmpty(allHotels)) {
            for (Hotel h : allHotels) {
                hotels.add(hotelPopulatorForREST(h));
            }
        }
        return hotels;
    }

    public List<HotelDTO> getHotelsForFiltersREST(String city) {
        List<HotelDTO> hotels = new ArrayList<>();
        List<Hotel> hotelsForFilters = hotelDAO.getHotelsForFilters(city);
        if (!CollectionUtils.isEmpty(hotelsForFilters)) {
            for (Hotel h : hotelsForFilters) {
                hotels.add(hotelPopulatorForREST(h));
            }
        }
        return hotels;
    }

    public HotelDTO getHotelDetailsForREST(Integer hotelId) {
        Hotel hotel = hotelDAO.getHotelInfo(hotelId);
        HotelDTO hotelDTO = new HotelDTO();
        if (hotel != null) {
            hotelDTO = hotelPopulatorForREST(hotel);
        }
        return hotelDTO;
    }

//    ------------------------------------------- MANAGER -------------------------------------------

    public HotelDTO getHotelInfo(Integer hotelId) {
        return hotelPopulator(hotelDAO.getHotelInfo(hotelId));
    }

//    ------------------------------------------- POPULATORS -------------------------------------------

    private HotelDTO hotelPopulator(Hotel hotel) {
        HotelDTO hotelDTO = new HotelDTO();
        if (hotel != null) {
            hotelDTO.setName(hotel.getName());
            hotelDTO.setAddress(hotel.getAddress());
            hotelDTO.setDescription(hotel.getDescription());
            hotelDTO.setContactPhoneNumber(hotel.getContactPhoneNumber());
            hotelDTO.setEmail(hotel.getEmail());
            hotelDTO.setNumberOfStars(hotel.getNumberOfStars());
            hotelDTO.setCheckInHours(hotel.getCheckInHours());
            hotelDTO.setCheckOutHours(hotel.getCheckOutHours());
            hotelDTO.setHotelFeatures(HBStringUtils.splitStringOnSymbol(hotel.getHotelFeatures(), ";"));
            hotelDTO.setRoomFeatures(HBStringUtils.splitStringOnSymbol(hotel.getRoomFeatures(), ";"));
            hotelDTO.setRoomsList(hotel.getRoomsList());
            List<Image> images = hotel.getImages();
            if (!CollectionUtils.isEmpty(images)) {
                hotelDTO.setMainImageURL(images.get(0).getImageURL());
            }
            hotelDTO.setHotelId(hotel.getHotelId());
            hotelDTO.setBuiltYear(hotel.getBuiltYear());
            hotelDTO.setNumberOfFloors(hotel.getNumberOfFloors());
        }
        return hotelDTO;
    }

    private HotelDTO hotelPopulatorForREST(Hotel hotel) {
        HotelDTO hotelDTO = new HotelDTO();
        if (hotel != null) {
            hotelDTO.setName(hotel.getName());
            hotelDTO.setAddress(hotel.getAddress());
            hotelDTO.setDescription(hotel.getDescription());
            hotelDTO.setContactPhoneNumber(hotel.getContactPhoneNumber());
            hotelDTO.setEmail(hotel.getEmail());
            hotelDTO.setNumberOfStars(hotel.getNumberOfStars());
            hotelDTO.setCheckInHours(hotel.getCheckInHours());
            hotelDTO.setCheckOutHours(hotel.getCheckOutHours());
            hotelDTO.setHotelFeatures(HBStringUtils.splitStringOnSymbol(hotel.getHotelFeatures(), ";"));
            hotelDTO.setRoomFeatures(HBStringUtils.splitStringOnSymbol(hotel.getRoomFeatures(), ";"));
            hotelDTO.setHotelId(hotel.getHotelId());
            hotelDTO.setBuiltYear(hotel.getBuiltYear());
            hotelDTO.setNumberOfFloors(hotel.getNumberOfFloors());
        }
        return hotelDTO;
    }

}
