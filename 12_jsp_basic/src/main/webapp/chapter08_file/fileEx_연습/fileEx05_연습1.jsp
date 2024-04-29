<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 24.04.24 time 16:20-16:50
	today 소감문
	일단 html form에서 jsScript를 위해 name, onsubmit을 썼고 
	서블렛 doPost로 보내기 위해 action, method, enctype을 썼는데
	이 곳에 모든 걸 다 써도 되는 지 잘 모르겠다.
	> 나는 답지와 다르게 name을 사용해서 값을 document.form이름.name명으로 표현했는데 이렇게 해도 되나?
	그리고 유효성은 문자열이 ""일때 return을 false로 줬었는데
	이번에는  png, PNG가 아닐 때도 넣어줬는데 맞는지 잘 모르겠다.
	> ""인 것은 빼도 될 것 같음 (나머지는 정답과 일치)
	그리고 서블렛에서 다시 jsScript로 반환을 어떻게 하는지 모르겠다.
	> 이 부분은 정답예시에서도 표현을 안해줌
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습문제</title>
<script>
	function formValidationCheck(){
		
		// 내 정답 
		// let fileName = document.f.uploadFile;
		// 정답예시에서는 form의 name을 이용하지 않고 getElementById로 입력한 값 받아옴
		let fileName = document.getElementById("file").value; 
		let checkPng = fileName.substring(fileName.lastIndexOf('.') + 1 );
		if ( checkPng != "png" || checkPng != "PNG"){
			alert("png 확장자만 업로드 할 수 있습니다.");
			return false;
		}

	}
</script>
</head>
<body>

	<!-- 
	
		1. 자바스크립트를 사용하여 파일의 확장자를 검사하여 png 또는 PNG 아닌 확장자는 fileEx05_연습 Servlet으로 파일을 전송 못하도록 한다.
		   그 의외의 확장자는 alert("png 확장자만 업로드 할 수 있습니다.");로 안내하며 전송을 하지 못하도록 한다.
	
		2. 아래의 기능을 구현한다.
		   2-1) 파일명 수정
		   2-2) 원본파일명 , 수정된 파일명 콘솔에 출력
		   2-3) fileReposiotry 디렉터리에서 수정된 파일확인
		   2-4) jsScript 반환
		
		힌트) 
		
			1) 자바스크립트 함수 사용 
			문자열.lastIndexOf('문자') 				> 해당 문자의 위치를 반환한다. 해당 문자가 없을 경우 -1을 반환한다.  
			문자열.substring(시작위치);      > 시작위치부터 문자열끝까지 문자열을 파싱한다.
			
			2) onsubmit="return 유효성체크함수();" 활용
			
	 -->

	<form name="f" onsubmit="return formValidationCheck();" action="fileEx5_연습1" method="post" enctype="multipart/form-data">
		<fieldset>
			<legend>파일 업로드</legend>
			<p><input type="file" id="file" name="uploadFile"/></p>
			<p><input type="submit" value="upload" /></p>		
		</fieldset>	
	</form>

</body>
</html>