<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 24.04.24 time 13:50-14:01
	today 소감문
	앞에서 업로더와 원본파일명은 했어서 그런지 기억이 남아있어 
	쭉 풀었는데 확장명 추출 및 rename하는 과정이 이번에는 또 새로웠던 것 같다.
 -->
<html>
<head>
<meta charset="UTF-8">
<title>연습문제</title>
</head>
<body>

	<!-- 
	
		1. 1개의 파일을 fileEx02_연습 Servlet으로 전송한다.
		
		2. 파일의 저장 위치는 수업때 사용하였던 fileRepository디렉터리를 사용하고 최대업로드 용량은 100MB로 지정한다.
		
		
		3. 
			파일의 UUID를 구하여 UUID.확장자 형태로 파일을 수정하여 저장하고
		    1) 업로더 , 2) 원본파일명 , 3) 수정된 파일명(UUID.확장자)를 콘솔에서 출력한다.
		
		4. 수정된 이름으로 업로드된 파일을 fileRepository디렉터리에서 확인한다. 
		
		5. 아래의 코드로 반환한다.
		    <script>
				alert('파일을 업로드 하였습니다.');
				history.go(-1);
			</script>
	 -->

	<form action="fileEx02_연습1" method="post" enctype="multipart/form-data">
		<fieldset>
			<legend>파일 업로드</legend>
			<p>업로더 : <input type="text" name="uploader" /></p>
			<p>파일 : <input type="file" name="file" /></p>
			<p><input type="submit" value="upload"></p>		
		</fieldset>	
	</form>

</body>
</html>