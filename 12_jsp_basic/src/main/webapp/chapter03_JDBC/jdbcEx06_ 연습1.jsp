<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 24.04.11 time 14:06-14:16
	today 소감문
	아직은 jdbc를 내 힘으로 풀기에는 실력이 부족해서 정답예시를 참고하면서 모르는 부분을
	참고했던 것 같다. 얼른 익숙해져서 내 힘으로만 풀어보겠다.
 -->
<html>
<head>
<meta charset="UTF-8">
<title>연습예제</title>
</head>
<body>

	<!-- 
	
		- 전송된 상품코드를 Database에서 select하고 자바 console환경에 select된 데이터를 출력하는 로직을 작성해보시오. 
	
		- 상품이 삭제된후 아래와 같이 수정화면으로 이동할수 있도록 화면을 작성해보시오.
		   <h3>상품이 조회되었습니다.</h3>
		   <a href="">상품조회 화면으로 이동하기</a>
	-->
	
	<form action="jdbcEx06Pro_연습1정답.jsp" method="post">
		<p>상품코드 : <input type="text" name="productCd"></p>
		<p><input type="submit" value="검색"></p>
	</form>

</body>
</html>