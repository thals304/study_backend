package com.application.trainingVer2.member.repository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.application.trainingVer2.mapper.MemberDTO;
import com.application.trainingVer2.member.domain.Member;
import com.application.trainingVer2.member.domain.QMember;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class MemberRepositoryImpl implements MemberRepositoryCustom {

	@Autowired
	private JPAQueryFactory queryFactory; // JPAQueryFactory 객체 주입
	
	QMember member = QMember.member;   // Q Class 주입
	
	/* 중복된 아이디 조회 Repository */
	@Override
	public String checkValidId(String memberId) {  
		return queryFactory
				.select(member.memberId)
				.from(member)
				.where(member.memberId.eq(memberId))
				.fetchOne();
	}
	
	/* 로그인 조회 Repository */
	@Override
	public MemberDTO login(String memberId) {
		Tuple result =  queryFactory
						.select(member.passwd , member.activeYn)
						.from(member)
						.where(member.memberId.eq(memberId))
						.fetchOne();
		
		MemberDTO memberDTO  = null;
		if (result != null) {
			// DTO 타입으로 매핑후 반환
			memberDTO  = new MemberDTO();				
			memberDTO.setPasswd(result.get(member.passwd));
			memberDTO.setActiveYn(result.get(member.activeYn));
		}
		
		return memberDTO;
		
	}

	/* 로그인 조회 Repository */
	@Override
	public Long getTodayNewMemberCnt(String today) {
		
		return queryFactory
			   .select(member.memberId.count())
			   .from(member)
			   .where(Expressions.stringTemplate("DATE_FORMAT({0}, {1})", member.joinAt, "%Y-%m-%d").eq(today))
			   .fetchOne();
	}

	@Override
	public List<Member> getInActiveMemberList() {
		
		LocalDate temp = LocalDate.now().minusDays(90);
		Date daysAgo90 = Date.from(temp.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		System.out.println(daysAgo90);
		
		List<Tuple> tuples = queryFactory
						        .select(member.memberId , member.profileUuid)
						        .from(member)
						        .where(member.inactiveAt.before(daysAgo90))
						        .fetch();
	
		List<Member> members = new ArrayList<Member>();
		
		for (Tuple tuple : tuples) {
			Member entity = new Member();
			entity.setMemberId(tuple.get(member.memberId));
			entity.setProfileUuid(tuple.get(member.profileUuid));
			members.add(entity);
		}
		
		return members;
		
	}

}
