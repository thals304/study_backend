package com.application.jpa.chapter04_entityRelation.oneToOne;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;

@Entity
@Getter
public class Profile {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROFILE_ID")
	private Long id;
	private String profile;
	
	@OneToOne
	@JoinColumn(name = "applicant_id")
	private Applicant applicant;
	
	public String toStringCustom() {
		return "Profile [id=" + id + ", profile=" + profile + "]";
	}
	
}
