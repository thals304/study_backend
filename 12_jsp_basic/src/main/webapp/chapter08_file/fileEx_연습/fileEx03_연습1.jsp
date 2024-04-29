<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 24.04.24 time 15:38-15:48
	today 소감문 
	파일 타입이 1개일 때는 if문을 이용하고 파일 타입이 여러 개 일때는 while문을 사용하는데
	파일 여러 개 중에서 업로드 한 것만 파일명과 uuid+확장명을 올려야 한다는 점이 다르고
	script로 업로드 완료했다는 것이 while문 밖에 써야 한다는 점이 앞에서와 다른 점이라는 걸
	주의하면 될 것 같다.  
 -->
<html>
<head>
<meta charset="UTF-8">
<title>연습문제</title>
</head>
<body>

	<!-- 
	
		1. 여러개의 파일을 fileEx03_연습 Servlet으로 전송한다.
		
		2. 파일의 저장 위치는 수업때 사용하였던 fileRepository디렉터리를 사용하고 최대업로드 용량은 300MB로 지정한다.
		
		3. 업로드되지 않은 엘리먼트에 대한 예외처리를 한다.
		
		4. 
			여러개의 파일의 UUID를 구하여 UUID.확장자 형태로 파일을 수정하여 저장하고
		    1) 업로더 , 2) 여러개의 원본파일명 , 3) 여러개의 수정된 파일명(UUID.확장자)를 콘솔에서 출력한다.
		
		5. 업로드된 여러개의 이름의 수정된 파일을 fileRepository디렉터리에서 확인한다. 
		
		6. 아래의 코드로 반환한다.
		    <script>
				alert('파일을 업로드 하였습니다.');
				history.go(-1);
			</script>
	 -->

	<form action="fileEx03_연습1" method="post" enctype="multipart/form-data">
		<fieldset>
			<legend>파일 업로드</legend>
			<p>업로더 : <input type="text" name="uploader" /></p>
			<p>파일1 : <input type="file" name="file1"/></p>
			<p>파일2 : <input type="file" name="file2"/></p>
			<p>파일3 : <input type="file" name="file3"/></p>
			<p><input type="submit" value="upload"></p>		
		</fieldset>	
	</form>

</body>
</html>