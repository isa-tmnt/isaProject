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

import tmnt.isa.project.model.Supplier;
import tmnt.isa.project.services.SupplierServices;

@RestController
@RequestMapping(
		value="/api/suppliers",
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
public class SupplierController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SupplierServices supplierServices;
	
	@RequestMapping(method = RequestMethod.GET)
	public ArrayList<Supplier> getSuppliers() {
		logger.info("> getSuppliers");
		ArrayList<Supplier> suppliers = supplierServices.getAllSuppliers();
		logger.info("< getSuppliers");
		return suppliers;
	}
	
	/*@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Supplier getSupplier(@PathVariable("id") Long id) {
		return supplierServices.getSupplier(id);
	}*/
	
	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public Supplier getSupplierByUsername(@PathVariable("username") String username) {
		return supplierServices.getSupplierByUsername(username);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Supplier addSupplier(@RequestBody Supplier supplier) {
		return supplierServices.addSupplier(supplier);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Supplier updateSupplier(@PathVariable("id") Long id, @RequestBody Supplier supplier) {
		supplier.setId(id);
		return supplierServices.updateSupplier(id, supplier);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteSupplier(@PathVariable("id") Long id) {
		supplierServices.deleteSupplier(id);
	}
}
