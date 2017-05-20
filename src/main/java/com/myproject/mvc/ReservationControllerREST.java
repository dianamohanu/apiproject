package com.myproject.mvc;

import com.myproject.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/reservationREST")
public class ReservationControllerREST {

    @Autowired
    private ReservationService reservationService;

}
