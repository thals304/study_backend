package step01_board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import step01_board.dto.BoardDTO;

/*

	# JSP MVC2 데이터베이스 연동메뉴얼

	1) 데이터베이스 연결 풀링(연결을 미리 만들어 놓고 재사용하여 데이터베이스 연결 및 해제에 따른 오버헤드를 줄임)과 
	   관련된 기능을 사용하고 데이터베이스 애플리케이션의 성능을 향상시키기 위하여 아래의 라이브러리를 WEB-INF/lib 경로에 추가한다.
	
		commons-dbcp2-2.2.0.jar 
		commons-pool2-2.5.0.jar
		mysql-connector-j-8.0.32.jar


	2) 이클립스에서 Servers폴더에 있는 Context.xml (경로설정) 파일에 아래의 설정을 추가한다. 
	
		[ 확인사항 ] 
		- url , name , username , password
	
		<Resource 
			auth="Container" 
			driverClassName="com.mysql.cj.jdbc.Driver"
			type="javax.sql.DataSource"
			url="jdbc:mysql://localhost:3306/MVC2_PRACTICE?serverTimezone=Asia/Seoul&amp;useSSL=false"
			name="jdbc/board" 
			username="root"
			password="1234" 
			loginTimeout="10" 
			maxWait="5000" 
		/> 

	3) 데이터베이스와 연동하는 메서드를 생성하여 데이터베이스 연결객체를 생성 및 사용한다. 
	
		(패키지)
		import javax.naming.Context;
		import javax.naming.InitialContext;
		import javax.sql.DataSource;
		
		(연결코드)
		Context initctx = new InitialContext();						 // 데이터베이스와 연결하기 위한 init객체 생성
		Context envctx = (Context) initctx.lookup("java:comp/env");  // lookup 메서드를 통해 context.xml 파일에 접근하여 자바환경 코드를 검색     
		DataSource ds = (DataSource) envctx.lookup("jdbc/board"); 	 // <Context>태그안의 <Resource> 환경설정의 name이 jdbc/board인 것을 검색	  
		conn = ds.getConnection();

*/

// DAO (Data Access Object) : 데이터베이스와의 통신 및 데이터베이스 관련 작업을 처리하는 데 사용
public class BoardDAO {

	/*
 	
	 	# 싱글턴 디자인 패턴
	  
		단일 인스턴스 유지, 상태 공유, 전역 접근 지점, 어플리케이션의 상태 관리 및 메모리 최적화와 같은 이점을 활용하여
		어플리케이션의 구조를 더 효율적으로 관리하고 유지보수하기 쉽게 개발할 수 있다.
	
	*/
	
	private BoardDAO(){}
	private static BoardDAO instance = new BoardDAO();
	public static BoardDAO getInstance() {
		return instance;
	}
	
	// 데이터베이스 연동객체 생성
	private Connection conn 		= null;
	private PreparedStatement pstmt = null;
	private ResultSet rs 			= null;
	
	// 데이터베이스 연동 메서드 생성
	private void getConnection() {
		
		try {
			
			Context initctx = new InitialContext();
			Context envctx = (Context) initctx.lookup("java:comp/env");    
			DataSource ds = (DataSource) envctx.lookup("jdbc/board"); 		  
			conn = ds.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		}						
		
	}
	
	// 데이터베이스 연동해지 메서드 생성
	private void getClose() {
		
		if (rs != null)    try {rs.close();} catch (SQLException e) {e.printStackTrace();}
		if (pstmt != null) try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
		if (conn != null)  try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		
	}
	
	// 게시글 입력 메서드
	public void insertBoard(BoardDTO boardDTO) {
		
		try {
			
			getConnection();
			String sql = "INSERT INTO BOARD(WRITER , SUBJECT , EMAIL , PASSWORD , CONTENT , READ_CNT , ENROLL_DT) ";
				   sql += " VALUES(? , ? , ? , ? , ? , 0 , NOW())";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDTO.getWriter());
			pstmt.setString(2, boardDTO.getSubject());
			pstmt.setString(3, boardDTO.getEmail());
			pstmt.setString(4, boardDTO.getPassword());
			pstmt.setString(5, boardDTO.getContent());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		
	}
	
	
	// 게시글 전체조회 메서드
	public ArrayList<BoardDTO> getBoardList() {
		
		ArrayList<BoardDTO> boardList = new ArrayList<BoardDTO>();
		
		try {
			
			getConnection();
			pstmt = conn.prepareStatement("SELECT BOARD_ID , WRITER , SUBJECT , READ_CNT , ENROLL_DT FROM BOARD");
			rs = pstmt.executeQuery();
			
			// 조회된 데이터를 ArrayList<BoardDTO>타입에 저장
			while (rs.next()) {
				
				BoardDTO temp = new BoardDTO();
				temp.setBoardId(rs.getLong("BOARD_ID"));
				temp.setWriter(rs.getString("WRITER"));
				temp.setSubject(rs.getString("SUBJECT"));
				temp.setReadCnt(rs.getLong("READ_CNT"));
				temp.setEnrollDt(rs.getDate("ENROLL_DT"));
				boardList.add(temp);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		
		// 단위(Unit) 테스트
		System.out.println("getBoardList : " + boardList);
		
		return boardList;
		
	}
	
	
	public BoardDTO getBoardDetail(long boardId){
		
		BoardDTO boardDTO = new BoardDTO();
		
		try {
			
			getConnection();
			// 재사용이 많다보니 게시물을 볼 때만 카운트가 늘어나도록 if문 사용해서 바꿔보기
			String sql = """
				UPDATE BOARD 
				SET    READ_CNT = READ_CNT + 1
				WHERE  BOARD_ID = ?
					""";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, boardId);
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("SELECT * FROM BOARD WHERE BOARD_ID = ?");
			pstmt.setLong(1, boardId);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				boardDTO.setBoardId(rs.getLong("BOARD_ID"));
				boardDTO.setWriter(rs.getString("WRITER"));
				boardDTO.setEmail(rs.getString("EMAIL"));
				boardDTO.setSubject(rs.getString("SUBJECT"));
				boardDTO.setContent(rs.getString("CONTENT"));
				boardDTO.setReadCnt(rs.getLong("READ_CNT"));
				boardDTO.setEnrollDt(rs.getDate("ENROLL_DT"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		
		// 단위 테스트
		System.out.println("getBoardDetail : " + boardDTO);
		
		return boardDTO;
		
	}
	
	
	public boolean checkAuthenticationUser(BoardDTO boardDTO) {
		
		System.out.println("checkAuthenticationUser param : " + boardDTO);
		
		boolean isAuthenticationUser = false;
		
		try {
			
			getConnection();
			
			String sql ="""
				SELECT *
				FROM   BOARD
				WHERE  BOARD_ID = ?
				AND    PASSWORD = ?	
					""";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, boardDTO.getBoardId());
			pstmt.setString(2, boardDTO.getPassword());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				isAuthenticationUser = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		
		System.out.println("checkAuthenticationUser return : " + isAuthenticationUser);
		
		return isAuthenticationUser;
		
	}
	
	
	public void updateBoard(BoardDTO boardDTO) {
		
		System.out.println("updateBoard param : " + boardDTO);
		
		try {
			
			getConnection();
			String sql = """
				UPDATE BOARD
				SET    SUBJECT = ?,
				       CONTENT = ?
				WHERE  BOARD_ID = ?	
					""";
		    pstmt = conn.prepareStatement(sql);
		    pstmt.setString(1, boardDTO.getSubject());
		    pstmt.setString(2, boardDTO.getContent());
		    pstmt.setLong(3, boardDTO.getBoardId());
		    pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		
	}
	
public void deleteBoard(long boardId) {
		
		try {
			
			getConnection();
			pstmt = conn.prepareStatement("DELETE FROM BOARD WHERE BOARD_ID = ?");
			pstmt.setLong(1, boardId);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		
	}

	
	
	
}
