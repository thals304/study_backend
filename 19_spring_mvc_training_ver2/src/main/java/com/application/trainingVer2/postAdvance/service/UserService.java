package com.application.trainingVer2.postAdvance.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.application.trainingVer2.postAdvance.dto.UserDTO;


public interface UserService {

	public void signUp(MultipartFile uploadProfile , UserDTO userDTO) throws IllegalStateException, IOException;	// 회원가입 서비스
	public String checkValidId(String memberId) ;		// 아이디 중복체크 서비스
	public String checkValidNickName(String nickname) ; // 닉네임 중복체크 서비스
	public UserDTO signIn(UserDTO userDTO) ; // 로그인 서비스
	public UserDTO getUserDetail(String memberId); // 유저 상세정보 조회 서비스
	public void updateUser(MultipartFile uploadProfile , UserDTO userDTO) throws IllegalStateException, IOException; // 유저정보 수정 서비스
	public void updatePasswd(UserDTO userDTO);	// 비밀번호 변경 서비스
	public void deleteUser(String userId);	// 회원탈퇴 서비스
	public int myPostCnt(String userId);	// 내가 작성한 게시글개수 조회 서비스
	public int myReplyCnt(String userId);   // 내가 작성한 댓글개수 조회 서비스
	
}
