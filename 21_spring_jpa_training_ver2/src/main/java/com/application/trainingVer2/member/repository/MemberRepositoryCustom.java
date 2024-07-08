package com.application.trainingVer2.member.repository;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.application.trainingVer2.mapper.MemberDTO;
import com.application.trainingVer2.member.domain.Member;

public interface MemberRepositoryCustom {

	public String checkValidId(@Param("memberId") String memberId); // 아이디 중복확인
	public MemberDTO login(@Param("memberId") String memberId);		// 로그인
	public Long getTodayNewMemberCnt(@Param("today") String today); // 일자별 신규회원가입수조회
	public List<Member> getInActiveMemberList();					// 비활성화 회원전체조회
	
}
