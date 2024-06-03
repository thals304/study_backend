package com.application.trainingVer2.postAdvance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.trainingVer2.postAdvance.dao.ReplyDAO;
import com.application.trainingVer2.postAdvance.dto.ReplyDTO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDAO replyDAO; // ReplyDAO 객체 주입
	
	/*  1개의 게시글의 전체 댓글 조회 */
	@Override
	public List<ReplyDTO> getReplyList(long postId) {
		return replyDAO.getReplyList(postId);
	}
	
	/* 1개의 게시글의 전체 댓글 개수 조회 */
	@Override
	public int getReplyCnt(long postId) {
		return replyDAO.getReplyCnt(postId);
	}
	
	/* 1개의 댓글 상세정보 조회 */
	@Override
	public ReplyDTO getReplyDetail(long replyId) {
		return replyDAO.getReplyDetail(replyId);
	}
	
	/* 댓글 작성 */
	@Override
	public void createReply(ReplyDTO replyDTO) {
		replyDAO.createReply(replyDTO);
	}

	/* 댓글 수정 */
	@Override
	public void updateReply(ReplyDTO replyDTO) {
		replyDAO.updateReply(replyDTO);
	}

	/* 댓글 삭제 */
	@Override
	public void deleteReply(long replyId) {
		replyDAO.deleteReply(replyId);
	}
	
}
