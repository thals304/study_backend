#CREATE DATABASE SPRING_JPA_EX;
USE SPRING_JPA_EX;

# 테이블 생성
CREATE TABLE POST(
	POST_ID 	BIGINT AUTO_INCREMENT PRIMARY KEY,
	SUBJECT 	VARCHAR(255),
	CONTENT 	VARCHAR(255),
	ENROLL_DATE TIMESTAMP DEFAULT NOW(),
	UPDATE_DATE TIMESTAMP DEFAULT NOW()
);

CREATE TABLE REPLY (
	REPLY_ID    BIGINT AUTO_INCREMENT PRIMARY KEY,
	POST_ID     BIGINT ,
    CONTENT     VARCHAR(255),
    ENROLL_DATE TIMESTAMP DEFAULT NOW(),
	UPDATE_DATE TIMESTAMP DEFAULT NOW()
);


# 테스트 데이터
INSERT INTO 
		POST(SUBJECT, CONTENT)
VALUES 
		('게시글1 입니다.' , '본문1 입니다.'),
		('게시글2 입니다.' , '본문2 입니다.'),
		('게시글3 입니다.' , '본문3 입니다.');
		

INSERT INTO 
		REPLY(POST_ID, CONTENT)
VALUES 
		(1, '댓글1 입니다.'),
		(1, '댓글2 입니다.'),
		(2, '댓글3 입니다.'),
		(2, '댓글4 입니다.'),
		(3, '댓글5 입니다.'),	
		(3, '댓글6 입니다.'),	
		(3, '댓글7 입니다.'),	
		(3, '댓글8 입니다.'),	
		(3, '댓글9 입니다.'),	
		(3, '댓글10 입니다.');	
	