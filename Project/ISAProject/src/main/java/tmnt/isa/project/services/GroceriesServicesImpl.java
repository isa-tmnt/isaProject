package tmnt.isa.project.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tmnt.isa.project.model.Groceries;
import tmnt.isa.project.repository.GroceriesRepository;

@Service
public class GroceriesServicesImpl implements GroceriesServices {
	
	@Autowired
	private GroceriesRepository groceriesRepository;
	
	@Override
	public ArrayList<Groceries> getAllGroceries() {
		ArrayList<Groceries> groceries = new ArrayList<Groceries>();
		for(Groceries gr : groceriesRepository.findAll()) {
			groceries.add(gr);
		}
		
		return groceries;
	}

	@Override
	public Groceries getGroceries(Long id) {
		Groceries groceries = groceriesRepository.findOne(id);
		if(groceries != null) {
			return groceries;
		}
		
		return null;
	}

	@Override
	public Groceries getGroceriesByName(String name) {
		Groceries groceries = groceriesRepository.findByName(name);
		if(groceries != null) {
			return groceries;
		}
		
		return null;
	}

	@Override
	public Groceries addGroceries(Groceries groceries) {
		return groceriesRepository.save(groceries);
	}

	@Override
	public Groceries updateGroceries(Long id, Groceries groceries) {
		Groceries g = groceriesRepository.findOne(id);
		if(g != null) {
			return groceriesRepository.save(groceries);
		}
		
		return null;
	}

	@Override
	public void deleteGroceries(Long id) {
		Groceries groceries = groceriesRepository.findOne(id);
		if(groceries != null) {
			groceriesRepository.delete(id);
		}
	}

}
