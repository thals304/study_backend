package com.application.trainingVer2.postAdvance.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.application.trainingVer2.postAdvance.dto.AdminDTO;
import com.application.trainingVer2.postAdvance.dto.PostDTO;
import com.application.trainingVer2.postAdvance.dto.ReplyDTO;
import com.application.trainingVer2.postAdvance.dto.UserDTO;

@Mapper
public interface AdminDAO {

	public AdminDTO signIn(AdminDTO adminDTO); // Admin 로그인 

	public List<UserDTO> getUserList();   // 유저 전체정보 조회
	public List<PostDTO> getPostList();   // 게시글 전체정보 조회
	public List<ReplyDTO> getReplyList(); // 댓글 전체정보 조회 
	
	public List<Map<String , Object>> getDailyNewUserCnt(); // 일자별 신규가입 회원숫자 조회 
	public List<Map<String , Object>> getDailyPostCnt();    // 일자별 게시글작성 숫자 조회
	public List<Map<String , Object>> getDailyReplyCnt();   // 일자별 댓글작성 숫자 조회
	
}
