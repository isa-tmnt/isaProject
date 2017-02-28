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

import tmnt.isa.project.model.Guest;
import tmnt.isa.project.services.GuestServices;

@RestController
@RequestMapping(
		value="/api/guests",
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
public class GuestController {
	//@RequestHeader(value="Authorization") String basicAuth
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private GuestServices guestServices;
	
	@RequestMapping(method = RequestMethod.GET)
	public ArrayList<Guest> getGuests() {
		logger.info("> getGuests");
		ArrayList<Guest> guests = guestServices.getAllGuests();
		logger.info("< getGuests");
		return guests;
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Guest getGuest(@PathVariable("id") Long id) {
		return guestServices.getGuest(id);
	}
	
	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public Guest getGuestByUsername(@PathVariable("username") String username) {
		return guestServices.getGuestByUsername(username);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Guest addGuest(@RequestBody Guest guest) {
		return guestServices.addGuest(guest);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Guest updateGuest(@PathVariable("id") Long id, @RequestBody Guest guest) {
		guest.setId(id);
		return guestServices.updateGuest(id, guest);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteGuest(@PathVariable("id") Long id) {
		guestServices.deleteGuest(id);
	}
	
	/*@RequestMapping(value = "/{id}/friends", method = RequestMethod.GET)
	public ArrayList<Guest> getFriends(@PathVariable("id") Long id) {
		ArrayList<Guest> friends = guestServices.getAllFriends(id);
		return friends;
	}*/
	
	/*@RequestMapping(value = "/{id}/resfriends", method = RequestMethod.GET)
	public ArrayList<Guest> getReceivedFriends(@PathVariable("id") Long id) {
		ArrayList<Guest> receivedFriends = guestServices.getAllReceivedFriends(id);
		return receivedFriends;
	}*/
	
	/*@RequestMapping(value = "/{id}/friends", method = RequestMethod.PUT)
	public Guest addFriend(@PathVariable("id") Long id, @RequestBody Guest friend) {
		return guestServices.addFriend(id, friend);
	}*/
	
	//Add pending friend
	//api/guests/friends_id/pendingFriends
	/*@RequestMapping(value = "/{id}/resfriends", method = RequestMethod.PUT)
	public Guest addReceivedFriend(@PathVariable("id") Long id, @RequestBody Guest friend) {
		return guestServices.addReceivedFriend(id, friend);
	}*/
	
	/*@RequestMapping(value = "/{id}/friends/{id1}", method = RequestMethod.PUT)
	public Guest deleteFriend(@PathVariable("id") Long id, @PathVariable("id1") Long id1) {
		return guestServices.deleteFriend(id, id1);
	}*/
	
	/*@RequestMapping(value = "/{id}/resfriends/{id1}", method = RequestMethod.PUT)
	public Guest deleteReceivedFriend(@PathVariable("id") Long id, @PathVariable("id1") Long id1) {
		return guestServices.deleteReceivedFriend(id, id1);
	}
	
	@RequestMapping(value = "/{id}/sentfriends", method = RequestMethod.GET)
	public ArrayList<Guest> getSentFriends(@PathVariable("id") Long id) {
		ArrayList<Guest> sentFriends = guestServices.getAllSentFriends(id);
		return sentFriends;
	}
	
	@RequestMapping(value = "/{id}/sentfriends", method = RequestMethod.PUT)
	public Guest addSentFriend(@PathVariable("id") Long id, @RequestBody Guest friend) {
		return guestServices.addSentFriend(id, friend);
	}
	
	@RequestMapping(value = "/{id}/sentfriends/{id1}", method = RequestMethod.PUT)
	public Guest deleteSentFriend(@PathVariable("id") Long id, @PathVariable("id1") Long id1) {
		return guestServices.deleteSentFriend(id, id1);
	}*/
}
