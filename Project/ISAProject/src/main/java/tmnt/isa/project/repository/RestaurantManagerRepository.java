package tmnt.isa.project.repository;

import org.springframework.data.repository.CrudRepository;

import tmnt.isa.project.model.RestaurantManager;

public interface RestaurantManagerRepository extends CrudRepository<RestaurantManager, Long> {
	
	public RestaurantManager findByUsername(String username);
	
	public RestaurantManager findByEmail(String email);
}
