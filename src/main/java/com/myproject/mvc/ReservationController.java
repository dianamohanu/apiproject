package com.myproject.mvc;

import com.myproject.domain.Client;
import com.myproject.domain.dto.ReservationDTO;
import com.myproject.service.ReservationService;
import com.myproject.service.UserService;
import com.myproject.util.ReservationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addReservationGetPage(Model model) {
        model.addAttribute("reservationForm", new ReservationForm());

        return "addReservationManager";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addReservationSuccess(Principal principal, @ModelAttribute("reservationForm") ReservationForm reservationForm, Model model) {
        String currentUser = principal.getName();
        Integer hotelId = userService.getHotelIdForUser(currentUser);

        if (!StringUtils.isEmpty(hotelId) && !StringUtils.isEmpty(reservationForm.getStartDate()) && !StringUtils.isEmpty(reservationForm.getEndDate()) &&
                !StringUtils.isEmpty(reservationForm.getCapacity()) && !StringUtils.isEmpty(reservationForm.getPhoneNumber()) && !StringUtils.isEmpty(reservationForm.getEmail())) {

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
                model.addAttribute("reservedRoom", reservedRoom);
            }
        }

        return "addReservationManager";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAllReservationsForRestaurant(Principal principal, Model model) {
        String currentUser = principal.getName();
        Integer hotelId = userService.getHotelIdForUser(currentUser);

        model.addAttribute("allReservationsForHotel", reservationService.getAllReservationsForHotel(hotelId));

        return "viewReservations";
    }

    @RequestMapping(value = "/getAllStartingOnDate", method = RequestMethod.GET)
    public String getAllReservationsForHotelStartingOnDate(Principal principal, @RequestParam("date") String
            date, Model model) {
        if (!StringUtils.isEmpty(date)) {
            String currentUser = principal.getName();
            Integer hotelId = userService.getHotelIdForUser(currentUser);

            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date javaDate = null;
            try {
                javaDate = format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            model.addAttribute("allReservationsForHotelStartingOnDate", reservationService.getAllReservationsForHotelStartingOnDate(hotelId, javaDate));
        }

        return "viewReservations";
    }

    @RequestMapping(value = "/getAllEndingOnDate", method = RequestMethod.GET)
    public String getAllReservationsForHotelEndingOnDate(Principal principal, @RequestParam("date") String
            date, Model model) {
        if (!StringUtils.isEmpty(date)) {
            String currentUser = principal.getName();
            Integer hotelId = userService.getHotelIdForUser(currentUser);

            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date javaDate = null;
            try {
                javaDate = format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            model.addAttribute("allReservationsForHotelEndingOnDate", reservationService.getAllReservationsForHotelEndingOnDate(hotelId, javaDate));
        }

        return "viewReservations";
    }
}
