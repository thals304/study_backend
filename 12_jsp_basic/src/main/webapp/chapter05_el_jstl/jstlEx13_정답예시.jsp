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
	
		# 데이터 출력
		
		- JstlEx13_정답예시 Servlet에서 pdCdList를 전달받고 데이터를 화면에 출력해보시오.
		Ex) "0x001" "0x002"  "0x003"  "0x004" "0x005"  "0x006" "0x007"	
		
	 -->
	 
	<c:forEach var="pdCd" items="${pdCdList }">
		${pdCd } &emsp;
	</c:forEach>
</body>
</html>