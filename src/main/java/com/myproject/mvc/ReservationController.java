package com.myproject.mvc;

import com.myproject.service.ReservationService;
import com.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
@RequestMapping(value = "/backoffice/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAllReservationsForRestaurant(Principal principal, Model model) {
        String currentUser = principal.getName();
        Integer hotelId = userService.getHotelIdForUser(currentUser);

        model.addAttribute("allReservationsForHotel", reservationService.getAllReservationsForHotel(hotelId));

        return "viewReservations";
    }
}
