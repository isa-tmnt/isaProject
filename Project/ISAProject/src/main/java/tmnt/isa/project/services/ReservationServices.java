package tmnt.isa.project.services;

import java.util.ArrayList;

import tmnt.isa.project.model.Reservation;

public interface ReservationServices {
	
	public ArrayList<Reservation> getAllReservations();
	
	public Reservation getReservation(Long id);

	public Reservation addReservation(Reservation reservation);
	
	public Reservation updateReservation(Long id, Reservation reservation);
	
	public void deleteReservation(Long id);
}
