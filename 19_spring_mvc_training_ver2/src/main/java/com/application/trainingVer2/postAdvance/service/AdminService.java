package com.application.trainingVer2.postAdvance.service;

import java.util.List;
import java.util.Map;

import com.application.trainingVer2.postAdvance.dto.AdminDTO;
import com.application.trainingVer2.postAdvance.dto.PostDTO;
import com.application.trainingVer2.postAdvance.dto.ReplyDTO;
import com.application.trainingVer2.postAdvance.dto.UserDTO;

public interface AdminService {

	public AdminDTO signIn(AdminDTO adminDTO);	// Admin 로그인 서비스

	public List<UserDTO> getUserList(); 		// 유저 전체정보 조회 서비스
	public List<PostDTO> getPostList(); 		// 게시글 전체정보 조회 서비스
	public List<ReplyDTO> getReplyList(); 		// 댓글 전체정보 조회 서비스
	 
	public List<Map<String , Object>> getDailyNewUserCnt(); // 일자별 신규가입 회원숫자 조회 서비스 
	public List<Map<String , Object>> getDailyPostCnt();    // 일자별 게시글작성 숫자 조회 서비스
	public List<Map<String , Object>> getDailyReplyCnt();   // 일자별 댓글작성 숫자 조회 서비스
	
}
