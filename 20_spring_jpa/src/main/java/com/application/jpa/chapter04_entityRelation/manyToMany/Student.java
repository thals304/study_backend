package com.application.jpa.chapter04_entityRelation.manyToMany;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;

@Entity
@Getter
public class Student {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STUDENT_ID")
	private Long id;
	private String name;
	
	@ManyToMany
	@JoinTable(
		 name = "ENROLLMENT",
		 joinColumns = @JoinColumn(name = "STUDENT_ID"),
		 inverseJoinColumns = @JoinColumn(name = "COURSE_ID")
	 )
	private List<Course> courses = new ArrayList<>();
	public String toStringCustom() {
		return "Applicant [id=" + id + ", name=" + name + "]";
	}
	
	
}
