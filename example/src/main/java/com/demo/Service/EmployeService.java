package com.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Repository.EmployeRepo;
import com.demo.entity.Employe;

@Service
public class EmployeService {
	@Autowired
	private EmployeRepo erepo;
	public Employe EmployeDetailes(Employe employe) {
		 Employe add=erepo.save(employe);
		 return add;	 
	}
	
		public Employe EmployeInfo(Long employeId) {
	        Optional<Employe> get = erepo.findById(employeId);
	        return get.orElse(null); // Return employee or null if not found
	}
	
		public Iterable<Employe> employeData(List<Employe> employes){
			return  erepo.saveAll(employes);
			
		}

	
}		 
