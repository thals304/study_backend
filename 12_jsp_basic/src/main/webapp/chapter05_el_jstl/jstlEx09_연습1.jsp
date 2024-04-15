<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%-- 24.04.15 time 21:36-21:39
	today 소감문
	scroipt에서 alert함수를 출력하려면 함수를 호출을 해야 하는데 버튼도 없고 폼도 없고
	어떻게 해야할지 생각이 안나는 것 같다.
	script가 body에서도 사용 가능할 지 몰랐다. 근데 생각해 보니까 js를 헤드 부분에서도 쓰고
	바디에서도 쓰기도 한다고 했는데 이 문제가 그 경우인 것 같다.
--%>
<html>
<head>
<meta charset="UTF-8">
<title>연습문제</title>

</head>
<body>

	<!-- 
	
		# 스크립트 이동
		
		1. JstlEx09_정답 Servlet파일에서 isChecked의 속성에 boolean변수를 넘겨 받는다.
		2. isChecked값이 true이면 script에서 alert함수로 '확인되었습니다.'를 출력한다.
		   isChecked값이 false이면 script에서 alert함수로 '확인되지 않았습니다.'를 출력한다.
	
	 -->

	<c:choose>
		<c:when test="${isChecked == true }">
			<script>
				alert("확인되었습니다.");
			</script>
		</c:when>
		<c:otherwise>
			<script>
			alert("확인되지 않았습니다.");
			</script>
		</c:otherwise>
	</c:choose>
	
</body>
</html>