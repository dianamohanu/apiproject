package com.myproject.mvc;

import com.myproject.domain.Client;
import com.myproject.mvc.validator.ReservationFormValidator;
import com.myproject.service.ReservationService;
import com.myproject.service.SendConfirmationMail;
import com.myproject.service.UserService;
import com.myproject.util.FiltersForm;
import com.myproject.util.ReservationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/backoffice/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UserService userService;

    @Autowired
    private SendConfirmationMail mailManager;

    @Autowired
    private ReservationFormValidator validator;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String makeReservation(Model model) {
        model.addAttribute("reservationForm", new ReservationForm());

        return "addReservationManager";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String makeReservationSuccess(Principal principal, @ModelAttribute("reservationForm") ReservationForm reservationForm, Model model,
                                         BindingResult bindingResult) {
        String currentUser = principal.getName();
        Integer hotelId = userService.getHotelIdForUser(currentUser);

        validator.validate(reservationForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "addReservationManager";
        }
        else {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            Date javaStartDate = null;
            try {
                javaStartDate = format.parse(reservationForm.getStartDate());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Date javaEndDate = null;
            try {
                javaEndDate = format.parse(reservationForm.getEndDate());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Client client = new Client();
            client.setFirstName(reservationForm.getFirstName());
            client.setLastName(reservationForm.getLastName());
            client.setPhoneNumber(reservationForm.getPhoneNumber());
            client.setEmail(reservationForm.getEmail());

            Integer reservedRoom = reservationService.makeReservation(hotelId, javaStartDate, javaEndDate, reservationForm.getCapacity(), client);
            if (reservedRoom != 0) {
                mailManager.sendConfirmationMail(reservationForm);
                model.addAttribute("reservedRoom", reservedRoom);
            }
        }

        return "addReservationManager";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAllForRestaurant(Principal principal, Model model) {
        String currentUser = principal.getName();
        Integer hotelId = userService.getHotelIdForUser(currentUser);

        model.addAttribute("filtersForm", new FiltersForm());
        model.addAttribute("reservations", reservationService.getAllReservationsForHotel(hotelId));

        return "viewReservations";
    }

    @RequestMapping(value = "/getAllStartingToday", method = RequestMethod.GET)
    public String getAllStartingTodayForRestaurant(Principal principal, Model model) {
        String currentUser = principal.getName();
        Integer hotelId = userService.getHotelIdForUser(currentUser);

        model.addAttribute("filtersForm", new FiltersForm());
        Date date = new Date();
        model.addAttribute("reservations", reservationService.getAllReservationsForHotelStartingOnDate(hotelId, date));

        return "viewReservations";
    }

    @RequestMapping(value = "/getAllEndingToday", method = RequestMethod.GET)
    public String getAllEndingTodayForRestaurant(Principal principal, Model model) {
        String currentUser = principal.getName();
        Integer hotelId = userService.getHotelIdForUser(currentUser);

        model.addAttribute("filtersForm", new FiltersForm());
        Date date = new Date();
        model.addAttribute("reservations", reservationService.getAllReservationsForHotelEndingOnDate(hotelId, date));

        return "viewReservations";
    }


    @RequestMapping(value = "/getAllByFilters", method = RequestMethod.POST)
    public String getAllByFiltersForRestaurant(Principal principal, @ModelAttribute("filtersForm") FiltersForm filtersForm, Model model) {
        String currentUser = principal.getName();
        Integer hotelId = userService.getHotelIdForUser(currentUser);

        String firstName = filtersForm.getFirstName();
        String lastName = filtersForm.getLastName();
        model.addAttribute("reservations", reservationService.getAllReservationsForHotelByFilters(hotelId, firstName, lastName));

        return "viewReservations";
    }

    @RequestMapping(value = "/cancelReservation", method = RequestMethod.GET)
    public String cancelReservation(Principal principal, Model model, @RequestParam("reservationId") Integer reservationId) {
        // TODO: check if principal has the right to remove

        reservationService.cancelReservation(reservationId);

        return "redirect:/backoffice/reservation/getAll";
    }
}
