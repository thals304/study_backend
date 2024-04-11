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
		
		- 전송된 상품코드를 Database에서 select하고 자바 console환경에 select된 데이터를 출력하는 로직을 작성해보시오.
		
		- (참고) SQL Like절은 예외케이스로 사용방법이 다르다.
		  COLUMN LIKE %?%사용이 안되고 
		  COLUMN LIKE CONCAT('%' , 전송된데이터 ,  '%') 형식으로 사용
		  
		  ex)예시
		  "SELECT * FROM MEMBER WHERE ADDRESS LIKE %전송된데이터%"   > X
		  "SELECT * FROM MEMBER WHERE ADDRESS LIKE CONCAT('%' , 전송된데이터 ,  '%')"
		   
		- 상품이 삭제된후 아래와 같이 수정화면으로 이동할수 있도록 화면을 작성해보시오.
		   <h3>상품이 조회되었습니다.</h3>
		   <a href="">상품조회 화면으로 이동하기</a>   
	-->

	<form action="" method="post">
		<p>상품검색 : <input type="text" name="productNm"></p>
		<p><input type="submit" value="검색"></p>
	</form>

</body>
</html>