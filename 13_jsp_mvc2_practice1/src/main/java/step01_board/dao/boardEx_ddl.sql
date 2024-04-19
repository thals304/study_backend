CREATE DATABASE MVC2_PRACTICE;
USE MVC2_PRACTICE;

CREATE TABLE BOARD (
	BOARD_ID  BIGINT AUTO_INCREMENT PRIMARY KEY,
	WRITER    VARCHAR(255),
	SUBJECT   VARCHAR(255),
	EMAIL     VARCHAR(255),
	PASSWORD  VARCHAR(255),
	CONTENT   VARCHAR(2000),
	READ_CNT  BIGINT ,
	ENROLL_DT TIMESTAMP
);

