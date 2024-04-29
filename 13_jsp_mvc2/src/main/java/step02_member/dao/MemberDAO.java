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
    
    private Connection conn 		= null;
    private PreparedStatement pstmt = null;
    private ResultSet rs 			= null;
    
    // Database 연결 메서드
    private void getConnection() {
        
    	try {
    		
    		/*
			
				이클립스에서 Servers폴더에 있는 Context.xml파일에 아래의 설정 추가 
			
				<Resource 
					auth="Container" 
					driverClassName="com.mysql.cj.jdbc.Driver"
					type="javax.sql.DataSource"
					url="jdbc:mysql://localhost:3306/MVC2_PRACTICE?serverTimezone=Asia/Seoul&amp;useSSL=false"
					name="jdbc/member" 
					username="root"
					password="0000" 
					loginTimeout="10" 
					maxWait="5000" 
				/> 
			
			 */
    		
    		Context initCtx = new InitialContext();
    		Context envCtx = (Context)initCtx.lookup("java:comp/env");
    		DataSource ds = (DataSource)envCtx.lookup("jdbc/member");
    		conn = ds.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }
    
    // Database 연결 해지 메서드
    private void getClose() {
    	if (rs != null)    {try {rs.close();}   catch (SQLException e) {}}
    	if (pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
        if (conn != null)  {try {conn.close();}  catch (SQLException e) {}}
    }
    
    
    // ID 중복확인 메서드
    public boolean checkDuplicateId(String memberId) {
    	
    	boolean isDuple = false;
    	
    	try {
    		
			getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM MEMBER WHERE MEMBER_ID = ?");
			pstmt.setString(1 , memberId);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				isDuple = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
    	
    	return isDuple;
    	
    }
    
    
    // 회원가입 메서드
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
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
    	
    }
    
    
    // 로그인 메서드
    public boolean loginMember(MemberDTO memberDTO) {
    	
    	boolean isLogin = false;
    	
    	try {
    		
			getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM MEMBER WHERE MEMBER_ID = ? AND PASSWD = ?");
			pstmt.setString(1, memberDTO.getMemberId());
			pstmt.setString(2, memberDTO.getPasswd());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				isLogin = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
    	
    	return isLogin;
    	
    }
    
    
    // 회원정보 상세조회 메서드
    public MemberDTO getMemberDetail(String memberId) {
        
    	MemberDTO memberDTO = null;
        
    	try {
    		
            getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM MEMBER WHERE MEMBER_ID = ?");
            pstmt.setString(1, memberId);
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
            	memberDTO = new MemberDTO(); 
            	memberDTO.setMemberId(rs.getString("MEMBER_ID"));
            	memberDTO.setMemberNm(rs.getString("MEMBER_NM"));
            	memberDTO.setProfileUUID(rs.getString("PROFILE_UUID"));
            	memberDTO.setSex(rs.getString("SEX"));
            	memberDTO.setBirthAt(rs.getString("BIRTH_AT"));
            	memberDTO.setRole(rs.getString("ROLE"));
            	memberDTO.setHp(rs.getString("HP"));
            	memberDTO.setSmsRecvAgreeYn(rs.getString("SMS_RECV_AGREE_YN"));
            	memberDTO.setEmail(rs.getString("EMAIL"));
            	memberDTO.setEmailRecvAgreeYn(rs.getString("EMAIL_RECV_AGREE_YN"));
            	memberDTO.setZipcode(rs.getString("ZIPCODE"));
            	memberDTO.setRoadAddress(rs.getString("ROAD_ADDRESS"));
            	memberDTO.setJibunAddress(rs.getString("JIBUN_ADDRESS"));
            	memberDTO.setNamujiAddress(rs.getString("NAMUJI_ADDRESS"));
            	memberDTO.setJoinAt(rs.getDate("JOIN_AT"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	getClose();
        }
    	
        return memberDTO;
    
    }
    
    
    
    // 회원탈퇴 메서드
    public void deleteMember(String memberId) {
    	
    	try {
    		
    		getConnection();
    		pstmt = conn.prepareStatement("DELETE FROM MEMBER WHERE MEMBER_ID = ?");
    		pstmt.setString(1, memberId);
    		pstmt.executeUpdate();
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	} finally {
    		getClose();
    	}
    	
    }
    
    
    
    // 회원정보 수정 메서드
    public void updateMember(MemberDTO memberDTO) {
        
    	try {
    		
            getConnection();
            String sql = """
            		UPDATE MEMBER 
            		SET	   MEMBER_NM = ?,
            			   SEX = ?,
            		       BIRTH_AT = ?,
            		       HP = ?,
            		       SMS_RECV_AGREE_YN = ?,
            		       EMAIL = ?,
            		       EMAIL_RECV_AGREE_YN = ?,
            		       ZIPCODE = ?,
            		       ROAD_ADDRESS = ?,
            		       JIBUN_ADDRESS = ?,
            		       NAMUJI_ADDRESS = ?""";
            
            // 파일을 다시 업데이트 해줬을 때
            if (memberDTO.getProfile() != null) { 
            	sql += """ 
            			,
            			PROFILE = ? ,
            			PROFILE_UUID = ?
            			""";
            }
            
            
            sql += "WHERE MEMBER_ID = ?";
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memberDTO.getMemberNm());
            pstmt.setString(2, memberDTO.getSex());
            pstmt.setString(3, memberDTO.getBirthAt());
            pstmt.setString(4, memberDTO.getHp());
            pstmt.setString(5, memberDTO.getSmsRecvAgreeYn());
			pstmt.setString(6, memberDTO.getEmail());
			pstmt.setString(7, memberDTO.getEmailRecvAgreeYn());
            pstmt.setString(8, memberDTO.getZipcode());
            pstmt.setString(9, memberDTO.getRoadAddress());
            pstmt.setString(10, memberDTO.getJibunAddress());
            pstmt.setString(11, memberDTO.getNamujiAddress());
            if (memberDTO.getProfile() == null) {
            	pstmt.setString(12, memberDTO.getMemberId());
            	
            }
            else {
            	pstmt.setString(12, memberDTO.getProfile());
            	pstmt.setString(13, memberDTO.getProfileUUID());
            	pstmt.setString(14, memberDTO.getMemberId());
            }
            pstmt.executeUpdate();
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
        	getClose();
        }
    	
    }
   
    
    
}
