package com.application.trainingVer2.member.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.application.trainingVer2.member.dto.MemberDTO;

public interface MemberService {

	public String checkValidId(String memberId);
	
	public void createMember(MultipartFile uploadProfile , MemberDTO memberDTO) throws IllegalStateException, IOException;
	
	public boolean login(MemberDTO memberDTO);
	
	public MemberDTO getMemberDetail(String memberId);
	
	public void updateMember(MultipartFile uploadProfile , MemberDTO memberDTO) throws IllegalStateException, IOException;

	public void updateInactiveMember(String memberId);
	
	public void getTodayNewMemberCnt();
	public void deleteMemberScheduler();
}
