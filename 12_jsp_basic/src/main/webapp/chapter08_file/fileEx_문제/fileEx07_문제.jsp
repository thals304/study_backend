<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습문제</title>
</head>
<body>

	<!-- 
	
		1. 여러개의 파일을 fileEx07_연습 Servlet으로 전송한다.
		
		2. 파일의 저장 위치는 수업때 사용하였던 fileRepository폴더를 사용하고 최대업로드 용량은 100MB로 지정한다.
		
		3. 업로드된 파일을 fileRepository폴더에서 확인한다. 
		
		4. 업로드되지 않은 엘리먼트에 대한 예외처리를 한다.
	
		5. 
			여러개의 파일의 UUID를 구하여 UUID.확장자 형태로 파일을 수정하여 저장하고
		    업로더 , 여러개의 원본파일명 , 여러개의 수정된 파일명(UUID.확장자)를 콘솔에서 확인한다.
		
		6. AyyList<FileDTO> 객체에 업로더 , 원본파일명 , 수정된 파일명(UUID.확장자)를 저장하여 콘솔에 출력한다.
		
		7. 아래의 코드로 반환한다.
		    <script>
				alert('파일을 업로드 하였습니다.');
				history.go(-1);
			</script>
	 -->

	<form>
		<fieldset>
			<legend>파일 업로드</legend>
			<p>업로더 : <input type="text" /></p>
			<p>파일 1 : <input type="file" /></p>
			<p>파일 2 : <input type="file" /></p>
			<p>파일 3 : <input type="file"/></p>
			<p><input type="submit" value="upload"></p>		
		</fieldset>	
	</form>

</body>
</html>