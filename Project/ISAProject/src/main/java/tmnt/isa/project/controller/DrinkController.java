package tmnt.isa.project.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tmnt.isa.project.model.Drink;
import tmnt.isa.project.services.DrinkServices;

@RestController
@RequestMapping(
		value="/api/drinks",
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
public class DrinkController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DrinkServices drinkServices;
	
	@RequestMapping(method = RequestMethod.GET)
	public ArrayList<Drink> getDrinks() {
		logger.info("> getDrinks");
		ArrayList<Drink> drinks = drinkServices.getAllDrinks();
		logger.info("< getDrinks");
		return drinks;
	}
	
	/*@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Drink getDrink(@PathVariable("id") Long id) {
		return drinkServices.getDrink(id);
	}*/
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public Drink getDrinkByName(@PathVariable("name") String name) {
		return drinkServices.getDrinkByName(name);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Drink addDrink(@RequestBody Drink drink) {
		return drinkServices.addDrink(drink);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Drink updateDrink(@PathVariable("id") Long id, @RequestBody Drink drink) {
		drink.setId(id);
		return drinkServices.updateDrink(id, drink);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteDrink(@PathVariable("id") Long id) {
		drinkServices.deleteDrink(id);
	}
}
