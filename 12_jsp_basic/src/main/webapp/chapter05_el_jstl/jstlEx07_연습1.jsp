<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%-- 24.04.15 time 14:37-14:50
	today 소감문
	일단 when문으로 하려고 했는데 apache 오류가 났다고 해서 if문 사용하는 것으로 바꾸었다.
	그리고 시간이 많이 걸린 이유는 랜덤으로 me가 가위, 바위, 보 값을 가져야 하는데
	request.setAttribute만 하다가 갑자기 랜덤을 어떻게 구현하지? 이런 혼란을 약간 가졌는데
	어차피 자바이기 때문에 Radom ran을 해주면 되는 것이었다.
 --%>
<html>
<head>
<meta charset="UTF-8">
<title>연습문제</title>
</head>
<body>

	<!--  
	
		# 가위 바위 보
		
		1. com은 바위만 낼 수 있다.
		2. me는 가위 바위 보 중에 하나의 값을 JstlEx07_정답 Servlet파일에서 넘겨받는다.
		3. me의 데이터에 따라
			1) 비겼다.
			2) 내가 이겼다.
			3) 내가 졌다.			를 출력한다.
	
	
	-->
 	<c:set var="com" value="바위" />
 	<c:set var="me" value="${me }" />
 	
 	<p>com : <c:out value="${com }"/></p>
 	<p>me : <c:out value="${me }"/></p>
 	<h3>결과 출력</h3>
 	<c:if test="${me == '가위' }">
 		<p>내가 졌다.</p>
 	</c:if>
 	<c:if test="${me == '바위' }">
 		<p>비겼다.</p>
 	</c:if>
 	<c:if test="${me == '보' }">
 		<p>내가 이겼다.</p>
 	</c:if>
</body>
</html>