package com.application.trainingVer2.member.domain;

import java.time.LocalDate;
import java.util.Date;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "MEMBER")
@Data
@DynamicInsert // default 제약사항 적용
@DynamicUpdate
public class Member {
	
	@Id
	@Column(name = "MEMBER_ID" , length = 20)
	private String memberId;
	
	@Column(name = "PASSWD" , length=255 , nullable = false)
	private String passwd;
	
	@Column(name = "PROFILE_ORIGINAL_NAME" , length=255 , nullable = false)
	private String profileOriginalName;
	
	@Column(name = "PROFILE_UUID" , length = 255 , nullable = false)
	private String profileUuid;
	
	@Column(name = "MEMBER_NM" , length = 50 , nullable = false)
	private String memberNm;
	
	@Column(name = "SEX" , nullable = false , columnDefinition = "CHAR(1)")
	private String sex;
	
	@Column(name = "BIRTH_AT" , nullable = false)
	private LocalDate birthAt;
	
	@Column(name = "HP" , nullable = false , columnDefinition = "CHAR(13)")
	private String hp;
	
	@Column(name = "SMSSTS_YN" , columnDefinition = "CHAR(1)")
	private String smsstsYn;
	
	@Column(name = "EMAIL" , length = 30 , nullable = false)
	private String email;
	
	@Column(name = "EMAILSTS_YN" , columnDefinition = "CHAR(1)")
	private String emailstsYn;
	
	@Column(name = "ZIPCODE" , length = 10)
	private String zipcode;
	
	@Column(name = "ROAD_ADDRESS" , length = 255)
	private String roadAddress;
	
	@Column(name = "JIBUN_ADDRESS" , length = 255)
	private String jibunAddress;
	
	@Column(name = "NAMUJI_ADDRESS" , length = 255)
	private String namujiAddress;
	
	@Lob
	@Column(name = "ETC")
	private String etc;
	
	@Column(name = "ACTIVE_YN" , columnDefinition = "CHAR(1) DEFAULT 'y'")
	private String activeYn;
	
	@Column(name = "INACTIVE_AT")
	private Date inactiveAt;
	
	@Column(name = "JOIN_AT" , columnDefinition = "TIMESTAMP DEFAULT NOW()")
	private LocalDate joinAt;
	
}

