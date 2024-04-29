<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습문제</title>
</head>
<body>

	<h3>fileEx08</h3>
	<fieldset>
		<p><a href="fileEx08_정답예시?fileName=test1.hwp">test1.hwp</a></p>
		<p><a href="fileEx08_정답예시?fileName=test2.txt">test2.txt</a></p>
		<p><a href="fileEx08_정답예시?fileName=test3.xlsx">test3.xlxs</a></p>
	</fieldset>
	<hr/>
	
	<h3>fileEx09</h3>
	<form action="fileEx09_정답예시" method="post">
		<fieldset>
			<legend>파일 삭제</legend>
			<p>삭제할 파일명 : <input type="text" name="deleteFileName"/></p>
			<input type="submit" value="삭제하기">
		</fieldset>
	</form>
	<hr/>
	
	<h3>fileEx10</h3>
	<form action="fileEx10_정답예시" method="post" enctype="multipart/form-data">
		<fieldset>
			<legend>파일 수정</legend>
		    <p>삭제할 파일명 : <input type="text" name="deleteFileName"></p>
		    <p>수정할 파일 : <input type="file" name="updateFile"></p>
		    <input type="submit" value="수정하기">
		</fieldset>
	</form>

</body>
</html>