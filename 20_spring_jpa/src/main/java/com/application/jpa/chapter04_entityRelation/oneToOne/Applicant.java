package com.application.jpa.chapter04_entityRelation.oneToOne;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.ToString;

@Entity
@Getter
@ToString
public class Applicant {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "APPLICANT_ID")
	private Long id;
	private String name;

	@OneToOne(mappedBy = "applicant")
	private Profile profile;
	
	public String toStringCustom() {
		return "Applicant [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
