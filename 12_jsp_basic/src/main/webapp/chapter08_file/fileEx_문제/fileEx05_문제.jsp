<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습문제</title>
</head>
<body>

	<!-- 
	
		1. 자바스크립트를 사용하여 파일의 확장자를 검사하여 png 또는 PNG 아닌 확장자만 fileEx05_연습 Servlet으로 파일을 전송하도록 한다.
		   그 의외의 확장자는 alert("png 확장자만 업로드 할 수 있습니다.");로 안내하며 전송을 하지 못하도록 한다.
	
		2. 아래의 기능을 구현한다.
		   2-1) 파일명수정
		   2-2) 원본파일명 , 수정된 파일명 콘솔에 출력
		   2-3) fileReposiotry 디렉터리에서 수정된 파일확인
		   2-4) jsScript 반환
		
		힌트) 
		
			1) 자바스크립트 함수 사용 
			문자열.lastIndexOf('문자') 					> 해당 문자의 위치를 반환한다. 해당 문자가 없을 경우 -1을 반환한다.  
			문자열.substring(시작위치 , 종료위치);      > 시작위치부터 문자열끝까지 문자열을 파싱한다.
			
			2) onsubmit="return 유효성체크함수();" 활용
			
	 -->

	<form>
		<fieldset>
			<legend>파일 업로드</legend>
			<p><input type="file" id="file" /></p>
			<p><input type="submit" value="upload" /></p>		
		</fieldset>	
	</form>

</body>
</html>