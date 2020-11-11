package com.meiit.webalk.reservation;

import java.time.LocalDateTime;
import com.meiit.webalk.reservation.domain.*;
import com.meiit.webalk.reservation.service.*;
import com.meiit.webalk.reservation.view.*;

public class App {
	
	private ReservationService rs;
	private View view;
	
	public static void main(String[] args) {
		App app=new App(new RSMethods(), new VMethods());
		app.createBookingPerson();
		app.book();
		app.checkOut();
	}
	
	public App(ReservationService rs, View view) {
		super();
		this.rs = rs;
		this.view = view;
	}

	void createBookingPerson()
	{
		BookingPerson person = view.readBookingPerson();
		rs.saveBookingPerson(person);
		view.printWelcomeMessage(person);
		view.printBalance(person);
		
	}
	void book()
	{
		BookingPerson person = rs.findBookingPerson();
		Room room = null;
		boolean quit = false;
		try{
			do {
				view.printRooms(rs.findAllHotels());
				room = view.selectRoom(rs.findAllHotels());
					if (person.getBalance().compareTo(room.getPrice()) >= 0) {
						Reservation reservation = new Reservation(room.getPrice(), LocalDateTime.now(), false, true, person,room);
						rs.saveReservation(reservation);
						view.printReservationSaved(reservation);
						person.setBalance(person.getBalance().subtract(room.getPrice()));
					}else {
						view.printNotEnoughBalance(person);
						room = null;
					}
					view.printBalance(person);
			}while(!quit);
		}catch(NullPointerException e)
		{
			checkIn();
		}
	}
	void checkIn()
	{
		rs.checkIn();
		view.printCheckIn(rs.findAllReservations());
	}
	void checkOut()
	{
		rs.checkOut();
		view.printCheckOut(rs.findBookingPerson(),rs.findAllReservations());
	}
}
