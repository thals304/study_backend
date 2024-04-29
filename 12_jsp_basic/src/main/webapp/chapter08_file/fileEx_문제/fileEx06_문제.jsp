<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습문제</title>
</head>
<body>

	<!-- 
	
		1. 1개의 파일을 fileEx06_연습 Servlet으로 전송한다.
		
		2. 파일의 저장 위치는 수업때 사용하였던 fileRepository폴더를 사용하고 최대업로드 용량은 100MB로 지정한다.
		
		3. 
			파일의 UUID를 구하여 UUID.확장자 형태로 파일을 수정하여 저장하고
		    업로더 , 원본파일명 , 수정된 파일명(UUID.확장자)를 콘솔에서 확인한다.
		
		4. FileDTO 객체에 업로더 , 원본파일명 , 수정된 파일명(UUID.확장자)를 저장하여 콘솔에 출력한다.
		
		5. 업로드된 파일을 fileRepository폴더에서 확인한다. 
		
		6. 아래의 코드로 반환한다.
		    <script>
				alert('파일을 업로드 하였습니다.');
				history.go(-1);
			</script>
	 -->
	
	

	<form >
		<fieldset>
			<legend>파일 업로드</legend>
			<p>업로더 : <input type="text" /></p>
			<p>파일 : <input type="file" /></p>
			<p><input type="submit" value="upload"></p>		
		</fieldset>	
	</form>

</body>
</html>