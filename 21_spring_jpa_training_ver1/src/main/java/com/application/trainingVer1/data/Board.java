package com.application.trainingVer1.data;

import java.util.Date;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@DynamicUpdate
public class Board {

	@Id // 엔티티의 기본 키(PK)를 나타낸다.
	@GeneratedValue(strategy = GenerationType.IDENTITY)// 기본 키의 값을 데이터베이스가 자동으로 생성해준다. = auto increment
													   // IDENTITY 전략은 데이터베이스에 의존적이며, 대부분의 데이터베이스가 지원하는 자동 증가 필드를 이용한다.
	@Column(nullable = false) // null 값을 허용하지 않음을 나타냄
	private Long boardId;
	
	@Column(nullable = false) // null 값을 허용하지 않음을 나타냄
	private String passwd;
	
	@Column(nullable = false) // null 값을 허용하지 않음을 나타냄
	private String writer;
	
	@Column(nullable = false) // null 값을 허용하지 않음을 나타냄
	private String subject;
	
	@Column(nullable = false) // null 값을 허용하지 않음을 나타냄
	private String content;
	
	@Column(nullable = false) // null 값을 허용하지 않음을 나타냄
	private Long readCnt;
	
	@Column(nullable = false) // null 값을 허용하지 않음을 나타냄
	private Date enrollAt;
	
}
