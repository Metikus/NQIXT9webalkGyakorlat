package com.meiit.webalk.reservation.view;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import com.meiit.webalk.reservation.domain.*;

public class VMethods implements View {
	
	Scanner sc = new Scanner(System.in);
	int counter=0;

	@Override
	public BookingPerson readBookingPerson() {
		BookingPerson bp = new BookingPerson();
		System.out.println("What's your name?");
		bp.setName(sc.nextLine());
		System.out.println("How much money do you have?");
		String b=CheckerB();
		long helper = Long.parseLong(b);
		bp.setBalance(BigDecimal.valueOf(helper));
		System.out.println("What is your currency? (HUF, EUR or USD)");
		String c=CheckerC();
		bp.setCurrency(Currency.valueOf(c));
		return bp;
	}

	@Override
	public void printWelcomeMessage(BookingPerson a) {
		System.out.println("Welcome " + a.getName());
	}

	@Override
	public void printBalance(BookingPerson a) {
		System.out.println("Your balance is " + a.getBalance() + " " + a.getCurrency().name());
	}

	@Override
	public void printRooms(List<Hotel> a) {
		System.out.println("Where do you want to book? (Choose a number or press q for quit)");
		counter = 0;
		for(Hotel h : a) {
			for(Floor f : h.getFloors()) {
				for(Wing w : f.getWings()) {
					for(Room r : w.getRooms()) {
						counter++;
						System.out.println(counter +": Hotel name: "+h.getName()+", Floor: "+ f.getFloorNumber()+", Wing: "+w.getWingtype()+", Room number: "+r.getNumber()+", Beds: "+r.getBeds()+", Room Price: "+r.getPrice());			
					}
				}
			}
		}
	}

	@Override
	public Room selectRoom(List<Hotel> a) {
		Room room = null;
		String select = CheckerR();
		if(select.equals("q")) {
			return room;
		}else{
			int in = Integer.parseInt(select);
			int i = 1;
			for(Hotel h : a) {
				for(Floor f : h.getFloors()) {
					for(Wing w : f.getWings()) {
						for(Room r : w.getRooms()) {
							if(i == in)
							{
								room = r;
							}
							i++;
						}
					}
				}
			}
			return room;
		}
	}

	@Override
	public void printReservationSaved(Reservation a) {
		System.out.println("The reservation successfully saved!");
		printDetails(a);
	}

	@Override
	public void printNotEnoughBalance(BookingPerson a) {
		System.out.println("Sorry you dont have enough balance! Please choose anoter room!");
	}

	@Override
	public void printCheckIn(List<Reservation> a) {
		System.out.println("Check in");
		printReservations(a);
	}

	@Override
	public void printCheckOut(BookingPerson a, List<Reservation> b) {
		try
		{
			System.out.println("Few days later");
			System.out.println("Check out, Suprise! You are the 100th guest you get a 10% refund");
			printBalance(a);
		}catch(IndexOutOfBoundsException e)
		{
			System.out.println("You don't have Reservation");
		}
	}
	
	boolean CheckB(String s) {
		try {
			Long.parseLong(s);
			return true;
		} catch (NumberFormatException e) {
			System.out.println("Wrong input! Try Again!");
			return false;
		}
	}
	
	String CheckerB() {
		String s = sc.nextLine();
		while (!CheckB(s)) {
			System.out.println("How much money do you have?");
			s = sc.nextLine();
		}
		return s;
	}
	
	boolean CheckC(String s) {
		boolean b = false;
		if(s.equals("HUF")) {
			b = true;
		}else if(s.equals("EUR")) {
			b = true;
		}else if(s.equals("USD")) {
			b = true;
		}else {
			System.out.println("Wrong input! Try again!");
			b = false;
		}
		return b;
	}
	
	String CheckerC() {
		String s = sc.nextLine();
		while (!CheckC(s)) {
			System.out.println("What is your currency? (HUF, EUR or USD)");
			s = sc.nextLine();
		}
		return s;
	}
	
	public boolean CheckQ(String s) {
		if(s.equals("q")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean CheckR(String s) {
		try {
			int in = Integer.parseInt(s);
			if(counter<in)
			{
				return false;
			}else {
				return true;
			}
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	String CheckerR() {
		String s = sc.nextLine();
		while ((!CheckR(s))&&(!CheckQ(s))) {
			System.out.println("Wrong input! Try Again!");
			s = sc.nextLine();
		}
		return s;
	}
	
	public void printDetails(Reservation rv) {
			System.out.println("Reservation details: "+rv.getRoom().getWing().getFloor().getHotel().getName()+", Floor: "+rv.getRoom().getWing().getFloor().getFloorNumber()+", Wing: "+rv.getRoom().getWing().getWingtype()+", Room number: "+rv.getRoom().getNumber()+", Beds: "+rv.getRoom().getBeds());	
			}
	
	public void printReservations(List<Reservation> rvs) {
		System.out.println("Your reservations: ");
		for(Reservation rv : rvs) {
			System.out.println(rv.getRoom().getWing().getFloor().getHotel().getName()+", Floor: "+rv.getRoom().getWing().getFloor().getFloorNumber()+", Wing: "+rv.getRoom().getWing().getWingtype()+", Room number: "+rv.getRoom().getNumber()+", Beds: "+rv.getRoom().getBeds());
		}
	}
}
