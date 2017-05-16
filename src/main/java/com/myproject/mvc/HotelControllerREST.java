package com.myproject.mvc;

import com.myproject.domain.dto.HotelDTO;
import com.myproject.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/hotelREST")
public class HotelControllerREST {

    @Autowired
    private HotelService hotelService;

    @RequestMapping(value = "", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    public List<HotelDTO> getAllHotels(HttpServletResponse response) {
        List<HotelDTO> hotels = hotelService.getAllHotels();
        if (hotels.size() == 0) {
            response.setStatus(404);
        } else {
            response.setStatus(200);
        }
        return hotels;
    }
}
