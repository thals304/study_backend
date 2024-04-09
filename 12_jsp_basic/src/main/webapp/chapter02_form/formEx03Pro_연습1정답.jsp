<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>process</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	    String me = request.getParameter("me");
	    String com = request.getParameter("com"); //com은 바위로 고정
	    
	    out.println("me : " + me);
	    out.println("com : " + com);
	    
	    out.println();
	    
	    if (me.equals("가위")){
	    	out.println("내가 졌다.");
	    }
	    else if (me.equals("바위")){
	    	out.println("비겼다.");
	    }
	    else if (me.equals("보")){
	    	out.println("내가 이겼다.");
	    }
	    else {
	    	out.println("잘못 입력된 값입니다.");
	    }
	%>
</body>
</html>