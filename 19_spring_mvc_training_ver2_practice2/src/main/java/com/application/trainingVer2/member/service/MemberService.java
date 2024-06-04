package com.application.trainingVer2.member.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.application.trainingVer2.member.dto.MemberDTO;

public interface MemberService {

	// 아이디 중복 확인
	public String checkValidId(String memberId);
	
	// 회원가입
	public void createMember(MultipartFile uploadProfile , MemberDTO memberDTO) throws IllegalStateException, IOException ;

	// 로그인
	public boolean login(MemberDTO memberDTO);
	
	// 회원 디테일 정보 가져오기
	public MemberDTO getMemberDetail(String memberId);
	
	// 수정하기
	public void updateMember(MultipartFile uploadProfile, MemberDTO memberDTO) throws IllegalStateException, IOException;
	
	// 회원 탈퇴 > 비활성 회원으로 만들기
	public void updateInactiveMember(String memberId);
	
	// 스케쥴링 - 신규 회원 수
	public void getTodayNewMemberCnt();
	
	// 스케쥴링 - 비활성화 회원 삭제
	public void deleteMemberScheduler();
}
