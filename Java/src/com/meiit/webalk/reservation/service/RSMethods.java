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
		for (int i = 0; i < rsl.size(); i++) {
			rsl.get(i).setActive(true);
			rsl.get(i).setFrom(LocalDateTime.now());
		}
	}
	@Override
	public void checkOut() {
		for (int i = 0; i < rsl.size(); i++) {
			rsl.get(i).setActive(false);
			rsl.get(i).setTo(LocalDateTime.now());
		}
	}
}
