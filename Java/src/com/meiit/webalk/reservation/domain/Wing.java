package com.meiit.webalk.reservation.domain;

import java.util.List;

public class Wing {

	private String description;
	private Floor floor;
	private WingType wingtype;
	private List<Room> rooms;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Floor getFloor() {
		return floor;
	}
	public void setFloor(Floor floor) {
		this.floor = floor;
	}
	public WingType getWingtype() {
		return wingtype;
	}
	public void setWingtype(WingType wingtype) {
		this.wingtype = wingtype;
	}
	public List<Room> getRooms() {
		return rooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	public Wing(String description, Floor floor, WingType wingtype, List<Room> rooms) {
		super();
		this.description = description;
		this.floor = floor;
		this.wingtype = wingtype;
		this.rooms = rooms;
	}
}
