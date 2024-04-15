<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%-- 24.04.15 time 22:09-22:23
	today 소감문
	아니 정답예시랑 같게 문제 풀이를 했는데 왜 아무것도 출력이 안되는지 모르겠다.
	톰캣이 문제인건지 내 코드가 문제인건지 너무 신경쓸게 많아서 더 힘든거 같다.
 --%>
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