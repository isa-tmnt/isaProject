package tmnt.isa.project.services;

import java.util.ArrayList;

import tmnt.isa.project.model.Drink;

public interface DrinkServices {
	
	public ArrayList<Drink> getAllDrinks();
	
	public Drink getDrink(Long id);
	
	public Drink getDrinkByName(String name);
	
	public Drink addDrink(Drink drink);
	
	public Drink updateDrink(Long id, Drink drink);
	
	public void deleteDrink(Long id);
}
