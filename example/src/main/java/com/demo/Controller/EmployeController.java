package com.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Service.EmployeService;
import com.demo.entity.Employe;

@RestController


public class EmployeController {
	@Autowired

private EmployeService service;
	
	@PostMapping("/practice")
	public Employe EmployeDetailes(@RequestBody Employe employe) {
		Employe add=service.EmployeDetailes(employe);
		return add;
		
				
	}	
    @GetMapping("/employee/{id}")  // ✅ Ensure this matches the Postman request
    public Employe getEmployeeById(@PathVariable Long id) {
        return service.EmployeInfo(id);
    }
    
    @PostMapping("/saveall")
    public Iterable<Employe> employeData(@RequestBody List<Employe> employes){
    	return service.employeData(employes);
    }

	

}
