package tmnt.isa.project.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tmnt.isa.project.model.Restaurant;
import tmnt.isa.project.repository.RestaurantRepository;

@Service
public class RestaurantServicesImpl implements RestaurantServices {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Override
	public ArrayList<Restaurant> getAllRestaurants() {
		ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
		for(Restaurant restaurant : restaurantRepository.findAll()) {
			restaurants.add(restaurant);
		}
		
		return restaurants;
	}

	@Override
	public Restaurant getRestaurant(Long id) {
		Restaurant restaurant = restaurantRepository.findOne(id);
		if(restaurant != null) {
			return restaurant;
		}
		
		return null;
	}

	@Override
	public Restaurant getRestaurantByName(String name) {
		Restaurant restaurant = restaurantRepository.findByName(name);
		if(restaurant != null) {
			return restaurant;
		}
		
		return null;
	}

	@Override
	public Restaurant addRestaurant(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}

	@Override
	public Restaurant updateRestaurant(Long id, Restaurant restaurant) {
		Restaurant r = restaurantRepository.findOne(id);
		if(r != null) {
			return restaurantRepository.save(restaurant);
		}
		
		return null;
	}

	@Override
	public void deleteRestaurant(Long id) {
		Restaurant restaurant = restaurantRepository.findOne(id);
		if(restaurant != null) {
			restaurantRepository.delete(id);
		}
	}

}
