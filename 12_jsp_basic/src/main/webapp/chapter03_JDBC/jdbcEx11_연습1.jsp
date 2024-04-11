<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 24.04.11 time 17:49-17:52
	today 소감문	
	delete는 확실히 앞에 애들보다 더 간단하고 쉬운 것 같다.
 -->
<html>
<head>
<meta charset="UTF-8">
<title>연습예제</title>
</head>
<body>

	<!-- 
		
		- 전송된 데이터를 Database에서 delete하는 로직을 작성해보시오. 
		- 상품이 삭제된후 아래와 같이 수정화면으로 이동할수 있도록 화면을 작성해보시오.
		
			<h3>상품이 삭제되었습니다.</h3>
			<a href="">상품삭제 화면으로 이동하기</a>
	-->

	<form action="jdbcEx11Pro_연습1정답.jsp" method="post">
		<h3>상품 삭제</h3>
		<p>상품코드 : <input type="text" name="productCd"></p>
		<p><input type="submit" value="삭제"></p>
	</form>

</body>
</html>