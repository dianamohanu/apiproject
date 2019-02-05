package com.myproject.mvc;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.myproject.domain.Client;
import com.myproject.domain.dto.AvailabilityDTO;
import com.myproject.service.ReservationService;
import com.myproject.service.SendConfirmationMail;
import com.myproject.util.ReservationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @Autowired
    private SendConfirmationMail mailManager;

    @RequestMapping(value = "/roomAvailability", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    public AvailabilityDTO checkRoomAvailability(@RequestParam("hotelId") Integer hotelId, @RequestParam("startDate") String startDate,
                                                 @RequestParam("endDate") String endDate, @RequestParam("capacity") Integer capacity) {
        AvailabilityDTO availabilityDTO = new AvailabilityDTO();
        Boolean available = false;

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

            Date currentDate = new Date();
            if (javaStartDate != null && javaEndDate != null) {
                if (!javaEndDate.before(javaStartDate) && !javaEndDate.before(currentDate) && !javaStartDate.before(currentDate)) {
                    available = reservationService.checkRoomAvailability(hotelId, javaStartDate, javaEndDate, capacity);
                }
            }
        }

        availabilityDTO.setAvailable(available);
        return availabilityDTO;
    }

    @RequestMapping(value = "/reservation", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
    @ResponseBody
    public Integer makeReservation(@RequestBody JsonObject jsonCategory) {

        ReservationForm reservationForm = new Gson().fromJson(jsonCategory, ReservationForm.class);
        Integer hotelId = reservationForm.getHotelId();
        String startDate = reservationForm.getStartDate();
        String endDate = reservationForm.getEndDate();
        Integer capacity = reservationForm.getCapacity();
        String firstName = reservationForm.getFirstName();
        String lastName = reservationForm.getLastName();
        String email = reservationForm.getEmail();
        String phoneNumber = reservationForm.getPhoneNumber();

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

            Date currentDate = new Date();
            if (javaStartDate != null && javaEndDate != null) {
                if (!javaEndDate.before(javaStartDate) && !javaEndDate.before(currentDate) && !javaStartDate.before(currentDate)) {
                    Client client = new Client();
                    client.setFirstName(firstName);
                    client.setLastName(lastName);
                    client.setPhoneNumber(phoneNumber);
                    client.setEmail(email);

                    Integer reservedRoom = reservationService.makeReservation(hotelId, javaStartDate, javaEndDate, capacity, client);
                    if (reservedRoom != 0) {
                        mailManager.sendConfirmationMail(reservationForm);
                    }

                    return reservedRoom;
                }
            }
        }

        return 0;
    }

}
