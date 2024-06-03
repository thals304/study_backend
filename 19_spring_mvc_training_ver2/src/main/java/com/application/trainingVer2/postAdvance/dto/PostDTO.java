package com.application.trainingVer2.postAdvance.dto;

import java.util.Date;

import lombok.Data;


@Data
public class PostDTO {

	private long postId;
	private String userId;
	private String subject;
	private String content;
	private long readCnt;
	private Date enrollAt;
	
}
