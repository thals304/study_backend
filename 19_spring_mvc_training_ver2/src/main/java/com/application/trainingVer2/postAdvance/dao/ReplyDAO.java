package com.application.trainingVer2.postAdvance.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.application.trainingVer2.postAdvance.dto.ReplyDTO;

@Mapper
public interface ReplyDAO {
	
	public int getReplyCnt(long postId);
	public List<ReplyDTO> getReplyList(long postId);
	public ReplyDTO getReplyDetail(long replyId);
	public void createReply(ReplyDTO replyDTO);
	public void updateReply(ReplyDTO replyDTO);
	public void deleteReply(long replyId);
	
}
