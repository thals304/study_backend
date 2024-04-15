<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- 24.04.15 time 14:31-14:34
	today 소감문
	문제가 너무 친절하게 com, me의 변수를 만들어주고 데이터 형변환까지 해줘서 
	나는 if문만 쓰면 되기 때문에 별로 어렵지 않았다.
 --%>
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
	
	<c:choose>
		<c:when test="${com > me }">
			<p>Up!</p>
		</c:when>
		<c:when test="${com == me }">
			<p>Bingo!</p>
		</c:when>
		<c:when test="${com < me }">
			<p>Down!</p>
		</c:when>
	</c:choose>
	
</body>
</html>