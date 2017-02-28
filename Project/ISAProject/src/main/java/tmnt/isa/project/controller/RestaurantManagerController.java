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

import tmnt.isa.project.model.RestaurantManager;
import tmnt.isa.project.services.RestaurantManagerServices;

@RestController
@RequestMapping(
		value="/api/resmanagers",
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantManagerController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RestaurantManagerServices restaurantManagerServices;
	
	@RequestMapping(method = RequestMethod.GET)
	public ArrayList<RestaurantManager> getRestaurantManagers() {
		logger.info("> getRestaurantManagers");
		ArrayList<RestaurantManager> restaurantManagers = restaurantManagerServices.getAllRestaurantManagers();
		logger.info("< getRestaurantManagers");
		return restaurantManagers;
	}
	
	/*@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public RestaurantManager getRestaurantManager(@PathVariable("id") Long id) {
		return restaurantManagerServices.getRestaurantManager(id);
	}*/
	
	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public RestaurantManager getRestaurantManagerByUsername(@PathVariable("username") String username) {
		return restaurantManagerServices.getRestaurantManagerByUsername(username);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public RestaurantManager addRestaurantManager(@RequestBody RestaurantManager restaurantManager) {
		return restaurantManagerServices.addRestaurantManager(restaurantManager);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public RestaurantManager updateRestaurantManager(@PathVariable("id") Long id, @RequestBody RestaurantManager restaurantManager) {
		restaurantManager.setId(id);
		return restaurantManagerServices.updateRestaurantManager(id, restaurantManager);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteRestaurantManager(@PathVariable("id") Long id) {
		restaurantManagerServices.deleteRestaurantManager(id);
	}
}
