package com.application.trainingVer2.postAdvance.dao;

import org.apache.ibatis.annotations.Mapper;

import com.application.trainingVer2.postAdvance.dto.UserDTO;

@Mapper
public interface UserDAO {

	public void signUp(UserDTO userDTO); // 회원가입

	public String checkValidId(String userId); // 아이디 중복체크

	public String checkValidNickName(String nickname); // 닉네임 중복체크

	public UserDTO signIn(String userId); // 로그인

	public UserDTO getUserDetail(String userId); // 유저 상세정보 조회

	public void updateUser(UserDTO userDTO); // 유저정보 수정
	public void updatePasswd(UserDTO userDTO); // 비밀번호 변경
	
	public String getDeleteUserProfile(String userId); // (회원탈퇴)회원탈퇴할 유저의 프로필 조회
	public void deleteUser(String userId);	// (회원탈퇴)유저정보 삭제
	public void deletePost(String userId);  // (회원탈퇴)유저가 작성한 게시글 삭제
	public void deleteReply(String userId); // (회원탈퇴)유저가 작성한 댓글 삭제

	public int myPostCnt(String userId); // 내가 작성한 게시글개수 조회
	public int myReplyCnt(String userId); // 내가 작성한 댓글개수 조회
	
}
