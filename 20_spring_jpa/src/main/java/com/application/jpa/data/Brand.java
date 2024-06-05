package com.application.jpa.data;

import java.util.Date;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
/*

- JPA 주요 어노테이션

@Entity : 클래스가 JPA 엔티티임을 나타낸다. 클래스 이름이 DB 테이블 이름에 매핑된다.

@Table  : 엔티티 클래스가 매핑될 테이블의 정보를 명시한다. (name, catalog, schema 등의 속성을 가질 수 있음)

@Id		: 엔티티의 기본 키(Primary Key)를 나타낸다.

@GeneratedValue : 기본 키의 값을 자동으로 생성할 전략을 명시한다. (AUTO, IDENTITY, SEQUENCE, TABLE 중 선택)

@Column : 필드가 매핑될 테이블의 컬럼을 명시한다. (name, nullable, length 등의 속성을 가질 수 있음)

@ManyToOne, @OneToMany, @OneToOne, @ManyToMany : 엔티티 간의 관계를 명시한다. (@JoinColumn과 함께 사용되는 경우가 많음)

@JoinColumn : 외래 키(Foreign Key)를 매핑할 때 사용한다. (name, referencedColumnName 등의 속성을 가질 수 있음)

@Transient : 필드가 영속성 컨텍스트에 저장되거나 검색되지 않음을 나타낸다.

@Temporal : 날짜 타입(java.util.Date, java.util.Calendar)의 매핑을 명시한다. (TemporalType.DATE, TemporalType.TIME, TemporalType.TIMESTAMP 중 선택)

*/
@Data
@Entity // JPA 엔티티 사용 선언 어노테이션
@DynamicUpdate // 하이버네이트 스펙에서 지원해주는 기능으로 @DynamicUpdate 애노테이션을 사용하여 변경되는 컬럼만 추적하여 수정한다.
public class Brand {
	
	@Id // primary key 컬럼 지정
	private Long brandId; // primary key를 클래스 형태로 써줌
	private String brandNm;
	private Date enteredDt;
	private String activeYn;
}
