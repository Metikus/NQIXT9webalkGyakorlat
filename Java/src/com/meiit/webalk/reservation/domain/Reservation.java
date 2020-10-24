package com.meiit.webalk.reservation.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Reservation {

	private BigDecimal ammount;
	private LocalDateTime from;
	private LocalDateTime to;
	private boolean active;
	private boolean processed;
	private Currency currency;
	private BookingPerson bookingperson;
	private Room room;
	
	public BigDecimal getAmmount() {
		return ammount;
	}
	public void setAmmount(BigDecimal ammount) {
		this.ammount = ammount;
	}
	public LocalDateTime getFrom() {
		return from;
	}
	public void setFrom(LocalDateTime from) {
		this.from = from;
	}
	public LocalDateTime getTo() {
		return to;
	}
	public void setTo(LocalDateTime to) {
		this.to = to;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isProcessed() {
		return processed;
	}
	public void setProcessed(boolean processed) {
		this.processed = processed;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public BookingPerson getBookingperson() {
		return bookingperson;
	}
	public void setBookingperson(BookingPerson bookingperson) {
		this.bookingperson = bookingperson;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public Reservation(BigDecimal ammount, LocalDateTime from, boolean active, boolean processed, BookingPerson bookingperson,Room room) {
		super();
		this.ammount = ammount;
		this.from = from;
		this.to = from.plusDays(1);
		this.active = active;
		this.processed = processed;
		this.currency = bookingperson.getCurrency();
		this.bookingperson = bookingperson;
		this.room = room;
	}
}
