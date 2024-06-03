package com.application.trainingVer2.postAdvance.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.trainingVer2.postAdvance.dao.AdminDAO;
import com.application.trainingVer2.postAdvance.dto.AdminDTO;
import com.application.trainingVer2.postAdvance.dto.PostDTO;
import com.application.trainingVer2.postAdvance.dto.ReplyDTO;
import com.application.trainingVer2.postAdvance.dto.UserDTO;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDAO; // AdminDAO객체 주입
	
	/* Admin 로그인 */
	@Override
	public AdminDTO signIn(AdminDTO adminDTO) {
		return adminDAO.signIn(adminDTO);
	}
	
	/* 유저 전체정보 조회 */
	@Override
	public List<UserDTO> getUserList() {
		return adminDAO.getUserList();
	}
	
	/* 게시글 전체정보 조회 */
	@Override
	public List<PostDTO> getPostList() {
		return adminDAO.getPostList();
	}
	
	/*  댓글 전체정보 조회 */
	@Override
	public List<ReplyDTO> getReplyList() {
		// TODO Auto-generated method stub
		return adminDAO.getReplyList();
	}
	
	/* 일자별 신규가입 회원숫자 조회 */
	@Override
	public List<Map<String, Object>> getDailyNewUserCnt() {
		return adminDAO.getDailyNewUserCnt();
	}
	
	/* 일자별 게시글작성 숫자 조회 */
	@Override
	public List<Map<String, Object>> getDailyPostCnt() {
		return adminDAO.getDailyPostCnt();
	}
	
	/* 일자별 댓글작성 숫자 조회 */
	@Override
	public List<Map<String, Object>> getDailyReplyCnt() {
		return adminDAO.getDailyReplyCnt();
	}

}
