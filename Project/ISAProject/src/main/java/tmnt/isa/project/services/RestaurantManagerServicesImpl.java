package tmnt.isa.project.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tmnt.isa.project.model.RestaurantManager;
import tmnt.isa.project.repository.RestaurantManagerRepository;
import tmnt.isa.project.security.SecurityServices;

@Service
public class RestaurantManagerServicesImpl implements RestaurantManagerServices {
	
	@Autowired
	private RestaurantManagerRepository restaurantManagerRepository;
	
	@Autowired
	private SecurityServices securityServices;
	
	@Override
	public ArrayList<RestaurantManager> getAllRestaurantManagers() {
		ArrayList<RestaurantManager> restaurantManagers = new ArrayList<RestaurantManager>();
		for(RestaurantManager restaurantManager : restaurantManagerRepository.findAll()) {
			restaurantManagers.add(restaurantManager);
		}
		
		return restaurantManagers;
	}

	@Override
	public RestaurantManager getRestaurantManager(Long id) {
		RestaurantManager restaurantManager = restaurantManagerRepository.findOne(id);
		if(restaurantManager != null) {
			return restaurantManager;
		}
		
		return null;
	}

	@Override
	public RestaurantManager getRestaurantManagerByUsername(String username) {
		RestaurantManager restaurantManager = restaurantManagerRepository.findByUsername(username);
		if(restaurantManager != null) {
			return restaurantManager;
		}
		
		return null;
	}
	
	@Override
	public RestaurantManager getRestaurantManagerByEmail(String email) {
		RestaurantManager restaurantManager = restaurantManagerRepository.findByEmail(email);
		if(restaurantManager != null) {
			return restaurantManager;
		}
		
		return null;
	}

	@Override
	public RestaurantManager addRestaurantManager(RestaurantManager restaurantManager) {
		boolean b = securityServices.validations(restaurantManager.getUsername(), restaurantManager.getEmail());
		
		if(b) {
			return restaurantManagerRepository.save(restaurantManager);
		} else {
			return null;
		}
	}

	@Override
	public RestaurantManager updateRestaurantManager(Long id, RestaurantManager restaurantManager) {
		RestaurantManager r = restaurantManagerRepository.findOne(id);
		if(r != null) {
			boolean b = securityServices.validationsU(r.getUsername(), r.getEmail(), 
					restaurantManager.getUsername(), restaurantManager.getEmail()
			);
			
			if(b) {
				return restaurantManagerRepository.save(restaurantManager);
			} else {
				return null;
			}
		}
		
		return null;
	}

	@Override
	public void deleteRestaurantManager(Long id) {
		RestaurantManager restaurantManager = restaurantManagerRepository.findOne(id);
		if(restaurantManager != null) {
			restaurantManagerRepository.delete(id);
		}
	}
}
