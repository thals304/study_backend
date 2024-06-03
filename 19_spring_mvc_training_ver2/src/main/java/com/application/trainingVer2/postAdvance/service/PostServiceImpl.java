package com.application.trainingVer2.postAdvance.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.trainingVer2.postAdvance.dao.PostDAO;
import com.application.trainingVer2.postAdvance.dto.PostDTO;

@Service		
public class PostServiceImpl implements PostService {

	@Autowired				
	private PostDAO postDAO;

	/* 게시글 전체조회 서비스 */
	@Override
	public List<Map<String,Object>> getPostList(){
		return postDAO.getPostList();
	}
	
	/* 전체게시글 개수 조회 서비스 */
	@Override
	public int getAllPostCnt() {
		return postDAO.getAllPostCnt();
	}

	/*  1개의 게시글 상세조회 서비스 */
	@Override
	@Transactional
	public Map<String,Object> getPostDetail(long postId, boolean isIncreaseReadCnt) {
		if (isIncreaseReadCnt) { // 조회수 증가 변수가 true이면
			postDAO.updateReadCnt(postId); // 조회수 증가
		}
		return postDAO.getPostDetail(postId); // 1개의 게시글데이터 반환
	}	
	
	/* 게시글 작성 서비스 */
	@Override
	public void createPost(PostDTO postDTO) {
		postDAO.createPost(postDTO);
	}
	
	/* 게시글 수정 서비스 */
	@Override
	public void updatePost(PostDTO postDTO) {
		postDAO.updatePost(postDTO);
	}

	/* 게시글 삭제 서비스 */
	@Override
	public void deletePost(long postId) {
		postDAO.deletePost(postId);
	}
	
}
