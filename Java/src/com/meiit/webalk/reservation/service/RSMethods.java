package com.meiit.webalk.reservation.service;

import java.math.BigDecimal;
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
			rsl.get(0).setActive(true);
			rsl.get(0).setFrom(LocalDateTime.now());
	}
	@Override
	public void checkOut() {
			rsl.get(0).setActive(false);
			rsl.get(0).setTo(LocalDateTime.now());
			BigDecimal refund = new BigDecimal("0.1");
			System.out.println(bp.getBalance());
			bp.setBalance(bp.getBalance().add(rsl.get(0).getAmmount().multiply(refund)));
	}
}
