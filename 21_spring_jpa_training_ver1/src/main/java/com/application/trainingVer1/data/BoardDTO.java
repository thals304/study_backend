package com.application.trainingVer1.data;

import java.util.Date;

import lombok.Data;

@Data
public class BoardDTO {
	
	private Long boardId;
	private String passwd;
	private String writer;
	private String subject;
	private String content;
	private Long readCnt;
	private Date enrollAt;
}
