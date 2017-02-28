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

import tmnt.isa.project.model.Groceries;
import tmnt.isa.project.services.GroceriesServices;

@RestController
@RequestMapping(
		value="/api/groceries",
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
public class GroceriesController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private GroceriesServices groceriesServices;
	
	@RequestMapping(method = RequestMethod.GET)
	public ArrayList<Groceries> getAllGroceries() {
		logger.info("> getAllGroceries");
		ArrayList<Groceries> groceries = groceriesServices.getAllGroceries();
		logger.info("< getAllGroceries");
		return groceries;
	}
	
	/*@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Groceries getGroceries(@PathVariable("id") Long id) {
		return groceriesServices.getGroceries(id);
	}*/
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public Groceries getGroceriesByName(@PathVariable("name") String name) {
		return groceriesServices.getGroceriesByName(name);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Groceries addGroceries(@RequestBody Groceries groceries) {
		return groceriesServices.addGroceries(groceries);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Groceries updateGroceries(@PathVariable("id") Long id, @RequestBody Groceries groceries) {
		groceries.setId(id);
		return groceriesServices.updateGroceries(id, groceries);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteGroceries(@PathVariable("id") Long id) {
		groceriesServices.deleteGroceries(id);
	}
}
