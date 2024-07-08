package com.application.jpa.chapter04_entityRelation.oneToMany;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
public class Employee {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMPLOYEE_ID")
	private Long id;
	private String name;
	
	// 단방향
	@OneToMany(mappedBy ="employee")
	private List<Salary> salaries = new ArrayList<Salary>();
	

	public String toStringCustom() {
		return "Employee [id=" + id + ", name=" + name + "]";
	} 
	
	
}
