package com.application.trainingVer2.postAdvance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.trainingVer2.postAdvance.dto.ReplyDTO;
import com.application.trainingVer2.postAdvance.service.ReplyService;

@Controller
@RequestMapping("/reply")
public class ReplyController {

	@Autowired
	private ReplyService replyService; // 댓글 서비스 객체 주입
	
	@GetMapping("/createReply") // localhost/post/createReply 요청시 매핑	 
	public String createReply(Model model , @RequestParam("postId") long postId) { // postId를 전달받는다.
		model.addAttribute("postId" , postId);	 // 데이터를 전달한다.
		return "postAdvance/reply/createReply";  // templates/postAdvance/post/createReply.html 포워딩(데이터포함)
	}
	
	
	@PostMapping("/createReply")  // createReply.html 파일에서 submit을 진행할 때 매핑
	@ResponseBody
	public String createReply(@ModelAttribute ReplyDTO replyDTO){  // ReplyDTO타입으로 관련정보를 전달받는다.
		
		replyService.createReply(replyDTO); // 전달받은 데이터를 서비스로 전달한다.
		
		// 응답(postDetail로 이동)
		String jsScript = "";
			jsScript += "<script>";
			jsScript += "alert('댓글이 등록되었습니다.');";
			jsScript += "location.href='/post/postDetail?postId=" + replyDTO.getPostId() + "';";
			jsScript += "</script>";
		
		return jsScript;

	}
	
	
	@GetMapping("/updateReply") // localhost/post/createReply 요청시 매핑
	public String updateReply(Model model , @RequestParam("replyId") long replyId) { // replyId를 전달받는다.
		
		model.addAttribute("replyDTO" , replyService.getReplyDetail(replyId)); // 1개의 댓글 정보를 조회한뒤 데이터를 반환한다.
		return "postAdvance/reply/updateReply";  // templates/postAdvance/post/updateReply.html 포워딩(데이터포함)
		
	}
	
	
	@PostMapping("/updateReply") // updateReply.html 파일에서 submit을 진행할 때 매핑
	@ResponseBody
	public String updateReply(@ModelAttribute ReplyDTO replyDTO) { // ReplyDTO타입으로 관련정보를 전달받는다.
		
		replyService.updateReply(replyDTO);  // 전달받은 데이터를 서비스로 전달한다.
		
		// 응답(postDetail로 이동)
		String jsScript = "";
			jsScript += "<script>";
			jsScript += "alert('수정되었습니다.');";
			jsScript += "location.href='/post/postDetail?postId=" + replyDTO.getPostId() + "';";
			jsScript += "</script>";
		
		return jsScript;
		
	}
	
	
	@GetMapping("/deleteReply")  // localhost/post/e 요청시 매핑
	@ResponseBody
	public String deleteReply(@RequestParam("replyId") long replyId) {  // replyId를 전달받는다.
		
		replyService.deleteReply(replyId); // 전달받은 데이터를 서비스로 전달한다.
		
		// 응답(한 페이지 뒤[postDetail]로 이동)
		String jsScript = """
			<script>
				history.go(-1);
			</script>	
				""";
		
		return jsScript;
		
	}
	
}
