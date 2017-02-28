package tmnt.isa.project.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tmnt.isa.project.model.Reservation;
import tmnt.isa.project.repository.ReservationRepository;

@Service
public class ReservationServicesImpl implements ReservationServices {
	
	@Autowired
	private ReservationRepository reservationRepository;

	@Override
	public ArrayList<Reservation> getAllReservations() {
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		for(Reservation reservation : reservationRepository.findAll()) {
			reservations.add(reservation);
		}
		
		return reservations;
	}

	@Override
	public Reservation getReservation(Long id) {
		Reservation reservation = reservationRepository.findOne(id);
		if(reservation != null) {
			return reservation;
		}
		
		return null;
	}

	@Override
	public Reservation addReservation(Reservation reservation) {
		return reservationRepository.save(reservation);
	}

	@Override
	public Reservation updateReservation(Long id, Reservation reservation) {
		Reservation r = reservationRepository.findOne(id);
		if(r != null) {
			return reservationRepository.save(reservation);
		}
		
		return null;
	}

	@Override
	public void deleteReservation(Long id) {
		Reservation reservation = reservationRepository.findOne(id);
		if(reservation != null) {
			reservationRepository.delete(id);
		}
	}
}
