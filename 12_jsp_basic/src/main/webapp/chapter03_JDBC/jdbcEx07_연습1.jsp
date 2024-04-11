<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 24.04.11 time 14:24-14:36
	today 소감문
	LIKE CONCAT ('%' , ? , '%')을 써보는 거는 이번이 처음으라
	조금 낮설었던 것 같다. 하지만 원리만 알면 나머지는 같기 때문에 
	해볼만 하다고 봤다.
	그리고 조회해서 값을 변수에 넣는 것에서 6번은 CD가 정확히 어떤 것인
	그 제품의 정보만 조회하는 것이므로 if (rs.next())를 써도 되지만
	7번은 어떤 단어가 포함된 모든 제품의 정보를 조회하는 것이므로 while(rs.next())를
	써야 한다는 점
 -->
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
		   
		- 상품이 조회된 후 아래와 같이 수정화면으로 이동할수 있도록 화면을 작성해보시오.
		   <h3>상품이 조회되었습니다.</h3>
		   <a href="">상품조회 화면으로 이동하기</a>   
	-->

	<form action="jdbcEx07Pro_연습1정답.jsp" method="post">
		<p>상품검색 : <input type="text" name="productNm"></p>
		<p><input type="submit" value="검색"></p>
	</form>

</body>
</html>