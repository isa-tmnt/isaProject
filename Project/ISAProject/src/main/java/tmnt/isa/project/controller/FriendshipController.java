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

import tmnt.isa.project.model.Friendship;
import tmnt.isa.project.services.FriendshipServices;

@RestController
@RequestMapping(
		value="/api/friends",
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
public class FriendshipController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FriendshipServices friendshipServices;
	
	@RequestMapping(method = RequestMethod.GET)
	public ArrayList<Friendship> getFriendships() {
		logger.info("> getFriendships");
		ArrayList<Friendship> friendships = friendshipServices.getAllFriendships();
		logger.info("< getFriendships");
		return friendships;
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Friendship getFriendship(@PathVariable("id") Long id) {
		return friendshipServices.getFriendship(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Friendship addFriendship(@RequestBody Friendship friendship) {
		return friendshipServices.addFriendship(friendship);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteFriendship(@PathVariable("id") Long id) {
		friendshipServices.deleteFriendship(id);
	}
}
