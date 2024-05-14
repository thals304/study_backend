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

    - **PrintWriter**
        - response.getWriter(); 메서드를 이용하여 PrintWriter 객체를 생성한다.
        - PrintWriter 클래스는 Springframework의 @ResponseBody , ResponseEntity , @RestController와 같은 기능을 한다.
        - PrintWriter 클래스의 print()메서드로 새로운 html을 표시한다.
    
    ```html
    import java.io.IOException;
    import java.io.PrintWriter;
    
    import javax.servlet.ServletException;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    
    @WebServlet("/servletEx03")
    public class ServletEx03 extends HttpServlet {
    	
    	private static final long serialVersionUID = 1L;
           
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		
    		// 반환되는 데이터의 encoding을 utf-8로 지정하여 데이터를 한글화 한다.
    		response.setContentType("text/html; charset=UTF-8");
    
    		PrintWriter out = response.getWriter();
    		// out.print("<h1>데이터 전송 성공<h1/>");
    		// out.print("<a href='servletEx01'>servletEx01</a>");
    		String jsScript = """
    				<script>
    					alert('1번 예시로 이동합니다');
    					location.href = 'servletEx01';
    				</script>
    				""";
    		out.print(jsScript);
    		
    		
    	}
    
    }
    
    ```
    - **history  객체**
      - 사용자가 방문한 url 정보로 이동하는 객체
      - **[ 페이지 관련 기능 ]**
        
          history.go(-1); 	// 한페이지 뒤로 이동
        
          history.back();		// 한페이지 뒤로 이동
        
          history.go(1);		// 한페이지 앞으로 이동
        
          history.forward(); 	// 한페이지 앞으로 이동
        
          history.go(n);		// n페이지 앞으로 이동
        
          history.go(-n);		// n페이지 뒤로 이동

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
- **세션 (Session)**
    - HTTP 프로토콜은 클라이언트의 요청(request)과 서버의 응답(response)이 이루어지고 나면 더 이상 연결상태를 '지속'하지 않는다.
    - 클라이언트와 서버의 연결 정보를 계속 유지할 방법이 필요한데 대표적으로 '쿠키(Cookie)'와 '세션(Session)'이 있다.
    - 세션은 클라이언트와의 연결 정보를 유지하기 위한 정보를 웹 컨테이너(웹 서버)에 저장한다.
    - 쿠키는 클라이언트와의 연결정보를 유지하기 위한 정보를 클라이언트측에 저장한 뒤에 웹 서버가 클라이언트의 웹브라우저에서 쿠키를 읽어서 사용한다.
    - 클라이언트측에 저장된 연결정보(쿠키)는 연결정보가 클라이언트에서 관리되고 있다는 점에서 연결정보를 서버측에서 관리하는 것보다 보안상 문제가 생길 확률이 많다.
    - 세션은 클라이언트와의 연결정보를 서버에서 관리하므로 보안적인 측면에서 쿠키보다 안전하다.
    - 세션만을 사용하면 서버에 부하를 줄 수도 있으므로 쿠키와 세션을 각각 목적에 맞게 사용하도록 권장한다.
    - **[ 자주 사용되어지는 메서드 ]**
        
        **setAttribute(속성명, 값)** 	: 세션 속성명과 속성값으로 value를 할당한다. 
        
        **getAttribute(속성명)**  : 세션 속성명의 값을 Object 타입으로 리턴한다.(할당했던 데이터 타입으로 형변환 후 사용) 
        해당 되는 속성명이 없을 경우에는 null 값을 리턴한다.
        
        **removeAttribute(속성명)** : 세션속성을 제거한다. (해당 속성만 제거)
        
        **invalidate()** : 세션속성을 제거한다. (초기화 , 주로 로그아웃시 사용)
        
        **setMaxInactiveInterval(유지기간(초))** : 세션을 유지하기 위한 세션 유지시간을 초 단위로 설정한다. (기본값은 30분)
        
    
    **// 로그인 (Login)**
    
    ```html
    @WebServlet("/sessionLogin")
    public class SessionLogin extends HttpServlet {
    	private static final long serialVersionUID = 1L;
    	
    	// 로그인(인증)화면 요청 or 로 이동
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		RequestDispatcher dis = request.getRequestDispatcher("chapter07_session_cookie/07_01_session/sessionLogin.jsp"); 
    		dis.forward(request, response);
    
    	}
    	// 로그인 기능 처리 로직
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		// 1) 전송된 id , password를 받는다.
    		String id = request.getParameter("id");
    		String passwd = request.getParameter("passwd");
    		
    	    // 2) SQL쿼리로 인증한다. 
    		// 예시 : SELECT * FROM MEMBER WHERE MEMBER_ID = ? AND PASSWORD = ?
    		
    		String dbId = "qwer1234";
    		String dbPasswd = "qwer1234";
    		String dbRole = "user";
    		
    		
    		// 3-1) 인증된 유저이면 session객체에 관련된 정보를 저장한다.
    		if (dbId.equals(id) && dbPasswd.equals(passwd) ) {
    				
    				// 3-1-1) request.getSesstion(); 메서드로 Session 객체를 생성 한다.
    				HttpSession session = request.getSession();
    				
    				// 3-1-2) 세션객체에 인증 관련 정보를 등록한다. 
    				// session.setAttribute("세션정보" , 데이터);
    				session.setAttribute("id", id );
    				session.setAttribute("role", dbRole); // 권한
    				
    				// 3-1-3) View로 페이지 이동
    				RequestDispatcher dis = request.getRequestDispatcher("chapter07_session_cookie/07_01_session/memberView.jsp"); 
    				dis.forward(request, response);
    
    		}
    		// 3-2) 인증된 유저가 아니면 비인증 유저에 관한 절차를 진행한다.
    		else {
    			String jsScript = """
    					<script>
    						alert("패스워드를 확인하세요.");
    						history.go(-1);
    					</script>
    				""";
    			
    			response.setContentType("text/html; charset=utf-8");
    			PrintWriter out = response.getWriter();	
    			out.print(jsScript);
    			
    
    		}
    
    	}
    
    }
    
    ```
    
    ```html
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>session 로그인</title>
    <style>
    body {
        font-family: Arial, sans-serif;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        background-color: #f0f0f0;
    }
    
    .login-container {
        background: white;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0px 0px 10px 0px #00000030;
    }
    
    form {
        display: flex;
        flex-direction: column;
    }
    
    .form-control {
        margin-bottom: 10px;
    }
    
    form h2 {
        text-align: center;
    }
    
    input[type="text"], input[type="password"] {
        width: 90%;
        padding: 10px;
        margin: 5px 0;
        border: 1px solid #ddd;
        border-radius: 4px;
    }
    
    button {
        padding: 10px;
        border: none;
        border-radius: 4px;
        background-color: blue;
        color: white;
        cursor: pointer;
    }
    
    button:hover {
        background-color: darkblue;
    }
    </style>
    </head>
    <body>
    
    	 <div class="login-container">
            <form action="sessionLogin" method="post">
                <h2>Login</h2>
                <div class="form-control">
                    <label for="id">id</label>
                    <input type="text" name="id" id="id" placeholder="Enter your id">
                </div>
                <div class="form-control">
                    <label for="passwd">Password</label>
                    <input type="password" name="passwd" id="passwd" placeholder="Enter your password">
                </div>
                <button type="submit">Login</button>
            </form>
        </div>
    
    </body>
    </html>
    ```
    
    ```html
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>메인</title>
    </head>
    <body>
    	
    	
    	<h3></h3>
    	<p><a href="myPage">마이페이지로 이동</a></p>
    	<p><a href="cart">카트리스트로 이동</a></p>
    	<p><a href="logout">로그아웃</a></p>
    
    </body>
    </html>
    ```
    
    **// 로그아웃 (logout)**
    
    ```html
    @WebServlet("/logout")
    public class SessionLogout extends HttpServlet {
    	private static final long serialVersionUID = 1L;
           
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		
    		// 1) request.getSession();	메서드로 Session 객체를 생성한다.
    		HttpSession session = request.getSession();
    		
    		// 2) Session객체에서 로그인관련 데이터를 삭제한다.
    		// session.removeAttribute("id");   // 특정 속성 제거
    		// session.removeAttribute("role"); // 특정 속성 제거
    		
    		session.invalidate(); // 전체 속성 제거
    		
    		// 3) 페이지 이동
    		String jsScript = """
    			<script>
    				alert("로그아웃 되었습니다.");
    				location.href = "sessionLogin";
    			</script>""";
    				
    		response.setContentType("text/html; charset=UTF-8");
    		PrintWriter out = response.getWriter();
    		out.print(jsScript);
    
    	}
    
    }
    
    ```

    **// 마이페이지** 

    ```html
    @WebServlet("/myPage")
    public class SessionMyPage extends HttpServlet {
    	private static final long serialVersionUID = 1L;
        
    	// 마이페이지 화면으로 이동
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		
    		// 1) request.getSession();	메서드로 Session 객체를 생성한다.
    		HttpSession session = request.getSession();
    		
    		// 2) getAttribute(세션정보); 메서드를 사용하여 로그인관련 데이터를 가져온다.
    		String id = (String)session.getAttribute("id");
    		
    		// 3-1) Session객체에 정보가 있으면 (인증)
    		if (id != null) {		
    			/* 
    			 
    				 3-1-1) DAO에서 유저 관련 데이터를 조회하는 로직 
    				   SELECT * FROM MEMBER WHERE MEMBER_ID = 'user';
    			 
    			 */
    			
    			// 3-1-2) DAO에서 조회한 데이터를 request객체에 저장 
    			// request.setAttribute("변수명", db에서 가져온 정보 );
    			request.setAttribute("name","익명" );
    			request.setAttribute("hp","010-1234-5678" );
    			request.setAttribute("address","서울 경기 인천" );
    			
    			// 3-1-3) View로 페이지 이동 (데이터 포함)
    			RequestDispatcher dis = request.getRequestDispatcher("chapter07_session_cookie/07_01_session/myPage.jsp"); 
    			dis.forward(request, response);
    		}	
    		// 3-1) Session객체에 정보가 없으면 (비인증)
    		else {
    			String jsScript = """
    					<script>
    						alert("로그인을 먼저 진행해주세요");
    						history.go(-1);
    					</script>
    				""";
    			
    			response.setContentType("text/html; charset=utf-8");
    			PrintWriter out = response.getWriter();	
    			out.print(jsScript);
    
    		}
    
    	}
    
    }
    
    ```
    
    ```html
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>마이페이지</title>
    </head>
    <body>
    	<%-- view(jsp)에서 session객체에 접근하는 방법 : ${sessionScope.속성명} --%>
    	<%-- view(jsp)에서 request객체에 접근하는 방법 : ${requestScope.속성명} or ${속성명} --%>
    	<h3>${sessionScope.id }님의 마이페이지 (${sessionScope.role })</h3> <%-- sessionScope. 생략 불가능 --%>
    	<h5> 이름 : ${requestScope.name } </h5> <%-- requestScope. 생략 가능 --%> 
    	<h5> 연락처 : ${hp }</h5>
    	<h5> 주소 : ${address }</h5>
    	
    </body>
    </html>
    ```
    
    **// 카트리스트**
    
    ```html
    @WebServlet("/cart")
    public class SessionCart extends HttpServlet {
    	
    	private static final long serialVersionUID = 1L;
    	
    	// 카트리스트 화면으로 이동
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    		// 1) request.getSession();	메서드로 Session 객체를 생성한다.
    		HttpSession session = request.getSession();
    		
    		// 2)  getAttribute(세션정보); 메서드를 사용하여 로그인관련 데이터를 가져온다.
    		String id  = (String)session.getAttribute("id");
    		
    		// 3-1) Session객체에 정보가 있으면 (인증)
    		if (id != null) {	
    				/* 
    				 
    					 3-1-1) DAO에서 유저 관련 데이터를 조회하는 로직 
    					   SELECT * FROM MEMBER WHERE MEMBER_ID = 'user';
    				 
    				 */
    				
    				// 3-1-2) DAO에서 조회한 데이터를 request객체에 저장
    				request.setAttribute("cart1","저장한 상품1" );
    				request.setAttribute("cart2","저장한 상품2" );
    				request.setAttribute("cart3","저장한 상품3" );
    			
    				// 3-1-3) View로 페이지 이동 (데이터 포함)
    				RequestDispatcher dis = request.getRequestDispatcher("chapter07_session_cookie/07_01_session/cart.jsp"); 
    				dis.forward(request, response);
    		}	
    		// 3-2) Session객체에 정보가 없으면 (비인증)
    		else {
    			String jsScript = """
    					<script>
    						alert("로그인을 먼저 진행해주세요");
    						history.go(-1);
    					</script>
    				""";
    			
    			response.setContentType("text/html; charset=utf-8");
    			PrintWriter out = response.getWriter();	
    			out.print(jsScript);
    		}
    		
    		
    	}
    
    }
    ```
    
    ```html
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>카트리스트</title>
    </head>
    <body>
    
    	<%-- view(jsp)에서 session객체에 접근하는 방법 : ${sessionScope.속성명} --%>
    	<%-- view(jsp)에서 request객체에 접근하는 방법 : ${reuqestScope.속성명} or ${속성명}--%>
    	
    
    	<h3>${sessionScope.id }님의 카트리스트 (${sessionScope.role })</h3>
    	<h5>상품1 : ${cart1 }</h5>
    	<h5>상품2 : ${cart2 }</h5>
    	<h5>상품3 : ${cart3 }</h5>
    	
    </body>
    </html>
    ```
    
    **// admin**
    
    if문 주의! role에 데이터가 있으면서 role이 admin이어야만 가능 (role에 데이터가 있는데 user인 경우에 접근 불가능하도록) 
    
    ```html
    @WebServlet("/admin")
    public class SessionAdmin extends HttpServlet {
    	
    	private static final long serialVersionUID = 1L;
    	
    	// 관리자 화면으로 이동
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    		// 1) request.getSession();	메서드로 Session 객체를 생성한다.
    		HttpSession session = request.getSession();
    		
    		// 2) getAttribute(세션정보); 메서드를 사용하여 권한관련 데이터를 가져온다.
    		String role = (String)session.getAttribute("role");
    		
    		// 3-1) 권한이 관리자 혹은 운영자인지 판별한다. 권한이 있고 admin이면 (인증)
    		if (role != null && role.equals("admin")) {
    			
    			/* 
    			 
    				 3-1-1) DAO에서 관리자 관련 데이터를 조회하는 로직 
    				   SELECT * FROM MEMBER WHERE MEMBER_ID = 'admin';
    			 
    			 */
    			
    			// 3-1-2) DAO에서 조회한 데이터를 request객체에 저장
    			request.setAttribute("productList" , "상품1, 상품2, 상품3");
    			request.setAttribute("userList" , "유저1 , 유저2 , 유저3");
    			request.setAttribute("orderList" , "결제1 , 결제2, 결제3");
    			
    			// 3-1-3) View로 페이지 이동 (데이터 포함)
    			RequestDispatcher dis = request.getRequestDispatcher("chapter07_session_cookie/07_01_session/admin.jsp"); 
    			dis.forward(request, response);
    			
    		}
    		// 3-2) 로그인을 하지 않았거나 관리자 권한이 아니면 (비인증)
    		else {
    			
    			String jsScript = """
    					<script>
    						alert("접근 금지");
    						history.go(-1);
    					</script>
    				""";
    			
    			response.setContentType("text/html; charset=utf-8");
    			PrintWriter out = response.getWriter();	
    			out.print(jsScript);
    			
    		}
    		
    		
    	}
    
    }
    
    ```
    
    ```html
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>admin</title>
    </head>
    <body>
    
    	<%-- view(jsp)에서 session객체에 접근하는 방법 : ${sessionScope.속성명} --%>
    	<%-- view(jsp)에서 request객체에 접근하는 방법 : ${reuqestScope.속성명} or ${속성명}--%>
    
    	<h3>'${sessionScope.id}'님의 운영자화면 (${sessionScope.role } 권한)</h3>
    	<h5>상품관리 : ${productList }</h5>
    	<h5>유저관리 : ${userList }</h5>
    	<h5>결제관리 : ${orderList }</h5>
    
    </body>
    </html>
    ```

- **file  > 업로드, 다운로드, 보고, *수정*= (삭제하고 다시 올리기), 삭제**
    - **파일 업로드**
        - 파일 업로드를 수행하는 **MultipartRequest 객체 생성 ( 핵심 역할 )**
            - **[ 생성자의 인수 설명 ]**
                
                **첫번째 인자**는 폼에서 가져온 인자 값을 얻기 위해 **request객체를 전달**한다.
                
                **두번째 인자**는 업로드 될 **파일의 위치**를 입력한다.
                
                **세번째 인자**는 업로드한 **모든 파일의 용량의 합의 최대치**를 의미하며 최대 크기를 넘는경우 Exception이 발생한다.
                
                **네번째 인자**는 **한글** 이름이 넘어올 경우 한글에 문제되지 않도록 **인코딩을 지정**한다.
                
            - **용량**
                
                8bit          > 1Byte
                1024Byte > 1KB
                1024KB    > 1MB
                1024MB   > 1GB
                1024GB    > 1TB
                
        - **JSP 파일**
            - JSP 파일 전송은 **cos.jar 라이브러리를 이용**한다. (
            - cos.jar 라이브러리를 **WEB-INF/lib위치에 추가**해준 후
            **form태그에 enctype="multipart/form-data"라는 속성을 부여**하여 사용한다.
            - **enctype은 post방식에서만 존재**하기 때문에 GET방식에서는 파일 전송이 불가능하다.
            - form태그에서 파일을(<input type="file"/>) 웹서버로 전송하게 되면 파일은 서버에 지정된 디렉토리에 저장된다.
            - 일반적으로 실제 파일은 별도의 파일 서버의 디렉터리에 저장하고
            **데이터베이스에는 실제 파일을 저장하는 것이 아닌 파일이름 및 관련 정보들만 저장**한다.
            - 파일 업 & 다운로드와 관련된 이슈는
            클라이언트가 업로드한 파일의 이름들이 중복되어 파일을 덮어쓸 수 있기 때문에 Rename 정책을 사용해야 한다.
    
    // 파일 기본 설정
    
    ```html
    @WebServlet("/fileMain")
    public class FileMain extends HttpServlet {
    	
    	private static final long serialVersionUID = 1L;
        
    	// 파일메인 화면으로 이동
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		RequestDispatcher dis = request.getRequestDispatcher("chapter08_file/fileEx/fileMain.jsp"); 
    		dis.forward(request, response);
    	}
    	
    }
    ```
    
    ```html
    // 파일관련 설정 클래스
    public class FileConfig {
    
    	public static final String FILE_REPOSITORY_PATH = "C:\\Users\\somin\\git\\study_backend\\12_jsp_basic\\src\\main\\webapp\\chapter08_file\\fileRepository\\";
    }
    ```
    
    // 파일 1개 업로드
    
    ```html
    @WebServlet("/upload1")
    public class Upload1 extends HttpServlet {
    	
    	private static final long serialVersionUID = 1L;
           
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    		// 파일의 저장 경로는 웹서비스의 접근 경로가 아닌 물리적인 실제 경로를 적어주어야 한다.
    		// String saveDirectory = "C:\\Users\\somin\\git\\study_backend\\12_jsp_basic\\src\\main\\webapp\\chapter08_file\\fileRepository\\";
    		
    		// MultipartRequest 이 코드가 실제로 파일 업로드를 담당하는 부분이다.
    		MultipartRequest multipartRequest = new MultipartRequest(request, FileConfig.FILE_REPOSITORY_PATH , 1024 * 1024 * 100 , "utf-8" );
    		
    		/*
    		 	이슈!
    			multipart/form-data형식으로 전송 되었기 때문에 request.getParameter가 불가능하고
    			MultipartRequest 객체의 getParamter메서드를 사용해야 한다.
    			request.getParameter("uploader"); 불가능
    		 */
    		// String uploader = request.getParameter("uploader");
    		String uploader = multipartRequest.getParameter("uploader");
    		
    		Enumeration<?> files = multipartRequest.getFileNames(); // <input type="file/>인 모든 엘리먼트를 반환
    		
    		if (files.hasMoreElements()) { // 엘리먼트가 있으면
    			
    			String element = (String)files.nextElement(); // <input type="file"/>인 엘리먼트 1개 반환
    			
    			String originalFileName = multipartRequest.getOriginalFileName(element); // 서버에 업로드 '한' 파일명을 반환 
    			String filesystemName   = multipartRequest.getFilesystemName(element);   // 서버에 업로드 '된' 파일명을 반환
    			String contentType      = multipartRequest.getContentType(element);      // 파일의 타입을 반환
    			long length             = multipartRequest.getFile(element).length();    // 파일의 크기를 반환(long 타입)
    
    		
    			System.out.println("uploader : " + uploader);
    			System.out.println("originalFileName : " + originalFileName);
    			System.out.println("filesystemName : " + filesystemName);
    			System.out.println("contentType : "      + contentType);
    			System.out.println("length : "           + length);
    			System.out.println();
    
    		}
    		
    		
    		String jsScript = """
    				<script>
    					alert('파일을 업로드 하였습니다.');
    					location.href = 'fileMain';
    				</script>""";
    		
    		response.setContentType("text/html; charset=UTF-8");
    		PrintWriter out = response.getWriter();
    		out.print(jsScript);
    		
    	}
    	
    }
    
    ```
    
    ```html
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>file</title>
    </head>
    <body>
    
    	<form action="upload1" method="post" enctype="multipart/form-data">
    		<fieldset>
    			<legend>파일 업로드1</legend>
    			<p>업로더 : <input type="text" name="uploader"></p>
    			<p>파일명 : <input type="file" name="file"></p>
    			<input type="submit" value="upload">
    		</fieldset>
    	</form>
    	
    </body>
    </html>
    
    ```
    
    // 파일 여러 개 업로드
    
    ```html
    @WebServlet("/upload2")
    public class Upload2 extends HttpServlet {
    	
    	private static final long serialVersionUID = 1L;
    
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    		// saveDirectory 맨 뒤에 \\ 를 반드시 추가해줘야함!!
    		// String saveDirectory ="C:\\Users\\somin\\git\\study_backend\\12_jsp_basic\\src\\main\\webapp\\chapter08_file\\fileRepository\\";
    		String saveDirectory = FileConfig.FILE_REPOSITORY_PATH;
    		
    		MultipartRequest multipartRequest = new MultipartRequest(request, saveDirectory , 1024 * 1024 * 300 , "utf-8");
    		
    		Enumeration<?> files = multipartRequest.getFileNames();
    		
    		while (files.hasMoreElements()) { // <input type="file" />엘리먼트가 있으면
    			
    			String element = (String)files.nextElement();
    			
    			if (multipartRequest.getOriginalFileName(element) != null) { // 업로드한 파일이 있으면
    				
    				String originalFileName = multipartRequest.getOriginalFileName(element);
    				
    				System.out.println("originalFileName : " + originalFileName);
    				
    				UUID uuid = UUID.randomUUID(); // UUID.randomUUID() : 해쉬 생성 메서드
    				System.out.println("uuid : " + uuid);
    				
    				// 파일의 확장자를 구한다.
    				String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
    				System.out.println("extension : " + extension);
    				
    				// UUID.확장자 형태파일명을 생성한다.
    				String fileUUID = uuid + extension;
    				System.out.println("fileUUID : " + fileUUID);
    				
    				File originalFile = new File(saveDirectory + originalFileName); // 기존에 업로드한 파일을 자바객체로 생성한다.
    				File renameFile = new File(saveDirectory + fileUUID);			// 변환된 파일을 자바객체로 생성한다.
    				originalFile.renameTo(renameFile);								// 기존에 업로드한 파일을 변환된 파일로 변경// 기존에 업로드한 파일을 변환된 파일로 변경
    			}
    			
    		}
    		String jsScript = """
    				<script>
    					alert('파일을 업로드 하였습니다.');
    					location.href = 'fileMain';
    				</script>""";
    		
    		response.setContentType("text/html; charset=UTF-8");
    		PrintWriter out = response.getWriter();
    		out.print(jsScript);
    		
    		
    		
    		
    	}
    
    }
    
    ```
    
    ```html
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>file</title>
    </head>
    <body>
    
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
    	
    </body>
    </html>
    ```
    
    - **파일 다운로드**
    
    ```html
    @WebServlet("/download")
    public class Download extends HttpServlet {
    	private static final long serialVersionUID = 1L;
           
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    		//import java.io.File;
    		//import java.io.FileInputStream;
    		//import java.io.IOException;
    		//import java.io.OutputStream;
    				
    				
    		request.setCharacterEncoding("utf-8");
    		
    		// 다운로드 받을 파일의 위치 지정
    		// fileRepository에 사진이 있어야 함
    		// String saveDirectory = "C:\\Users\\somin\\git\\study_backend\\12_jsp_basic\\src\\main\\webapp\\chapter08_file\\fileRepository\\";
    		String saveDirectory = FileConfig.FILE_REPOSITORY_PATH;
    		String fileName = request.getParameter("fileName");
    		
    		String downloadFilePath = saveDirectory + fileName; 
    		
    		// 파일을 읽어 스트림에 담기
    		File file = new File(downloadFilePath);
    	    FileInputStream in = new FileInputStream(downloadFilePath);
    		
    	    // 한글명 파일 처리 명령어
    	    fileName = new String(fileName.getBytes("utf-8"), "8859_1");   
    	    
    	    // 파일다운로드 헤더지정
    	    response.setContentType("application/octet-stream");							
    	    response.setHeader("Content-Disposition", "attachment; filename=" + fileName ); 
    	    
    	    // 다운로드 명령어
    	    OutputStream os = response.getOutputStream();
    	    
    	    int length;
    	    byte[] b = new byte[(int)file.length()];
    
    	    while ((length = in.read(b)) > 0) {
    	    	os.write(b,0,length);
    	    }
    	    
    	    os.flush();
    	    
    	    os.close();
    	    in.close();
    		
    
    	}
    
    }
    ```
    
    ```html
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>file</title>
    </head>
    <body>
    
    	<fieldset>
    		<legend>파일 다운로드</legend>	
    		<table border="1"> 
    			<tr>
    				<td><img src="chapter08_file/fileSample/test6.PNG" width="70" height="70"></td>
    				<td>이미지1</td>
    				<td><a href="download?fileName=test6.PNG">다운로드</a></td>
    			</tr>
    			<tr>
    				<td><img src="chapter08_file/fileSample/test7.png" width="70" height="70"></td>
    				<td>이미지2</td>
    				<td><a href="download?fileName=test7.png">다운로드</a></td>
    			</tr>
    			<tr>
    				<td><img src="chapter08_file/fileSample/test8.jpg" width="70" height="70"></td>
    				<td>이미지3</td>
    				<td><a href="download?fileName=test8.jpg">다운로드</a></td>
    			</tr>
    		</table>
    	</fieldset>
    
    </body>
    </html>
    
    ```
    
    - **파일 삭제**
    
    ```html
    @WebServlet("/delete")
    public class Delete extends HttpServlet {
    	private static final long serialVersionUID = 1L;
           
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		
    		request.setCharacterEncoding("utf-8");
    		String deleteFile = request.getParameter("deleteFile");
    		
    		File file = new File(FileConfig.FILE_REPOSITORY_PATH + deleteFile);
    		
    		if (file.exists()) { // 파일이 존재하면
    			file.delete();   // delete 메서드로 파일을 삭제한다.
    			
    		String jsScript = """
    				<script>
    					alert('파일을 삭제 하였습니다.');
    					location.href = 'fileMain';
    				</script>""";
    		
    		response.setContentType("text/html; charset=UTF-8");
    		PrintWriter out = response.getWriter();
    		out.print(jsScript);
    		
    		}
    		else { // 파일이 존재하지 않으면
    			String jsScript = """
    					<script>
    						alert('파일이 존재하지 않습니다.');
    						location.href = 'fileMain';
    					</script>""";
    			
    			response.setContentType("text/html; charset=UTF-8");
    			PrintWriter out = response.getWriter();
    			out.print(jsScript);
    		}
    ```
    
    ```html
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>file</title>
    </head>
    <body>
    
    	<form action="delete" method="post">
    		<fieldset>
    		<legend>파일 삭제</legend>
    		   <p>삭제할 파일명 : <input type="text" name="deleteFile" ></p>
    		   <input type="submit" value="삭제하기">
    		</fieldset>
    	</form>
    	
    	<hr>
    
    	<form action="update" method="post" enctype="multipart/form-data">
    		<fieldset>
    		<legend>파일 수정</legend>
    		   <p>삭제할 파일명 : <input type="text" name="deleteFileName"></p>
    		   <p>수정할 파일 : <input type="file" name="updateFile"></p>
    		   <input type="submit" value="수정하기">
    		</fieldset>
    	</form>
    
    </body>
    </html>
    ```

- **action - tag**
    - **include**
        - 주로 화면의 레이아웃을 구성할때 사용한다.
        - 주로 상위파트는 header 하위파트는 footer 메뉴파트는 side,aside,menu 본문파트는 content,article,body 로 사용한다.
        - 동적 include 방식으로 포함하는 문서와 상관없이 동적으로 컴파일 된다.
        - 파일들이 완전히 별도로 동작하므로 완성된 문서의 형태를 포함해야 한다.
        - param 액션 태그를 통해 데이터를 전달할 수 있다.
        - 스프링 JSP개발환경으로는 Tiles3 및 Sitemesh로 구현하고
        스프링 Thymeleaf개발환경으로는 Thymeleaf include를 사용한다.

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

### SPRING BOOT

- **spring boot 문법**
    - **의존관계주입(di, ioc)**
        
        - **(before) AsIs Model**
            - 객체의 생성 순서 **Controller > Service > DAO**
            - 객체가 생성됨과 동시에 **상위클래스 내부에서 하위클래스의 객체를 생성**한다.
            - 결합력(의존성)이 강하다.
            - 상위클래스와 하위 클래스간의 종속성이 생긴다.
            - 유지보수시 재사용성이 줄어들며 클래스를 수정해야 하는 빈도 및 위험이 높아진다.
            - 유연성과 테스트 용이성이 부족하다.
            - 유지보수가 어려워 질 수 있다.
            
            ```java
            public class AsIsController {
            	
            	AsIsService asIsService = new AsIsService();
            
            }
            ```
            
            ```java
            public class AsIsService {
            
            	AsIsDAO asIsDAO = new AsIsDAO();
            }
            ```
            
            ```java
            public class AsIsDAO {
            
            }
            ```
            
        - **(after) Tobe Model**
            - IoC컨테이너에 의해서 ToBeDAO , ToBeService , ToBeController 객체가 생성 및 관리된다.
            - **ToBeDAO > ToBeService > ToBeController**의 순서로 객체가 생성 및 주입된다.
            - 외부에서 생성된 객체를 주입한다.
            - 결합력(의존성)이 약하다.
            - 유연성과 테스트 용이성이 좋다.
            - 유지보수에도 용이하다.
        
        ```java
        public interface ToBeDAO {
        
        }
        ```
        
        ```java
        import org.springframework.stereotype.Repository;
        
        @Repository // 해당 클래스를 repository로 지정하여 spring bean으로 등록한다.
        public class ToBeDAOImpl implements ToBeDAO{
        
        }
        ```
        
        ```java
        public interface ToBeService {
        
        }
        ```
        
        ```java
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        
        @Service // 해당 클래스를 service로 지정하여 spring bean으로 등록한다.
        public class ToBeServiceImpl implements ToBeService{
        
        	// before
        	// private ToBeDAO toBeDAO = new ToBeDAOImpl();
        	
        	// after
        	@Autowired
        	private ToBeDAO toBeDAO;
        }
        ```
        
        ```java
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        
        @Controller // 해당 클래스를 controller로 지정하여 spring bean으로 등록한다.
        public class ToBeController {
        	
        	// before
        	// ToBeService toBeService = new ToBeServiceImpl();
        	// 인터페이스 타입으로 객체 생성 : 인터페이스 변수명 = new 클래스명();
        	
        	// after
        	@Autowired
        	ToBeService toBeService;
        	
        }
        
        ```
        
        **+) 패스워드 인코더 적용 예시**
        
        1. build.gradle 파일에 아래의 의존성 추가 후에 refresh build project
        implementation 'org.springframework.boot:spring-boot-starter-security'
        (build.gradle > 우클릭 > gradle > refresh)
        2. config 객체를 생성
        3. 의존성 주입하여 기능 구현
        
        ```java
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
        import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
        import org.springframework.security.crypto.password.PasswordEncoder;
        
        @Configuration // 스프링 컨테이너는 @Configuration이 붙은 클래스를 구성 클래스로 인식하고 이 안에서 선언된 메소드들을 통해 빈을 등록한다.
        @EnableWebSecurity // @EnableWebSecurity 어노테이션은 스프링 시큐리티 설정을 활성화한다.
        public class SecurityConfig {
        
        	@Bean // @Bean 어노테이션은 메소드 레벨에서 사용되며 메소드가 반환하는 객체를 스프링 컨테이너의 빈으로 등록하도록 한다.
        	public PasswordEncoder passwordEncoder() {
        		
        	    PasswordEncoder encoder = new BCryptPasswordEncoder();
        		
        	    // 테스트 코드 및 기타 로직 구현 가능
        		
        		return encoder;   // PasswordEncoder는 스프링 시큐리티에서 비밀번호를 안전하게 인코딩하거나 검증할 때 사용하는 인터페이스이다.
        	}
        	
        	
        }
        
        ```
        
        ```java
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.security.crypto.password.PasswordEncoder;
        import org.springframework.stereotype.Service;
        
        @Service
        public class SecurityService {
        
        	// before
        	// 테스트 코드 및 기타 로직 구현 불가능
        	// private PasswordEncoder encoder = new BCryptPasswordEncoder();
        	
        	// after
        	@Autowired
        	private PasswordEncoder encoder;
        }
        
        ```
        
    - **MVC(핵심개발)** - thymeleaf, from , mybatis, AJAX + restapi
        
        **view(html) Controller(java) service(java) DAO(java) Mapper(sql)**
        
        - **@Controller**
            - 스프링 프레임워크에서 @Controller 어노테이션은 클래스 레벨에서 사용되며
            해당 클래스를 웹 요청을 처리하는 컨트롤러로 지정하는 데 사용한다.
            - @Controller가 붙은 클래스는 스프링 MVC의 웹 레이어의 일부로서
            클라이언트의 요청을 받아 처리한 후 적절한 응답을 반환하는 역할을 한다.
            - **[ 주요 기능과 사용 목적 ]**
                - @Controller 어노테이션이 지정된 클래스는 HTTP 요청을 처리하는 엔드포인트를 정의한다.
                이러한 클래스 내에서 정의된 메소드들은 특정 요청 경로(URL), HTTP 메소드(GET, POST 등)에 매핑한다.
                - 요청 매핑: @RequestMapping 어노테이션 또는 그와 유사한 어노테이션(@GetMapping, @PostMapping 등)을 사용하여 메소드를 특정 요청에 매핑한다.
                이러한 메소드들은 요청을 처리하고, 데이터 모델을 준비하며, 뷰 이름을 반환하여 클라이언트에게 응답을 보낸다.
                - 데이터 모델과 뷰: 컨트롤러 메소드는 데이터 모델을 뷰에 전달할 수 있다.
                모델 데이터는 Model 객체를 통해 뷰에 전달되며 뷰 템플릿(예: Thymeleaf, JSP 등)에서 이 데이터를 사용하여 동적인 웹 페이지를 생성할 수 있다.
                - 뷰 리졸버: 스프링 MVC는 컨트롤러가 반환한 뷰 이름을 기반으로 실제 뷰 템플릿의 위치를 찾으며 이 과정은 뷰 리졸버(view resolver)에 의해 수행된다.
        
        ```java
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        
        @Controller
        public class MVCController {
        
        	//@RequestMapping(value="/main" , method=RequestMethod.GET) // value에는 url주소를 작성 , method는 요청방식을 작성한다. (method를 생략할 경우 GET, POST를 모두 처리한다.)
        	@GetMapping("/main")    // Get요청의 'localhost/main' URL에 매핑
        	//@PostMapping("/main") // Post요청의 'localhost/main' URL에 매핑
        	public String main() {
        		
        		/*
        		
        			- Spring Boot Controller에서 메서드의 return타입은 view(html)를 명시할 String타입을 기본적으로 사용한다.
        	  		
        	  		- application.properties 파일의 아래의 설정으로 바인딩되어 view(html)화면으로 포워딩 한다.
        			
        				1) view 파일 위치지정 (src/main/resources/templates 하위 폴더)
        				spring.thymeleaf.prefix=classpath:/templates/
        			
        				2) view 파일 확장자지정
        				spring.thymeleaf.suffix=.html
        	
        				[ 예시 ]
        				return "home"		 	 > /templates/home.html 파일로 이동
        				return "goods/main"   	 > /templates/goods/main.html 파일로 이동
        				return "order/orderList" > /templates/order/orderList.html 파일로 이동
        				
        		 */
        		
        		return "main"; // /templates/main.html 파일로 이동한다.
        	
        	}
        	
        	
        	@GetMapping("/source") // localhost/source
        	public String source() {
        		
        		/*
        	  	
        	  		# return "redirect:/경로"로 사용할 경우 다른 URL로 리다이렉트(Re Direct)한다. 
        	 
        	 		예시)
        	 		return "redirect:/admin/memberList"	 > @GetMapping("/admin/memberList")으로 이동한다.
        	  		return "redirect:/order/modifyOrder" > @GetMapping("/order/modifyOrder")으로 이동한다.
        		
        		 */
        		
        		return "redirect:/target"; // @GetMapping("/target")으로 이동한다.
        		//return "target"; 		   // /templates/target.html로 이동한다.
        	
        	}
        	
        	
        	@GetMapping("/target")
        	public String target() {
        
        		/*
        		  
        		 	# html로 이동하는 방법과 URL redirect의 차이점
        			 
        			1) html로 이동하는 경우 : 단순 페이지만 이동  
        			2) redirect하는 경우    : (주로사용하는 방법) url에 포함된 모든 비즈니스 로직(Controller , Service , DAO)을 수행한 후 페이지 이동
        			
        		*/
        		
        		System.out.println("SELECT * FROM TABLE");
        		System.out.println("request.setAttribute('data1' , data1)");
        		System.out.println("request.setAttribute('data2' , data2)");
        		System.out.println("request.setAttribute('data3' , data3)");
        		System.out.println();
        		
        		return "target";
        		
        	}	
        	
        }
        
        ```
        
        - **DTO > 롬복(lombok)**
            - 롬복은 Java 라이브러리로, 반복되는 코드(예: getter, setter, toString 등) 작성을 줄여주는 도구이다.
            - 이를 사용하면 클래스의 가독성을 높이고, 유지보수를 용이하게 만들 수 있다.
            - **주요 어노테이션**
                - **@Data**  : 클래스의 모든 필드에 대한 getter, setter를 자동으로 생성한다. equals(), hashCode(), toString() 메서드도 포함한다.
                - **@Getter / @Setter** : 클래스 또는 필드 레벨에서 사용할 수 있으며, 각 필드에 대한 getter와 setter 메서드를 생성한다.
                - **생성자**
                    - **@NoArgsConstructor**: 매개변수가 없는 기본 생성자를 생성한다.
                    - **@RequiredArgsConstructor**: final 또는 @NonNull 필드에 대한 생성자를 생성한다.
                    - **@AllArgsConstructor**: 모든 필드를 매개변수로 하는 생성자를 생성한다.
                - **@Builder** : 객체의 불변성을 유지하면서 객체 생성을 보다 용이하게 하는 빌더 패턴을 구현한다.
                - **@Slf4j** 로깅을 위한 Logger 객체를 자동으로 생성한다. SLF4J(Logging Facade)를 사용한다.
                - **@Value** 불변 클래스를 만들기 위해 사용되며, 모든 필드를 final로 만들고, getter만 생성한다.
                - **@NonNull** 필드가 null이 아님을 나타내며, 해당 필드에 대한 생성자나 setter에서 자동으로 null 체크를 추가한다.
            - **롬복 사용의 장점**
                - **코드 간소화**: 반복적인 메서드 작성을 줄여준다.
                - **가독성 향상**: 필요한 로직에 더 집중할 수 있게 해준다.
                - **유지보수 용이**: 필드 변경 시 관련 메서드를 일일이 수정할 필요가 없다.
            
            ```java
            import java.util.Date;
            
            import lombok.Data;
            import lombok.Getter;
            import lombok.Setter;
            
            @Data
            public class BrandDTO {
            
            	private long brandId;
            	private String brandNm;
            	private Date enteredDt;
            	private String activeYn;
            }
            
            ```
            
            ```java
            import java.util.Date;
            
            import lombok.Data;
            import lombok.Getter;
            import lombok.Setter;
            import lombok.ToString;
            
            //@Getter
            //@Setter
            //@ToString
            @Data
            public class ProductDTO {
            
            	private long productId;
            	private String productNm;
            	private int price;
            	private int deliveryPrice;
            	private Date enrollDt; // java.util.Date;
            	private long brandId;	
            	
            }
            
            ```
            
        - **DAO > @Repository**
            - 스프링 프레임워크에서 @Repository 어노테이션은 데이터 접근 계층(DAO, Data Access Object)의 클래스에 사용된다.
            - 이 어노테이션은 클래스를 스프링 컨테이너에 빈으로 등록하며, 주로 데이터베이스와의 통신을 담당하는 컴포넌트임을 나타낸다.
                - @Repository는 스프링의 스테레오타입 어노테이션 중 하나로, 데이터베이스 연산을 수행하는 클래스에 부여함으로써 스프링이 해당 클래스를 DAO로 인식하게 한다.
            - **[ 주요 기능과 사용 목적 ]**
                - **예외 변환**: @Repository 어노테이션을 사용하면, 스프링은 데이터 접근 계층에서 발생하는 예외를 스프링이 제공하는 데이터 접근 예외로 자동 변환한다.
                이를 통해 데이터베이스 기술(예: JDBC, JPA 등)에 종속적인 예외를 스프링의 일관된 예외 계층 구조로 처리할 수 있게 됩니다.
                - **빈 자동 등록**: @Repository 어노테이션을 사용하여 클래스를 정의하면 스프링 컨테이너는 해당 클래스의 인스턴스를 빈으로 자동 등록한다.
                이를 통해 의존성 주입과 같은 스프링 컨테이너의 기능을 활용할 수 있다.
                - **코드의 명시성**: 이 어노테이션은 클래스가 데이터 접근 계층의 컴포넌트임을 명시적으로 표현한다.
                이는 애플리케이션의 아키텍처를 이해하는 데 도움이 된다.
            
            ```java
            import java.util.ArrayList;
            import java.util.Date;
            import java.util.HashMap;
            import java.util.List;
            import java.util.Map;
            
            import org.springframework.stereotype.Repository;
            
            @Repository
            public class SupposeDAO {
            
            	/*
            	 
            		view 레이어 실습을 위해 Database에서 다양한 데이터 타입을 조회하였다고 가정한 상태
            	 
            	 */
            	
            	// String 타입 예시
            	public String getString() {
            		return "글자 데이터";
            	}
            	
            	// int , long 타입 예시
            	public int getInt() {
            		return 7777777;
            	}
            
            	// double 타입 예시
            	public double getDouble() {
            		return 7777777.777;
            	}
            	
            	// boolean 타입 예시
            	public boolean getBoolean() {
            		return true;
            	}
            
            	// Date 타입 예시
            	public Date getDate() {
            		return new Date(); // import java.util.Date;
            	}
            	
            	// DTO 타입 예시
            	public ProductDTO getDTO() {
            		
            		ProductDTO productDTO = new ProductDTO();
            		productDTO.setProductId(1);
            		productDTO.setProductNm("노트북1");
            		productDTO.setPrice(1000000);
            		productDTO.setDeliveryPrice(2500);
            		productDTO.setEnrollDt(new Date());
            		productDTO.setBrandId(1);
            		
            		return productDTO;
            
            	}
            	
            	
            	// List<DTO> 타입 예시
            	public List<ProductDTO> getDTOList() {
            		
            		List<ProductDTO> productList = new ArrayList<ProductDTO>();
            		
            		for (int i = 1; i < 11; i++) {
            			ProductDTO productDTO = new ProductDTO();
            			productDTO.setProductId(i);
            			productDTO.setProductNm("노트북 " + i);
            			productDTO.setPrice(100000 * i);
            			productDTO.setDeliveryPrice(2500);
            			productDTO.setEnrollDt(new Date());
            			productDTO.setBrandId(i);
            			productList.add(productDTO);
            		}
            
            		return productList;
            
            	}
            	
            	
            	// Map 타입 예시
            	public Map<String,Object> getMap() {
            		
            		Map<String,Object> productMap = new HashMap<String, Object>();
            		
            		//ProductDTO property
            		productMap.put("productId", 1);
            		productMap.put("productNm", "노트북1");
            		productMap.put("brandId", 1);
            		productMap.put("price", 10000);
            		productMap.put("deliveryPrice", 2500);
            		productMap.put("enrollDt",  new Date());
            		
            		// ProductDTO property에 포함되지 않는 데이터
            		productMap.put("addTax", 10000 * 0.1);
            		productMap.put("totalPrice" , 10000 + 10000 * 0.1);
            		
            		//BrandDTO property
            		productMap.put("brandNm", "브랜드1");
            		productMap.put("enteredDt", new Date());
            		productMap.put("activeYn", "Y");
            		
            		return productMap;
            
            	}
            
            	
            	// List<Map> 타입 예시
            	public List<Map<String,Object>> getMapList() {
            		
            		List<Map<String,Object>> productMapList = new ArrayList<Map<String,Object>>();
            		
            		for (int i = 1; i < 11; i++) {
            			
            			Map<String,Object> productMap = new HashMap<String, Object>();
            			productMap.put("productId", i);
            			productMap.put("productNm", "노트북 " + i);
            			productMap.put("brandId", i);
            			productMap.put("price", 10000 * i);
            			productMap.put("deliveryPrice", 2500);
            			productMap.put("enrollDt",  new Date());
            			
            			// ProductDTO property에 포함되지 않는 데이터
            			productMap.put("addTax", (10000 * i) * 0.1);
            			productMap.put("totalPrice" , (10000 * i) + (10000 * i) * 0.1);
            			
            			//BrandDTO property
            			productMap.put("brandNm", "브랜드" + i);
            			productMap.put("enteredDt", new Date());
            			productMap.put("activeYn", "Y");
            			
            			productMapList.add(productMap);
            			
            		}
            		
            		return productMapList;
            		
            	}
            	
            }
            
            ```
            
        - **화면 전송 ( Controller → View )**
            - **HttpServeletRequest**
                - 컨트롤러 클래스 메서드의 파라메타로 HttpServletRequest를 추가하여 사용한다.
                - **setAttribute("속성명", 데이터) 메서드를 사용**하여 데이터를 뷰로 전송 한다.
                
                ```java
                import org.springframework.beans.factory.annotation.Autowired;
                import org.springframework.stereotype.Controller;
                import org.springframework.ui.Model;
                import org.springframework.web.bind.annotation.GetMapping;
                import org.springframework.web.servlet.ModelAndView;
                
                import com.application.mvc.data.SupposeDAO;
                
                import jakarta.servlet.http.HttpServletRequest;
                
                @Controller
                public class C2V_modelAndView {
                
                	//SupposeDAO supposeDAO = new SupposeDAO();
                	
                	@Autowired
                	private SupposeDAO supposeDAO;
                	
                	@GetMapping("/request") //localhost/request
                	public String request(HttpServletRequest request) {
                		
                		// 데이터 전송
                		request.setAttribute("string"  , supposeDAO.getString());
                		request.setAttribute("int"     , supposeDAO.getInt());
                		request.setAttribute("double"  , supposeDAO.getDouble());
                		request.setAttribute("boolean" , supposeDAO.getBoolean());
                		request.setAttribute("date"    , supposeDAO.getDate());
                		request.setAttribute("dto"     , supposeDAO.getDTO());
                		request.setAttribute("dtoList" , supposeDAO.getDTOList());
                		request.setAttribute("map"     , supposeDAO.getMap());
                		request.setAttribute("mapList" , supposeDAO.getMapList());
                		
                		return "chapter02_modelAndView/c2v"; // /templates/chapter02_modelAndView/c2v.html 파일로 이동
                	
                	}
                	
                }
                
                ```
                
            - **Model**
                - 컨트롤러 클래스 메서드의 파라메타로 Model을 추가하여 사용한다.
                - **addAttribute("속성명", 데이터) 메서드를 사용**하여 데이터를 뷰로 전송 한다.
                
                ```java
                import org.springframework.beans.factory.annotation.Autowired;
                import org.springframework.stereotype.Controller;
                import org.springframework.ui.Model;
                import org.springframework.web.bind.annotation.GetMapping;
                import org.springframework.web.servlet.ModelAndView;
                
                import com.application.mvc.data.SupposeDAO;
                
                import jakarta.servlet.http.HttpServletRequest;
                
                @Controller
                public class C2V_modelAndView {
                
                	//SupposeDAO supposeDAO = new SupposeDAO();
                	
                	@Autowired
                	private SupposeDAO supposeDAO;
                	
                	@GetMapping("/model") //localhost/model
                	public String model(Model model) {
                		
                		// 데이터 전송
                		model.addAttribute("string"  , supposeDAO.getString());
                		model.addAttribute("int"     , supposeDAO.getInt());
                		model.addAttribute("double"  , supposeDAO.getDouble());
                		model.addAttribute("boolean" , supposeDAO.getBoolean());
                		model.addAttribute("date"    , supposeDAO.getDate());
                		model.addAttribute("dto"     , supposeDAO.getDTO());
                		model.addAttribute("dtoList" , supposeDAO.getDTOList());
                		model.addAttribute("map"     , supposeDAO.getMap());
                		model.addAttribute("mapList" , supposeDAO.getMapList());
                		
                		return "chapter02_modelAndView/c2v"; // /templates/chapter02_modelAndView/c2v.html 파일로 이동
                	
                	}
                	
                }
                
                ```
                
            - **ModelAndView**
                - ModelAndView 객체를 메서드에서 생성한다.
                - **setViewName("뷰 경로"); 메서드를 사용**하여 뷰 경로를 지정한다.
                - setViewName(); 메서드 대신 **생성자의 인수로 뷰 경로를 지정**할 수 있다.
                - **addObject("속성명", 데이터); 메서드를 사용**하여 데이터를 뷰로 전송 한다.
                - ModelAndView 객체를 return한다.
                - 관례적으로 **객체명은 mv 혹은 mav**로 사용한다.
                
                ```java
                import org.springframework.beans.factory.annotation.Autowired;
                import org.springframework.stereotype.Controller;
                import org.springframework.ui.Model;
                import org.springframework.web.bind.annotation.GetMapping;
                import org.springframework.web.servlet.ModelAndView;
                
                import com.application.mvc.data.SupposeDAO;
                
                import jakarta.servlet.http.HttpServletRequest;
                
                @Controller
                public class C2V_modelAndView {
                
                	//SupposeDAO supposeDAO = new SupposeDAO();
                	
                	@Autowired
                	private SupposeDAO supposeDAO;
                	
                	@GetMapping("/modelAndView") //localhost/modelAndView
                	public ModelAndView modelAndView() {
                		
                		ModelAndView mv = new ModelAndView();
                		mv.setViewName("chapter02_modelAndView/c2v");
                		
                		// 데이터 전송
                		mv.addObject("string"  , supposeDAO.getString());
                		mv.addObject("int"     , supposeDAO.getInt());
                		mv.addObject("double"  , supposeDAO.getDouble());
                		mv.addObject("boolean" , supposeDAO.getBoolean());
                		mv.addObject("date"    , supposeDAO.getDate());
                		mv.addObject("dto"     , supposeDAO.getDTO());
                		mv.addObject("dtoList" , supposeDAO.getDTOList());
                		mv.addObject("map"     , supposeDAO.getMap());
                		mv.addObject("mapList" , supposeDAO.getMapList());
                		
                		return mv;
                		
                	}
                	
                	
                }
                
                ```
                
        - **데이터 전송 (Controller → View)**
            - **Representational State Transfer**
                - 웹 시스템에서 서버와 클라이언트간의 자원(resource)를 교환하기 위한 아키텍처 스타일
                - 자원을 표현(representation) 으로 구분하여 해당 자원의 상태(get , post , put , delete)를 주고 받는 모든 것을 의미한다.
                    - **@ResponseBody**
                        - HTTP 본문의 응답을 나타내는데 사용한다.
                        - 이는 클라이언트가 요청한 작업의 결과를 포함하며 , 데이터 형식은 JSON , XML , HTML 등으로 표현된다.
                        - 서버에서 클라이언트로 전송되는 데이터의 실제 내용을 담고 있고 , 클라이언트가 이 정보를 바탕으로 필요한
                        로직을 처리하거나 클라이언트 UI를 업데이트할 수 있다.
                        - ResponseEntity와 기능이 같으며 헤더와 상태 코드를 제외한 HTML 본문만 전송한다.
                    
                    ```java
                    @Controller
                    public class C2V_REST {
                    
                    	@GetMapping("/responseBody")
                    	@ResponseBody // 사용하면 데이터 전송 , 안 사용하면 html파일로 포워딩 
                    				  //  PrintWriter         , RequestDispatcher
                    	public String responseBody() {
                    		
                    		//return "target";
                    		String jsScript = """
                    				<script>
                    					alert('확인되었습니다.');
                    				</script>
                    				""";
                    		
                    		return jsScript;
                    		
                    		}
                    	}
                    ```
                    
                    - **@RestController**
                        - @ResponseController 어노테이션이 추가된 컨트롤러는 기본 반환 타입(String)이 뷰 경로로 구현되지 않고 @ResponseBody로 구현된다.
                        - ResponseBody와 기능이 같으며 헤더와 상태 코드를 제외한 HTML 본문만 전송한다.
                        - 메서드가 아닌 '클래스'영역에 @RestController어노테이션을 작성하여 구현한다.
                        - RESTFul API의 Controller 역할을 한다.
                    
                    ```java
                    //@Controller   // 기본값은 페이지 이동
                    @RestController // 기본값은 데이터 전송
                    class RestControllerEx {
                    	
                    	@GetMapping("/restEx") // localhost/restEx
                    	// @ResponseBody 어노테이션 없이 데이터 전송형태로 동작
                    	public String restEx() {
                    		
                    		String jsScript = """
                    				<script>
                    					alert('확인되었습니다.');
                    				</script>
                    				""";
                    		return jsScript;
                    		
                    	}
                    	
                    	@GetMapping("/read")
                    	public String read() {
                    		return "조회"; // 1) html  2) [data]
                    	}
                    	
                    	@GetMapping("/create")
                    	public String create() {
                    		return "추가"; 
                    	}
                    	
                    	@GetMapping("/update")
                    	public String update() {
                    		return "수정"; 
                    	}
                    	
                    	@GetMapping("/delete")
                    	public String delete() {
                    		return "삭제"; 
                    	}
                    	
                    }
                    ```
                    
                    - **ResponseEntity**
                        - HTTP에서 Request와 Response 동작시 전송되는 정보는 크게 body(몸체) , headers(헤더), status code(상태 코드)가 있다.
                        - @ResponseBody에 없는 헤더와 상태코드를 함께 반환한다.
                        - **[ 구성요소 ]**
                            
                            **I) body (옵션)**
                            - HTTP의 request 또는 response가 전송하는 데이터(본문)
                            
                            **II) headers (옵션)**
                            - HTTP의 request 또는 response에 대한 부가적인 정보
                            
                            (한글 헤더 참고)
                            HttpHeaders responseHeaders = new HttpHeaders();
                            responseHeaders.add("Content-Type", "text/html; charset=utf-8");
                            
                            **III) status code (필수)**
                            - 클라이언트의 요청이 성공적으로 처리되었는지 상태를 알려주는 것
                            
                        
                        ```java
                        @Controller
                        public class C2V_REST {
                        
                        	@GetMapping("/responseEntity")
                        	public ResponseEntity<Object> responseEntity() {
                        		
                        		// 1) 상태코드
                        		// return new ResponseEntity<Object>(HttpStatus.OK);
                        		
                        		// 2) 본문(html의 body) + 상태코드
                        		String jsScript = """
                        				<script>
                        					alert('확인되었습니다.');
                        				</script>
                        				""";
                        		//return new ResponseEntity<Object>(jsScript , HttpStatus.OK);
                        		
                        		// 3) 본문(html의 body) + 헤더(html의 head) + 상태코드
                        		HttpHeaders header = new HttpHeaders();	   
                        		header.add("Content-Type" , "text/html; charset=UTF-8");
                        		
                        		return new ResponseEntity<Object>(jsScript , header , HttpStatus.OK);
                        		
                        	}
                        
                        }
                        ```
                        
        - **Thymeleaf (View에서 사용하는 문법)**
            - **html태그에 thymeleaf(xmlns:th="[http://www.thymeleaf.org](http://www.thymeleaf.org/)") 속성을 적용하여 thymeleaf를 사용**한다.
                
                ```java
                import org.springframework.beans.factory.annotation.Autowired;
                import org.springframework.stereotype.Controller;
                import org.springframework.ui.Model;
                import org.springframework.web.bind.annotation.GetMapping;
                
                import com.application.mvc.data.SupposeDAO;
                
                import jakarta.servlet.http.HttpServletRequest;
                import jakarta.servlet.http.HttpSession;
                
                @Controller
                public class ExpressionController {
                	
                	// SupposeDAO supposeDAO = new SupposeDAO();
                	
                	@Autowired
                	SupposeDAO supposeDAO;
                	
                	@GetMapping("/ex01")
                	public String ex01(Model model) {
                		// 데이터 전송 예시
                		model.addAttribute("string"  , supposeDAO.getString());
                		model.addAttribute("int"     , supposeDAO.getInt());
                		model.addAttribute("double"  , supposeDAO.getDouble());
                		model.addAttribute("boolean" , supposeDAO.getBoolean());
                		model.addAttribute("date"    , supposeDAO.getDate());
                		model.addAttribute("dto"     , supposeDAO.getDTO());
                		model.addAttribute("dtoList" , supposeDAO.getDTOList());
                		model.addAttribute("map"     , supposeDAO.getMap());
                		model.addAttribute("mapList" , supposeDAO.getMapList());
                
                		return "chapter01_thymeleaf/expression/expressionEx01";
                	}
                	
                	@GetMapping("/ex02")
                	public String ex02(HttpServletRequest request) {
                		
                		// session 예시
                		HttpSession session = request.getSession();
                		
                		session.setAttribute("id", "qwer1234");
                		session.setAttribute("userRole", "admin");
                		
                		return "chapter01_thymeleaf/expression/expressionEx02";
                	
                	}
                
                }
                ```
                
            - **문법**
                - **데이터 표현식1 (Data Expressions)**
                    - **${...} 표현식**은 주로 컨트롤러에서 전달한 데이터를 HTML 페이지에 동적으로 표시할 때 사용된다.
                    - html 태그속성에 **th:text=${..} 표현식을 사용**하여 데이터를 출력한다.
                
                ```html
                <!DOCTYPE html>
                <html xmlns:th="http://www.thymeleaf.org"> <!-- html태그에 thymeleaf 속성(xmlns:th="http://www.thymeleaf.org")을 적용하여 thymeleaf를 사용한다. -->
                <head>
                <meta charset="UTF-8">
                <title>expression</title>
                </head>
                <body>
                	
                	<h3>1. 데이터 출력</h3> 
                	<p th:text="${string}"></p>  <!-- model.addAttribute("string" , supposeDAO.getString()); -->
                	<p th:text="${int}"></p>     <!-- model.addAttribute("int" , supposeDAO.getInt()); -->	 
                	<p th:text="${double}"></p>  <!-- model.addAttribute("double" , supposeDAO.getDouble()); -->
                	<p th:text="${boolean}"></p> <!-- model.addAttribute("boolean" , supposeDAO.getBoolean()); -->
                	<p th:text="${date}"></p>    <!-- model.addAttribute("date" , supposeDAO.getDate()); -->
                	<p th:text="${dto}"></p>     <!-- model.addAttribute("dto" , supposeDAO.getDTO()); -->
                	<p th:text="${dtoList}"></p> <!-- model.addAttribute("dtoList" , supposeDAO.getDTOList()); -->
                	<p th:text="${map}"></p>     <!-- model.addAttribute("map" , supposeDAO.getMap()); -->
                	<p th:text="${mapList}"></p> <!-- model.addAttribute("mapList" , supposeDAO.getMapList()); -->
                	
                </body>
                </html>
                ```
                
                - **데이터 표현식2 (Data Expressions)**
                    - **[[${속성}]] 표현식**은 주로 컨트롤러에서 전달한 데이터를 HTML 페이지에 동적으로 표시할 때 사용된다.
                    - html 태그속성이 아닌 엘리먼트에 표현식을 사용하여 데이터를 출력한다.
                    - 정적 및 동적의 유연한 화면레이어를 구성할 수 없다.
                
                ```html
                <!DOCTYPE html>
                <html xmlns:th="http://www.thymeleaf.org"> <!-- html태그에 thymeleaf 속성(xmlns:th="http://www.thymeleaf.org")을 적용하여 thymeleaf를 사용한다. -->
                <head>
                <meta charset="UTF-8">
                <title>expression</title>
                </head>
                <body>
                
                	<h3>2. 데이터 출력</h3>
                	<p>[[${string}]]</p>		<!-- model.addAttribute("string" , supposeDAO.getString()); -->
                	<p>[[${int}]]</p>			<!-- model.addAttribute("int" , supposeDAO.getInt()); -->	 
                	<p>[[${double}]]</p>		<!-- model.addAttribute("double" , supposeDAO.getDouble()); -->
                	<p>[[${boolean}]]</p>		<!-- model.addAttribute("boolean" , supposeDAO.getBoolean()); -->
                	<p>[[${date}]]</p>			<!-- model.addAttribute("date" , supposeDAO.getDate()); -->
                	<p>[[${dto}]]</p>			<!-- model.addAttribute("dto" , supposeDAO.getDTO()); -->
                	<p>[[${dtoList}]]</p>		<!-- model.addAttribute("dtoList" , supposeDAO.getDTOList()); -->
                	<p>[[${map}]]</p>			<!-- model.addAttribute("map" , supposeDAO.getMap()); -->
                	<p>[[${mapList}]]</p>		<!-- model.addAttribute("mapList" , supposeDAO.getMapList()); -->
                
                </body>
                </html>
                ```
                
                - **정적 및 동적 화면의 출력의 우선순위**
                    - 전송되는 데이터가 없을 경우 정적데이터가 화면에 출력된다.
                    **(html 확장자파일을 직접실행하여 확인할 수 있다.)**
                    - 전송되는 데이터가 있을 경우 전송된 동적데이터가 화면에 출력된다.
                    **(WAS가 실행되고 URL로 접근하여 확인할 수 있다.)**
                    - ex)
                    <p th:text="${string}">HTML에 정적으로 기록된 데이터입니다.</p> html 확장자 파일에서는 HTML에 정적으로 기록된 데이터입니다. 가 나오고 
                    WAS를 통해 URL로 접근할 때는 ${string} 값이 나옴
                    - ex) 
                    <p>[[${string}]]</p>
                    html 확장자 파일에서는 [[${string}]]가 그대로 나오고
                    WAS를 통해 URL로 접근할 때는 [[${string}]] 값이 나옴
                
                ```html
                <!DOCTYPE html>
                <html xmlns:th="http://www.thymeleaf.org"> <!-- html태그에 thymeleaf 속성(xmlns:th="http://www.thymeleaf.org")을 적용하여 thymeleaf를 사용한다. -->
                <head>
                <meta charset="UTF-8">
                <title>expression</title>
                </head>
                <body>
                
                	<h3>3. 데이터 출력 우선순위예시</h3>
                	
                	<!-- 정적 및 동적 렌더링이 가능하다. -->
                	<p th:text="${string}">HTML에 정적으로 기록된 데이터입니다.</p>
                	<p th:text="${dto}">HTML에 정적으로 기록된 데이터입니다.</p>
                	
                	<!-- 정적 및 동적 렌더링이 불가능하다. -->
                	<p>[[${string}]]</p>
                	<p>[[${dto}]]</p>
                	
                </body>
                </html>
                ```
                
                - **복수의 데이터 및 문자열 조합 출력**
                    - '+' , **'|' 기호를 사용**하여 복수의 데이터 및 문자열을 조합하여 출력할 수 있다.
                
                ```html
                <!DOCTYPE html>
                <html xmlns:th="http://www.thymeleaf.org"> <!-- html태그에 thymeleaf 속성(xmlns:th="http://www.thymeleaf.org")을 적용하여 thymeleaf를 사용한다. -->
                <head>
                <meta charset="UTF-8">
                <title>expression</title>
                </head>
                <body>
                
                	<h3>4. 복수 데이터 , 문자열 조합 출력예시</h3>
                	<!-- error code : <p th:text="${int}원">0원</p>   --> 
                	
                	<p th:text="|${int}원|">0원</p>    <!-- 문자열 조합예시 -->
                	<p th:text="|글자 데이터 입니다 : ${string}|">없음</p> <!-- 문자열 조합예시 -->
                	<p th:text="|${dto.productNm} : ${dto.price}원|">없음</p><!-- 복수의 데이터 출력 예시 (dto) --> 
                	<p th:text="|${map.productNm} / ${map.price} / ${map.addTax} / ${map.totalPrice}|">없음</p><!-- 복수의 데이터 출력 예시 (map) -->				
                
                </body>
                </html>
                ```
                
                - **Session 데이터 출력**
                    - Thymeleaf에서 세션 데이터에 접근하려면 ${session} 객체를 사용한다.
                    - **${session.속성명} 형태**로 세션에 저장된 데이터를 뷰에서 접근한다.
                
                ```java
                <!DOCTYPE html>
                <html xmlns:th="http://www.thymeleaf.org"> <!-- html태그에 thymeleaf(xmlns:th="http://www.thymeleaf.org") 속성을 적용하여 thymeleaf를 사용한다. -->
                <head>
                <meta charset="UTF-8">
                <title>expression</title>
                </head>
                <body>
                
                	<h3>Session 데이터 출력</h3>
                	<!-- before : ${sessionScope.id} -->
                	<p th:text="|id : ${session.id}|">없음</p>             <!-- session.setAttribute("id", "qwer1234"); -->
                	<p th:text="|userRole : ${session.userRole}|">없음</p> <!-- session.setAttribute("userRole", "admin"); -->
                	
                	<p>id : [[${session.id}]]            </p><!-- session.setAttribute("id", "abcde"); -->
                	<p>userRole : [[${session.userRole}]] </p><!-- session.setAttribute("userRole", "admin"); -->
                
                </body>
                </html>
                ```

                - **utext , [(${속성})]**
                    - 타임리프에서 utext(unescaped text)는 HTML을 이스케이프 처리하지 않고 원시 HTML 코드로 출력할 때 사용하는 속성이다.
                    - 기본적으로 타임리프는 모든 변수 값을 HTML 이스케이프 처리하여 XSS(Cross-Site Scripting) 공격을 방지한다.
                    즉 문자열에 포함된 HTML 태그가 브라우저에 의해 해석되지 않고 그대로 표시된다.
                    - 하지만 때때로 안전하게 관리되는 HTML 콘텐츠를 페이지에 직접 삽입해야 할 필요가 있다.
                    이 때 utext 속성 [[${속성}]] 표현식을 사용한다.
                
                ```java
                 @Controller
                 public class ExpressionController {
                 
                 @GetMapping("/ex03") // localhost/th/expression/ex03
                	public String ex03(Model model) {
                		
                		// unescape 예시
                		model.addAttribute("data1", "<h6 style='color:red;'>unescape 테스트 데이터1</h6>");
                		model.addAttribute("data2", "<div align='center'>unescape 테스트 데이터2</div>");
                		
                		return "chapter01_thymeleaf/expression/expressionEx03";
                		
                			}
                	}
                ```
                
                ```html
                <!DOCTYPE html>
                <html xmlns:th="http://www.thymeleaf.org"> <!-- html태그에 thymeleaf(xmlns:th="http://www.thymeleaf.org") 속성을 적용하여 thymeleaf를 사용한다. -->
                <head>
                <meta charset="UTF-8">
                <title>expression</title>
                </head>
                <body>
                
                	<h3>escaped text</h3>
                	<p th:text="${data1}">hi</p>
                	<p th:text="${data2}">hello</p>
                	<p>[[${data1}]]</p>
                	<p>[[${data2}]]</p>
                	<hr/>
                		
                	<h3>unescaped text</h3>
                	<p th:utext="${data1}"></p>
                	<p th:utext="${data2}"></p>
                	<p>[(${data1})]</p>
                	<p>[(${data2})]</p>
                	<hr/>
                	
                </body>
                </html>
                ```
                
                - **조건문**
                    - 타임리프(Thymeleaf)에서 th:if와 th:unless는 조건부로 HTML 요소를 렌더링하는 데 사용되는 속성이다.
                    - 이 두 속성은 조건에 따라 특정 HTML 요소가 표시되거나 숨겨지도록 지시할 수 있다.
                    - **th:if**
                        - th:if 속성은 지정된 **조건이 true일 때 태그를 렌더링**한다.
                    - **th:unless**
                        - th:unless 속성은 지정된 **조건이 false일 때 태그를 렌더링**한다.
                        - else구문과 다르게 **if없이 th:unless를 독립적으로 사용**할 수 있다.
                    - 조건식에 '>' , '>=' , '<'  , '<=' , '==' , '!=’
                        
                              'gt', 'ge' , 'lt' , 'le' , 'eq' , 'ne’
                        
                               '&&' , '||' , '!' 
                        
                               'and' , 'or' , 'not' 모두 사용 가능하다.
                        
                    
                    ```java
                    @Controller
                    @RequestMapping("/th/control")
                    public class ControlStatementController {
                    
                    	@Autowired
                    	private SupposeDAO supposeDAO;
                    	
                    	@GetMapping("/ex01") // localhost/th/control/ex01
                    	public String ex01(Model model) {
                    	
                    		// th:if , th:unless 예시
                    		String menu = "일정관리"; // 권한관리 , 일정관리 , 위험관리
                    		String role = "admin";    // admin , user
                    		int deliveryPrice = 3000; // 0 , 3000
                    		int grade = 75; 		  // 75 , 85 , 95
                    		
                    		model.addAttribute("menu" , menu);
                    		model.addAttribute("role" , role);
                    		model.addAttribute("deliveryPrice" , deliveryPrice);
                    		model.addAttribute("grade" , grade);
                    		
                    		return "chapter01_thymeleaf/controlStatment/controlEx01";
                    		
                    		}
                    	}
                    ```
                    
                    ```html
                    <!DOCTYPE html>
                    <html xmlns:th="http://www.thymeleaf.org">
                    <head>
                    <meta charset="UTF-8">
                    <title>control statement</title>
                    </head>
                    <body>
                    
                    	<h3>1. If</h3>
                    	<div th:if="${menu == '권한관리'}">
                    		<p>권한관리 화면입니다.</p>
                    	</div>
                    	<div th:if="${menu == '일정관리'}">
                    		<p>일정관리 화면입니다.</p>
                    	</div>
                    	<div th:if="${menu == '위험관리'}">
                    		<p>위험관리 화면입니다.</p>
                    	</div>
                    	
                    	<hr/>
                    	
                    	<h3>2. If Unless</h3>
                    	<div th:if="${deliveryPrice == 0}">
                    		<p>배송비 : 무료</p>
                    		<p>배송일자 : 내일</p>
                    	</div>
                    	<div th:unless="${deliveryPrice == 0}">
                    		<p th:text="|배송비 : ${deliveryPrice}원 |"></p>
                    		<p>배송일자 : 내일</p>
                    	</div>
                    	<hr/>
                    	
                    	<h3>3. If ~ else if (지원 없음)</h3>
                    	<div th:if="${grade >= 90}">
                    		<p>A학점</p>
                    	</div>
                    	<div th:if="${not(grade >= 90) && grade >= 80 }">
                    		<p>B학점</p>
                    	</div>
                    	<div th:if="${not(grade >= 90) && not(grade >= 80) && grade >= 70 }">
                    		<p>C학점</p>
                    	</div>
                    	
                    	</body>
                    </html>
                    ```
                    
                    **+) th:block**
                    
                    - th:block는 타임리프의 속성 중 하나로 HTML 요소(ex. div, span 등)를 생성하지 않고 템플릿의 일부를 그룹화하고 싶을 때 사용한다.
                    - 보통 HTML 요소를 생성하지 않으면서도 타임리프의 로직을 사용해야 할 때 유용하다.
                    - 여기서 condition은 타임리프의 표현식이며 이를 통해 조건부로 HTML 코드를 그룹화하고 조건에 따라 렌더링할 수 있다.
                    - th:block은 실제로 브라우저에 렌더링되지 않지만 조건이 충족될 때 그 안에 있는 내용은 렌더링한다.
                    
                    ```html
                    <!DOCTYPE html>
                    <html xmlns:th="http://www.thymeleaf.org">
                    <head>
                    <meta charset="UTF-8">
                    <title>control statement</title>
                    </head>
                    <body>
                    
                    	<h3>4. block</h3>
                    	<th:block th:if="${deliveryPrice == 0}">
                    		<p>배송비   : 무료</p>
                    		<p>배송일자 : 내일</p>
                    	</th:block>
                    	<th:block th:unless="${deliveryPrice == 0}">
                    		<p th:text="|배송비 : ${deliveryPrice}원|"></p>
                    		<p>배송일자 : 내일</p>
                    	</th:block>
                    	<hr/>
                    	
                    </body>
                    </html>
                    ```
                    
                    - **th:switch , th:case**
                        - 타임리프(Thymeleaf)의 th:switch는 다중 조건을 처리할 때 유용한 속성이다.
                        - th:switch는 Java의 switch 문과 유사한 구조를 가지고 있다.
                        - 이를 통해 여러 경우를 평가하고 각각 다른 동작을 수행할 수 있다.
                    
                    ```java
                    @Controller
                    @RequestMapping("/th/control")
                    public class ControlStatementController {
                    
                      @GetMapping("/ex02")
                    	public String ex02(Model model) {
                    	
                    		// th:switch , th:case 예시
                    		String menu = "일정관리"; // 권한관리 , 일정관리 , 위험관리
                    		model.addAttribute("menu" , menu);
                    		
                    		return "chapter01_thymeleaf/controlStatment/controlEx02";
                    		
                    			}
                    	}
                    ```
                    
                    ```html
                    <!DOCTYPE html>
                    <html xmlns:th="http://www.thymeleaf.org">
                    <head>
                    <meta charset="UTF-8">
                    <title>control statement</title>
                    </head>
                    <body>
                    
                    	<h3>th:switch ! th:case</h3>
                    	<th:block th:switch="${menu}">
                    		<p th:case="권한관리">권한관리 화면</p>
                    		<p th:case="일정관리">일정관리 화면</p>
                    		<p th:case="위험관리">위험관리 화면</p>
                    	</th:block>
                    	
                    </body>
                    </html>
                    ```
                    
                - **반복문**
                    - **th:each**
                        - 타임리프(Thymeleaf)에서 반복문은 th:each 속성을 사용하여 구현한다.
                        - 리스트, 배열, 맵 등 다양한 종류의 컬렉션에 대해 동작한다.
                        - 타임리프의 th:each 속성을 사용하면 서버 사이드에서 생성된 데이터 컬렉션을 효율적으로 웹 페이지에 표시할 수 있다.
                        - **#numbers 객체 (java for문과 같은 기능)**
                            - **[ 형식 ]**
                                
                                **${#numbers.sequence(from , to)}**
                                
                                **${#numbers.sequence(from , to , step)}**
                                
                    
                    ```html
                    <!DOCTYPE html>
                    <html xmlns:th="http://www.thymeleaf.org">
                    <head>
                    <meta charset="UTF-8">
                    <title>control statement</title>
                    </head>
                    <body>
                    	 
                        <h3>1. #numbers 객체</h3>
                        <th:block th:each="var : ${#numbers.sequence(1,10)}">
                        	<th:block th:text="${var}"> </th:block>
                        </th:block>
                        <br/>
                        
                        <th:block th:each="leapYear : ${#numbers.sequence(0 , 2024 , 400)}">
                        	<th:block th:text="${leapYear}"></th:block>
                        </th:block>
                        
                    </body>
                    </html>
                    ```
                    
                    - **객체 반복 th:each**
                        - **[ 형식 ]**
                            
                            **th:each="변수 : ${반복가능자료형(array,list)}”**
                            
                    
                    ```java
                    @Controller
                    @RequestMapping("/th/control")
                    public class ControlStatementController {
                    
                    	@GetMapping("/ex03")
                    	 public String ex03(Model model) {
                    		
                    		// 반복문 예시
                    		List<ProductDTO> dtoList         = supposeDAO.getDTOList();
                    		List<Map<String,Object>> mapList = supposeDAO.getMapList();
                    		
                    		model.addAttribute("dtoList" , dtoList);
                    		model.addAttribute("mapList" , mapList);
                    		
                    		return "chapter01_thymeleaf/controlStatment/controlEx03";
                    		
                    			}
                    	}
                    ```
                    
                    ```html
                    <!DOCTYPE html>
                    <html xmlns:th="http://www.thymeleaf.org">
                    <head>
                    <meta charset="UTF-8">
                    <title>control statement</title>
                    </head>
                    <body>
                    
                    	<h3>2-1) 객체반복(DTO List)</h3>
                    		<table border="1">
                    			<tr>
                    				<th>상품ID</th>
                    				<th>상품이름</th>
                    				<th>가격</th>
                    				<th>배송비</th>
                    				<th>등록일자</th>
                    				<th>브랜드ID</th>
                    			</tr>
                    			<tr th:each="dto : ${dtoList}">  <!-- model.addAttribute("dtoList" , dtoList); -->
                    				<td th:text="${dto.productId}"></td>
                    				<td th:text="${dto.productNm}"></td>
                    				<td th:text="${dto.price}"></td>
                    				<td th:text="${dto.deliveryPrice}"></td>
                    				<td th:text="${dto.enrollDt}"></td>
                    				<td th:text="${dto.brandId}"></td>
                    			</tr>
                    		</table>
                    		<hr/>
                    
                    		<h3>2-2) 객체반복(Map List)</h3>
                    		<table border="1">
                    			<tr>
                    				<th>상품ID</th>
                    				<th>상품이름</th>
                    				<th>브랜드ID</th>
                    				<th>가격</th>
                    				<th>배송비</th>
                    				<th>등록일자</th>
                    				<th>부가세</th>
                    				<th>최종금액</th>
                    				<th>브랜드명</th>
                    				<th>활성화여부</th>
                    			</tr>
                    			<tr th:each="map : ${mapList}">  <!-- model.addAttribute("mapList" , mapList); -->
                    				<td th:text="${map.productId}"></td>
                    				<td th:text="${map.productNm}"></td>
                    				<td th:text="${map.brandId}"></td>
                    				<td th:text="${map.price}"></td>
                    				<td th:text="${map.deliveryPrice}"></td>
                    				<td th:text="${map.enrollDt}"></td>
                    				<td th:text="${map.addTax}"></td>
                    				<td th:text="${map.totalPrice}"></td>
                    				<td th:text="${map.brandNm}"></td>
                    				<td th:text="${map.activeYn}"></td>
                    			</tr>
                    		</table>
                    
                    </body>
                    </html>
                    ```

                    - **status**
                        - 반복문 내에서 현재 반복의 상태에 대한 다양한 정보를 제공한다.
                        - 그러므로 반복문의 현재 상태에 대한 추가적인 제어와 정보 접근이 가능하다.
                        - thymeleaf status는 **반복대상 변수명 + "Stat" 변수명**으로 접근 할 수 있다.
                        - **[ 속성 ]**
                            
                            **current**	: 현재 엘리먼트
                            
                            **index**	: 현재 반복 인덱스  (0부터 시작)		
                            
                            **count**	: 현재 반복 인덱스  (1부터 시작)
                            
                            **size**	        : 모든 엘리먼트의 개수
                            
                            **first**	         : 현재 반복이 첫번째인지 여부 (boolean)
                            
                            **last**	         : 현재 반복이 마지막인지 여부 (boolean)
                            
                            **odd**	         : 현재 반복이 홀수인지 여부 (boolean)
                            
                            **even**	 : 현재 반복이 짝수인지 여부 (boolean)
                            
                        - **id , name 등 속성을 부여하려면 th:id , th:name** 형태로 사용한다.
                    
                    ```java
                    @Controller
                    @RequestMapping("/th/control")
                    public class ControlStatementController {
                    
                    @GetMapping("/ex04")
                    	public String ex04(Model model) {
                    		
                    		// 반복문 + Status 예시
                    		List<ProductDTO> dtoList = supposeDAO.getDTOList();
                    		
                    		model.addAttribute("dtoList", dtoList);
                    		
                    		return "chapter01_thymeleaf/controlStatment/controlEx04";
                    		
                    	}
                    		
                    }
                    ```
                    
                    ```html
                    <!DOCTYPE html>
                    <html xmlns:th="http://www.thymeleaf.org">
                    <head>
                    <meta charset="UTF-8">
                    <title>control statement</title>
                    </head>
                    <body>
                    
                    	<h1>반복문 + Status</h1>
                    	<table border="1">
                    		<tr>
                    			<th>현재 엘리먼트</th>
                    			<th>현재 인덱스</th>
                    			<th>현재 카운트</th>
                    			<th>총 엘리먼트의 개수</th>
                    			<th>첫번째 반복 여부</th>
                    			<th>마지막 반복 여부</th>
                    			<th>홀수 여부</th>
                    			<th>짝수 여부</th>
                    		</tr>
                    		<tr th:id = "|tr${dtoStat.index}|" 
                    		th:name="|tr${dtoStat.index}|" th:each=" dto : ${dtoList}">
                    			<td th:text="${dtoStat.current}"></td>
                    			<td th:text="${dtoStat.index}"></td>
                    			<td th:text="${dtoStat.count}"></td>
                    			<td th:text="${dtoStat.size}"></td>
                    			<td th:text="${dtoStat.first}"></td>
                    			<td th:text="${dtoStat.last}"></td>
                    			<td th:text="${dtoStat.odd}"></td>
                    			<td th:text="${dtoStat.even}"></td>
                    		</tr>
                    	</table>
                    
                    </body>
                    </html>
                    ```
                    
                    - **Format (포맷)**
                        
                        ```java
                        @Controller
                        public class FormatController {
                        
                        	@GetMapping("/th/format/ex") // localhost/th/format/ex
                        	public String format(Model model) {
                        		
                        		// 날짜 (Date)
                        		model.addAttribute("date1" , new Date());
                        		model.addAttribute("date2" , System.currentTimeMillis());
                        		
                        		// 정수 (Integer)
                        		model.addAttribute("intVar" , 1000000000); // 1 , 10 , 100 , 1000000000
                        		
                        		// 소수점 (Decimal)
                        		model.addAttribute("doubleVar" , 3.141592); // 3.141592 , 30000.141592
                        		
                        		return "chapter01_thymeleaf/format/formatEx";
                        		
                        	}
                        ```
                        
                        - **DATE 포맷**
                            - 날짜형식을 구현하기 위해 **#dates** 유틸리티 객체의 메서드를 사용한다.
                            - format 메서드를 사용하여 날짜 객체를 원하는 형식의 문자열로 변환한다.
                            - **[형식]**
                                
                                **${#dates.format(데이터, 표현식)}**
                                
                            - **표현식**
                                
                                **연도 : yyyy**
                                
                                **월   : MM**
                                
                                **일   : dd**
                                
                                **시   : HH**
                                
                                **분   : mm**
                                
                                **초   : ss**
                                
                        
                        ```html
                        <!DOCTYPE html>
                        <html xmlns:th="http://www.thymeleaf.org">
                        <head>
                        <meta charset="UTF-8">
                        <title>format</title>
                        </head>
                        <body>
                        
                        	<h3>Date Format</h3>
                        	<p th:text="${date1}"></p>
                        	<p th:text="${date2}"></p>
                        	<br/>
                        	<p th:text="${#dates.format(date1 , 'yyyy-MM-dd')}"></p>
                        	<p th:text="${#dates.format(date2 , 'yyyy-MM-dd')}"></p>
                        	<br/>
                        	<p th:text="${#dates.format(date1 , 'yyyy년 MM월 dd일 hh시 mm분 ss초')}"></p>
                        	<p th:text="${#dates.format(date2 , 'yyyy년 MM월 dd일 hh시 mm분 ss초')}"></p>
                        	
                        </body>
                        </html>
                        ```
                        
                        - **정수 format 포맷 >  formatInteger**
                            - Integer는 소수점이 없는 숫자를 의미한다.
                            - Integer Format을 구현하기 위해 **#numbers 유틸리티 객체의 formatInteger 메소드를 사용하여 구현**한다.
                            - 이를 통해 숫자를 통화 , 백분율 , 표시자리수 , 구분자 등 다양한 정수 포맷기능을 구현할 수 있다.
                            - **[ 형식 ]**
                                
                                **${﻿#numbers.formatInteger(데이터 , 최소 표시 자리수)**}
                                
                                **${﻿#numbers.formatInteger(데이터 , 최소 표시 자리수 , 구분자표현)**}
                                
                            - (참고)
                                - **구분자** : 세자리마다 사이에 표시되는 구분자로서 **'COMMA', 'POINT', 'WHITESPACE', 'NONE', 'DEFAULT'가 있으며
                                Default는 COMMA이다.**
                        
                        ```html
                        <!DOCTYPE html>
                        <html xmlns:th="http://www.thymeleaf.org">
                        <head>
                        <meta charset="UTF-8">
                        <title>format</title>
                        </head>
                        <body>
                        
                        	<h3>formatInteger</h3>
                        	<p th:text="${intVar}"></p>
                        	<br/>
                        	<p th:text="${#numbers.formatInteger(intVar , 1 ,'COMMA')}"></p>
                        	<p th:text="${#numbers.formatInteger(intVar , 2 ,'COMMA')}"></p>
                        	<p th:text="${#numbers.formatInteger(intVar , 3 ,'COMMA')}"></p>
                        	
                        </body>
                        </html>
                        ```
                        
                        - **소수점 format 포맷 > formatDecimal**
                            - Decimal은 소수점을 포함하는 숫자를 말한다.
                            - 소수점 제어는 **formatDecimal를 사용하여 구현**한다.
                            - **[ 형식 ]**
                                
                                **${#numbers.formatDecimal(데이터 , 표시자리수, 구분자 , 소수점표시자리수 , 'POINT')}**
                                
                        
                        ```html
                        <!DOCTYPE html>
                        <html xmlns:th="http://www.thymeleaf.org">
                        <head>
                        <meta charset="UTF-8">
                        <title>format</title>
                        </head>
                        <body>
                        	 
                        	<h3>formatDecimal</h3>
                        	<p th:text="${doubleVar}"></p>
                        	<br/>
                        	<p th:text="${#numbers.formatDecimal(doubleVar, 1 , 'COMMA' , 1 , 'POINT')}"></p>
                        	<p th:text="${#numbers.formatDecimal(doubleVar, 1 , 'COMMA' , 2 , 'POINT')}"></p>
                        	<p th:text="${#numbers.formatDecimal(doubleVar, 1 , 'COMMA' , 3 , 'POINT')}"></p>
                        
                        </body>
                        </html>
                        ```
                        
                    - **th:with**
                        - th:with는 지역 변수를 선언하여 HTML 템플릿의 **특정 영역에서만 변수를 사용할 수 있게 해준다.**
                        - 이를 통해 코드의 중복을 줄이고 템플릿의 가독성을 높일 수 있다.
                        
                        ```java
                        @Controller
                        public class WithController {
                        
                        	@GetMapping("/th/with/ex")  // localhost/th/with/ex
                        	public String with(Model model) {
                        		
                        		model.addAttribute("price" , 10000);
                        		model.addAttribute("orderQty" , 3);
                        		model.addAttribute("deliveryPrice", 3000);
                        		model.addAttribute("usePoint" , 5000);
                        		
                        		return "chapter01_thymeleaf/with/withEx";
                        		
                        	}
                        	
                        }
                        ```
                        
                        ```html
                        <!DOCTYPE html>
                        <html xmlns:th="http://www.thymeleaf.org">
                        <head>
                        <meta charset="UTF-8">
                        <title>with</title>
                        </head>
                        <body>
                        
                        	<h3>1. with</h3>
                        	<!-- block 범위 안에서만 유효 -->
                        	<th:block th:with="totalAmountDue=${price * orderQty + deliveryPrice - usePoint}">
                        		<p th:text="|최종 결제 금액 : ${totalAmountDue}|"></p>
                        	</th:block>
                        	<p th:text="|최종 결제 금액 : ${totalAmountDue}|"></p> <!-- 유효 x -->
                        	<hr/>
                        	
                        	<!-- 	
                        	
                        		- th:with를 사용하여 여러 변수를 한 번에 선언할 수 있다.
                        		
                        			[ 예시 ] 
                        		 
                        			- varName1과 varName2 두 개의 지역 변수를 선언하고 데이터를 각각 할당하여 사용한다.
                        			
                        			<div th:with="varName1=${data}, varName2=${data}">
                        			
                        			</div>
                        			
                        	-->
                        	
                        	<h3>2. with 동시 변수 선언</h3>
                        	<th:block th:with="purchaseAmount=${price * orderQty + deliveryPrice} , 
                        					   totalAmountDue=${price * orderQty + deliveryPrice - usePoint}" >
                        	
                        		<p th:text="|구매금액 : ${purchaseAmount}|"></p>
                        		<p th:text="|최종 결제 금액 : ${totalAmountDue}|"></p>
                        	
                        	</th:block>
                        	<hr/>
                        	
                        	<!-- 	
                        	
                        		- th:with는 중첩하여 사용할 수 있다. 내부에서 선언된 변수는 해당 범위 내에서만 유효하다.
                        		
                        		[ 예시 ]
                        		
                        		- 이 구조에서 innerVar는 안쪽 <div> 내부에서만 유효하고 outerVar는 두 <div> 태그 모두에서 유효하다.
                        		
                        		<div th:with="outerVar='First level'">
                        		    
                        		    <div th:with="innerVar='Second level'">
                        		   		- innerVar는 이곳에서만 유효 
                        		    </div>
                        		    
                        		</div>
                        		
                        	 -->
                        	 
                        	<h3>3. with 중첩사용</h3>
                        	<th:block th:with="purchaseAmount=${price * orderQty + deliveryPrice}">
                        	
                        		<th:block th:with="totalAmountDue=${price * orderQty + deliveryPrice - usePoint}">
                        			<p th:text="|구매금액 : ${purchaseAmount}|"></p>
                        			<p th:text="|최종 결제 금액 : ${totalAmountDue}|"></p>
                        		</th:block>
                        		
                        		<p th:text="|구매금액 : ${purchaseAmount}|"></p>
                        		<p th:text="|최종 결제 금액 : ${totalAmountDue}|"></p> <!-- 유효 X -->
                        		
                        	</th:block>
                        	
                        	
                        	
                        	
                        	
                        </body>
                        </html>
                        ```
                        
                    - **th:object**
                        - 'th:object'는 타임리프 **템플릿 내의 <form> 태그에 사용**되며 폼이 제출될 때 컨트롤러로 전송될 객체를 지정한다.
                        - 'th:field'와 함께 사용되어 **폼 필드와 객체 필드 *{필드명}형태로 바인딩**한다. 여기에서 **id , name , value 속성이 동시에 지정**된다.
                        - 이를 통해 폼 데이터를 객체에 바인딩하여 서버로 전송할 수 있으며
                        컨트롤러에서는 이 객체를 통해 클라이언트로부터 받은 데이터를 처리할 수 있다.
                        - **[ 사용법 ]**
                            
                            **step 1) 컨트롤러에서 모델 객체를 뷰로 전달해 주어야 한다.**
                            예시 : model.addAttribute("dto" , DTO데이터);
                            
                            **step 2) 템플릿의 <form> 태그에서 전송된 객체를 'th:object'속성을 통해 지정한다.**
                            예시 : th:object="${dto}"
                            
                            **step 3) 폼 내의 입력 필드는 th:field="*{필드명}"을 사용하여 th:object에 지정된 객체의 필드와 바인딩된다.**
                            예시 : dto.필드명     > *{필드명}
                            
                        
                        ```java
                        @Controller
                        @RequestMapping("/th/object")
                        public class ObjectController {
                        
                        	@GetMapping("/ex01")  // localhost/th/object/ex01
                        	public String ex01(Model model) {
                        	
                        		// th:object , th:value 예시
                        		ProductDTO productDTO = new ProductDTO();
                        		productDTO.setProductId(1);
                        		productDTO.setProductNm("테스트 상품");
                        		productDTO.setPrice(300000);
                        		productDTO.setDeliveryPrice(3000);
                        		productDTO.setEnrollDt(new Date());
                        		productDTO.setBrandId(100);
                        		
                        		model.addAttribute("productDTO" , productDTO);
                        		
                        		return "chapter01_thymeleaf/object/objectEx01";
                        	
                        			}
                        	}
                        ```
                        
                        ```html
                        <!DOCTYPE html>
                        <html xmlns:th="http://www.thymeleaf.org">
                        <head>
                        <meta charset="UTF-8">
                        <title>form</title>
                        </head>
                        <body>
                        
                        	<h3>th:object , th:field</h3>
                        	<form action="#" method="post" th:object="${productDTO}"> <!-- model.addAttribute("productDTO" , productDTO); -->
                        		<p>PRODUCT_ID : 	<input type="text" th:field="*{productId}" ></p>
                        		<p>PRODUCT_NM : 	<input type="text" th:field="*{productNm}"></p>
                        		<p>PRICE : 			<input type="text" th:field="*{price}"></p>
                        		<p>DELIVERY_PRICE : <input type="text" th:field="*{deliveryPrice}"></p>
                        		<p>ENROLL_DT : 		<input type="text" th:field="*{enrollDt}"></p>
                        		<p>BRAND_ID : 		<input type="text" th:field="*{brandId}"></p>
                        		<input type="submit">
                        	</form>
                        	<hr>
                        		
                        </body>
                        </html>
                        ```
                   - **th:path**
                        - **th:href**
                            - 타임리프의 URL 처리 기능은 **@{...} 구문을 사용하여 표현**된다.
                            - 이 구문은 타임리프가 실행되는 서버의 컨텍스트를 자동으로 고려하여 절대 경로를 생성한다.
                                - **url 이동 : <a th:href=”@{/URL}”></a>**
                            - 파라미터를 URL에 추가할 수 있으며 **/URL(파라메타명=데이터)** 형태로 작성한다.
                            - **복수의 파라메타를 전송**할경우 , 를 사용하여 **/URL(param1=value1 , param2=value2 , param3=value3)** 형태로 작성한다.
                                - **url 이동(파라메타) : <a th:href=””@{/URL(param1=value1, param2=value2 , param3 = value3)}></a>**
                            - **경로 변수(path variable)**를 사용하여 RESTful URL을 생성할 수 있으며 **/URL/{파라메타명}(파라메타명=데이터) 형태**로 작성한다.
                            - **복수의 파라메타를 전송**할경우  **/URL/{param1}/{param2}/{param3}(param1=value1 , param2=value2 , param3=value3)** 형태로 작성한다.
                                - **경로 변수 : <a th:href=”@{/URL/{param1}/{param2}/{param3}(param1=value1, param2=value2, param3=value3)}”></a>**
                        - **th:src**
                            - **static 디렉터리를 기준**으로 **@{/경로}형태**로 작성한다.
                                - **<img th:src=”@{/경로}”>**
                                - **<link th:href=*"@{/경로}"* rel=*"stylesheet"* type=*"text/css"*>**
                                - **<script th:src=*"@{/경로}"*></script>**
                                - **<script th:src=*"@{/jquery/jquery-3.7.1.min.js}"*></script>**
                                - **<script th:src=*"@{/ckeditor/ckeditor.js}"*></script>**
                        - **th:action**
                            - form태그의 action속성은 **th:action="@{/경로}"** 형태로 작성한다.
                                - **<form th:action=”@{/경로}”></form>**
                        
                        ```html
                        <!DOCTYPE html>
                        <html xmlns:th="http://www.thymeleaf.org">
                        <head>
                        <meta charset="UTF-8">
                        <title>path</title>
                        <!-- static 디렉터리를 기준으로 @{/경로}형태로 작성한다. -->
                        <link th:href="@{/style.css}" rel="stylesheet" type="text/css"> <!-- css import 예시 -->
                        <script th:src="@{/script.js}"></script>                        <!-- js import 예시 -->
                        <script th:src="@{/jquery/jquery-3.7.1.min.js}"></script>       <!-- jquery import 예시 -->
                        <script th:src="@{/ckeditor/ckeditor.js}"></script>             <!-- ckeditor import 예시 -->
                        
                        <script>
                            $().ready(function(){
                                alert("jquery import success");
                            });
                        </script>
                        
                        </head>
                        <body>
                        
                            <!--  
                                
                                - 타임리프의 URL 처리 기능은 @{...} 구문을 사용하여 표현된다.
                                 
                                - 이 구문은 타임리프가 실행되는 서버의 컨텍스트를 자동으로 고려하여 절대 경로를 생성한다. 
                                
                            -->
                        
                            <h1>1. URL 이동</h1>
                            <!-- before : <p><a href="https://www.naver.com">네이버로 이동하기</a></p> -->
                            <p><a th:href="@{https://www.naver.com}">네이버로 이동하기</a>
                            <p><a th:href="@{/main}">메인화면으로 이동하기</a></p>
                            <hr>
                            
                            
                            
                            <!--  
                            
                                - 파라미터를 URL에 추가할 수 있으며 /URL(파라메타명=데이터) 형태로 작성한다.
                                
                                - 복수의 파라메타를 전송할경우 , 를 사용하여 /URL(param1=value1 , param2=value2 , param3=value3) 형태로 작성한다.  
                            
                            -->
                            <h1>2. URL 이동(파라메타 추가)</h1>
                            <!-- before : <p><a th:href="/board/detail?boardId=10">상세정보 확인</a></p> -->
                            <p><a th:href="@{/board/detail(boradId=10)}">상세정보확인</a></p>
                            <!-- before : <p><a th:href="/webtoon/detail?titleId=1111&tab=fri&no=300">상세정보 확인</a></p> -->
                            <p><a th:href="@{/webtoon/detail(titleId=1111, tab=fri , no = 300)}">상세정보확인</a></p>
                            <hr>
                        
                            <!--
                              
                                - 경로 변수(path variable)를 사용하여 RESTful URL을 생성할 수 있으며 /URL/{파라메타명}(파라메타명=데이터) 형태로 작성한다.
                                
                                - 복수의 파라메타를 전송할경우  /URL/{param1}/{param2}/{param3}(param1=value1 , param2=value2 , param3=value3) 형태로 작성한다.
                                 
                            -->
                            <h1>3. 경로 변수(Path Variable) > controller에서 좀 더 설명 필요</h1>
                            <!-- before : <p><a href="/board/detail/10">상세정보확인</a></p> -->
                            <p><a th:href="@{/board/detail/{boardId}(boardId=10)}">상세정보확인</a></p>
                            <p><a th:href="@{/webtoon/detail/{titleId}/{tab}/{no}(titleId=1111, tab=fri, no=300)}">상세정보확인</a></p>
                            <hr>
                            
                            
                            
                            <!-- static 디렉터리를 기준으로 @{/경로}형태로 작성한다. -->
                            <h1>4. 정적 자원</h1>
                            <!-- before : <img src="/thymeleaf.PNG"> -->
                            <img th:src="@{/thymeleaf.PNG}">
                            <br/><br/>
                            
                            <textarea rows="10" cols="10" name="test" ></textarea>
                            <script>CKEDITOR.replace("test");</script>
                            <hr/>
                            
                            
                            <!-- form태그의 action속성은 th:action="@{/경로}" 형태로 작성한다. -->
                            <h1>5. form</h1>
                            <form th:action="@{/toController}" method="post">
                                <p>ID : <input type="text" name="id"></p>
                                <p>PASSWORD : <input type="password" name="passwd"></p>
                                <input type="submit">
                            </form>
                            
                        </body>
                        </html>
        
                        ```
    - **View → Controller**
        - **@ModelAttribute**
            - @ModelAttribute 어노테이션을 사용하여 HTML element name 과 DTO property가 일치된 경우(타입도 일치 해야함)에 DTO 형식으로 바인딩(매핑) 된 전달 받을 수 있다.
            - @ModelAttribute 의 경우 내부적으로 검증(Validation) 작업을 진행하기 때문에 setter 메서드를 이용하여 값을 바인딩하려고 시도하다가
            예외를 만날때(데이터 타입 불일치) 작업이 중단되면서 Http 400 Bad Request가 발생한다.
            - **String to Date 데이터 형식의 바인딩은 DTO클래스 property위에 @DateTimeFormat(pattern = "yyyy-MM-dd")을 추가하여 매핑해야함**
            
            ```java
            @Controller
            @RequestMapping("/v2c")
            public class V2C_binding {
            
            	@GetMapping("/view") // localhost/v2c/view
            	public String view() {
            		return "chapter02_modelAndView/v2c";
            	}
            
            	@PostMapping("/modelAttribute")
            	public String modelAttribute(@ModelAttribute ProductDTO productDTO) {
            		
            		System.out.println("\n - @ModelAttribute - \n");
            		System.out.println(productDTO);
            		
            	    return "redirect:/v2c/view";
            		
            		}
            	}
            ```
            
            ```html
            <!DOCTYPE html>
            <html xmlns:th="http://www.thymeleaf.org">
            <head>
            <meta charset="UTF-8">
            <title>view to controller</title>
            </head>
            <body>
            
            	<h1>1) @ModelAttribute</h1>
            	<form th:action="@{/v2c/modelAttribute}" method="post"> 
            		<input type="hidden" name="isPC" value="true">
            		<input type="hidden" name="locationId" value="1">
            		<input type="hidden" name="lang" value="kor">
            		<fieldset>
            			<legend>상품등록</legend>
            			<p>상품코드(숫자) : <input type="text" name="productId" /></p>
            			<p>상품명   : <input type="text" name="productNm" /></p>
            			<p>가격(숫자)     : <input type="text" name="price" /></p>
            			<p>배송비(숫자)   : <input type="text" name="deliveryPrice" /></p>
            			<p>등록날짜 : <input type="date" name="enrollDt" /></p>
            			<p>브랜드 :  
            				<select name="brandId">
            					<option value="1">SAMSUNG</option>
            					<option value="2">LG</option>
            					<option value="3">APPLE</option>
            					<option value="4">LENOVO</option>
            					<option value="5">GIGABYTE</option>
            					<option value="6">HP</option>
            				</select>
            			</p>
            		    <p><input type="submit" value="상품등록" ></p>
            		</fieldset>	
                </form>
                
            </body>
            </html>
            ```
            
            **+) 참고 : 오류 코드**
            
            **405 : get, post 방법 불일치**
            
            **404 : url 경로 불일치**
            
            **400 : 파라메타 불일치**
            
            **500 : 서버 코드 오류** 
            
            ```java
              // (참고: 오류 코드)
            	// 405(get, post 방법 불일치)
            	@PostMapping("/url") // 404 (url 경로 불일치)
            	public String debugMethod(@ModelAttribute ProductDTO productDTO) { // 400 (파라메타 불일치)
            		
            		// 이하 500 (서버 코드 오류)
            		
            		return "";
            	}
            ```
            
        - **@RequestParam Map<K,V>**
            - 요청 HTML의 name속성이 Map 컬렉션 프레임워크의 "KEY"로 바인딩되며
            요청 HTML의 name의 value속성이 Map 컬렉션 프레임워크의 "VALUE"로 바인딩된다.
            - HashMap타입이 아닌 **HashMap의 인터페이스인 Map타입**으로 데이터를 받는다.
            - Map으로 전달되는 데이터가 정수 , 실수 , 글자등 다양한 데이터일 경우 다형성을 이용하여 Object타입으로 처리할 수 있다.
            - **Object 타입으로 전송받는 경우** 데이터를 전송 받은 이후 로직에 알맞게 **데이터 형변환을 따로 해주어야** 한다.
            
            ```java
            @Controller
            @RequestMapping("/v2c")
            public class V2C_binding {
            
            	@GetMapping("/view") // localhost/v2c/view
            	public String view() {
            		return "chapter02_modelAndView/v2c";
            	}
            	
            	@PostMapping("/map")
            	public String map(@RequestParam Map<String,Object> productMap ) {
            		
            		System.out.println("\n - @RequestParam Map - \n");
            		System.out.println(productMap);
            		System.out.println();
            		
            	    return "redirect:/v2c/view";
            	}
            
            }
            
            ```
            
            ```html
            <!DOCTYPE html>
            <html xmlns:th="http://www.thymeleaf.org">
            <head>
            <meta charset="UTF-8">
            <title>view to controller</title>
            </head>
            <body>
            
              <h1>2) @RequestParam Map</h1>
            	<form th:action="@{/v2c/map}" method="post"> 
            		<input type="hidden" name="isPC" value="true">
            		<input type="hidden" name="locationId" value="1">
            		<input type="hidden" name="lang" value="kor">
            		<fieldset>
            			<legend>상품등록</legend>
            			<p>상품코드(숫자) : <input type="text" name="productId" /></p>
            			<p>상품명 : <input type="text" name="productNm" /></p>
            			<p>가격(숫자) : <input type="text" name="price" /></p>
            			<p>배송비(숫자) : <input type="text" name="deliveryPrice" /></p>
            			<p>등록날짜 : <input type="date" name="enrollDt" /></p>
            			<p>브랜드 :  
            				<select name="brandId">
            					<option value="1">SAMSUNG</option>
            					<option value="2">LG</option>
            					<option value="3">APPLE</option>
            					<option value="4">LENOVO</option>
            					<option value="5">GIGABYTE</option>
            					<option value="6">HP</option>
            				</select>
            			</p>
            		    <p><input type="submit" value="상품등록" ></p>
            		</fieldset>	
                </form>
            </body>
            </html>
            ```
            
            → ModelAttribute와 달리 html에서 type이 hidden 것도 console에 출려됨
            
        - **HttpServletRequest**
            - HttpServletRequest인터페이스에서 **getParameter메서드를 사용**하여 파라메타를 전달받을 수 있다.
            - JSP HttpServletRequest과 사용방법이 같다.
            
            ```java
            @Controller
            @RequestMapping("/v2c")
            public class V2C_param {
            
            	@GetMapping("/httpServletRequest")
            	public String httpServletRequest(HttpServletRequest request) {
            		
            		System.out.println("\n - httpServletRequest -\n");
            		
            		System.out.println("titleId : " + Long.parseLong(request.getParameter("titleId")));
            		System.out.println("tab : " + request.getParameter("tab"));
            		System.out.println("no : " + Integer.parseInt(request.getParameter("no")));
            		System.out.println();
            		
            		return "redirect:/v2c/view";
            		
            			}
            	}
            ```
            
            ```html
            <!DOCTYPE html>
            <html xmlns:th="http://www.thymeleaf.org">
            <head>
            <meta charset="UTF-8">
            <title>view to controller</title>
            </head>
            <body>
                 
              <h1>3) HttpServletRequest</h1>
            	<p><a th:href="@{/v2c/httpServletRequest(titleId=11111, tab=tue, no=200)}">HttpServletRequest</a></p>
              
            </body>
            </html>
            ```
            
        - **@RequestParam (요즘 많이 사용)**
            - @RequestParam 어노테이션을 사용하여 파라메타를 전달받을 수 있다.
            - @RequestParam 어노테이션을 사용하여 데이터를 전달받는다.
            - **[ @RequestParam 어노테이션의 속성 ]**
                
                **name**  : 파라메타의 이름을 지정한다. (다른 옵션을 사용하지 않을 경우 name 키워드생략가능)
                
                **required**	 : 필수 여부를 지정한다. 기본값은 true이며 요청값이 없으면 익셉션이 발생한다.
                
                **defaultValue** : 요청 파라메타의 값이 없을 때 사용할 값을 지정한다.
                
            
            ```java
            @Controller
            @RequestMapping("/v2c")
            public class V2C_param {
            
            	@GetMapping("/requestParam")
            	public String requestParam(@RequestParam(name="titleId" , defaultValue="000") long titleId, 
            			                       @RequestParam("tab") String tab,
            			                       @RequestParam("no") int no) {
            		System.out.println("\n - @RequestParam -\n");
            		
            		System.out.println("titleId : " + titleId);
            		System.out.println("tab : " + tab);
            		System.out.println("no : " + no);
            		System.out.println();
            		
            		return "redirect:/v2c/view";
            	}
            		}
            ```
            
            ```html
            <!DOCTYPE html>
            <html xmlns:th="http://www.thymeleaf.org">
            <head>
            <meta charset="UTF-8">
            <title>view to controller</title>
            </head>
            <body>
            
              <h1>4) @RequestParam</h1>
            	<!-- <p><a href="/v2c/requestParam?titleId=22222&tab=tue&no=301">@RequestParam</a></p> -->
            	<p><a th:href="@{/v2c/requestParam(titleId=22222 , tab=tue , no=301)}">@RequestParam</a></p>
                 
            </body>
            </html>
            ```
            
        - **@PathVariable**
            - 요청 URL과 함께 파라메타를 같이 전달할 수 있다. REST API에서 사용하며 '명사'형태로 전송한다.
            - @PathVariable 어노테이션을 사용하여 데이터를 전달받는다.
            
            ```java
            @Controller
            @RequestMapping("/v2c")
            public class V2C_param {
            
            	@GetMapping("/pathVariable/{titleId}/{tab}/{no}")
            	public String pathVariable(@PathVariable("titleId") long titleId ,
            			                       @PathVariable("tab") String tab,
            			                       @PathVariable("no") int no) {
            		
            		System.out.println("\n - @PathVariable -\n");
            		
            		System.out.println("titleId : " + titleId);
            		System.out.println("tab : " + tab);
            		System.out.println("no : " + no);
            		System.out.println();
            		
            		return "redirect:/v2c/view";
            	}
            	
            }
            ```
            
            ```html
            <!DOCTYPE html>
            <html xmlns:th="http://www.thymeleaf.org">
            <head>
            <meta charset="UTF-8">
            <title>view to controller</title>
            </head>
            <body>
            
              <h1>5) @PathVariable</h1>
               <!-- thymeleaf가 아닐때 : <p><a href="/v2c/pathVariable/33333/tue/302">@PathVariable</a></p> -->
            	<p><a th:href="@{/v2c/pathVariable/{titleId}/{tab}/{no}(titleId=33333, tab=tue, no=302)}">@PathVariable</a></p>
                 
            </body>
            </html>
            ```
     - **mybatis (java와 db 를 매핑)**
        - Mapper 목적 파일로 사용하기 위한 선언문(.xml)
            - **<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">**
        - **SQL과 매핑할 자바객체를 (패키지명.DAO)형태로 namespace에 작성 (.xml)**
        - **Mapper → DAO**
            - **id 속성** : query의 식별자이며 다른 id와 중복없이 고유해야 한다.
            DAO의 추상메서드와 id속성을 연결시켜 SQL과 JAVA를 매핑한다.
                
                 [Mapper]				             [DAO]
                
                id="getProductList"    	 		getProductList();
                
                id="getProductDetail"    	        getProductDetail();
                
            - **parameterType속성** : DAO에서 Mapper으로 전달되는 파라미터의 타입을 명시하며 생략 가능하다.
            - **resultType속성**
                - 반환되는 데이터의 타입을 명시하며 반환 데이터가 있는 **select쿼리문에서 사용한다. (int , String , hashmap , map , Map , double , path.DTO , path.VO)**
                path.DTO , path.VO 타입은 application.properteis파일에서 alias(별칭)지정을 하여 간략하게 사용할 수 있다.
                    
                    예시) mybatis.type-aliases-package=패키지명
                    
                - snake to camel매핑 설정도 application.properties파일에서 아래의 설정을 추가하여 사용할 수 있다.
                mybatis.configuration.map-underscore-to-camel-case=true
            - **resultMap속성  :** 주로 반환되는 데이터의 컬럼명을 DTO의 필드와 일치시키거나 map 컬렉션프레임워크의 키로 등록시켜서 SQL과 JAVA가 매핑된다.
            - **<![CDATA[]]>**
                - SQL 내부의 특정 연산자가 (ex '>' , '<') 마이바티스 태그와 중첩되기 때문에 <![CDATA[]]>로 쿼리문을 감싸고 쿼리문을 작성한다.
            - **map (이 방식으로 사용 x)**
                - COLUMN에서 AS키워드를 작성하여 자바 DTO의 property와 바인딩시키거나 맵의 key값으로 지정한다.
                - resultType =” hashmap”
            - **resultMap (요즘 많이 사용)**
                - resultMap속성은 resultMap태그의 id와 매핑된다.
                - <resultMap type=”hashmap” id=”” > <result column=”” property=”” ></resultMap>
                - resultMap속성은 resultMap태그의 id와 매핑된다.
            
            ```xml
            <?xml version="1.0" encoding="UTF-8"?>
            <!-- Mapper 목적 파일로 사용하기 위한 선언문 -->
            <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
            
            <!-- SQL과 매핑할 자바객체를 (패키지명.DAO)형태로 namespace에 작성 -->
            <mapper namespace="com.application.mvc.chapter03_mybatis.M2D">
            
            	<!-- DTO List 반환 예시1 -->
            	<!-- alias적용전 : com.application.mvc.data.ProductDTO -->
            	<select id="ex01" resultType="ProductDTO"> 
            		SELECT *
            		FROM   PRODUCT
            	</select>
            	
            	<!-- DTO List 반환 예시2 -->
            	<select id="ex02" resultType="BrandDTO">
            		SELECT *
            		FROM   BRAND
            	</select>
            	
            	
            	<!-- DTO 반환 예시1 -->
            	<select id="ex03" resultType="ProductDTO">
            		SELECT *
            		FROM   PRODUCT
            		WHERE  PRODUCT_ID = 1
            	</select>
            	
            	<!-- DTO 반환 예시2 -->
            	<select id="ex04" resultType="BrandDTO">
            		SELECT *
            		FROM   BRAND
            		WHERE  BRAND_ID = 1
            	</select>
            	
            	
            	<!-- 단일데이터 반환 예시1 -->
            	<select id="ex05" resultType="int">
            		SELECT COUNT(*)
            		FROM   PRODUCT
            	</select>
            	
            	<!-- 단일데이터 반환 예시2 -->
            	<select id="ex06" resultType="double">
            		SELECT AVG(PRICE)
            		FROM   PRODUCT
            	</select>
            	
            	<!-- 단일데이터 반환 예시3 -->
            	<select id="ex07" resultType="String">
            		SELECT PRODUCT_NM
            		FROM   PRODUCT
            		WHERE  PRODUCT_ID = 1
            	</select>
            
            	<!--  
            
            		# <![CDATA[]]>
            
            	 	- SQL 내부의 특정 연산자가 (ex '>' , '<') 마이바티스 태그와 중첩되기 때문에
            	 	<![CDATA[]]>로 쿼리문을 감싸고 쿼리문을 작성한다.
            	 	     
            	-->
            	
            	<!-- <![CDATA]]> 사용예시  -->	
            	<select id="ex08" resultType="ProductDTO">
            		<![CDATA[
            			SELECT *
            			FROM   PRODUCT
            			WHERE  PRICE <= 1000000
            		]]>
            	</select>
            	
            	
            	<!-- 
            	
            		# map 사용 예시
            	
            		- COLUMN에서 AS키워드를 작성하여 자바 DTO의 property와 바인딩시키거나 맵의 key값으로 지정한다.
            			
            		<select id = "" >
            			SELECT
            				컬럼1  AS DTO의 property 혹은 Map의 key
            				컬럼2  AS DTO의 property 혹은 Map의 key
            				컬럼3  DTO의 property 혹은 Map의 key    		< AS 키워드는 생략가능하다.
            				컬럼4  DTO의 property 혹은 Map의 key   
            			FROM
            				테이블명		
            		</select> 
            	 
            	-->
            	
            	<!-- AS명 > hashmap key로 매핑 -->
            	<select id="ex09" resultType="hashmap">
            		SELECT PRODUCT_ID 			AS productId,
            			   PRICE 	  			AS price,
            			   PRICE * 0.1 			AS tax,
            			   PRICE + PRICE * 0.1  AS totalPrice
            		FROM   PRODUCT
            	</select>
            	
            	<!--  
            	
            		# resultMap 사용예시
            		
            		<resultMap id="getProduct" type="000.000.000.Product">  		<< 식별id , DTO클래스 전체 경로
                   		<result property="productCode" column="PRODUCT_CODE"/>		<< 변수값 , 컬럼명
                   		<result property="productName" column="PRODUCT_NAME"/>
                	</resultMap>
                	
                	<select id = ""  resultMap="getProduct">						<< 식별id , resultMap의 id
                		SELECT
            				PRODUCT_CODE
            				PRODUCT_NAME
            			FROM
            				PRODUCT		
                	</select>
            
            		> resultMap속성은 resultMap태그의 id와 매핑된다.
            		
            	-->
            	
            	<!-- resultMap 사용 예시1 -->
            	<resultMap type="hashmap" id="priceMap">
            		<result column="PRODUCT_ID"  property="productId" />
            		<result column="PRICE" 		 property="price" />
            		<result column="TAX" 		 property="tax" />
            		<result column="TOTAL_PRICE" property="totalPrice" />
            	</resultMap>
            	
            	<select id="ex10" resultMap="priceMap">
            		SELECT PRODUCT_ID 			AS PRODUCT_ID,
            			   PRICE 	  			AS PRICE,
            			   PRICE * 0.1 			AS TAX,
            			   PRICE + PRICE * 0.1  AS TOTAL_PRICE
            		FROM   PRODUCT
            	</select>
            	
            	
            	<!-- resultMap 사용 예시2 -->
            	<resultMap type="hashmap" id="joinMap">
            		<result column="PRODUCT_ID" property="productId"/>
            		<result column="PRODUCT_NM" property="productNm"/>
            		<result column="BRAND_ID"   property="brandId"/>
            		<result column="BRAND_NM"   property="brandNm"/>
            	</resultMap>
            	
            	<select id="ex11" resultMap="joinMap">
            		SELECT P.PRODUCT_ID  AS PRODUCT_ID,
            			   P.PRODUCT_NM  AS PRODUCT_NM,
            			   B.BRAND_ID    AS BRAND_ID,
            			   B.BRAND_NM    AS BRAND_NM
            		FROM   PRODUCT P
            		JOIN   BRAND B
            		  ON   P.BRAND_ID = B.BRAND_ID
            	</select>
            
            </mapper>
            
            ```
            
            ```java
            @Mapper
            public interface M2D {
            
            	// List<DTO> 반환예시1 > m2dMapper.xml파일의 <select id="ex01" resultType="ProductDTO">와 매핑
            	public List<ProductDTO> ex01();
            	// List<DTO> 반환예시2 > m2dMapper.xml파일의 <select id="ex02" resultType="BrandDTO">와 매핑
            	public List<BrandDTO> ex02();
            	
            	// DTO 반환 예시1 > m2dMapper.xml파일의 <select id="ex03" resultType="ProductDTO">와 매핑
            	public ProductDTO ex03();
            	// DTO 반환 예시2 > m2dMapper.xml파일의 <select id="ex04" resultType="BrandDTO">와 매핑
            	public BrandDTO ex04();
            	
            	// 단일 데이터 반환 예시1 > m2dMapper.xml파일의 <select id="ex05" resultType="int">와 매핑
            	public int ex05();
            	// 단일 데이터 반환 예시2 > m2dMapper.xml파일의 <select id="ex06" resultType="double">와 매핑
            	public double ex06();
            	// 단일 데이터 반환 예시3 > m2dMapper.xml파일의 <select id="ex07" resultType="String">와 매핑
            	public String ex07();
            	
            	// <![CDATA[]]> 사용예시  > m2dMapper.xml파일의 <select id="ex08" resultType="ProductDTO">와 매핑
            	public List<ProductDTO> ex08();
            	
            	// map사용 예시          > m2dMapper.xml파일의 <select id="ex09" resultType="hashmap">와 매핑
            	public List<Map<String , Object>> ex09();
            	
            	// resultMap 사용 예시1  > m2dMapper.xml파일의 <resultMap type="hashmap" id="priceMap">와 매핑
            	public List<Map<String , Object>> ex10();
            	// resultMap 사용 예시1  > m2dMapper.xml파일의 <resultMap type="hashmap" id="joinMap">와 매핑
            	public List<Map<String, Object>> ex11();
            }
            ```
                
            - **테스트 코드**
                - 테스트 코드를 작성하는 것은 애플리케이션의 안정성을 보장하고,
                기능이 예상대로 동작하는지 확인하기 위한 중요한 과정이다.
                - 단위 테스트(Unit Test): 가장 작은 코드 단위의 기능을 테스트한다.
                보통 메소드 레벨에서 이루어지며, 스프링 컨텍스트를 로드하지 않아 실행 속도가 빠르다.
                - **@SpringBootTest 애너테이션을 클래스 레벨에 사용**하여 스프링 부트의 테스트 환경을 구성한다.
                **@Test 애너테이션을 메서드 레벨에 사용**하여 테스트 케이스를 정의한다.
            
            ```java
            @SpringBootTest
            public class M2dMapperTest {
            
            	@Autowired
            	private M2D m2d;
            	
            	@DisplayName("DTO List 반환 예시1")
            	@Test
            	public void ex01() {
            		System.out.println("\n- ex01 - \n");
            		
            		for ( ProductDTO productDTO : m2d.ex01() ) {
            			System.out.println(productDTO);
            		}
            		
            	}
            	
            	@DisplayName("DTO List 반환 예시2")
            	@Test
            	public void ex02() {
            		System.out.println("\n- ex02 - \n");
            		
            		for (BrandDTO brandDTO : m2d.ex02()) {
            			System.out.println(brandDTO);
            		}
            	}
            	
            	@DisplayName("DTO 반환 예시1")
            	@Test
            	public void ex03() {
            		System.out.println("\n- ex03 - \n");
            		
            		System.out.println(m2d.ex03());
            		
            	}
            	
            	@DisplayName("DTO 반환 예시2")
            	@Test
            	public void ex04() {
            		System.out.println("\n- ex04 - \n");
            		
            		System.out.println(m2d.ex04());
            		
            	}
            	
            	@DisplayName("단일데이터 반환 예시1")
            	@Test
            	public void ex05() {
            		System.out.println("\n- ex05 - \n");
            		
            		System.out.println(m2d.ex05());
            		
            	}
            	
            	@DisplayName("단일데이터 반환 예시2")
            	@Test
            	public void ex06() {
            		System.out.println("\n- ex06 - \n");
            		
            		System.out.println(m2d.ex06());
            		
            	}
            	
            	@DisplayName("단일데이터 반환 예시3")
            	@Test
            	public void ex07() {
            		System.out.println("\n- ex07 - \n");
            		
            		System.out.println(m2d.ex07());
            		
            	}
            	
            	@DisplayName("<![CDATA[]]> 사용예시")
            	@Test
            	public void ex08() {
            		System.out.println("\n - ex08 - \n");
            		
            		for (ProductDTO productDTO : m2d.ex08()) {
            			System.out.println(productDTO);
            		}
            	}
            	
            	@DisplayName("map 컬렉션 프레임워크 사용 예시")
            	@Test
            	public void ex09() {
            		System.out.println("\n - ex09 - \n");
            		
            		for (Map<String,Object> map : m2d.ex09() ) {
            			System.out.println(map);
            		}
            	}
            	
            	@DisplayName("resultMap 사용 예시1")
            	@Test
            	public void ex10() {
            		System.out.println("\n - ex10 - \n");
            		for (Map<String,Object> priceMap : m2d.ex10()) {
            			System.out.println(priceMap);
            		}
            	}
            	
            	@DisplayName("resultMap 사용 예시2")
            	@Test
            	public void ex11() {
            		System.out.println("\n - ex11 - \n");
            		for (Map<String, Object> joinMap : m2d.ex11()) {
            			System.out.println(joinMap);
            		}
            	}
            
            	
            	
            	
            }
            ```


       - **DAO → Mapper**
            - 단위테스트를 통해 db에 insert, update 할 값들 보냄
            
            ```java
            @SpringBootTest
            public class D2mMapperTest {
            	
            	@Autowired
            	private D2M d2m;
            	
            	@DisplayName("단일 데이터 전송 예시 1")
            	@Test
            	public void ex01() {
            		
            		long productId = 1;
            	    d2m.ex01(productId);
            		
            	}
            	
            	
            	@DisplayName("단일 데이터 전송 예시 2")
            	@Test
            	public void ex02() {
            		
            		long brandId = 6;
            		d2m.ex02(brandId);
            		
            	}
            	
            	
            	@DisplayName("단일 데이터 전송 예시 3")
            	@Test
            	public void ex03() {
            		
            		String brandNm = "apple";
            		
            		for (BrandDTO brandDTO : d2m.ex03(brandNm)) {
            			System.out.println(brandDTO);
            		}
            
            	}
            	
            	
            	@DisplayName("DTO 전송예시 1")
            	@Test
            	public void ex04() {
            		
            		/*
            		
            			(자주발생하는 오류 원인)
            			Duplicate entry '~~~' for key 'PRIMARY' : primary key 중복 에러
            			Data too long for column				: 데이터 길이 오버플로우 에러
            		 
            		 */
            		
            		BrandDTO brandDTO = new BrandDTO();
            		// brandDTO.setBrandId(1); 키 중복 오류 
            		brandDTO.setBrandId(100); 	
            		brandDTO.setBrandNm("추가된브랜드100");
            		brandDTO.setActiveYn("N");
            		//brandDTO.setActiveYn("N하이헬로우"); char/varchar 정한 길이 넘어가면 에러
            		
            		d2m.ex04(brandDTO);
            		
            	}
            	
            	
            	@DisplayName("DTO 전송예시 2")
            	@Test
            	public void ex05() {
            		
            		ProductDTO productDTO = new ProductDTO();
            		productDTO.setProductNm("추가된 상품1");
            		productDTO.setPrice(1);
            		productDTO.setDeliveryPrice(1);
            		productDTO.setBrandId(1);
            		
            		d2m.ex05(productDTO);
            		
            	}
            	
            	
            	@DisplayName("DTO 전송예시 3")
            	@Test
            	public void ex06() {
            		
            		ProductDTO productDTO = new ProductDTO();
            		productDTO.setPrice(1000000);
            		productDTO.setDeliveryPrice(3000);
            		
            		for (ProductDTO dto : d2m.ex06(productDTO)) {
            			System.out.println(dto);
            		}
            		
            	}
            	
            	
            	@DisplayName("Map 전송예시 1")
            	@Test
            	public void ex07() {
            		
            		Map<String, Integer> priceMap = new HashMap<String, Integer>();
            		// DTO 에 포함되어 있지 않은 데이터
            		priceMap.put("min", 500000);
            		priceMap.put("max", 1000000);
            		for (ProductDTO productDTO : d2m.ex07(priceMap)) {
            			System.out.println(productDTO);
            		}
            		
            	}
            	
            	
            	@DisplayName("Map 전송예시 2")
            	@Test
            	public void ex08() {
            		
            		Map<String, String> dateMap = new HashMap<String, String>();
            		// DTO 에 포함되어 있지 않은 데이터
            		dateMap.put("startDate","2021-01-01");
            		dateMap.put("endDate", "2021-03-31");
            		
            		for (BrandDTO brandDTO : d2m.ex08(dateMap)) {
            			System.out.println(brandDTO);
            		}
            		
            	}
            	
            	
            	@DisplayName("Map 전송예시3")
            	@Test
            	public void ex09() {
            		
            		Map<String, Object> searchMap = new HashMap<String, Object>();
            		// DTO 에 포함되어 있지만 , BrandDTO와 ProductDTO에 포함되어 있는 데이터
            		searchMap.put("activeYn","N");
            		searchMap.put("price", 1000000);
            				
            		for (Map<String, Object> map : d2m.ex09(searchMap)) {
            			System.out.println(map);
            		}
            	}
            
            	
            }
            ```
            
            - 2개 이상의 파라미터를 Mapper로 전달할 수 없고 **오직 1개의 파라미터만 전송이 가능**하다.
            - 2개 이상의 데이터는 DTO , Map , List , Array 타입으로 전송한다.
            - 전송되는 복수의 데이터가 DTO의 멤버로 포함되어 있으면 일반적으로 DTO , List<DTO> 전송 방식을 사용하고
            전송되는 복수의 데이터가 DTO의 멤버에 포함되어 있지 않은 경우 Map , List<Map> 전송 방식을 사용한다.
            
            ```java
            @Mapper
            public interface D2M {
            
            	// 단일 데이터 전송예시1 > d2mMapper.xml파일의 <update id="ex01" parameterType="long">와 매핑
            	public void ex01(long productId);
            	// 단일 데이터 전송예시2 > d2mMapper.xml파일의 <update id="ex02" parameterType="long">와 매핑
            	public void ex02(long brandId);
            	// 단일 데이터 전송예시3 > d2mMapper.xml파일의 <select id="ex03" parameterType="String" resultType="BrandDTO">와 매핑
            	public List<BrandDTO> ex03(String brandNm);
            	
            	// DTO 전송예시1 > d2mMapper.xml파일의 <insert id="ex04" parameterType="BrandDTO">와 매핑
            	public void ex04(BrandDTO brandDTO); 
            	// DTO 전송예시2 > d2mMapper.xml파일의 <insert id="ex05" parameterType="ProductDTO">와 매핑
            	public void ex05(ProductDTO productDTO);
            	
            	// DTO 전송예시3 > d2mMapper.xml파일의 <select id="ex06" parameterType="ProductDTO" resultType="ProductDTO">와 매핑
            	public List<ProductDTO> ex06(ProductDTO productDTO);
            	
            	// Map 전송예시1 > d2mMapper.xml파일의 <select id="ex07" parameterType="hashmap" resultType="ProductDTO">와 매핑
            	public List<ProductDTO> ex07(Map<String, Integer> priceMap);
            	// Map 전송예시2 > d2mMapper.xml파일의 <select id="ex08" parameterType="hashmap" resultType="BrandDTO">와 매핑
            	public List<BrandDTO> ex08(Map<String, String> dateMap);
            	// Map 전송예시3 > d2mMapper.xml파일의 <select id="ex09" parameterType="hashmap" resultType="hashmap">와 매핑
            	public List<Map<String, Object>> ex09(Map<String, Object> searchMap);
            
            }
            ```
            
            - DAO에서 Mapper XML파일로 파라메타 전송은 1개만 가능하다.
            - 단일 데이터를 전송할 경우 단일 데이터 전송
            - 2개 이상의 데이터를 전송할 경우 데이터가 DTO안에 포함되면 DTO , List<DTO>타입으로 전송
            - 2개 이상의 데이터를 전송할 경우 데이터가 DTO안에 포함되지 않으면 Map , List<Map>타입으로 전송
            - **DAO에서 전달 받은 데이터는 쿼리문에서 #{변수} 형태**로 사용한다.
                - **단일 데이터  : #{변수명}**
                - **DTO               : #{property}**
                - **Map	              : #{key}**
            - '대소문자가 정확하게 구분' 되므로 오타에 주의한다.
                - DTO는 정확하게 property를 입력
                - Map은 정확하게 key를 입력
            - parameterType 속성은 생략해도 Mybatis가 파라메타의 타입을 인식하여 쿼리문은 수행하지만 가독성 향상을 위해 작성하는 것을 권장한다.
            
            ```java
            <?xml version="1.0" encoding="UTF-8"?>
            <!-- Mapper 목적 파일로 사용하기 위한 선언문 -->
            <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
            
            <!-- SQL과 매핑할 자바객체를(path.object)형태로 namespace에 작성 -->
            <mapper namespace="com.application.mvc.chapter03_mybatis.D2M">
            
            	<!-- 단일 데이터 전송예시1 -->
            	<update id="ex01" parameterType="long"> <!-- parameterType은 생략 가능 -->
            		UPDATE PRODUCT
            		SET    DELIVERY_PRICE = DELIVERY_PRICE + 1
            		WHERE  PRODUCT_ID = #{productId}
            	</update>
            	<!-- 단일 데이터 전송예시2 -->
            	<update id="ex02" parameterType="long">
            		UPDATE PRODUCT
            		SET    PRICE = PRICE + 1
            		WHERE  BRAND_ID = #{brandId}
            	</update>
            	<!-- 단일 데이터 전송예시3 -->
            	<select id="ex03" parameterType="String" resultType="BrandDTO">
            		SELECT *
            		FROM   BRAND
            		WHERE  BRAND_NM = #{brandNm}
            	</select>
            
            	<!-- DTO 전송예시1 -->
            	<insert id="ex04" parameterType="BrandDTO">
            		INSERT INTO BRAND
            		VALUES      (
            			#{brandId} ,
            			#{brandNm} ,
            			NOW() ,
            			#{activeYn}
            		)
            	</insert>
            	<!-- 문법 오류
            	     VALUES      (#{brandDTO.brandId},#{brandDTO.brandNm},NOW(),#{brandDTO.activeYn}) 
            		-> 변수명만 작성해야함
            		-->
            	<!-- DTO 전송예시2 -->
            	<insert id="ex05" parameterType="ProductDTO">
            		INSERT INTO PRODUCT (
            			PRODUCT_NM , 
            			PRICE , 
            			DELIVERY_PRICE , 
            			ENROLL_DT ,
            			BRAND_ID
            		)
            		VALUES      (
            			#{productNm} , 
            			#{price} , 
            			#{deliveryPrice} ,
            			NOW() , 
            			#{brandId}
            		)
            	</insert>
            	
            	<!-- DTO 전송예시3 -->
            	<select id="ex06" parameterType="ProductDTO" resultType="ProductDTO" >
            			SELECT *
            			FROM   PRODUCT
            			WHERE  PRICE >= #{price}
            			AND    DELIVERY_PRICE = #{deliveryPrice}
            	</select>
            	
            	<!-- Map 전송예시1 -->
            	<select id="ex07" parameterType="hashmap" resultType="ProductDTO">
            		SELECT *
            		FROM   PRODUCT
            		WHERE  PRICE BETWEEN #{min} AND #{max}
            	</select>
            	<!-- 
            		문법 오류 -> 변수명으로만 적어주면 됨
            		WHERE  PRODUCT BETWEEN #{priceMap.min} AND #{priceMap.max}
            	 -->
            	<!-- Map 전송예시2 -->
            	<select id="ex08" parameterType="hashmap" resultType="BrandDTO">
            		SELECT *
            		FROM   BRAND
            		WHERE  ENTERED_DT BETWEEN #{startDate} AND #{endDate}
            	</select>
            	<!-- Map 전송예시3 -->
            	<select id="ex09" parameterType="hashmap" resultType="hashmap">
            		SELECT *
            		FROM    PRODUCT P
                    JOIN    BRAND B
                    ON      P.BRAND_ID = B.BRAND_ID
                    AND     P.PRICE >= #{price}
                    AND     B.ACTIVE_YN != #{activeYn}
            	</select>
            
            </mapper>
            ```  
- **AOP ( Aspect-Oriented Programming ) 관점 지향 프로그래밍**
    - 프로젝트 개발 과정에서 핵심 기능 외에 추가적이고 다양한 부가(공통) 기능이 필요로 한다. (로깅 , 보안 , 트랜잭션 , 테스트 , 등등)
    - 이 부가(공통)기능들은 프로젝트에 중요한 역할을 하며 이 부가(공통)기능이 코드마다 반복적(중복)으로 나타나는 부분이 존재한다.
    - 코드에서 비즈니스 핵심 로직과 부가기능을 분리하여 부가 로직을 따로 관리(모듈화)한다.
    - 종단(비즈니스 로직) 기능 , 횡단(관심,Aspect) 기능
    - 부가 기능이 비즈니스 로직(핵심 기능)을 담은 클래스의 코드에 전혀 영향을 주지 않으면서 부가기능의 구현을 용이하게 할 수 있는 구조를 제공한다.
    - AOP는 OOP를 대체하는 새로운 개념이 아니라 OOP를 돕는 보조적 기술 중에 하나이다.
    - 스프링 DI  : 의존성(new)주입 , 스프링 AOP  : 로직(code) 주입
    - **[ 용어 정리 ]**
        - **Aspect** : 관점
        - **Advice** : 핵심기능에 부여되는 부가기능 ( 타겟 메서드에 적용될 부가 기능 )
            - **Around (Advice)** : 대상 객체의 메서드 실행 전,후 및 예외 발생 모두 실행한다.
            - **Before (Advice)** : 대상 객체의 메서드 메서드 호출전에 수행한다.
            - **After (Advice)** : 대상 객체의 메서드 실행도중 예외 발생 여부와 상관없이 메서드 실행 후 실행한다.
            - **AfterReturning (Advice)** : 대상 객체의 메서드가 실행 도중 예외 없이 실행 성공한 경우에 실행한다.
            - **AfterThrowing (Advice)**  : 대상 객체의 메서드가 실행 도중 예외가 발생한 경우에 실행한다.
        - **Pointcut**   : Aspect 적용 위치 지정자      ( Advice를 어디에 적용할지를 결정  )
        - **Advisor**    : Advice + Pointcut
        - **Joinpoint**  : Aspect가 적용한 지점
    - **AOP 구현**
        - **build.gradle 파일에 AOP 의존성 추가**
            
            **// AOP
            implementation 'org.springframework.boot:spring-boot-starter-aop'**
            
        - **Application 클래스에 어노테이션 추가**
            
            **@EnableAspectJAutoProxy**
            
            설명 → proxy (대변인,대변자) 
            
            Spring Framework에게 AOP Proxy를 사용 시키도록 하는 어노테이션
            
        - **Advice 클래스에 @Component 및 @Aspect 어노테이션 지정**
            
            **@Component
            @Aspect**
            
        - **Advice 적용**
    - **execution 명시자**
        - **execution(수식어(접근제어자)패턴 리턴타입패턴 패키지이름패턴.클래스이름패턴.메서드이름패턴(파라미터패턴))**
        Ex)        public           void          com.application.aop.board.dto.boardDetail(long)
        - 각 패턴은 ***을 이용하여 모든 값을 표현**할 수 있습니다.
        - **패키지**
            - com.spring.aop	 > com.spring.aop패키지를 타겟
            - com.spring.aop..  > com.spring.aop로 시작하는 하위의 모든 패키지를 타겟
        - **리턴 타입**
            - *****	 > 모든 리턴 타입 타겟
            - **void**	 > 리턴 타입이 void인 메서드만 타겟
            - **!void** > 리턴 타입이 void가 아닌 메서드만 타겟
        - **매개 변수 지정**
        - **(..)**			> 0개 이상의 모든 파라미터 타겟
        - **(*)**			> 1개의 파라미터만 타겟
        - **( * , * )**		> 2개의 파라미터만 타겟
        - **(String,*)**	> 2개의 파라미터중 첫번째 파라미터가 String타입만 타겟
        
        ```java
        // 테스트 클래스
        @Component
        public class Boss {
        
        	public void work() {
        		System.out.println("사장의 일을 한다.");
        	}
        	
        	public void getWorkingTime() {
        		try {
        			Thread.sleep(300); // 0.3초
        		} catch (InterruptedException e) {
        			e.printStackTrace();
        		} 
        	}
        }
        ```
        
        ```java
        // 테스트 클래스
        @Component
        public class Manager {
        
        	public void work() {
        		System.out.println("매니저의 일을 한다.");
        	}
        	
        	public void getWorkingTime() {
        		try {
        			Thread.sleep(700); // 0.7초
        		} catch (InterruptedException e) {
        			e.printStackTrace();
        		} 
        	}
        }
        ```
        
        ```java
        // 테스트 클래스
        @Component
        public class Employee {
        
        	public void work() {
        		System.out.println("직원의 일을 한다.");
        	}
        	
        	public void getWorkingTime() {
        		try {
        			Thread.sleep(1000); // 1초
        		} catch (InterruptedException e) {
        			e.printStackTrace();
        		} 
        	}
        }
        ```
        
        ```java
        @Aspect
        @Component
        public class AopAdvice {
        
        	// 메서드 호출 전
        	@Before("execution(public void com.application.aop.chapter01_aop.*.work())")
        	public void beforeWork() {
        		System.out.println("(공통기능 , Before)출근한다.");
        	}
        	
        	// 메서드 호출 후
        	@After("execution(public void com.application.aop.chapter01_aop.*.work())")
        	public void afterWork() {
        		System.out.println("(공통기능 , After)퇴근한다.\n");
        	}
        	
        	// 메서드 호출 전 후
        	@Around("execution(public * com.application.aop.chapter01_aop.*.getWorkingTime())")
        	public void aroundGetWorkingTime(ProceedingJoinPoint pjp) throws Throwable {
        		
        		// 메서드 호출 전
        		long startTime = System.currentTimeMillis();
        		
        		// ProceedingJoinPoint 객체의 proceed(); 메서드를 사용하여 타겟팅 메서드를 실행한다.
        		pjp.proceed();
        		
        		// 메서드 호출 후
        		long endTime = System.currentTimeMillis();
        		
        		System.out.println("메서드 실행 시간 : " + (endTime - startTime)/1000.0 +"초");
        	}	
        }
        ```
        
        테스트 코드로 확인 가능
        
        ```java
        @SpringBootTest
        public class AopTest {
        
        	@Autowired
        	private Boss boss;
        	
        	@Autowired
        	private Manager manager;
        	
        	@Autowired
        	private Employee employee;
        	
        	@Test
        	void testMethod() {
        		boss.work();
        		manager.work();
        		employee.work();
        		
        		System.out.println("\n\n");
        		
        		boss.getWorkingTime();
        		manager.getWorkingTime();
        		employee.getWorkingTime();
        	}
        }
        ```

### MVC2_ver1 (by Spring Boot)

**[순서]**

**db 연결**

```java
# 1. Database Connection

# 1-1) Connection URL
spring.datasource.url=jdbc:mysql://localhost:3306/DB이름?serverTimeZone=Asia/Seoul

# 1-2) Connection Username
spring.datasource.username=root

# 1-3) Connection Password
spring.datasource.password=db비밀번호

# 1-4) Connection Driver
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver

# 2. MyBatis Configuration

# 2-1) 매퍼(.xml) 파일위치 지정 (src/main/resources/mapper 하위 폴더 만들어야함)
mybatis.mapper-locations=classpath:/mapper/*.xml

# 2-2) 데이터 타입 alias가 매핑되는 패키지 지정
# 매핑 예시 1) com.application.mvc.data.ProductDTO > ProductDTO
# 매핑 예시 2) com.application.mvc.data.BrandDTO > BrandDTO
mybatis.type-aliases-package=com.application.src/main/java에 기본으로 있는 패키지 이름

# 2-3) underscore 와 camel case 매핑 설정
# 매핑 예시 (DB Table) MEMBER_ID <> (java Object) memberId
#           (DT Table) USER_ROLE <> (java Object) userRole
mybatis.configuration.map-underscore-to-camel-case=true

# 3. Thymeleaf Configuration (이미 적용되어있다.)
# 3-1) view 파일 위치지정 (src/main/resources/templates 하위 폴더)
# spring.thymeleaf.prefix=classpath:/templates/

# 3-2) view 파일 확장자지정
#spring.thymeleaf.suffix=.html

# 4) 웹어플리케이션 서비스의 Port 지정
server.port=80
```

**+) DBeaver에 db랑 테이블 만들기**

**DTO**

db 테이블의 컬럼과 같은 내용의 private 필드를 만들고 
클래스 맨 위에 **lombok으로 @data를 작성**해서 getter, setter, toString 기능을 할 수 있도록 함


**중요한 구조!**

**html <> Controller → @Controller <> ServiceImple → @Service <> DAO → @Mapper <> mapper**

**Controller에서는 Service 객체를 ServiceImpl에서는 DAO 객체를 injection 해야함 
→ @Autowired**

