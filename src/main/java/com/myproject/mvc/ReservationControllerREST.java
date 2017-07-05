package com.myproject.mvc;

import com.myproject.domain.Client;
import com.myproject.domain.dto.AvailabilityDTO;
import com.myproject.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/reservationREST")
public class ReservationControllerREST {

    @Autowired
    private ReservationService reservationService;

    @RequestMapping(value = "/roomAvailability", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    public AvailabilityDTO checkRoomAvailability(@RequestParam("hotelId") Integer hotelId, @RequestParam("startDate") String startDate,
                                                 @RequestParam("endDate") String endDate, @RequestParam("capacity") Integer capacity) {
        AvailabilityDTO availabilityDTO = new AvailabilityDTO();

        if (!StringUtils.isEmpty(hotelId) && !StringUtils.isEmpty(startDate) && !StringUtils.isEmpty(endDate) &&
                !StringUtils.isEmpty(capacity)) {

            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            Date javaStartDate = null;
            try {
                javaStartDate = format.parse(startDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Date javaEndDate = null;
            try {
                javaEndDate = format.parse(endDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            availabilityDTO.setAvailable(reservationService.checkRoomAvailability(hotelId, javaStartDate, javaEndDate, capacity));
        } else {
            availabilityDTO.setAvailable(false);
        }

        return availabilityDTO;
    }

    @RequestMapping(value = "/reservation", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    public Integer makeReservation(@RequestParam("hotelId") Integer hotelId, @RequestParam("startDate") String startDate,
                                   @RequestParam("endDate") String endDate, @RequestParam("capacity") Integer capacity,
                                   @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                                   @RequestParam("phoneNumber") String phoneNumber, @RequestParam("email") String email) {

        if (!StringUtils.isEmpty(hotelId) && !StringUtils.isEmpty(startDate) && !StringUtils.isEmpty(endDate) &&
                !StringUtils.isEmpty(capacity) && !StringUtils.isEmpty(phoneNumber) && !StringUtils.isEmpty(email)) {

            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            Date javaStartDate = null;
            try {
                javaStartDate = format.parse(startDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Date javaEndDate = null;
            try {
                javaEndDate = format.parse(endDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Client client = new Client();
            client.setFirstName(firstName);
            client.setLastName(lastName);
            client.setPhoneNumber(phoneNumber);
            client.setEmail(email);

            return reservationService.makeReservation(hotelId, javaStartDate, javaEndDate, capacity, client);
        }

        return 0;
    }

}
