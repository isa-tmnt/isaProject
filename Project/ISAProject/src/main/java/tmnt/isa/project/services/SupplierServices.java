package tmnt.isa.project.services;

import java.util.ArrayList;

import tmnt.isa.project.model.Supplier;

public interface SupplierServices {
	
	public ArrayList<Supplier> getAllSuppliers();
	
	public Supplier getSupplier(Long id);
	
	public Supplier getSupplierByUsername(String username);
	
	public Supplier getSupplierByEmail(String email);
	
	public Supplier addSupplier(Supplier supplier);
	
	public Supplier updateSupplier(Long id, Supplier supplier);
	
	public void deleteSupplier(Long id);
}
