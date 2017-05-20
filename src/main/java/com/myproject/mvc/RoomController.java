package com.myproject.mvc;

import com.myproject.domain.dto.RoomDTO;
import com.myproject.service.RoomService;
import com.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/backoffice/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getAvailableRooms", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    public List<RoomDTO> getAvailableRoom(HttpServletResponse response, Principal principal, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("capacity") Integer capacity) {
        List<RoomDTO> rooms = new ArrayList<>();

        if (!StringUtils.isEmpty(startDate) && !StringUtils.isEmpty(endDate)) {
            String currentUser = principal.getName();
            Integer hotelId = userService.getHotelIdForUser(currentUser);

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

            rooms = roomService.getAvailableRooms(hotelId, javaStartDate, javaEndDate, capacity);
            if (rooms.size() == 0) {
                response.setStatus(404);
            } else {
                response.setStatus(200);
            }
        }

        return rooms;
    }
}
