package tmnt.isa.project.services;

import java.util.ArrayList;

import tmnt.isa.project.model.RestaurantManager;

public interface RestaurantManagerServices {
	
	public ArrayList<RestaurantManager> getAllRestaurantManagers();
	
	public RestaurantManager getRestaurantManager(Long id);
	
	public RestaurantManager getRestaurantManagerByUsername(String username);
	
	public RestaurantManager getRestaurantManagerByEmail(String email);
	
	public RestaurantManager addRestaurantManager(RestaurantManager restaurantManager);
	
	public RestaurantManager updateRestaurantManager(Long id, RestaurantManager restaurantManager);
	
	public void deleteRestaurantManager(Long id);
}
