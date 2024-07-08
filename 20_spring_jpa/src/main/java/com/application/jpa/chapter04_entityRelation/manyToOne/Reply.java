package com.application.jpa.chapter04_entityRelation.manyToOne;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter 
public class Reply {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REPLY_ID")
	private Long id;
	// private Long postId; // 외래키를 쓰지 않고 참조형태를 사용함
	private String content;
	private LocalDateTime enrollDate;
	private LocalDateTime updateDate;
	
	// 단방향 
	// reply 기준으로 reply 여러 개 : post 1개
	//@ManyToOne (fetch = FetchType.EAGER) // 즉시로딩 (기본값 , 해당객체를 참조하지 않아도 엔티티를 로드한다.)
	@ManyToOne(fetch = FetchType.LAZY) // 지연로딩 (해당객체를 참조할때만 엔티티를 로드한다.)
	@JoinColumn(name = "post_id")
	private Post post;
	

	public String toStringCustom() {
		return "Reply [id=" + id + ", content=" + content + ", enrollDate=" + enrollDate + ", updateDate=" + updateDate+ "]";	
	}

	
}
