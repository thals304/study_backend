<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습문제</title>
</head>
<body>

	
	<!--  
	
		# Up & Down 게임
		
		1. com은 3이다.
		2. me는 com의 숫자를 맞추는 게임이다.
		3. 다음과 같은 메세지를 출력한다.
		1) me < com	: Up!
		2) me == com : Bingo!
		3) me > com  : Down!
	
	--> 

	<c:set var="com" value="3"/>
	<c:set var="me" value="12" />
	
	<fmt:parseNumber var="com" value="${com }"/>
	<fmt:parseNumber var="me" value="${me }"/>
	
</body>
</html>