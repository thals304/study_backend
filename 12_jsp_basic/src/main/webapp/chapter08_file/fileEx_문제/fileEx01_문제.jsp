<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습문제</title>
</head>
<body>

	<!-- 
	
		1. 1개의 파일을 fileEx01_연습 Servlet으로 전송한다.
		
		2. 파일의 저장 위치는 수업때 사용하였던 fileRepository디렉터리를 사용하고 최대업로드 용량은 100MB로 지정한다.
		
		3.업로드된 파일의 원본파일명과 업로더를 콘솔에서 출력한다.
		
		4. 업로드된 파일을 fileRepository디렉터리에서 확인한다. 
		
		5. 아래의 코드로 반환한다.
		    <script>
				alert('파일을 업로드 하였습니다.');
				history.go(-1);
			</script>
	 -->

	<form>
		<fieldset>
			<legend>파일 업로드</legend>
			<p>업로더 : <input type="text" /></p>
			<p>파일 : <input type="file" /></p>
			<p><input type="submit" value="upload"></p>		
		</fieldset>	
	</form>

</body>
</html>