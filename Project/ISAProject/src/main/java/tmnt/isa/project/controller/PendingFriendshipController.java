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

import tmnt.isa.project.model.PendingFriendship;
import tmnt.isa.project.services.PendingFriendshipServices;

@RestController
@RequestMapping(
		value="/api/pendingfriends",
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
public class PendingFriendshipController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PendingFriendshipServices pendingFriendshipServices;
	
	@RequestMapping(method = RequestMethod.GET)
	public ArrayList<PendingFriendship> getPendingFriendships() {
		logger.info("> getPendingFriendships");
		ArrayList<PendingFriendship> pendingFriendships = pendingFriendshipServices.getAllPendingFriendships();
		logger.info("< getPendingFriendships");
		return pendingFriendships;
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public PendingFriendship getPendingFriendship(@PathVariable("id") Long id) {
		return pendingFriendshipServices.getPendingFriendship(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public PendingFriendship addPendingFriendship(@RequestBody PendingFriendship pendingFriendship) {
		return pendingFriendshipServices.addPendingFriendship(pendingFriendship);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletePendingFriendship(@PathVariable("id") Long id) {
		pendingFriendshipServices.deletePendingFriendship(id);
	}
}
