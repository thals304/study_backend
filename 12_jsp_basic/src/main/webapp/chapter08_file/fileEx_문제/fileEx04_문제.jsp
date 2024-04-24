<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습문제</title>
</head>
<body>

	<!-- 
	
		1. jQuery를 사용하여 아래의 기능을 구현한다.
			
			1-1) 추가 버튼을 누를경우 업로드할 파일의 개수가 1개씩 추가된다.
			1-2) 삭제 버튼을 누를경우 업로드할 파일의 개수가 1개씩 삭제된다. (최소 하나의 엘리먼트는 삭제하지 않는다.)
		
		
		2. 아래의 기능을 구현한다.
		   2-1) 업로드 파일 예외처리 
		   2-2) 파일명수정
		   2-3) 원본파일명 , 수정된 파일명 콘솔에 출력
		   2-4) fileReposiotry 디렉터리에서 수정된 파일확인
		   2-5) jsScript 반환
		
		
	 -->

	<p>
		<input type="button" id="addBtn" value="추가">
		<input type="button" id="removeBtn" value="삭제">
	</p>
	
	<form>
		<fieldset>
			<legend>파일 업로드</legend>
			<div id="fileList">
				<p id="file1"><input type="file" name="file1"></p>
			</div>
			<p><input type="submit" value="upload"></p>		
		</fieldset>	
	</form>

</body>
</html>