package com.application.trainingVer2.member.dao;

import org.apache.ibatis.annotations.Mapper;

import com.application.trainingVer2.member.dto.MemberDTO;

@Mapper
public interface MemberDAO {

	public String checkValidId(String memberId);
	
	public void createMember(MemberDTO memberDTO);
	
}
