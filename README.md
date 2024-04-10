# web_backend
## **🔥 목표**

- 독립 (생각하는 것을 코드로 )
- 신입 개발자 이상 ( 실력, 가능성 )

## 📆 기간

24.01 ~ 24.06

## 🏃 과정

- 자바 + 프로그래밍 훈련, 디버깅, 소스 관리 ( 형성, 버전 관리 )
- 자바 ( 객체 지향 ) + 프로그래밍 훈련
    
    cs ( 컴퓨터 사이언스: 네트워크, 리눅스, 자료구조 )
    
- 웹 관련 언어 ( html, css, js + jquery)
    
    RDB ( 관계형 데이터베이스 > MySQL )
    
- **백엔드 관련 ( JSP 발전 과정 )**
    
    **→ 추가 : 마이바티스, JPA, Model And View, rest api**
    
- 클라우드, 문서화 > 포트폴리오
    
    Amazon > AWS

## 📖 Study - web

### JSP (Java[Jakarta] Server Page)

- **Basic**
    - **만드는 방법**
        - JSP(Java[Jakarta] Server Page)는 html태그 위에 jsp태그가 추가된 형태로 사용되어진다.
        
            **지시자(Directive) 태그        	   <%@    %>**
        
            **스크립트릿(Scriptlet) 태그  	    <%     %>**
        
            **표현식(Expression) 태그      	    <%=    %>**
        
    
    ```html
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>출력함수</title>
    </head>
    <body>
    	
    	<!-- html 문법 -->
    	<h3>출력함수</h3>
    	
    	<!-- html 주석 : 개발자도구에서 볼 수 있습니다. -->
    	<%-- jsp 주석  : 개발자도구에서 볼 수 없습니다. --%>
    	
    	<%
    	   // 자바 문법
    	   String name = "팀 버너스 리";
    	   out.println("html 출력결과 : " + name); // 웹브라우저 환경에 데이터 출력
    	   System.out.println(name);            // console 환경에 데이터 출력
    	%>
    	
    	<p>출력 결과 : name</p>
    	<!-- html에서 자바 변수 표기법 -->
    	<p>출력 결과 : <%=name%></p>
    	
    </body>
    </html>
    ```
    
    - **조건문**
    - **반복문 for**
    - **반복문 while**
    
    ```html
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>제어문</title>
    </head>
    <body>
    	<h3>조건문</h3>
    
    	<%
             String name = "데니스리치";
         
             if (name.equals("데니스리치")){
        %>
    	        <p>데니스리치 입니다.</p>  
    	<%   }
             else {
        %>
    	        <p>데니스리치가 아닙니다.</p>
    	<% 
             }
         
        %>
        
        <hr/>
        
        <h3>반복문</h3>
        <%
           for (int i = 0; i < 10; i++ ){
        %>
        	 <p>for문 : <%=i %><p> 
        <%  	  
           }
        %>
       
        <hr/>
        
        <h3>while문</h3>
        <%
           int idx = 0;
           while (idx <10){
        %>
        	<p>while문 : <%=idx %></p>
        <% 
           }
        %>
    </body>
    </html>
    ```
    
    - **import**
    
    ```html
    <%@page import="java.text.SimpleDateFormat"%>
    <%@page import="java.util.Date"%>
    <%@page import="java.util.Random"%>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>import</title>
    </head>
    <body>
    		
    	<%
    	   Random ran = new Random();
    	   String[] languages = {"java" , "HTML5" ,"CSS3" , "javascript" , "MySQL" , "jQuery"};
    	   
    	   int r = ran.nextInt(6); // [0-5]
    	%>
    	<h3><%=languages[r] %>언어가 재밌다.</h3>
    	
    	<%
    	   Date temp = new Date();
    	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    	   String time = sdf.format(temp);
    	%>
    	<h3>현재시간 : <%=temp %></h3>
    	<h3>현재시간 : <%=time %></h3>
    	
    </body>
    </html>
    ```

- **데이터 전송 (html <> java)**
    - 폼 데이터 전송
        - action : 데이터를 전송할 위치를 작성한다.
        - method : 입력데이터가 서버로 보내지는 방법을 기술한다. GET과 POST 방식이 있고 기본방식은 GET방식이다.
            - GET방식 : URL 주소 뒤에 파라미터를 붙여서 데이터를 전달하는 방식.
                
                ? 기호 앞에적힌 곳은 URL주소가 되고 
                
                 ? 기호 뒤에 오는 값들이 서버로 전달되는 파라미터 값이 된다.
                
            - POST방식 : 사용자가 입력한 데이터를 URL 주소에 붙이지 않고 HTTP Request 헤더에 포함 시켜서 전송하는 방식이다.
    
    ```html
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>데이터 전송 기초1</title>
    <script>
    	function sendData(){
            // submit 함수를 사용하여 폼데이터를 서버로 전송한다.
            // 보내기 전에 추가 작업 가능
    		document.f.submit();
    	}
    </script>
    </head>
    <body>
    
    	<!-- 방법1) submit 타입을 사용하여 전송한다. (가장 일반적으로 사용 되는 방법) -->
    	<form action="formEx01Pro.jsp" method="post"> 
    		<fieldset>
    			<legend>개인정보 입력 </legend>
    			<p>이름 : <input type="text" name="name"></p>
    			<p>연락처 : <input type="text" name="contact"></p>
    			<p>나이 : <input type="text" name="age"></p>
    			<input type="submit" value="업로드">
    		</fieldset>
    	</form>
    	
    	<br><hr><br>
    	
    	<!-- 방법2) 자바스크립트의 submit() 함수를 사용하여 전송한다. (form의 name값이 설정되어 있어야 가능하다.) -->
    	<form action="formEx01Pro.jsp" method="post" name="f"> 
    		<fieldset>
    			<legend>개인정보 입력 </legend>
    			<p>이름 : <input type="text" name="name" ></p>
    			<p>연락처 : <input type="text" name="contact"></p>
    			<p>나이 : <input type="text" name="age"></p>
    			<input type="button" value="업로드" onclick="sendData();">
    		</fieldset>
    	</form>
    	
    </body>
    </html>
    ```
    
    - 폼 전송을 통해서 넘어 오는 데이터는 request내장(built in) 객체를 통해서 전달을 받는다.
    - 페이지의 encoding설정 외에 request객체의 encoding을 **setCharacterEncoding메서드**를 이용하여 추가로 지정해 주어야 한다.
    - **request.getParameter(name명);** 메소드를 통해서 form을 통해 넘어온 데이터의 name속성 값을 가져온다.
    - request.getParameter(name명); 의 **기본 반환 타입은 문자열**이다.
    - **request.getParameterValues(name명);** 메소드를 통해서 **배열 데이터**를 전송 받을 수 있다. **(checkbox는 문자열 배열로 받아와야 함)**
    
    ```html
    <title>process</title>
    </head>
    <body>
    	
    	<%
    		request.setCharacterEncoding("utf-8");	// 얘를 해줘야 글자가 깨지지 않고 이클립스 콘솔에서 볼 수 있음
    	
    		String name    = request.getParameter("name");
    		String contact = request.getParameter("contact");
    		// String age     = request.getParameter("age"); // 문자열
    		
    	    int age = Integer.parseInt(request.getParameter("age")); // 문자열이 아닌 데이터는 직접 형변환을 해야한다.
    	    
    	    System.out.println( "이름  : " + name);
    	    System.out.println( "연락처 : " + contact);
    	    System.out.println( "나이  : " + age);
    	    System.out.println();
    	
    	%>
    	<h1>전송되었습니다.</h1>
    	<p><a href="formEx01.jsp">뒤로가기</a></p>
    	
    </body>
    </html>
    ```
