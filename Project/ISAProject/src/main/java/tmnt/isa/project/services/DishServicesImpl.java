package tmnt.isa.project.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tmnt.isa.project.model.Dish;
import tmnt.isa.project.repository.DishRepository;

@Service
public class DishServicesImpl implements DishServices {
	
	@Autowired
	private DishRepository dishRepository;

	@Override
	public ArrayList<Dish> getAllDishes() {
		ArrayList<Dish> dishs = new ArrayList<Dish>();
		for(Dish dish : dishRepository.findAll()) {
			dishs.add(dish);
		}
		
		return dishs;
	}

	@Override
	public Dish getDish(Long id) {
		Dish dish = dishRepository.findOne(id);
		if(dish != null) {
			return dish;
		}
		
		return null;
	}

	@Override
	public Dish getDishByName(String name) {
		Dish dish = dishRepository.findByName(name);
		if(dish != null) {
			return dish;
		}
		
		return null;
	}

	@Override
	public Dish addDish(Dish dish) {
		return dishRepository.save(dish);
	}

	@Override
	public Dish updateDish(Long id, Dish dish) {
		Dish d = dishRepository.findOne(id);
		if(d != null) {
			return dishRepository.save(dish);
		}
		
		return null;
	}

	@Override
	public void deleteDish(Long id) {
		Dish dish = dishRepository.findOne(id);
		if(dish != null) {
			dishRepository.delete(id);
		}
	}
}
