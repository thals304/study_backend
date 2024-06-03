package com.application.trainingVer2.postAdvance.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyDTO {

	private long replyId;
	private String userId;
	private long postId;
	private String content;
	private Date enrollAt;
	
}
