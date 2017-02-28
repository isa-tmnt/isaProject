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

import tmnt.isa.project.model.ReservationFriends;
import tmnt.isa.project.services.ReservationFriendsServices;

@RestController
@RequestMapping(
		value="/api/reservationfriends",
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
public class ReservationFriendsController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ReservationFriendsServices reservationFriendsServices;
	
	@RequestMapping(method = RequestMethod.GET)
	public ArrayList<ReservationFriends> getAllReservationFriends() {
		logger.info("> getAllReservationFriends");
		ArrayList<ReservationFriends> reservationFriends = reservationFriendsServices.getAllReservationFriends();
		logger.info("< getAllReservationFriends");
		return reservationFriends;
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ReservationFriends getReservationFriends(@PathVariable("id") Long id) {
		return reservationFriendsServices.getReservationFriends(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ReservationFriends addReservationFriends(@RequestBody ReservationFriends reservationFriends) {
		return reservationFriendsServices.addReservationFriends(reservationFriends);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ReservationFriends updateReservationFriends(@PathVariable("id") Long id, @RequestBody ReservationFriends reservationFriends) {
		reservationFriends.setId(id);
		return reservationFriendsServices.updateReservationFriends(id, reservationFriends);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteReservationFriends(@PathVariable("id") Long id) {
		reservationFriendsServices.deleteReservationFriends(id);
	}
}
