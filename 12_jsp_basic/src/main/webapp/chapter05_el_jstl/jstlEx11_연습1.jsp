<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%-- 24.04.15 time 21:57-22:02
	today 소감문
	이번 문제는 잘 푼 것 같아 기분이 좋다. 헷갈릴만 한데 헷갈리지 않은 점은
	foreach를 select 안에 넣은 점이다. 만약 밖에 두었으면 년,월,일마다
	몇 십개씩 select문이 나왔을 것이다.
 --%>
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
	 <p>
	 	<select>
	 		<c:forEach var="year" begin="1900" end="2020">
	 			<option value="${year }">${year }</option>
	 		</c:forEach>
	 	</select>
	 	년
	 
	 	<select>
	 		<c:forEach var="month" begin="1" end="12">
	 			<option value="${month }">${month }</option>
	 		</c:forEach>
	 	</select>
	 	월
	 	
	 	<select>
	 		<c:forEach var="day" begin="1" end="31">
	 			<option value="${day }">${day }</option>
	 		</c:forEach>
	 	</select>
	 </p>
	 
	 	
</body>
</html>