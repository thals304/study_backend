<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%-- 24.04.15 time 22:04-22:07
	today 소감문
	밑에서 요구하는 테이블이 행이 12개 이더라도 한 행의 첫번째 열이기 때문에
	td를 꼭 써줘야 한다는 점!
 --%>
<html>
<head>
<meta charset="UTF-8">
<title>연습문제</title>
</head>
<body>

	<!-- 
		
		- 반복문을 사용하여 하나의 테이블의 12개의 tr을 생성해보시오.
		  Ex)
			  1
			  2
			  3
			  4
			  5
			  6
			  7
			  8
			  9
			  10
			  11
			  12
		
	 -->	 
	
	
		<table border="1">
			<c:forEach var="i" begin="1" end="12">
				<tr>
					<td>${i} </td>
				</tr>
			</c:forEach>
		</table>
	
</body>
</html>