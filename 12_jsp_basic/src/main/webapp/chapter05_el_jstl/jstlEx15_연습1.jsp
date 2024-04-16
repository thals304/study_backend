<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%-- 24.04.16 time 11:52-12:16
	today 소감문
	수업에서 이미 한 문제를 안보고 내 힘으로 못풀었다는 것은
	수업에 대한 완벽한 복습이 안이루어졌다고 볼 수가 있다.
	그리고 어레이 리스트를 생성하는 방법과 값을 추가해 주는 방법도 다 잊어버려서
	복습이 필요하다.
	그리고 java에서는 set으로 값을 수정할 수 있고
	jstl에서는 그냥 .변수로 값을 출력해야 한다는 점(나는 jstl에서도 .set변수로 출력하려는 실수가 발생했음 propertynotfoundException)  
 --%>
<html>
<head>
<meta charset="UTF-8">
<title>연습문제</title>
</head>
<body>

	<!-- 
	
		# 데이터 출력
		
		1. JstlEx15_정답예시 Servlet에서 productList를 전달받고
		2. 전달받은 상품이 없으면 '조회된상품이 없습니다'를 출력
		   전달받은 상품이 있으면 각각 상품에 알맞도록 데이터를 출력해보시오.
		
	 -->
	 
	<table border="1">
		<tr>
			<td>상품코드</td>
			<td>상품이름</td>
			<td>부서코드</td>
			<td>부서이름</td>
			<td>관리자이름</td>
		</tr>
		<c:choose>
			<c:when test="${not empty productList }">
				<c:forEach var="productDTO" items="${productList }">
					<tr>
						<td>${productDTO.pdCd }</td>
						<td>${productDTO.pdNm }</td>
						<td>${productDTO.deptCd }</td>
						<td>${productDTO.deptNm }</td>
						<td>${productDTO.mgrCd}</td>
						<td>${productDTO.mgrNm}</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr align="center">
					<td colspan="6">조회된 데이터가 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table> 
	
</body>
</html>