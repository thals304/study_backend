package step02_member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import step02_member.dto.MemberDTO;

public class MemberDAO {
	
	// 싱글턴 패턴
	private MemberDAO() {}
    private static MemberDAO instance = new MemberDAO();
    public static MemberDAO getInstance() {
        return instance;
    }

	// 데이터베이스 연동객체 생성
	private Connection conn         = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs            = null;

	// 데이터베이스 연동 메서드 생성
	private void getConnection() {
		Context initctx;
		try {
			initctx = new InitialContext(); // 데이터베이스와 연결하기 위한 init객체 생성
			Context envctx = (Context) initctx.lookup("java:comp/env");  // lookup 메서드를 통해 context.xml 파일에 접근하여 자바환경 코드를 검색
			DataSource ds = (DataSource) envctx.lookup("jdbc/board"); 	 // <Context>태그안의 <Resource> 환경설정의 name이 jdbc/board인 것을 검색
			conn = ds.getConnection();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 데이터베이스 연동해지 메서드 생성
	private void getClose() {
		if (rs != null)    try {rs.close();} catch(SQLException e) {e.printStackTrace();}
		if (pstmt != null) try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
		if (conn!= null)   try {conn.close();} catch (SQLException e) {e.printStackTrace();}
	}
	
	// ID 중복 체크 메서드
	public boolean checkDuplicateId(String memberId) {
		boolean isDuple = false;
		
		try {
			getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM MEMBER WHERE MEMBER_ID = ?");
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				isDuple = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			getClose();
		}
		return isDuple;
	}
	
	public void registerMember(MemberDTO memberDTO) {
		try {
			getConnection();
			pstmt = conn.prepareStatement("INSERT INTO MEMBER VALUES(? , ? , ? , ? , ? , ? , ? , 'USER' , ? , ? , ? , ? , ? , ? , ? , ? , NOW())");
			pstmt.setString(1, memberDTO.getMemberId());
			pstmt.setString(2, memberDTO.getMemberNm());
			pstmt.setString(3, memberDTO.getPasswd());
			pstmt.setString(4, memberDTO.getProfile());
			pstmt.setString(5, memberDTO.getProfileUUID());
			pstmt.setString(6, memberDTO.getSex());
			pstmt.setString(7, memberDTO.getBirthAt());
			pstmt.setString(8, memberDTO.getHp());
			pstmt.setString(9, memberDTO.getSmsRecvAgreeYn());
			pstmt.setString(10, memberDTO.getEmail());
			pstmt.setString(11, memberDTO.getEmailRecvAgreeYn());
			pstmt.setString(12, memberDTO.getZipcode());
			pstmt.setString(13, memberDTO.getRoadAddress());
			pstmt.setString(14, memberDTO.getJibunAddress());
			pstmt.setString(15, memberDTO.getNamujiAddress());
			pstmt.executeUpdate();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			getClose();
		}
		
	}
}
