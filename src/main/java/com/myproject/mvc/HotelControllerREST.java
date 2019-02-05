package com.myproject.mvc;

import com.myproject.domain.dto.HotelDTO;
import com.myproject.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/hotelREST")
public class HotelControllerREST {

    @Autowired
    private HotelService hotelService;

    @RequestMapping(value = "/allHotels", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    public List<HotelDTO> getAllHotels(HttpServletResponse response) {
        List<HotelDTO> hotels = hotelService.getAllHotelsForREST();
        response.setStatus(200);
        return hotels;
    }

    @RequestMapping(value = "/hotels/{city}", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    public List<HotelDTO> getHotelsForFilters(@PathVariable("city") String city, HttpServletResponse response) {
        List<HotelDTO> hotels = hotelService.getHotelsForFiltersREST(city);
        response.setStatus(200);
        return hotels;
    }

    @RequestMapping(value = "/hotel/{hotelId}", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    public HotelDTO getHotelDetails(@PathVariable("hotelId") Integer hotelId, HttpServletResponse response) {
        HotelDTO hotel = hotelService.getHotelDetailsForREST(hotelId);
        if (hotel != null) {
            response.setStatus(200);
            return hotel;
        }

        response.setStatus(404);
        return null;
    }
}
