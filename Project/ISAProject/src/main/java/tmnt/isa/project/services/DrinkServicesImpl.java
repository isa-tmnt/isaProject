package tmnt.isa.project.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tmnt.isa.project.model.Drink;
import tmnt.isa.project.repository.DrinkRepository;

@Service
public class DrinkServicesImpl implements DrinkServices {
	
	@Autowired
	private DrinkRepository drinkRepository;

	@Override
	public ArrayList<Drink> getAllDrinks() {
		ArrayList<Drink> drinks = new ArrayList<Drink>();
		for(Drink drink : drinkRepository.findAll()) {
			drinks.add(drink);
		}
		
		return drinks;
	}

	@Override
	public Drink getDrink(Long id) {
		Drink drink = drinkRepository.findOne(id);
		if(drink != null) {
			return drink;
		}
		
		return null;
	}

	@Override
	public Drink getDrinkByName(String name) {
		Drink drink = drinkRepository.findByName(name);
		if(drink != null) {
			return drink;
		}
		
		return null;
	}

	@Override
	public Drink addDrink(Drink drink) {
		return drinkRepository.save(drink);
	}

	@Override
	public Drink updateDrink(Long id, Drink drink) {
		Drink d = drinkRepository.findOne(id);
		if(d != null) {
			return drinkRepository.save(drink);
		}
		
		return null;
	}

	@Override
	public void deleteDrink(Long id) {
		Drink drink = drinkRepository.findOne(id);
		if(drink != null) {
			drinkRepository.delete(id);
		}
	}
}
