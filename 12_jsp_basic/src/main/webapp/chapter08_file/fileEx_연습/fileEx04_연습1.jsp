<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 24.04.24 time 15:55-16:15
	today 소감문
	일단 jQuery에서 추가 , 삭제하는 방법을 까먹어서  이 부분을 다시 공부하고 오기엔
	다른 할게 너무 많아 일단 정답예시를 참고하기로 했다.
	처음에는 추가, 삭제를 구현해야 되니 jQuery와 html과 서블렛을 왔다 갔다 하는 걸
	어떻게 하지? 싶었는데 그게 아니라 서블렛 doPost에서는 파일 여러 개 추가 하는 방식으로
	구현해주면 되는 것이었고
	html에서 추가 버튼을 누르면 fileset 다음에 파일추가 형식이 하나 더 생기고
	       삭제 버튼을 누르면 1개는 무조건 남아놓는 조건식을 쓰고 마지막 파일 추가 형식을
	지우도록 하면 되는 것이었다. 
	이 문제는 jquery 와 서블렛을 동시에 복습할 수 있는 것이므로 다시 풀어봐야 할 문제라고 생각한다.
	근데 이 문제에서 
	let addElement = "<p id='file" + fileElementCnt + "'><input type='file' name='file" + fileElementCnt + "' /></p>"
	이 형식이 이해가 안되고 헷갈렸는데 보니까 
	<p id="file1"><input type="file" name="file1"></p>
	fileset에 있는 파일 형식을 따라한 것이었다.
 -->
<html>
<head>
<meta charset="UTF-8">
<title>연습문제</title>
<script src ="chapter08_file/jquery-3.7.1.min.js"></script>
<script>
	$().ready(function(){
	
		let fileElementCnt = 1;
		
		$("#addBtn").click(function(){
			
			fileElementCnt++;
			let addElement = "<p id='file" + fileElementCnt + "'><input type='file' name='file" + fileElementCnt + "' /></p>"
			$("#fileList").append(addElement);
			
		});
		
		
		$("#removeBtn").click(function(){
			
			if (fileElementCnt == 1) {
				return;
			}
			
			$("#file" + fileElementCnt).remove();
			fileElementCnt--;
			
		});

	});
</script>
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
	
	<form action="fileEx04_연습1" post="method" enctype="multipart/form-data">
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