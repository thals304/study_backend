package com.application.trainingVer2.postAdvance.service;

import java.util.List;

import com.application.trainingVer2.postAdvance.dto.ReplyDTO;

public interface ReplyService {

	public List<ReplyDTO> getReplyList(long postId);	// 1개의 게시글의 전체 댓글 조회 서비스
	public int getReplyCnt(long postId);				// 1개의 게시글의 전체 댓글 개수 조회 서비스
	public ReplyDTO getReplyDetail(long replyId);		// 1개의 댓글 상세정보 조회 서비스
	public void createReply(ReplyDTO replyDTO);			// 댓글 작성 서비스
	public void updateReply(ReplyDTO replyDTO);			// 댓글 수정 서비스
	public void deleteReply(long replyId);				// 댓글 삭제 서비스
	
}
