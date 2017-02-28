package tmnt.isa.project.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tmnt.isa.project.model.Reservation;
import tmnt.isa.project.services.ReservationServices;

@RestController
@RequestMapping(
		value="/api/reservations",
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
public class ReservationController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ReservationServices reservationServices;
	
	@RequestMapping(method = RequestMethod.GET)
	public ArrayList<Reservation> getReservations() {
		logger.info("> getReservations");
		ArrayList<Reservation> reservations = reservationServices.getAllReservations();
		logger.info("< getReservations");
		return reservations;
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Reservation getReservation(@PathVariable("id") Long id) {
		return reservationServices.getReservation(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Reservation addReservation(@RequestBody Reservation reservation) {
		return reservationServices.addReservation(reservation);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Reservation updateReservation(@PathVariable("id") Long id, @RequestBody Reservation reservation) {
		reservation.setId(id);
		return reservationServices.updateReservation(id, reservation);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteReservation(@PathVariable("id") Long id) {
		reservationServices.deleteReservation(id);
	}
}
