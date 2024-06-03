package com.application.trainingVer2.postAdvance.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.application.trainingVer2.postAdvance.dto.PostDTO;

@Mapper
public interface PostDAO {

	public List<Map<String,Object>> getPostList(); 			// 게시글 전체조회
	public int getAllPostCnt();								// 전체게시글 개수 조회
	public Map<String,Object> getPostDetail(long postId);	// 1개의 게시글 상세조회
	public void updateReadCnt(long postId);					// 조회수 증가
	public void createPost(PostDTO postDTO);				// 게시글 작성
	public void updatePost(PostDTO postDTO);				// 게시글 수정
	public void deletePost(long postId);					// 게시글 삭제
	
}
