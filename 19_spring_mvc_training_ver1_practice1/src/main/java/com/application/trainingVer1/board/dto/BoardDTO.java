package com.application.trainingVer1.board.dto;

import java.util.Date;

public class BoardDTO {

	private long boardId;
	private String passwd;
	private String writer;
	private String subject;
	private String content;
	private long readCnt;
	private Date enrollAt;
	
	public long getBoardId() {
		return boardId;
	}
	public void setBoardId(long boardId) {
		this.boardId = boardId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getReadCnt() {
		return readCnt;
	}
	public void setReadCnt(long readCnt) {
		this.readCnt = readCnt;
	}
	public Date getEnrollAt() {
		return enrollAt;
	}
	public void setEnrollAt(Date enrollAt) {
		this.enrollAt = enrollAt;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [boardId=" + boardId + ", passwd=" + passwd + ", writer=" + writer + ", subject=" + subject
				+ ", content=" + content + ", readCnt=" + readCnt + ", enrollAt=" + enrollAt + "]";
	}
}
