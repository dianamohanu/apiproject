package com.myproject.service;

import com.myproject.dao.RoomDAO;
import com.myproject.domain.Room;
import com.myproject.domain.dto.RoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomDAO roomDAO;

    public List<RoomDTO> getAvailableRooms(Integer hotelId, Date startDate, Date endDate, Integer capacity) {
        List<RoomDTO> rooms = new ArrayList<>();
        for (Room r : roomDAO.getAvailableRooms(hotelId, startDate, endDate, capacity)) {
            rooms.add(roomPopulator(r));
        }
        return rooms;
    }

    private RoomDTO roomPopulator(Room room) {
        RoomDTO roomDTO = new RoomDTO();
        if (room != null) {
            roomDTO.setRoomId(room.getRoomId());
            roomDTO.setRoomNumber(room.getRoomNumber());
            roomDTO.setCapacity(room.getCapacity());
            roomDTO.setPrice(room.getPricePerNight());
        }
        return roomDTO;
    }
}
