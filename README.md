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
