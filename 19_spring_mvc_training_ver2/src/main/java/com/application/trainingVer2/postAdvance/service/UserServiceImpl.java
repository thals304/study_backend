package com.application.trainingVer2.postAdvance.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.application.trainingVer2.postAdvance.dao.UserDAO;
import com.application.trainingVer2.postAdvance.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	@Value("${file.repo.path}")         // application.properties파일의 file.repo.path=c:/spring_member_profile/ 주입
    private String fileRepositoryPath;  // c:/spring_member_profile
	
	@Autowired
	private UserDAO userDAO; // UserDAO 객체 주입
	
	@Autowired
	private PasswordEncoder passwordEncoder; // SecurityConfig클래스의 new BCryptPasswordEncoder(); 객체 주입
	
	/* 회원가입 서비스 */
	@Override 
	public void signUp(MultipartFile uploadProfile , UserDTO userDTO) throws IllegalStateException, IOException  {
		
		if (!uploadProfile.isEmpty()) { 													 // 업로드된 파일이 있으면
			String originalFilename = uploadProfile.getOriginalFilename();					 // 원본파일명을 구한다.
			userDTO.setProfileOriginalName(originalFilename);								 // userDTO에 저장한다.
			
			String extension = originalFilename.substring(originalFilename.lastIndexOf(".")); // 확장자를 구한다.
			
			String uploadFile = UUID.randomUUID() + extension;								  // 'UUID.확장자' 형태로 중복되지 않는 파일명을 만든다.
			userDTO.setProfileUUID(uploadFile);											  // userDTO에 저장한다.
			
			uploadProfile.transferTo(new File(fileRepositoryPath + uploadFile));			  // 새로운파일명으로 파일을 최종적으로 업로드한다.
			
		}
		
		
		userDTO.setPasswd(passwordEncoder.encode(userDTO.getPasswd())); 				 // 전송된 비밀번호를 암호화하여 userDTO에 다시 저장한다.
		
		userDAO.signUp(userDTO);													 // 데이터를 DAO로 전달한다.
		
	}

	
	/* 아이디 중복체크 서비스 */
	@Override
	public String checkValidId(String userId)  {  
		
		String isValidId = "n";	   					  // 유효여부 변수 (초깃값 'n')
		if (userDAO.checkValidId(userId) == null) {  // DAO에서 조회결과가 없을 경우
			isValidId = "y";						 // 유효여부 변수 'y'
		}
		
		return isValidId; // 유효여부('y' or 'n') 반환
		
	}
	
	
	/* 닉네임 중복체크 서비스 */
	@Override
	public String checkValidNickName(String nickname) {
		String isValidNickName = "n";	   						// 유효여부 변수 (초깃값 'n')
		if (userDAO.checkValidNickName(nickname) == null) {  	// DAO에서 조회결과가 없을 경우
			isValidNickName = "y";							    // 유효여부 변수 'y'
		}
		return isValidNickName; // 유효여부('y' or 'n') 반환
	}
	
	
	/* 로그인 서비스 */
	@Override
	public UserDTO signIn(UserDTO userDTO)  { 
		
		UserDTO resultDTO = userDAO.signIn(userDTO.getUserId());
		
		if (resultDTO != null) { // 조회결과가 있으면
			// 화면에서 전송된 비밀번호와 암호화된 패스워드가 일치하면
			if (passwordEncoder.matches(userDTO.getPasswd() ,resultDTO.getPasswd())) {
				return resultDTO; // 유저정보가 저장되어있는 DTO를 반환
			} 
		}
		
		return null; // 조회결과가 없거나 패스워드가 일치하지 않으면 null을 반환
		
	}
	
	
	/* 유저 상세정보 조회 서비스 */
	@Override
	public UserDTO getUserDetail(String userId)  {
		return userDAO.getUserDetail(userId); // DAO에서 1명의 유저에 관한 정보를 조회하여 반환
	}
	
	
	/* 유저정보 수정 서비스 */
	@Override
	public void updateUser(MultipartFile uploadProfile , UserDTO userDTO) throws IllegalStateException, IOException  {
		
		if (!uploadProfile.isEmpty()) { 														// 업로드된 파일이 있으면		
			
			new File(fileRepositoryPath + userDTO.getProfileUUID()).delete(); 				// 기존의 이미지 파일을 삭제한다.
			
			String originalFilename = uploadProfile.getOriginalFilename();						// 원본파일명을 구한다.
			userDTO.setProfileOriginalName(originalFilename);									// userDTO에 저장한다.
			
			String extension = originalFilename.substring(originalFilename.lastIndexOf("."));   // 확장자를 구한다.
			
			String uploadFile = UUID.randomUUID() + extension;									// 'UUID.확장자' 형태로 중복되지 않는 파일명을 만든다.
			userDTO.setProfileUUID(uploadFile);												// userDTO에 저장한다.
			
			
			uploadProfile.transferTo(new File(fileRepositoryPath + uploadFile));				// 새로운파일명으로 파일을 최종적으로 업로드한다.
			
		}
		
		userDAO.updateUser(userDTO);														// 데이터를 DAO로 전달한다.			
	
	}

	
	/* 비밀번호 변경 서비스 */
	@Override
	public void updatePasswd(UserDTO userDTO) {
		userDTO.setPasswd(passwordEncoder.encode(userDTO.getPasswd())); // 화면에서 전송된 패스워드 데이터를 암호화하여 다시 DTO에 저장한다.
		userDAO.updatePasswd(userDTO); // DAO로 암호화된 패스워드와 유저아이디를 전달한다.
	}
	
	
	/* 회원탈퇴 서비스 */
	@Override
	@Transactional
	public void deleteUser(String userId) {
		
		String deleteProfile = userDAO.getDeleteUserProfile(userId); // 유저의 프로필을 조회한다.
		new File(fileRepositoryPath + deleteProfile).delete();		 // 유저의 프로필을 삭제한다.
 		userDAO.deleteUser(userId);		// 유저를 삭제한다.
		userDAO.deletePost(userId);		// 유저가 작성한 게시글을 삭제한다.
		userDAO.deleteReply(userId);	// 유저가 작성한 댓글을 삭제한다.
		
	}

	
	/*  내가 작성한 게시글개수 조회 서비스 */
	@Override
	public int myPostCnt(String userId) {
		return userDAO.myPostCnt(userId);	// 내가 작성한 게시글의 개수를 반환한다.
	}

	
	/* 내가 작성한 댓글개수 조회 서비스 */
	@Override
	public int myReplyCnt(String userId) {
		return userDAO.myReplyCnt(userId); // 내가 작성한 댓글의 개수를 반환한다.
	}
	
}
