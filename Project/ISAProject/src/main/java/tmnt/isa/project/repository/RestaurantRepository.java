package tmnt.isa.project.repository;

import org.springframework.data.repository.CrudRepository;

import tmnt.isa.project.model.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
	
	public Restaurant findByName(String name);
}
