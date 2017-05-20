package com.myproject.dao;

import com.myproject.domain.Room;

import java.util.Date;
import java.util.List;

public interface RoomDAO {

    List<Room> getAvailableRooms(Integer hotelId, Date startDate, Date endDate, Integer capacity);

}
