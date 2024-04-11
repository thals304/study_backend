<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 24.04.11 time 17:21-17:38
	today 소감문
	정답예시에서는 price = price - (price * ?);로 하고
	밑에서 radio 값을 받아 올 때 0.01을 곱해줬는데
	나는 price = price - price * (? / 100); 으로 하고
	setDouble로 radio 값을 받아줬는데 코드가 잘 적용이 되지 않았던 것 같다.
 -->
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

	<form action="jdbcEx09Pro_연습1정답.jsp" method="post">
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