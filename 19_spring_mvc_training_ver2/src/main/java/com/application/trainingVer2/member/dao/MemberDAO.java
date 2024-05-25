package com.application.trainingVer2.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.application.trainingVer2.member.dto.MemberDTO;

@Mapper
public interface MemberDAO {

	public void createMember(MemberDTO memberDTO);  	// 회원가입 DAO
	public String checkValidId(String memberId); 		// (회원가입) 아이디 중복체크 DAO 
	public MemberDTO login(String memberId);			// 로그인 DAO
	public MemberDTO getMemberDetail(String memberId);	// 회원정보 상세조회 DAO
	public void updateMember(MemberDTO memberDTO);		// 회원정보 수정 DAO
	public void updateInactiveMember(String memberId);  // 회원탈퇴(활성화 > 비활성화) DAO
	
	public int getTodayNewMemberCnt(String today); 		// 하루 신규회원수 조회 DAO
	public List<MemberDTO> getInActiveMemberList();		// 비활성화 회원 전체조회 DAO
	public void deleteMember(String memberId);			// 회원삭제 DAO
	
}
