package com.myproject.mvc;

import com.myproject.domain.Client;
import com.myproject.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/makeReservation", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    public Integer makeReservation(HttpServletResponse response, @RequestParam("hotelId") Integer hotelId, @RequestParam("startDate") String startDate,
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
