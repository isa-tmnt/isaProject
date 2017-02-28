package tmnt.isa.project.services;

import java.util.ArrayList;

import tmnt.isa.project.model.Dish;

public interface DishServices {
	
	public ArrayList<Dish> getAllDishes();
	
	public Dish getDish(Long id);
	
	public Dish getDishByName(String name);
	
	public Dish addDish(Dish dish);
	
	public Dish updateDish(Long id, Dish dish);
	
	public void deleteDish(Long id);
}
