package step01_board.dto;

import java.util.Date;

public class BoardDTO_연습1 {
	
	private long boardId;
	private String writer;
	private String subject;
	private String email;
	private String password;
	private String content;
	private long readCnt;
	private Date  enrollDt;
	public long getBoardId() {
		return boardId;
	}
	public void setBoardId(long boardId) {
		this.boardId = boardId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public Date getEnrollDt() {
		return enrollDt;
	}
	public void setEnrollDt(Date enrollDt) {
		this.enrollDt = enrollDt;
	}
	@Override
	public String toString() {
		return "BoardDTO_연습1 [boardId=" + boardId + ", writer=" + writer + ", subject=" + subject + ", email=" + email
				+ ", password=" + password + ", content=" + content + ", readCnt=" + readCnt + ", enrollDt=" + enrollDt
				+ "]";
	}
	
	
}
