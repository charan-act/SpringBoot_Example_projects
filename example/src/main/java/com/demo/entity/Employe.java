package com.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;

@ Entity
@Data
public class Employe {
	@Id
	
	private long employeId;
	private String employeName;
	private double salary;
}