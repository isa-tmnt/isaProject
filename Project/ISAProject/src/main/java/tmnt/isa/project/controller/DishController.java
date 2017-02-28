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

import tmnt.isa.project.model.Dish;
import tmnt.isa.project.services.DishServices;

@RestController
@RequestMapping(
		value="/api/dishes",
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
public class DishController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DishServices dishServices;
	
	@RequestMapping(method = RequestMethod.GET)
	public ArrayList<Dish> getDishes() {
		logger.info("> getDishes");
		ArrayList<Dish> dishes = dishServices.getAllDishes();
		logger.info("< getDishes");
		return dishes;
	}
	
	/*@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Dish getDish(@PathVariable("id") Long id) {
		return dishServices.getDish(id);
	}*/
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public Dish getDishByName(@PathVariable("name") String name) {
		return dishServices.getDishByName(name);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Dish addDish(@RequestBody Dish dish) {
		return dishServices.addDish(dish);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Dish updateDish(@PathVariable("id") Long id, @RequestBody Dish dish) {
		dish.setId(id);
		return dishServices.updateDish(id, dish);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteDish(@PathVariable("id") Long id) {
		dishServices.deleteDish(id);
	}
}
