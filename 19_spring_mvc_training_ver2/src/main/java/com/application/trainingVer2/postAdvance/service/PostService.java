package com.application.trainingVer2.postAdvance.service;

import java.util.List;
import java.util.Map;

import com.application.trainingVer2.postAdvance.dto.PostDTO;

public interface PostService {
	
	public List<Map<String,Object>> getPostList();									  // 게시글 전체조회 서비스
	public int getAllPostCnt();														  // 전체게시글 개수 조회 서비스
	public Map<String,Object> getPostDetail(long postId , boolean isIncreaseReadCnt); // 1개의 게시글 상세조회 서비스
	public void createPost(PostDTO postDTO);										  // 게시글 작성 서비스
	public void updatePost(PostDTO postDTO); 										  // 게시글 수정 서비스
	public void deletePost(long postId);  											  // 게시글 삭제 서비스
	
}
