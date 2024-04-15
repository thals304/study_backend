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
			<td>관리자코드</td>
			<td>관리자이름</td>
		</tr>
		<c:choose>
			<c:when test="${empty productList }"> 
			<tr>
		       <td colspan="5" ><strong>조회된 상품이 없습니다.</strong></td>
		    </tr>
		 	</c:when>
		 	<c:otherwise>
	  			<c:forEach var="product" items="${productList }">
				<tr>				
					<td>${product.pdCd}</td>
					<td>${product.pdNm}</td>
					<td>${product.deptCd}</td>
					<td>${product.deptNm}</td>
					<td>${product.mgrCd}</td>
					<td>${product.mgrNm}</td>
				</tr>
			</c:forEach>
			</c:otherwise>
		</c:choose>	      
	</table> 
	
</body>
</html>