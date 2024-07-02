package com.application.jpa.chapter04_entityRelation.basic;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
/*
	
	2. 기본키 매핑 


- @Id : 엔티티의 기본 키(Primary Key)를 나타낸다.

	strategy: 기본 키 생성 전략을 지정한다. 
	GenerationType : 열거형(enum)의 값 중 하나를 사용할 수 있다.
	
	
- @GeneratedValue : 기본 키의 값을 자동으로 생성할 전략을 명시한다. (AUTO, IDENTITY, SEQUENCE, TABLE 중 선택)

	@GeneratedValue(strategy = GenerationType.AUTO) 
	- AUTO는 JPA 구현체가 기본 키 생성을 자동으로 선택하게 한다. 
	- 데이터베이스에 따라 적절한 전략을 자동으로 선택한다.

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	- IDENTITY는 데이터베이스의 자동 증가(auto-increment) 필드를 사용하여 기본 키 값을 생성한다. 
	  주로 MySQL, SQL Server 등에서 사용된다.

	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	- SEQUENCE는 데이터베이스 시퀀스를 사용하여 기본 키 값을 생성한다. 
	  주로 Oracle, PostgreSQL 등에서 사용되고 이 경우 @SequenceGenerator와 함께 사용해야 한다.

	@GeneratedValue(strategy = GenerationType.TABLE)
	- TABLE은 키 생성용 테이블을 사용하여 기본 키 값을 생성한다. 
	  모든 데이터베이스에서 사용할 수 있으며 @TableGenerator와 함께 사용해야 한다.
	
	  
*/

@Entity
@Table(name="ENTITY_EX02")
public class EntityRelationEx02 {

	// @Id // 직접 할당
	// @Id @GeneratedValue(strategy = GenerationType.AUTO)     // 관계형 데이터베이스에 위임
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)  // 자동증가(auto_increment)
	// @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) // 시퀀스 생성
	// @Id @GeneratedValue(strategy = GenerationType.TABLE)      // 테이블 생성
	private Long id;
	
}
