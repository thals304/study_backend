<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 24.04.15 time 21:06-21:18
	today 소감문
	지금 코드가 문제가 아니라 톰캣이 말을 안들어서 내 정답을 확인할 수 없는게 너무 답답하다.
	정답예시는 나처럼 <c:set>으로 서블렛에서 값 안 받아오고 바로 사용했는데
	나도 정답예시 방법을 많이 사용해야겠다.
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습문제</title>
</head>
<body>

	<!--  
	
		# 로그인
		
		1. JstlEx08_정답 Servlet파일에서 id와 pw를 넘겨받는다.
		2. 넘겨받은 데이터와 db데이터를 비교해 로그인 처리를 진행한다.
		예) 로그인 성공 or 로그인 실패
 	
 	-->3
 	
 	<c:set var="dbId" value="qwer1234" />
 	<c:set var="dbPw" value="1234" />
 	
 	<c:set var="myId" value="${myId }"/>
 	<c:set var="myPw" value="${myPw }"/>
 	
 	<c:choose>
 		<c:when test="${dbId == myId && dbPw == myPw}">
 			<p>로그인 성공</p>
 		</c:when>
 		<c:otherwise>
 			<p>로그인 실패</p>
 		</c:otherwise>
 	</c:choose>
 	
 	
</body>
</html>