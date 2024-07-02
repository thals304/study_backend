package com.application.jpa.chapter04_entityRelation.basic;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
/*


spring.jpa.hibernate.ddl-auto=정책 (application.properties 설정파일)


- Hibernate는 애플리케이션을 시작할 때 데이터베이스 스키마를 자동으로 업데이트한다. 

- Entity 클래스에 대한 변경 사항(새로운 엔티티 추가, 기존 엔티티의 필드 추가/삭제/변경 등)이 있을 경우
  해당 변경 사항을 데이터베이스 스키마에 반영할 수 있다.

	[ 정책 ]
	
	1) none: 데이터베이스 스키마를 자동으로 생성하지 않는다. 혹은 ddl-auto 설정을 주석처리하여 사용
	
	2) create: 애플리케이션을 실행할 때마다 데이터베이스 스키마를 새로 생성한다.
	
	3) create-drop: create와 유사하게 애플리케이션 시작 시 데이터베이스 스키마를 생성하지만 
	                애플리케이션이 종료될 때 생성된 테이블을 모두 삭제한다.
	
	4) update: 애플리케이션 실행 시 데이터베이스 스키마를 업데이트한다.
	
	5) validate: 애플리케이션 실행 시 엔티티와 테이블이 올바르게 매핑되었는지 검증만 수행하고 데이터베이스 스키마는 변경하지 않는다.


*/



/*

1. 객체와 테이블 매핑 @Entity , @Table

- JPA를 사용하여 관계형 데이터베이스의 테이블과 매핑할 클래스에 @Entity 어노테이션을 사용한다.

	@Entity : 클래스가 JPA 엔티티임을 나타낸다. 클래스 이름이 DB 테이블 이름에 매핑된다.
	@Table  : 엔티티 클래스가 매핑될 테이블의 정보를 명시한다. (name, catalog, schema 등의 속성을 가질 수 있음)

- 기본생성자는 필수로 존재해야 한다.

*/

@Entity
@Table(name = "ENTITY_EX01")
public class EntityRelationEx01 {

	@Id
	private Long id;
	
}
