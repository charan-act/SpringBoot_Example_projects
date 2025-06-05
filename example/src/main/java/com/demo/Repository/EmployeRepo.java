package com.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.entity.Employe;

public interface EmployeRepo extends CrudRepository<Employe, Long> {


}
