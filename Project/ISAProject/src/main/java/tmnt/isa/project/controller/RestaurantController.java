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

import tmnt.isa.project.model.Restaurant;
import tmnt.isa.project.services.RestaurantServices;

@RestController
@RequestMapping(
		value="/api/restaurants",
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RestaurantServices restaurantServices;
	
	@RequestMapping(method = RequestMethod.GET)
	public ArrayList<Restaurant> getRestaurants() {
		logger.info("> getRestaurants");
		ArrayList<Restaurant> restaurants = restaurantServices.getAllRestaurants();
		logger.info("< getRestaurants");
		return restaurants;
	}
	
	/*@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Restaurant getRestaurant(@PathVariable("id") Long id) {
		return restaurantServices.getRestaurant(id);
	}*/
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public Restaurant getRestaurantByName(@PathVariable("name") String name) {
		return restaurantServices.getRestaurantByName(name);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
		return restaurantServices.addRestaurant(restaurant);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Restaurant updateRestaurant(@PathVariable("id") Long id, @RequestBody Restaurant restaurant) {
		restaurant.setId(id);
		return restaurantServices.updateRestaurant(id, restaurant);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteRestaurant(@PathVariable("id") Long id) {
		restaurantServices.deleteRestaurant(id);
	}
}
