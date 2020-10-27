package com.meiit.webalk.reservation.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.meiit.webalk.reservation.domain.*;

public class RSMethods implements ReservationService {

	BookingPerson bp;
	List<Reservation> rsl = new ArrayList<Reservation>();

	@Override
	public void saveBookingPerson(BookingPerson a) {
		bp = a;
	}
	@Override
	public BookingPerson findBookingPerson() {
		return bp;
	}
	@Override
	public List<Hotel> findAllHotels() {
		List<Hotel> hotels = new ArrayList<Hotel>();
		hotels = Data.Test();
		return hotels;
	}
	@Override
	public void saveReservation(Reservation r) {
		r.setProcessed(true);
		rsl.add(r);
	}
	@Override
	public List<Reservation> findAllReservations() {
		return rsl;
	}
	@Override
	public void checkIn() {
		//1 person not able to check in more than 1 place pls modify based on this
		for (int i = 0; i < rsl.size(); i++) {
			rsl.get(i).setActive(true);
			rsl.get(i).setFrom(LocalDateTime.now());
		}
	}
	@Override
	public void checkOut() {
		//1 person not able to check in more than 1 place pls modify based on this
		//Refund calculation??
		for (int i = 0; i < rsl.size(); i++) {
			rsl.get(i).setActive(false);
			rsl.get(i).setTo(LocalDateTime.now());
		}
	}
}
