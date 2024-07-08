#CREATE DATABASE SPRING_JPA_EX;
USE SPRING_JPA_EX;

# 테이블 생성
CREATE TABLE STUDENT (
	STUDENT_ID  BIGINT AUTO_INCREMENT PRIMARY KEY,
	NAME        VARCHAR(255)   
);

CREATE TABLE ENROLLMENT (  # JOIN 테이블
	STUDENT_ID BIGINT, 
	COURSE_ID  BIGINT
);

CREATE TABLE COURSE(
	COURSE_ID  BIGINT AUTO_INCREMENT PRIMARY KEY,
	NAME       VARCHAR(255)
);


# 테스트 데이터
INSERT INTO 
		STUDENT(NAME)
VALUES 
		('익명1'),
		('익명2'),
		('익명3'),
		('익명4'),
		('익명5'),
		('익명6'),
		('익명7'),
		('익명8'),
		('익명9'),
		('익명10');
				
INSERT INTO 
		COURSE(NAME)
VALUES 
		('C'),
		('Python'),
		('Java');

INSERT INTO 
		ENROLLMENT
VALUES 
		(1,1),
		(1,2),
		(1,3),
		(2,1),
		(2,2),
		(3,3),
		(4,1),
		(4,2),
		(4,3),
		(5,1),
		(6,1),
		(6,2),
		(7,1),
		(7,2),
		(7,3),
		(8,1),
		(9,2),
		(10,3);