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
		
		반복문을 사용하여
	
		1900~2020년 까지		select태그에 구현해보시오.
		1월 부터 12월 까지		select태그에 구현해보시오.
		1일 부터 31일 까지		select태그에 구현해보시오.
		
	 -->
	 
	<select>
		<c:forEach var="i" begin="1900" end="2020">
			<option value=${i }>${i}</option>
		</c:forEach>
	</select>년 
	<select>
		<c:forEach var="i" begin="1" end="12">
			<option value=${i }>${i}</option>
		</c:forEach>
	</select>월 
	<select>
		<c:forEach var="i" begin="1" end="31">
			<option value=${i }>${i}</option>
		</c:forEach>
	</select>일    
	 
</body>
</html>