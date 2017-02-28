package tmnt.isa.project.repository;

import org.springframework.data.repository.CrudRepository;

import tmnt.isa.project.model.Dish;

public interface DishRepository extends CrudRepository<Dish, Long> {
	
	public Dish findByName(String name);
}
