package com.application.jpa.chapter04_entityRelation.oneToMany;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
public class Salary {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SALARY_ID")
	private Long id;
	private Integer salary;
	private LocalDate receiptDate;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	public String toStringCustom() {
		return "Salary [id=" + id + ", salary=" + salary + ", receiptDate=" + receiptDate + "]";
	}
	
}
