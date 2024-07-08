package com.application.jpa.chapter04_entityRelation.manyToOne;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;

@Entity
@Getter // @toString을 하면 무한 루프에 걸림
public class Post {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "POST_ID")
	private Long id;
	private String subject;
	private String content;
	private LocalDateTime enrollDate;
	private LocalDateTime updateDate;
	
	// 양방향 @OneToMany는 기본 fetch 타입이 Lazy이기 때문에 관계 엔티티를 기본적으로 지연로딩한다 
	// post 기준으로 post 1개, reply 여러 개
	@OneToMany(mappedBy = "post")
	private List<Reply> replies = new ArrayList<Reply>(); // 관례
	
	
	public String toStringCustom() {
		return "Post [id=" + id + ", subject=" + subject + ", content=" + content + ", enrollDate="
				+ enrollDate + ", updateDate=" + updateDate + "]";

	}
	
}
