#CREATE DATABASE SPRING_JPA_EX;
USE SPRING_JPA_EX;


# 테이블 생성
CREATE TABLE EMPLOYEE(
	EMPLOYEE_ID  BIGINT AUTO_INCREMENT PRIMARY KEY,
    NAME   		 VARCHAR(255)
);

CREATE TABLE SALARY(
	SALARY_ID    BIGINT AUTO_INCREMENT PRIMARY KEY,
	EMPLOYEE_ID  BIGINT,
	SALARY       INT,
	RECEIPT_DATE DATE
);


# 테스트 데이터
INSERT INTO 
		EMPLOYEE(NAME)
VALUES 
		('익명1'),
		('익명2'),
		('익명3');
		
INSERT INTO 
		SALARY(EMPLOYEE_ID , SALARY , RECEIPT_DATE)
VALUES 
		(1, 3000000, '2024-01-25'),
		(1, 3000000, '2024-02-25'),
		(1, 3000000, '2024-03-25'),
		(1, 3000000, '2024-04-25'),
		(1, 3000000, '2024-05-25'),
		(1, 3000000, '2024-06-25'),
		(1, 3000000, '2024-07-25'),
		(2, 5000000, '2024-01-25'),
		(2, 5000000, '2024-02-25'),
		(2, 5000000, '2024-03-25'),
		(3, 7000000, '2024-01-25'),
		(3, 8000000, '2024-02-25'),
		(3, 9000000, '2024-03-25');

