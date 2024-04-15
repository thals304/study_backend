<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습문제</title>
</head>
<body>

	<!-- 
	
		문제1) 1~5까지의 합 출력
		정답1) 15
	
		문제2) 1~10까지 반복해 3미만 7이상만 출력
		정답2) 1 2 7 8 9 10
	
		문제3) 문제2의 조건에 맞는 수들의 합 출력
		정답3) 37
		
		문제4) 문제2의 조건에 맞는 수들의 개수 출력
		정답4) 6
		
	 -->
	 
	<c:set var="sum" value="0"/>
	<c:forEach var="i" begin="1" end="5">
		<c:set var="sum" value="${sum+i }"/>
	</c:forEach>
	1번 정답 : ${sum }
	
	<hr>		
	
	2번 정답 : 	
	<c:forEach var="i" begin="1" end="10">
		<c:if test="${i < 3 or i >= 7 }">
			${i }
		</c:if>
	</c:forEach>
		
	
	<hr>	
	
	<c:set var="total" value="0" />
	<c:forEach var="i" begin="1" end="10">
		<c:if test="${i < 3 or i >= 7 }">
			<c:set var="total" value="${total + i }" />
		</c:if>
	</c:forEach>		
	3번 정답 : ${total }
	
	<hr>	
		
	<c:set var="count" value="0" />
	<c:forEach var="i" begin="1" end="10">
		<c:if test="${i < 3 or i >= 7 }">
			<c:set var="count" value="${count + 1 }" />
		</c:if>
	</c:forEach>	
	4번 정답 : ${count }	
	
</body>
</html>