package com.myproject.mvc;

import com.myproject.domain.dto.HotelDTO;
import com.myproject.service.HotelService;
import com.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
@RequestMapping(value = "/backoffice/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/hotelInfo", method = RequestMethod.GET)
    public String getHotelInfoForCurrentLoggedInUser(Principal principal, Model model) {
        String currentUser = principal.getName();
        Integer hotelId = userService.getHotelIdForUser(currentUser);

        HotelDTO hotelInfo = hotelService.getHotelInfo(hotelId);
        model.addAttribute("hotelInfo", hotelInfo);

        Integer numberOfStars = hotelInfo.getNumberOfStars();
        int i = 0;
        String html = "";
        while (i < numberOfStars) {
            html += "<span class=\"glyphicon glyphicon-star\"></span> ";
            i++;
        }
        model.addAttribute("stars", html);

        return "hotelInfoManager";
    }

}
