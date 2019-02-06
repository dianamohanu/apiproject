package com.myproject.service;

import com.myproject.dao.HotelDAO;
import com.myproject.domain.Hotel;
import com.myproject.domain.Image;
import com.myproject.domain.Room;
import com.myproject.domain.dto.HotelDTO;
import com.myproject.util.HBStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService {

    private static final String URI = "http://localhost:8080/HibernateAndSpring";

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

//    ------------------------------------------- POPULATORS -------------------------------------------

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
            List<Image> images = hotel.getImages();
            if (!CollectionUtils.isEmpty(images)) {
                hotelDTO.setMainImageURL(URI + images.get(0).getImageURL());
            }
            List<Room> roomsList = hotel.getRoomsList();
            if (!CollectionUtils.isEmpty(roomsList)) {
                Double minimumPrice = roomsList.get(0).getPricePerNight().getPriceInEuro();
                for (int i = 1; i < roomsList.size(); i++) {
                    Room r = roomsList.get(i);
                    if (r.getPricePerNight().getPriceInEuro() < minimumPrice) {
                        minimumPrice = r.getPricePerNight().getPriceInEuro();
                    }
                }
                hotelDTO.setMinimumPricePerNight(minimumPrice);
            }
        }
        return hotelDTO;
    }

}
