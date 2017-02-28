package tmnt.isa.project.services;

import java.util.ArrayList;

import tmnt.isa.project.model.Restaurant;

public interface RestaurantServices {
	
	public ArrayList<Restaurant> getAllRestaurants();
	
	public Restaurant getRestaurant(Long id);
	
	public Restaurant getRestaurantByName(String name);

	public Restaurant addRestaurant(Restaurant restaurant);
	
	public Restaurant updateRestaurant(Long id, Restaurant restaurant);
	
	public void deleteRestaurant(Long id);
}
