<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<!-- 24.04.09 time 13:36-13:42
	today 소감문
	이번에는 정답예시처럼 문자열 result에 결과값을 저장하고
	html에서 <h3></h3>로 표현하도록 만들어보았다.
	이번에 조금 당황했던 점은 키를 숫자인 int로 받았는데
	120.0이상일 때 라는 조건에서 if(double(height) >= 120.0)이라고 
	표현했는데 괜찮은 표현인가? 라는 고민을 했던 것 같다.
	정답예시를 보니 Double.parseDouble을 사용해도 되는 걸 새롭게 알게 된 것 같다. 
 -->
<html>
<head>
<meta charset="utf-8">
<title>연습문제</title>
</head>
<body>

	<%-- 
	
		# 놀이기구 이용제한
		
		 1. 키를 입력받는다.
		 
		 [ formEx06Pro_정답.jsp ] 
		 
		 2. 입력받은 키가 120.0 이상이면  "놀이기구를 이용할 수 있습니다." 를 출력한다.  (실수형 형변환 메서드 : Double.parseDouble("문자열");)
		 3. 키가 120.0 미만이면			  "놀이기구를 이용할 수 없습니다." 를 출력한다.
		 4. 단, 부모님과 함께 온 경우는   "놀이기구를 이용할 수 있습니다." 를 출력한다.
		 
	
	--%>
	
	<form action="formEx06Pro_연습1정답.jsp" method="post">
		<fieldset>
			<p>키를 입력하세요 :  <input type="text" name="height"><br></p>
			<p>부모님을 동반하였나요? 
				<input type="radio" name="withParents" value="yes"> 예 &emsp;
				<input type="radio" name="withParents" value="no"> 아니요 &emsp;
			</p>
			<p><input type="submit" value="전송"></p>
		</fieldset>
	</form>

</body>
</html>