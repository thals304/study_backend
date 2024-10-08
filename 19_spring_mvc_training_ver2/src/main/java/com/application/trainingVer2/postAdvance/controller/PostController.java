package com.application.trainingVer2.postAdvance.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.trainingVer2.postAdvance.dto.PostDTO;
import com.application.trainingVer2.postAdvance.service.PostService;
import com.application.trainingVer2.postAdvance.service.ReplyService;
/*
 * 24.06.06-08 
 * 24.06.13
 * today 소감문
 * 모든 Post, Reply, User html에 session.userId != null 로 로그인 / 마이페이지, 로그아웃이 나눠지는 부분이 포함
 * Post   > [Post - 게시물 디테일 정보 보기 ] -> PostServiceImpl에서 @Transactional을 사용한 이유? 기능?
 *        > [Post - 게시물 수정]  -> mapper에서 수정할 수도 없는 userId를 if문으로 수정하게 한 이유? 
 * Reply  > [Reply  - 댓글 수정] -> mapper에서 수정할 수도 없는 userId를 if문으로 수정하게 한 이유? 
 * reply의 모든 컬럼들을 업데이트 시키지 않기 위해 (그렇다면 ReplyDTO에서 다른 컬럼들은 if문으로 안한 이유?)
 * User   > [User - 회원 정보 수정] -> html에서 profileUUID를 hidden으로 보내는 이유? 
 * 어차피 다시 업로드 하는 건데 수정하지 않았을 때 기존 profileUUID를 보내주기 위함인가? 그러면 mapper에서 부분 update로 profileUUID는 업데이트 안해주면 되는 것 아닌가?
 *        > [User - 회원 탈퇴] -> Controller(Post)에서 session 객체 생성하는 것이 아닌 html에서 session.userId를 hidden으로 전달해서 사용해도 되나? 
 * 모든 Admin html에 session.adminId != null로 공통화면, 로그아웃 나눠지는 부분 포함
 * Admin 
 * */

@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired								
	private PostService postService;	// 게시글 서비스 객체 주입
	
	@Autowired
	private ReplyService replyService; // 댓글 서비스 객체 주입
	
	@GetMapping("/postList") // localhost/post/postList 요청시 매핑	 
	public String postList(Model model) {
		
		model.addAttribute("allPostCnt" , postService.getAllPostCnt()); // 전체 게시글 수 전달
		model.addAttribute("postListMap" ,  postService.getPostList());	// 게시판관련정보 전달
		
		return "postAdvance/post/postList"; // templates/postAdvance/post/postList.html 포워딩(데이터포함)
		
	}
	
	@GetMapping("/createPost")  // localhost/post/createPost 요청시 매핑	 
	public String createPost(){
		return "postAdvance/post/createPost";  // templates/postAdvance/post/createPost.html 포워딩
	}
	
	@PostMapping("/createPost") // createPost.html 파일에서 submit을 진행할 때 매핑
	@ResponseBody
	public String createPost(@ModelAttribute PostDTO postDTO) { // PostDTO타입으로 관련정보를 전달받는다.
		
		postService.createPost(postDTO); // 전달받은 데이터를 서비스로 전달한다.
		
		// 응답(postList로 이동)
		String jsScript = """
				<script>
					alert('커뮤니티 게시글이 작성 되었습니다.');
					location.href = '/post/postList';
				</script>""";
			
		return jsScript;
		
	}
	
	@GetMapping("/postDetail") // localhost/post/postDetail 요청시 매핑	 
	public String postDetail(Model model , @RequestParam("postId") long postId){
		
		model.addAttribute("postMap" , postService.getPostDetail(postId , true)); // 1개의 게시글 관련정보 반환 (+조회수 증가)
		model.addAttribute("allReplyCnt" , replyService.getReplyCnt(postId));	  // 총 댓글의 갯수를 반환
		model.addAttribute("replyList" , replyService.getReplyList(postId));	 // 댓글 리스트를 반환
		
		return "postAdvance/post/postDetail"; // templates/postAdvance/post/postDetail.html 포워딩(데이터포함)
		
	}
	
	@GetMapping("/updatePost")  // localhost/post/updatePost 요청시 매핑
	public String updatePost(Model model , @RequestParam("postId") long postId) {
		
		model.addAttribute("postMap" , postService.getPostDetail(postId , false));  // 1개의 게시글 관련정보 반환 (+조회수 증가 x)
		
		return "postAdvance/post/updatePost"; // templates/postAdvance/post/updatePost.html 포워딩(데이터포함)
		
	}
	
	@PostMapping("/updatePost") // updatePost.html 파일에서 submit을 진행할 때 매핑
	@ResponseBody
	public String updatePost(@ModelAttribute PostDTO postDTO) {  // PostDTO타입으로 관련정보를 전달받는다.
		
		postService.updatePost(postDTO); // 전달받은 데이터를 서비스로 전달한다.
		
		// 응답(postList로 이동)
		String jsScript = """
				<script>
					alert('커뮤니티 게시글이 수정 되었습니다.');
					location.href = '/post/postList';
				</script>
				""";
		
		return jsScript;
		
	}
	
	@GetMapping("/deletePost")  // localhost/post/deletePost 요청시 매핑
	public String deletePost(Model model , @RequestParam("postId") long postId) { // postId를 전달받는다.
		model.addAttribute("postId" , postId); // postId를 전달한다.
		return "postAdvance/post/deletePost";  // templates/postAdvance/post/deletePost.html 포워딩(데이터포함)
	}
	
	@PostMapping("/deletePost") // deletePost.html 파일에서 submit을 진행할 때 매핑
	@ResponseBody
	public String postDeletePost(@RequestParam("postId") long postId) {  // postId를 전달받는다.
		
		postService.deletePost(postId); // 게시글을 삭제하는 서비스로직으로 postId를 전달한다.
		
		// 응답(postList로 이동)
		String jsScript = """
				<script>
					alert('커뮤니티 게시글이 삭제 되었습니다.');
					location.href = '/post/postList';
				</script>
				""";
		
		return jsScript;
		
	}
	
	
}
