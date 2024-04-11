<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 24.04.11 time 14:42-14:47 17:17-17:19
	today 소감문
	앞에서 많이 틀려보고 정답예시도 참고해 봤더니 이제야 이 유형에 익숙해진 것 같다.
	내가 생각한대로 코드를 짤 수 있게 더 노력해야 된다는 생각이 이 문제를 풀면서 갑자기 떠올랐다.
 -->
<html>
<head>
<meta charset="UTF-8">
<title>연습예제</title>
</head>
<body>

	<!-- 
	
		- 전송된 상품코드 'P10001'에 관한 데이터를 Database에서 update해보는 로직을 작성해보시오. 
		
		- 상품이 수정된후 아래와 같이 수정화면으로 이동할수 있도록 화면을 작성해보시오.
		
			<h3>상품이 수정되었습니다.</h3>
			<a href="">상품수정 화면으로 이동하기</a>
		
	-->

	<form action="jdbcEx08Pro_연습1정답.jsp" method="post">
		<h3>상품 코드 'P10001' 정보 수정</h3>
		<input type="hidden" name="productCd" value="P10001">
		<p>상품이름 : <input type="text" name="productNm"></p>
		<p>금액 : <input type="text" name="price"></p>
		<p><input type="submit" value="수정"></p>
	</form>

</body>
</html>