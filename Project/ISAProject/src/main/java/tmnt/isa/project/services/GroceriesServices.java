package tmnt.isa.project.services;

import java.util.ArrayList;

import tmnt.isa.project.model.Groceries;

public interface GroceriesServices {
	
	public ArrayList<Groceries> getAllGroceries();
	
	public Groceries getGroceries(Long id);
	
	public Groceries getGroceriesByName(String name);
	
	public Groceries addGroceries(Groceries groceries);
	
	public Groceries updateGroceries(Long id, Groceries groceries);
	
	public void deleteGroceries(Long id);
}
