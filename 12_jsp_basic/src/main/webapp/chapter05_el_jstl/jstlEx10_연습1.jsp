<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%-- 24.04.15 time 21:41-21:54
	today 소감문
	합과 카운트를 하는 코드를 써야 하는데 <c:set val="${}">를 사용하는 것을
	정답예시를 보면서 깨달아서 새롭게 알게 된 것 같아 암기해야겠다고 생각했다.
	그리고 value="${}"에서는 증감식 사용이 불가능하다는 점! 그냥 +1 해주면 된다는 점
 --%>
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
	<h3>문제 1)</h3>
	<c:set var="sum" value="0" />
	<c:forEach var="i" begin="1" end="5">
		<c:set var="sum" value="${sum += i }"/>
	</c:forEach>
	<h3>문제 2)</h3>
	<c:forEach var="j" begin="1" end="10">
		<c:choose>
			<c:when test="${j < 3 || j >= 7 }">
				${j }
			</c:when>
		</c:choose>
	</c:forEach>
	
	<h3>문제 3)</h3>
	<c:set var="sum2" value="0"/>
	<c:forEach var="k" begin="1" end="10">
		<c:choose>
			<c:when test="${k < 3 || k >= 7 }">
				<c:set val="sum2" value="${sum += k}"/>
			</c:when>
		</c:choose>
	</c:forEach>
	
	<h3>문제 4)</h3>
	<c:set var="cnt" val="0"/>
	<c:forEach var="j" begin="1" end="10">
		<c:choose>
			<c:when test="${j < 3 || j >= 7 }">
				<c:set val="cnt" val="${cnt + 1 }"/>
			</c:when>
		</c:choose>
	</c:forEach>
</body>
</html>