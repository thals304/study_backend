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
	
		# 로그인
		
		1. JstlEx08_정답 Servlet파일에서 id와 pw를 넘겨받는다.
		2. 넘겨받은 데이터와 db데이터를 비교해 로그인 처리를 진행한다.
		예) 로그인 성공 or 로그인 실패
 	
 	-->
 	
 	<c:set var="dbId" value="qwer1234" />
 	<c:set var="dbPw" value="1234" />
 	
 	<c:choose>
 		<c:when test="${dbId eq id and dbPw eq pw }">
 			로그인 성공
 		</c:when>
 		<c:otherwise>
 			로그인 실패
 		</c:otherwise>
 	</c:choose>

</body>
</html>