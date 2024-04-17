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

- **JDBC (Java DataBase Connectivity) (mysql <> java)**
    - **데이터 베이스 연동 방법**
        - (중요)mysql-connector-j-x.x.xx.jar파일을 WEB-INF 폴더의 lib 폴더에 넣는다.
        - Class.forName("com.mysql.cj.jdbc.Driver"); 및 연결 정보를 작성한다.(url , id , password)
        - DriverManager의 getConnection(url , id , password) 메소드를 사용하여
        데이터베이스 연결 정보가 저장되어있는 Connection 객체를 생성한다.
    
    ```html
    <%@page import="java.sql.DriverManager"%>
    <%@page import="java.sql.Connection"%>
    <%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>Java DataBase Connectivity</title>
    </head>
    <body>
    
    	<%
    	    // 데이터베이스를 연결하기 위한 객체
    	    Connection conn = null; // import : java.sql.Connection
    	    
    	    try{
    			
    		    // 연결드라이버 생성 forName
    		    Class.forName("com.mysql.cj.jdbc.Driver");
    		    
    		    // database 연결 정보 > "jdbc:mysql://ip:port/databasename?option"
    		    String url = "jdbc:mysql://localhost:3306/JDBC_EX?serverTimezone=Asia/Seoul";
    		 	
    		    // database 연결 계정
    		    String user = "root";
    		    
    		    // database 연결 비밀번호
    		    String password = "0000";
    		    
    		    // 데이터 베이스에 연결
    		    conn = DriverManager.getConnection(url,user,password); // import : java.sql.DriverManager
    	    	System.out.println("연결에 성공하였습니다.");
    	    }
    		catch(Exception e){
    			e.printStackTrace();
    			System.out.println("연결에 실패하였습니다");
    		}
    		finally {
    			// 데이터 베이스 연결 종료
    			conn.close();
    		}	
    	    
    	%>
    	
    </body>
    </html>
    ```
    
    - **SELECT 예시**
    
    ```html
    <%@page import="java.util.Date"%>
    <%@page import="java.sql.ResultSet"%>
    <%@page import="java.sql.DriverManager"%>
    <%@page import="java.sql.PreparedStatement"%>
    <%@page import="java.sql.Connection"%>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>select 예시</title>
    </head>
    <body>
    	<%
    		// 데이터 베이스를 연결하기 위한 객체
    		Connection conn = null;        // import : java.sql.Connection
    	
    		// 쿼리문을 실행하기 위한 객체
    		PreparedStatement pstmt = null; // import : java.sql.PreparedStatement
    		
    		// select 쿼리의 결과를 저장할 객체
    		ResultSet rs = null;            // import : java.sql.ResultSet
    		
    		try{
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_EX?serverTimezone=Asia/Seoul", "root", "0000");
    			
    			// 선처리문 쿼리 작성
    			pstmt = conn.prepareStatement("SELECT * FROM PRODUCT");
    			
    			// executeQuery(); : select문 실행 메서드
    			rs = pstmt.executeQuery();
    			
    			/*
    			
    			# db의 컬럼명을 가져 오는 2가지 방법
    			
    				1) rs.get자료형메서드("컬럼명");
    				  
    					ex) 
    						rs.getString("PRODUCT_CD"); 
    						rs.getInt("PRODUCT_PRICE");
    						rs.getDate("ENROLL_DT");
    				
    						
    				2) rs.get자료형메서드(index);
    					
    					ex) 
    						rs.getString(1);
    						rs.getInt(2);
    						rs.getDate(3);
    				
    					- 유지보수 및 가독성 향상을 위해서 컬럼명지정 방식을 권장한다.
    					- index가 1부터 시작되는 점을 유의해야 한다.
    			
    		*/
    			
    			while(rs.next()){ // rs.next() : 다음 결과물이 있으면 true를 반환한다.
    				
    				  String productCd = rs.getString("PRODUCT_CD");  // rs.getString(1);
    			    String productNm = rs.getString("PRODUCT_NM");  // rs.getString(2);
    			    int price = rs.getInt("PRICE");                 // rs.getInt(3);
    			    Date regDt = rs.getDate("REG_DT");               // rs.getDate(4); 
    			
    				System.out.println("productCd : " + productCd);
    				System.out.println("productNm : " + productNm);
    				System.out.println("price : " + price);
    				System.out.println("date : " + regDt);
    				System.out.println();
    			}
    			
    		}
    		catch (Exception e){
    			e.printStackTrace();
    		}
    		finally {
    			// 데이터베이스 연결정보 해지
    			rs.close();
    			pstmt.close();
    			conn.close();
    			
    		}
    	%>
    </body>
    </html>
    ```
    
    - **INSERT 예시**
    
    ```html
    import="java.sql.DriverManager"%>
    <%@page import="java.sql.PreparedStatement"%>
    <%@page import="java.sql.Connection"%>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>Insert 예시</title>
    </head>
    <body>
    	<%
    		Connection conn = null;
    	
    		PreparedStatement pstmt = null;
    		
    		try{
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_EX?serverTimezone=Asia/Seoul", "root", "0000");
    			
    		/*
    		
    			# prepareStatement
    			
    			- 원래 statement객체로 사용하였으나 SQL Injection 공격에 대응하는 보안 기법으로 prepareStatement를 사용한다.
    			
    			- 우선 ?로 쿼리문의 파라메타 형식을 만들고 setter 메서드로 데이터를 대입하여 쿼리문을 완성한다.
    			   pstmt.set자료형(인덱스, 값);
    			
    			- 인덱스는 1부터 시작한다.
    			
    			Ex)
    			pstmt.setInt(index , value);     // 정수 타입 데이터 적용 메서드
    			pstmt.setString(index , value);  // 문자열 타입 데이터 적용 메서드
    			pstmt.setDate(index , value);  	 // 날짜 타입 데이터 적용 메서드
    		
    		*/
    			// ? 기능 : sql 인젝션(injection)을 디펜스함
    			String sql = "INSERT INTO PRODUCT VALUES(? , ? , ? , NOW())"; 
    			
    			// 선처리문 쿼리 작성
    			pstmt = conn.prepareStatement(sql);
    			
    			// 선처리문 쿼리 완성
    			pstmt.setString(1, "P10016");      // INSERT INTO PRODUCT VALUES("P10016" , ? , ? , NOW())
    			pstmt.setString(2, "게이밍의자1");  // INSERT INTO PRODUCT VALUES("P10016" , "게이밍의자" , ? , NOW())
    			pstmt.setInt(3, 185000);           // INSERT INTO PRODUCT VALUES("P10016" , "게이밍의자" , 185000 , NOW())
    			
    			/*
    			  - 화면에서 전송된 데이터를 저장
    			  pstmt.setString(1, request.getParameter("전송된 데이터"));
    			  pstmt.setString(2, request.getParameter("전송된 데이터"));
    			  pstmt.setInt(3, Integer.parseInt(getParameter("전송된 데이터")));
    			
    			*/
    			
    			// executeUpdate(); : insert , update, delete 실행 메서드
    			pstmt.executeUpdate();
    			
    		}
    		catch(Exception e){
    			e.printStackTrace();
    		}
    		finally {
    			pstmt.close();
    			conn.close();
    		}
    	%>
    </body>
    </html>
    ```
    
    - **UPDATE 예시**
    
    ```html
    <%@page import="java.sql.DriverManager"%>
    <%@page import="java.sql.PreparedStatement"%>
    <%@page import="java.sql.Connection"%>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>Update 예시</title>
    </head>
    <body>
    	<%
    		Connection conn = null;
    	
    		PreparedStatement pstmt = null;
    		
    		try{
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_EX?serverTimezone=Asia/Seoul", "root", "0000");
    			
    			// UPDATE PRODUCT SET WHERE 띄어쓰기 주의!
    			String sql = "UPDATE PRODUCT ";  
    			       sql += "SET PRODUCT_NM = ? ,";
    			       sql +=     "PRICE = ? ";  
    			       sql += "WHERE PRODUCT_CD = ? ";
    			
    			pstmt = conn.prepareStatement(sql);
    			
    			pstmt.setString(1, "수정된 게이밍의자");
    			pstmt.setInt(2, 160000);
    			pstmt.setString(3, "P10016");
    			
    			pstmt.executeUpdate();
    		}
    		catch(Exception e){
    			e.printStackTrace();
    		}
    		finally {
    			pstmt.close();
    			conn.close();
    		}
    	%>
    
    </body>
    </html>
    ```
    
    - **DELETE 예시**
    
    ```html
    <%@page import="java.sql.DriverManager"%>
    <%@page import="java.sql.PreparedStatement"%>
    <%@page import="java.sql.Connection"%>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>Delete 예시</title>
    </head>
    <body>
    
    	<%
    		Connection conn = null;
    	
    		PreparedStatement pstmt = null;
    		
    		try{
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_EX?serverTimezone=Asia/Seoul", "root", "0000");
    			
    			pstmt = conn.prepareStatement("DELETE FROM PRODUCT WHERE PRODUCT_CD = 'P10017'");
    			
    			pstmt.executeUpdate();
    			
    		}
    		catch(Exception e){
    			e.printStackTrace();
    		}
    		finally {
    			pstmt.close();
    			conn.close();
    		}
    	%>	
    	
    </body>
    </html>
    ```

- **서블렛 (Servelt) > constroller라고 생각하기**
    
    - 서블렛이란 자바를 사용하여 웹을 만들기 위해 필요한 기술이름이다.
    - 클라이언트의 요청을 처리하고 그 결과를 반환하는 자바 웹 프로그래밍 기술이다.
    - M(model) V(view) C(controller) 패턴에서 Controller로 이용된다.
    - HTTP 프로토콜 서비스를 지원하는 javax.servlet.http.HttpServlet 클래스를 상속받아서 구현되어진다.
    - Java Server(WAS)가 JSP 코드를 읽어 들여 서블릿 소스 코드로 변환하여 컴파일한다. (JSP 파일 > Servlet 파일 > 클래스 파일 > 컴파일)
    - 서블렛은 jsp파일과 다르게 재컴파일이 되어야 하므로 재컴파일 완료 유무를 항상 확인해야 한다.
    - 서블릿(Servlet)은 웹 브라우저에서 request가 있는 경우 애플리케이션 서버(WAS)가 서블릿 클래스의 인스턴스를 생성한다.
    매번 리퀘스트 할 때마다 인스턴스를 생성하는 것은 서버에 부하가 걸리기 때문에,
    처음 생성된 인스턴스를 request에 대한 response 뒤에도 파기하지 않고 클라이언트의 다음 request에서도 재사용하며 서버를 종료하는 등의 경우 서버에서 인스턴스를 파기한다.
    
    ```html
    import java.io.IOException;
    
    import javax.servlet.RequestDispatcher;
    import javax.servlet.ServletException;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    
    @WebServlet("/servletEx01") 					// 클라이언트가 웹 어플리케이션에 jsp페이지가 아닌 해당 url경로로 request한다.
    public class ServletEx01 extends HttpServlet {  // Http 통신이 가능한 HttpServlet클래스를 상속받아 구현한다.
    	
    	private static final long serialVersionUID = 1L; // Servlet 생성시 기본값으로 생성된다. 서블릿의 내부 식별자 역할을 한다.
        
    	// get형식으로 url요청이 들어왔을 때 수행할 메서드
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		
    		// 할일
    		
    		// 아래의 dispatcher에 명시된 jsp파일로 이동 한다.
    		RequestDispatcher dis = request.getRequestDispatcher("chapter04_servlet/servletEx01.jsp"); // webapp 디렉터리 하위 경로부터 기술한다.
    		dis.forward(request, response);
    		
    	}
    	
    	/*
    	 * Spring version
    	 * 
    	 * @GetMapping("/servletEx01")
    	 * public String servletEx01() {
    	 * 		return "chapter04_servlet/servletEx01";
    	 * }
    	 * 
    	 */
    	
    	// post형식으로 url요청이 들어왔을 때 수행할 메서드
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    		request.setCharacterEncoding("utf-8");	
    		
    		System.out.println("data1 : " + request.getParameter("data1"));
    		System.out.println("data2 : " + request.getParameter("data2"));
    		System.out.println("data3 : " + request.getParameter("data3"));
    		System.out.println();
    		
    		RequestDispatcher dis = request.getRequestDispatcher("chapter04_servlet/servletEx01Action.jsp"); // webapp 디렉터리 하위 경로부터 기술한다.
    		dis.forward(request, response);
    		
    	}
    	
    	/*
    	 * Spring version
    	 * 
    	 * @PostMapping("/servletEx01")
    	 * public String servletEx01() {
    	 * 		return "chapter04_servlet/servletEx01Action";
    	 * }
    	 * 
    	 */
    ```
    
    ```html
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>servletEx01</title>
    </head>
    <body>
    	
    	
    	<h3>데이터 전송</h3>
    	<form action="servletEx01" method="post" >		<!-- (중요)jsp파일명이 아닌 서블렛 URL을 작성한다. -->
    		<table border="1">
    			<tr>
    				<th>데이터1</th>
    				<td><input type="text" name="data1"></td>
    			</tr>
    			<tr>
    				<th>데이터2</th>
    				<td><input type="text" name="data2"></td>
    			</tr>
    			<tr>
    				<th>데이터3</th>
    				<td><input type="text" name="data3"></td>
    			</tr>
    			<tr>
    				<td colspan="2" align="center">
    					<input type="submit" value="전송">
    				</td>
    			</tr>
    		</table>
    	</form>
    	
    </body>
    </html>
    ```
    
    ```html
    <%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>Action</title>
    </head>
    <body>
    
    	<h3>데이터 전송이 완료되었습니다.</h3>
    	<!-- jsp파일 경로가 아닌 servlet경로로 이동한다. -->
    	<p><a href="serveltEx01">전송화면으로 이동하기</a></p>
    	
    </body>
    </html>
    ```
    
    - servlet에서 jsp파일로 데이터를 전송할 경우 **request.setAttribute("속성명", 값);** 메서드를 통하여서 전송한다.
    
    ```html
    import java.io.IOException;
    
    import javax.servlet.RequestDispatcher;
    import javax.servlet.ServletException;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    
    @WebServlet("/servletEx02")
    public class ServletEx02 extends HttpServlet {
    	private static final long serialVersionUID = 1L;
           
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		
    		// servlet에서 jsp파일로 데이터를 전송할 경우 request.setAttribute("속성명", 값); 메서드를 통하여서 전송한다.
    		request.setAttribute("data1", "글자데이터");
    		request.setAttribute("data2", 3);
    		request.setAttribute("data3", 3.14);
    		
    		RequestDispatcher dis = request.getRequestDispatcher("chapter04_servlet/servletEx02.jsp"); // webapp 디렉터리 경로부터 기술한다.
    		dis.forward(request, response);
    	}
    
    }
    ```
    
    ```html
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>servletEx02</title>
    </head>
    <body>
    
    	<h3>servletEx02 페이지 입니다.</h3>
    	<p>전송된 데이터1 : ${data1}</p>
    	<p>전송된 데이터2 : ${data2}</p>
    	<p>전송된 데이터3 : ${data3}</p>
    </body>
    </html>
    ```

- **EL (Expression Language)**
    - 자바코드를 사용하지 않고 간편하게 출력을 지원하기 위한 방법이다.
    - 자바의 문법과 html의 태그요소들이 섞여있기에 프론트와 백앤드의 효율적인 업무 분리 작업을 위하여 나온 표현 방법이 EL이다.
    - $ 와 {}를 사용하여 표현한다.
    - **[ 형식 ]**
        
        **${표현1.표현2}     : $ 와 {}를 사용하여 표현한다.**
        
        **[표현1 상세]**
        
        **${param.} 		      : 파라미터값 접근**
        
        **${paramValues.} 	      : 파라미터값 배열로 접근**
        
        **${sessionScope.}	      : 세션 Scope에 접근**
        
        **${pageScope.}		      : 페이지 Scope에 접근**
        
        **${requestScope.} 	      : 리퀘스트 Scope에 접근**
        
        **${applicationScope.}    : 어플리케이션 Scope에 접근**
        
        **[표현2 상세]**
        
        **form형식의 name값 , 세션 및 쿠키의 id 값 등등**
        
        [ 예시 ] 
        
        ${param.contact}   : 파라메타로 전달되는 값 중에 contact속성
        
        ${param.grade}     : 파라메타로 전달되는 값 중에 grade속성
        
        ${sessionScope.id} : session중에 id속성
        
        ${requestScope.name} : request요청중에 name속성
        
        ${name} : request요청중에 name속성(생략가능)
        
    
    ```html
    
    import java.io.IOException;
    
    import javax.servlet.RequestDispatcher;
    import javax.servlet.ServletException;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    
    @WebServlet("/elEx01")
    public class ElEx01 extends HttpServlet {
    	private static final long serialVersionUID = 1L;
       
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		
    		request.setAttribute("name", "Tim");
    		request.setAttribute("num1", 12);
    		request.setAttribute("num2", 3);
    		
    		// 배열형 데이터 타입 (3가지 경우)
    		ArrayList<String> list1 = null;						// 생성 x
    		ArrayList<String> list2 = new ArrayList<String>();	// 생성 o , 데이터 x
    		ArrayList<String> list3 = new ArrayList<String>();  // 생성 o , 데이터 o
    		list3.add("data1");
    		list3.add("data2");
    		list3.add("data3");
    		
    		request.setAttribute("list1", list1);
    		request.setAttribute("list2", list2);
    		request.setAttribute("list3", list3);
    		
    		// Spring Ver
    		// model.addAttribute("list3" , list3); // 주로 사용
    		// mv.addObject("list3" , list3);
    		
    		RequestDispatcher dis = request.getRequestDispatcher("chapter05_el_jstl/elEx01.jsp");
    		dis.forward(request, response);
    
    	}
    
    }
    ```
    
    ```html
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>EL 기초</title>
    </head>
    <body>
    
    	<h3>자바의 변수 표기</h3>
    	<p>${name }</p>
    	<p>${num1 }</p>
    	<p>${num2 }</p>
    	<hr/>
    	
    	<h3>산술 연산자</h3>
    	<p>${num1 + num2 }</p>
    	<p>${num1 - num2 }</p>
    	<p>${num1 * num2 }</p>
    	<p>${num1 / num2 } , ${num1 div num2 }</p>
    	<p>${num1 % num2 } , ${num1 mod num2 }</p>
    	<hr/>
    	
    	<h3>관계 연산자</h3>
    	<p>${num1 > num2 }  , ${num1 gt num2 }</p> <!-- Greater Than -->
    	<p>${num1 >= num2 } , ${num1 ge num2 }</p> <!-- Greater than or Equal to -->
    	<p>${num1 < num2 }  , ${num1 lt num2 }</p> <!-- Less Than -->
    	<p>${num1 <= num2 } , ${num1 le num2 }</p> <!-- Less than or Equal to -->
    	<p>${num1 == num2 } , ${num1 eq num2 }</p> <!-- EQual -->
    	<p>${num1 != num2 } , ${num1 ne num2 }</p> <!-- Not Equal -->
    	<hr/>
    	
    	<h3>논리 연산자</h3>
    	<p>${num1 > num2 && name == "Tim"} , ${num1 > num2 and name == "Tim"}</p>
    	<p>${num1 > num2 || name == "Tim"} , ${num1 > num2 or name == "Tim"}</p>
    	<p>${!(name == "Tim")} 			   , ${not(name == "Tim")}</p>
    	<hr/>
    	
    	<h3>배열형 데이터 타입</h3>
    	<p>${list1 == null}</p>
    	<p>${empty list2}</p>
    	<p>${not empty list3}</p>
    </body>
    </html>
    ```
    
    - **JSTL (JSP Standard Tag Library)**
        - JSP 개발을 단순화하기 위한 태그 library
        - jstl-x.x.jar파일을 lib폴더에 넣어주고 사용한다.
        - <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 태그라이브러리를 선언해주고 jstl core구문을 사용한다.
        - **변수**
            - **변수 생성**
                - **[형식]**
                    
                    **<c:set var="변수 이름" value="값"/>**
                    
                - 선언된 변수를 EL 형식 ${변수이름}으로 사용 가능하지만 스크립트 표현식으로 사용할 수 없다.
            - **변수 삭제**
                - **[형식]**
                    
                    **<c:remove var="변수이름" />**	
                    
            - **데이터 출력**
                - **[형식]**
                    
                    **<c:out value="" />**
                    
            
            ```html
            <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <html>
            <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSTL 기본 문법</title>
            </head>
            <body>
            
            	<h3>1,2,3) 변수 생성 , 삭제 , 출력</h3>
            	<%-- 변수 선언 방법 2가지 --%>
            	<% String testVar = "데이터"; %>
            	<c:set var="예시 변수명" value="예시 데이터"/>
            	
            	<c:set var="name1" value="팀 버너스 리"/>
            	<c:set var="name2" value="Tim Berners Lee"/>
            	
            	<%-- 출력 방법 2가지 --%>
            	<p>${name1 }</p>
            	<p><c:out value="${name2 }"/></p>
            	<hr/>
            	
            	<c:remove var="name1"/>
            	<c:remove var="name2"/>
            	<p>${name1 }</p>
            	<p><c:out value="${name2 }"/></p>
            	
            	
            </body>
            </html>
            ```
            
        - **조건문**
            - **if 문**
                - [형식]
                    
                    **<c:if test="조건식"></c:if>** 
                    
                - 자바의 if문 기능을 한다.
                - test값의 조건식이 true면 실행된다.
                - EL로 조건식을 사용한다.
            - **when ~ otherwise 문**
                - **[형식]**
                    
                    **<c:choose>** 	> 특정한 기능은 하지 않지만 문법적으로 사용해야 된다.
                    
                         **<c:when test="조건식"> </c:when>** > 조건식이 참일 경우 수행된다. ****
                    
                         **<c:otherwise> </c:otherwise>**        > 조건식이 거짓일 경우 수행된다.
                    **</c:choose>**
                    
                - 자바의 if ~ else문 기능을 한다.
            - **when , when ~ otherwise문**
                - **[형식]**
                    
                    **<c:choose>** 	 > 특정한 기능은 하지 않지만 문법적으로 사용해야 된다.
                    
                           **<c:when test="조건식"></c:when>** > 조건식이 참일 경우 수행된다.
                    
                           **<c:when test="조건식"></c:when>** 
                    
                           **<c:when test="조건식"></c:when>**
                    
                           **<c:otherwise></c:otherwise>**
                    
                    **</c:choose>**
                    
                - 자바의 if ~ else if문 기능을 한다.
                - 다중 택일로서 특정 구문이 실행되면 이하 구문은 실행되지 않는다.
            
            ```html
            <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <!DOCTYPE html>
            <html>
            <head>
            <meta charset="UTF-8">
            <title>분기문</title>
            </head>	 
            <body>
            
            	<h3>1) if 문 </h3>
            	<c:set var="grade" value="85"/> <%-- 85는 문자열 취급 --%>
            	 <%-- 숫자와 비교할 때는 숫자로 알아서 바뀌지만 두 변수의 비교에서는 문자열끼리 비교로 바뀌기 때문에 주의 --%>
            	<c:if test="${grade >= 90}">
            		<p>A 학점</p>
            	</c:if>
            	<c:if test="${grade >= 80}">
            		<p>B 학점</p>
            	</c:if>
            	<c:if test="${grade >= 70}">
            		<p>C 학점</p>
            	</c:if>
            	
            	<hr/>
            	
            	<%-- if - else문 --%>
            	<h3>2) when ~ otherwise 문  </h3>
            	<c:choose>
            		<c:when test="${grade ge 90}">
            			<p>합격</p>
            		</c:when>
            		<c:otherwise>
            			<p>불합격</p>
            		</c:otherwise>
            	</c:choose>
            
            	<hr/>
            	
            	<%-- if - else if - else 문 --%>
            	<h3>3) when ~ when ~ otherwise 문  </h3>
            	<c:choose>
            		<c:when test="${grade ge 90}">
            			<p>A 학점</p>
            		</c:when>
            		<c:when test="${grade ge 80 }">
            			<p>B 학점</p>
            		</c:when>
            		<c:when test="${grade ge 70 }">
            			<p>C 학점</p>
            		</c:when>
            		<c:otherwise>
            			<p>D학점</p>
            		</c:otherwise>
            	</c:choose>
            	
            </body>
            </html>
            ```
            
        - **반복문**
            - **forEach문 1**
                - **[형식]**
                    
                    **<c:forEach var="임시변수명" begin="시작" end="끝" step="증감식"></c:forEach>**
                    
                - java의 for문 기능을 한다.
                - var속성에 임시변수명을 작성하고 begin , end속성으로 반복 횟수를 지정한다.
                - (옵션)step을 통해서 증감식을 지정할 수 있다.
            - **forEach문2**
                - **[형식]**
                    
                    **<c:forEach var="임시변수명" items=${배열이름}" varStatus="변수명">	</c:forEach>**
                    
                - 자바의 forEach문 기능을 한다.
                - items 속성에 배열 및 어레이리스트등 반복가능한 객체를 지정한다.
                - **[ varStatus 속성값 ]**
                    - **${변수명.current}** : 현재 for문의 해당하는 값
                    - **${변수명.index}**   : 0부터의 순서
                    - **${변수명.count}**   : 1부터의 순서
                    - **${변수명.first}**   : 첫 번째인지 여부
                    - **${변수명.last}**    : 마지막인지 여부
                    - **${변수명.begin}**   : for문의 시작 번호
                    - **${변수명.end}**     : for문의 끝 번호
                    - **${변수명.step}**    : for문의 증가값
            
            ```html
            <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <!DOCTYPE html>
            <html>
            <head>
            <meta charset="UTF-8">
            <title>반복문</title>
            </head>
            <body>
            
            	 <h3>1) forEach문</h3>
            	 
            	 <c:forEach var="i" begin="1" end="10">
            			${i } 
             	 </c:forEach>
             	 
             	 <hr/>
             	 
             	 <%-- 
            	
            		- JSTL 코드는 JSP 주석으로 처리해야 한다.
            		- forEach는 내림차순이 적용되지 않는다.
            		
            		<c:forEach var="i"  begin="10" end="1">
            			${i } 
            		</c:forEach>
            		
            	--%>
             	 
             	  <c:forEach var="i" begin="1" end="10" step="${i = i + 2 }">
            			${i } 
             	  </c:forEach>
             	  
             	  <h3>2) forEach문</h3>
             	  
             	  <c:forEach var="data" items="${datas }" varStatus="i">
             	  		 <p id="id_data${i.index}" class="id_class${i.index}"> ${i.index} /${i.count} /${i.first} /${data }</p>
             	  </c:forEach>
             	  <hr/>
             	  
             	  <table border="1">
            		<tr>
            			<th>상품코드</th>
            			<th>상품이름</th>
            			<th>부서코드</th>
            			<th>부서이름</th>
            			<th>담당자코드</th>
            			<th>담당자이름</th>
            		</tr>
            		<c:choose>
            			<c:when test="${not empty productList }">
            				<c:forEach var="productDTO" items="${productList }">
            					<tr>
            						<td>${productDTO.pdCd }</td>
            						<td>${productDTO.pdNm }</td>
            						<td>${productDTO.deptCd }</td>
            						<td>${productDTO.deptNm }</td>
            						<td>${productDTO.mgrCd }</td>
            						<td>${productDTO.mgrNm }</td>
            					</tr>
            				</c:forEach>
            			</c:when>
            			<c:otherwise>
            				<tr align="center">
            					<td colspan="6">조회된 데이터가 없습니다.</td>
            				</tr>
            			</c:otherwise>
            		</c:choose>
            		
            	</table>
             	  
             	  
             	  
            </body>
            </html>
            ```

       - **fmt (format)**
          - Formatting 태그로 포맷에 관련된 태그이다.
          - <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 를 선언한 뒤에 사용한다.
          - **[ Attribute ]**
            
              **requestEncoding** : value 속성을 통해 지정한 문자 셋으로 변경
            
              **setLocale** 		: 통화 기호나 시간 대역을 설정한 지역에 맞게 표시
            
              **timeZone** 		: 특정 영역의 시간대를 설정
            
              **setTimeZone** 	: 특정 영역의 시간대 설정 정보를 변수에 저장
            
              **bundle basename** : 속성에 지정된 properties 파일을 읽어옴
            
              **setBundle** 	: properties 파일을 읽어와 다양한 영역에서 참조할 수 있게 설정
            
              **message bundle**  : 태그를 통해 저장된 key로 value를 가져온다
            
              **formatNumber**    : 숫자를 특정 양식에 맞추어 출력
            
              **parseNumber**     : 문자열을 숫자 형식으로 변환
            
              **formatDate**      : 날자 정보를 가진 객체(Date)를 특정 형식으로 변환하여 출력
            
              **parseDate**       : 문자열을 날짜 형식으로 변환하여 출력
            
        
            ```html
            <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <!DOCTYPE html>
            <html>
            <head>
            <meta charset="UTF-8">
            <title>JSTL 포맷</title>
            </head>
            <body>
            
            	<h3>데이터 형변환</h3>
            	
            	<c:set var="num1" value="7"/>
            	<c:set var="num2" value="12"/>
            	
            	<fmt:parseNumber var="num1" value="${num1 }" />
            	<fmt:parseNumber var="num2" value="${num2 }" />
            		
            	<c:if test="${num1 < num2 }">
            			<p>${num2 }(이)가 크다.</p>
            	</c:if>
            	
            	<h3>날짜 형식</h3>
            	<p>${now }</p> <!-- 형식 x-->
            	<p><fmt:formatDate value="${now }"/></p>
            	<p><fmt:formatDate value="${now }" pattern="yyyy-MM-dd"/></p>
            	<p><fmt:formatDate value="${now }" pattern="yyyy년MM월dd일 hh시mm분ss초"/></p>
            	
            	
            	<h3>숫자 형식</h3>
            	<p>${nData }</p> <!-- 형식 x-->
            	<p><fmt:formatNumber value="${nData }"/></p> <!-- 세자리마다 , 표현 -->
            	<p><fmt:formatNumber value="${nData }" pattern=".0"/></p> <!-- 소수점 1자리 표현 -->
            	<p><fmt:formatNumber value="${nData }" pattern=".00"/></p> <!-- 소수점 2자리 표현 -->
            	<p><fmt:formatNumber value="${nData }" pattern="#,##.00"/></p> <!-- 세자리마다 , 표현 / 소수점 1자리 표현 -->
            	
            </body>
            </html>
            ```
            
            ```html
            import java.io.IOException;
            import java.util.Date;
            
            import javax.servlet.RequestDispatcher;
            import javax.servlet.ServletException;
            import javax.servlet.annotation.WebServlet;
            import javax.servlet.http.HttpServlet;
            import javax.servlet.http.HttpServletRequest;
            import javax.servlet.http.HttpServletResponse;
            
            @WebServlet("/jstlEx04")
            public class JstlEx04 extends HttpServlet {
            	
            	private static final long serialVersionUID = 1L;
                   
            	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            		
            		request.setAttribute("nData", 100000000.12345);
            		request.setAttribute("now" , new Date());
            	
            		RequestDispatcher dis = request.getRequestDispatcher("chapter05_el_jstl/jstlEx04.jsp"); 
            		dis.forward(request, response);
            		
            	}
            
            }
            ```
        
      - **fn (function)**
          - function 태그로 문자열 함수에 관련된 태그이다.
          - <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 태그라이브러리를 선언한 뒤 사용한다.
        
          **fn:contains(A, B)** : 문자열 A에 문자열B가 포함되어 있는지 확인
        
          **fn:containsIgnoreCase(A, B)** : 대소문자 구분없이 A에 B가 포함되어 있는지 확인
        
          **fn:endWith(A, B)**  : 문자열 A의 끝이 B로 끝나는지 확인
        
          **fn:escapeXml(A)**  : A가 XML과 HTML에서 정의된 문자열이 포함되어 있을 경우, 엔티티 코드로 변환
        
          **fn:indexOf(A, B)**  : 문자열 A에서 B가 처음으로 위치하는 index를 반환
        
          **fn:join(A[], B)**  : 문자열 배열A를 구분자를 붙여 하나의 문자열로 변환
        
          **fn:length(A)**  : Collection 객체(List,ArrayList)의 전체 길이를 반환
        
          **fn:replace(A, B, C)**  : 문자열 A에서 B에 해당하는 문자를 찾아 C로 변환
        
          **fn:split(A, B)**  : A에서 B에서 지정한 문자열로 나눠 배열로 반환
        
          **fn:startsWith(A, B)**  : 문자열 A의 시작이 B로 시작하는지 확인
        
          **fn:substring(A, B, C)**  : A에서 index 번호 B부터 C까지 해당하는 문자열을 반환
        
          **fn:substringAfter(A, B)**   : A에서 B가 나타내는 이후의 문자열을 반환
        
          **fn:substringBefore(A, B)**  : A에서 B가 나타내는 이전의 문자열을 반환
        
          **fn:toLowerCase(A)**  : A를 모두 소문자로 변환
        
          **fn:toUpperCase(A)**  : A를 모두 대문자로 변환
        
          **fn:trim(A)**  : 문자열 A에서 앞 뒤 공백을 제거
        
            ```html
            <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
            <!DOCTYPE html>
            <html>
            <head>
            <meta charset="UTF-8">
            <title>함수</title>
            </head>
            <body>
            
            	 <p>${fileName }</p>
            	 <p>length : ${fn:length(fileName)}</p> 
            	 <p>indexOf : ${fn:indexOf(fileName , ".") } </p>
            	 <p>contains : ${fn:contains(fileName , ".png") }</p>
            	 <p>
            	 	<c:choose>
            	 		<c:when test="${fn:contains(fileName , '.png')}">
            	 			png 확장자 입니다.
            	 		</c:when>
            	 		<c:otherwise>
            	 		    png 확장자가 아닙니다.
            	 	    </c:otherwise>
            	 	</c:choose>
            	 </p>
            	 <p>substring : ${fn:substring(fileName , 10 , 13)}</p>
            	 <c:set var="extention" value="${fn:substring(fileName , 10 , 13)}"/>
            	 <p>extention : ${extention }</p>
            	 
            </body>
            </html>
            ```
            
            ```html
            import java.io.IOException;
            
            import javax.servlet.RequestDispatcher;
            import javax.servlet.ServletException;
            import javax.servlet.annotation.WebServlet;
            import javax.servlet.http.HttpServlet;
            import javax.servlet.http.HttpServletRequest;
            import javax.servlet.http.HttpServletResponse;
            
            @WebServlet("/jstlEx05")
            public class JstlEx05 extends HttpServlet {
            	private static final long serialVersionUID = 1L;
                   
            	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            		
            		request.setAttribute("fileName" , "test_file.png");
            	
            		RequestDispatcher dis = request.getRequestDispatcher("chapter05_el_jstl/jstlEx05.jsp"); 
            		dis.forward(request, response);
            		
            	}
            
            }
            ```
            
- **에러 페이지 (error page)**
    
    
    - 에러메세지를 화면에 그대로 노출시키면 웹 서버 관련 정보 및 데이터베이스의 이름 , 테이블명 , 쿼리문 등 중요한 코드들이 브라우저 화면에 노출된다.
    [보안 취약점 , 해당 취약점은 서비스 오픈 불가]
    - 보안적인 문제 외에도 에러페이지 화면을 그대로 노출하면 웹서비스를 이용하는 사용자에게 거부감을 준다.
    - 그러므로 에러 페이지를 별도로 관리해야 한다.
    - **[ 방법 ]**
        - **web.xml에 아래의 코드를 추가한다.**
        
        ```html
        <error-page>
        				<error-code>에러코드</error-code>
        				<location>jsp파일 경로</location>       
        			</error-page>
        			<error-page>
        				<error-code>에러코드</error-code>
        				<location>jsp파일 경로</location>	
        			</error-page>
        			
        	# location태그에서는 webapp(/)를 기준으로 에러페이지의 절대경로를 작성한다.
        ```
        
        - **location에 적혀있는 실제 위치에 에러가 날 경우 화면에 보여줄 페이지를 생성한다.**

### MVC2 - 게시판 만들기

- **DAO (Data Access Object)**
    - **데이터베이스와의 통신 및 데이터베이스 관련 작업을 처리하는 데 사용**
    - **JSP MVC2 데이터베이스 연동 메뉴얼**
        - 데이터베이스 연결 풀링(연결을 미리 만들어 놓고 재사용하여 데이터베이스 연결 및 해제에 따른 오버헤드를 줄임)과 관련된 기능을 사용하고 데이터베이스 애플리케이션의 성능을 향상시키기 위하여 **아래의 라이브러리를 WEB-INF/lib 경로에 추가**한다.
            
            **commons-dbcp2-2.2.0.jar
            commons-pool2-2.5.0.jar
            mysql-connector-j-8.0.32.jar**
            
        - 이클립스에서 **Servers폴더에 있는 Context.xml (경로설정) 파일에 아래의 설정을 추가**한다.
            - **[ 확인사항 ]**
                - **url , name , username , password**
            
            **<Resource
            auth="Container"
            driverClassName="com.mysql.cj.jdbc.Driver"
            type="javax.sql.DataSource"
            url="jdbc:mysql://localhost:3306/MVC2_PRACTICE?serverTimezone=Asia/Seoul&useSSL=false"
            name="jdbc/board"
            username="root"
            password="0000"
            loginTimeout="10"
            maxWait="5000"
            />**
            
        - **데이터베이스와 연동하는 메서드를 생성**하여 **데이터베이스 연결객체를 생성 및 사용**한다.
            
            **(패키지)**
            
            **import javax.naming.Context;
            import javax.naming.InitialContext;
            import javax.sql.DataSource;**
            
            **(연결코드)**
            
            **Context initctx = new InitialContext();**	
            
            **Context envctx = (Context) initctx.lookup("java:comp/env");** 
            
            **DataSource ds = (DataSource) envctx.lookup("jdbc/board");** 	
            
            **conn = ds.getConnection();**
            
- **DTO(Data Transfer Object)**
    - **데이터 전송을 위한 객체**
    - DTO는 데이터를 효과적으로 전송하고 관리하기 위해 사용되며
    주로 소프트웨어 시스템의 다른 부분 간에 데이터를 전달하거나 데이터베이스와 어플리케이션 간의 상호 작용에 사용
- **컨트롤러 (Controller) > servlet**
    - **모델(Model)과 뷰(View) 간의 흐름을 제어하고 클라이언트의 요청을 처리**
