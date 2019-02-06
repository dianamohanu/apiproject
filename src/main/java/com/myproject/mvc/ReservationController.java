package com.myproject.mvc;

import com.myproject.domain.Client;
import com.myproject.domain.dto.ReservationDTO;
import com.myproject.mvc.validator.ReservationFormValidator;
import com.myproject.service.ReservationService;
import com.myproject.service.SendConfirmationMail;
import com.myproject.service.UserService;
import com.myproject.util.FiltersForm;
import com.myproject.util.ReservationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/backoffice/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAllForRestaurant(Principal principal, Model model) {
        String currentUser = principal.getName();
        Integer hotelId = userService.getHotelIdForUser(currentUser);

        model.addAttribute("filtersForm", new FiltersForm());
        model.addAttribute("reservations", reservationService.getAllReservationsForHotel(hotelId));

        return "viewReservations";
    }

    @RequestMapping(value = "/cancelReservation", method = RequestMethod.GET)
    public String cancelReservation(Principal principal, Model model, @RequestParam("reservationId") Integer reservationId) {
        String currentUser = principal.getName();
        Integer hotelId = userService.getHotelIdForUser(currentUser);

        List<ReservationDTO> allReservationsForHotel = reservationService.getAllReservationsForHotel(hotelId);
        if (!CollectionUtils.isEmpty(allReservationsForHotel)) {
            for (ReservationDTO r : allReservationsForHotel) {
                if (r.getReservationId().equals(reservationId)) {
                    reservationService.cancelReservation(reservationId);
                }
            }
        }

        return "redirect:/backoffice/reservation/getAll";
    }
}
