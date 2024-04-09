<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
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
	
	<form>
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