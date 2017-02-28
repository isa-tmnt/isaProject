package tmnt.isa.project.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tmnt.isa.project.model.Supplier;
import tmnt.isa.project.repository.SupplierRepository;
import tmnt.isa.project.security.SecurityServices;

@Service
public class SupplierServicesImpl implements SupplierServices {
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	@Autowired
	private SecurityServices securityServices;
	
	@Override
	public ArrayList<Supplier> getAllSuppliers() {
		ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
		for(Supplier supplier : supplierRepository.findAll()) {
			suppliers.add(supplier);
		}
		
		return suppliers;
	}

	@Override
	public Supplier getSupplier(Long id) {
		Supplier supplier = supplierRepository.findOne(id);
		if(supplier != null) {
			return supplier;
		}
		
		return null;
	}

	@Override
	public Supplier getSupplierByUsername(String username) {
		Supplier supplier = supplierRepository.findByUsername(username);
		if(supplier != null) {
			return supplier;
		}
		
		return null;
	}
	
	@Override
	public Supplier getSupplierByEmail(String email) {
		Supplier supplier = supplierRepository.findByEmail(email);
		if(supplier != null) {
			return supplier;
		}
		
		return null;
	}

	@Override
	public Supplier addSupplier(Supplier supplier) {
		boolean b = securityServices.validations(supplier.getUsername(), supplier.getEmail());
		
		if(b) {
			return supplierRepository.save(supplier);
		} else {
			return null;
		}
	}

	@Override
	public Supplier updateSupplier(Long id, Supplier supplier) {
		Supplier s = supplierRepository.findOne(id);
		if(s != null) {
			boolean b = securityServices.validationsU(s.getUsername(), s.getEmail(), 
					supplier.getUsername(), supplier.getEmail()
			);
			
			if(b) {
				return supplierRepository.save(supplier);
			} else {
				return null;
			}
		}
		
		return null;
	}

	@Override
	public void deleteSupplier(Long id) {
		Supplier supplier = supplierRepository.findOne(id);
		if(supplier != null) {
			supplierRepository.delete(id);
		}
	}
}
