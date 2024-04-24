<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습문제</title>
<script>

	function checkFileType(){
		
		let fileName = document.getElementById("file").value;	// 파일명을 읽어온다.
		let index = fileName.lastIndexOf('.');					// .의 인덱스를 찾는다.
		let type = fileName.substring(index+1);					// .다음 문자부터 문자열의 끝까지 문자열을 파싱한다.
		
		if (type != "png" && type != "PNG") {					// 파싱된 문자열이 png가 아닐 경우
			alert("png 확장자만 업로드 할 수 있습니다.");		// 안내메세지 출력후
			return false;										// 폼을 전송하지 않는다.
		}
		
	}
	
</script>
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

	<form action="fileEx05_정답예시" method="post" enctype="multipart/form-data" onsubmit="return checkFileType();" >
		<fieldset>
			<legend>파일 업로드</legend>
			<p><input type="file" id="file" name="file" /></p>
			<p><input type="submit" value="upload" /></p>		
		</fieldset>	
	</form>

</body>
</html>