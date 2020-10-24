package com.meiit.webalk.reservation.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.meiit.webalk.reservation.domain.*;

public class Data {
	static public List<Hotel> Test() {
		List<Hotel> hotels = new ArrayList<Hotel>();
		List<Floor> floors = new ArrayList<Floor>();
		List<Wing> wings = new ArrayList<Wing>();
		List<Room> rooms = new ArrayList<Room>();
		
		Hotel hotel = new Hotel("Hilton", "Somewhere", 4, floors);
		
		Floor Floor1 = new Floor(1, hotel, wings);
		
		Wing Wing1 = new Wing("North", Floor1, WingType.NORTH, rooms);
		
		Room Room1 = new Room(1, 2, true, BigDecimal.valueOf(500), Wing1);
		rooms.add(Room1);

		Room Room2 = new Room(2, 4, true, BigDecimal.valueOf(1500), Wing1);
		rooms.add(Room2);

		Room Room3 = new Room(3, 1, true, BigDecimal.valueOf(200), Wing1);
		rooms.add(Room3);

		Room Room4 = new Room(4, 2, true, BigDecimal.valueOf(500), Wing1);
		rooms.add(Room4);

		Wing1.setRooms(rooms);
		wings.add(Wing1);

		Floor1.setWings(wings);
		floors.add(Floor1);

		hotel.setFloors(floors);
		hotels.add(hotel);
		return hotels;
	}
}
