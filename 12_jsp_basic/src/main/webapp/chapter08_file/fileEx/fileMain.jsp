<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>file</title>
</head>
<body>

	<!-- 
	
		# JSP 파일
	
			- JSP 파일 전송은 cos.jar 라이브러리를 이용한다.
			
			- cos.jar 라이브러리를 WEB-INF/lib위치에 추가해준 후 
			  form태그에 enctype="multipart/form-data"라는 속성을 부여하여 사용한다.
			  
			- enctype은 post방식에서만 존재하기 때문에 GET방식에서는 파일전송이 불가능하다.
			
			- form태그에서 파일을(<input type="file"/>) 웹서버로 전송하게 되면 파일은 서버에 지정된 디렉토리에 저장된다.
			
			- 일반적으로 실제 파일은 별도의 파일서버의 디렉터리에 저장하고 
			  데이터베이스에는 실제 파일을 저장하는 것이 아닌 파일이름 및 관련정보들만 저장한다.
			
			- 파일 업 & 다운로드와 관련된 이슈는 
			   클라이언트가 업로드한 파일의 이름들이 중복되어 파일을 덮어쓸 수 있기때문에 Rename 정책을 사용해야한다. 
	
	 -->
	
	<form action="upload1" method="post" enctype="multipart/form-data">
		<fieldset>
			<legend>파일 업로드1</legend>
			<p>업로더 : <input type="text" name="uploader"></p>
			<p>파일명 : <input type="file" name="file"></p>
			<input type="submit" value="upload">
		</fieldset>
	</form>
	
	<hr/>
	
	<form action="upload2" method="post" enctype="multipart/form-data">
		<fieldset>
		<legend>파일 업로드2</legend>
		   <p>업로더 : <input type="text" name="uploader" ></p>
		   <p>파일명 : <input type="file" name="file1"></p>
		   <p>파일명 : <input type="file" name="file2"></p>
		   <p>파일명 : <input type="file" name="file3"></p>
		   <input type="submit" value="업로드">
		</fieldset>
	</form>
	
	<hr>

	<fieldset>
		<legend>파일 다운로드</legend>	
		<table border="1"> 
			<tr>
				<td><img width="70" height="70"></td>
				<td>이미지1</td>
				<td><a href="#">다운로드</a></td>
			</tr>
			<tr>
				<td><img width="70" height="70"></td>
				<td>이미지2</td>
				<td><a href="#">다운로드</a></td>
			</tr>
			<tr>
				<td><img width="70" height="70"></td>
				<td>이미지3</td>
				<td><a href="#">다운로드</a></td>
			</tr>
		</table>
	</fieldset>
	
	<hr>
	
	<form >
		<fieldset>
		<legend>파일 삭제</legend>
		   <p>삭제할 파일명 : <input type="text" ></p>
		   <input type="submit" value="삭제하기">
		</fieldset>
	</form>
	
	<hr>

	<form>
		<fieldset>
		<legend>파일 수정</legend>
		   <p>삭제할 파일명 : <input type="text" ></p>
		   <p>수정할 파일 : <input type="file" ></p>
		   <input type="submit" value="수정하기">
		</fieldset>
	</form>

</body>
</html>
