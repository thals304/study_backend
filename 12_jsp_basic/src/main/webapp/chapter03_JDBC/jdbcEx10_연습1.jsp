<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 24.04.11 time 17:41-17:47
	today 소감문
	이번거는 간단했던 것 같다.
	확실히 select가 가장 어렵게 느껴지고 업데이트나 삭제가 가장 간단하고 생각한다.
 -->
<html>
<head>
<meta charset="UTF-8">
<title>연습예제</title>
</head>
<body>

	<!-- 
		
		- 전송된 데이터를 Database에서 insert하는 로직을 작성해보시오. 
		
		- 상품이 추가된후 아래와 같이 수정화면으로 이동할수 있도록 화면을 작성해보시오.
		
			<h3>상품이 추가되었습니다.</h3>
			<a href="">상품추가 화면으로 이동하기</a>
		
	-->

	<form action="jdbcEx10Pro_연습1정답.jsp" method="post">
		<h3>상품추가</h3>
		<p>상품코드 : <input type="text" name="productCd"></p>
		<p>상품이름 : <input type="text" name="productNm"></p>
		<p>금액 : <input type="text" name="price"></p>
		<p><input type="submit" value="추가"></p>
	</form>

</body>
</html>