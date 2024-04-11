<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습예제</title>
</head>
<body>

	<!-- 
	
		- 선택된 할인률만큼 Database에서 모든 상품의 가격을 update하는 로직을 작성해보시오. 
		
		- 상품이 수정된후 아래와 같이 수정화면으로 이동할수 있도록 화면을 작성해보시오.
		
			<h3>상품이 수정되었습니다.</h3>
			<a href="">상품수정 화면으로 이동하기</a>
	-->

	<form action="jdbcEx09_정답예시.jsp" method="post">
		<h3>할인 적용</h3>
		<p>
			<input type="radio" name="discountRate" value="3"> 3% 
			<input type="radio" name="discountRate" value="5"> 5% 
			<input type="radio" name="discountRate" value="7"> 7% 
			<input type="radio" name="discountRate" value="10"> 10% 
		</p>
		<p><input type="submit" value="수정"></p>
	</form>

</body>
</html>