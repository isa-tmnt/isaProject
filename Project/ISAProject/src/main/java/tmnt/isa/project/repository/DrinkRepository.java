package tmnt.isa.project.repository;

import org.springframework.data.repository.CrudRepository;

import tmnt.isa.project.model.Drink;

public interface DrinkRepository extends CrudRepository<Drink, Long> {
	
	public Drink findByName(String name);
}
