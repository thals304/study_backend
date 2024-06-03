package com.application.trainingVer2.postAdvance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.trainingVer2.postAdvance.dto.AdminDTO;
import com.application.trainingVer2.postAdvance.service.AdminService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService; // AdminService 객체 주입
	
	@GetMapping("/signIn") // localhost/admin/signIn 요청시 매핑
	public String signIn() {
		return "postAdvance/admin/adminSignIn"; // templates/postAdvance/admin/adminSignIn.html 파일로 포워딩
	}
	
	@PostMapping("/signIn") // adminSignIn.html 파일에서 로그인 진행할 때 매핑
	@ResponseBody		// 전송된 데이터를 받는다.			session에 등록하기 위해 작성한다.
	public String signIn(@RequestBody AdminDTO adminDTO , HttpServletRequest request) {
		
		String isValidUser = "n";					// 초기값 : 인증 x
		AdminDTO resultDTO = adminService.signIn(adminDTO);
		if (resultDTO != null) {		// adminService에서 인증여부를 확인한 후 인증이 되었을 경우
			
			HttpSession session = request.getSession();					
			session.setAttribute("adminId", resultDTO.getAdminId());  // session 객체에 adminId를 저장한다.
			session.setAttribute("role", resultDTO.getRole()); 		  // session 객체에 role을 저장한다.
			
			isValidUser = "y";  // 인증 o
			
		} 
		
		return isValidUser; // 로그인 여부 ('y' or 'n')을 adminSignIn.html파일의 AJAX success 콜백함수로 반환
		
	}
	
	@GetMapping("/main")  // localhost/admin/signIn 요청시 매핑(접근제어)
	public String main() {
		return "postAdvance/admin/adminMain";  // templates/postAdvance/admin/adminMain.html 파일로 포워딩
	}
	
	@GetMapping("/signOut") // localhost/admin/signOut 요청시 매핑
	@ResponseBody
	public String signOut(HttpServletRequest request) {
		
		HttpSession session = request.getSession(); // 세션객체 생성
		session.invalidate(); // 세션 삭제
		
		// 응답(postList)로 이동
		String jsScript = """
				<script>
					alert('로그아웃 되었습니다.');
					location.href = '/post/postList';
				</script>""";
			
		return jsScript;
		
	}
	
	@GetMapping("/adminUserList")  // localhost/admin/adminUserList 요청시 매핑(접근제어)
	public String adminUserList(Model model) {
		model.addAttribute("userList" , adminService.getUserList());	// 유저관련 전체데이터를 전달
		return "postAdvance/admin/adminUserList";  // templates/postAdvance/admin/adminUserList.html 파일로 포워딩(데이터포함)
	}
	
	@GetMapping("/adminPostList")  // localhost/admin/adminPostList 요청시 매핑(접근제어)
	public String adminPostList(Model model) {
		model.addAttribute("postList" , adminService.getPostList()); // 게시글관련 전체데이터를 전달한
		return "postAdvance/admin/adminPostList"; // templates/postAdvance/admin/adminPostList.html 파일로 포워딩(데이터포함)
	}
	
	@GetMapping("/adminReplyList")  // localhost/admin/adminReplyList 요청시 매핑(접근제어)
	public String adminReplyList(Model model) {
		model.addAttribute("replyList" , adminService.getReplyList());  // 댓글관련 전체데이터를 전달
		return "postAdvance/admin/adminReplyList"; // templates/postAdvance/admin/adminReplyList.html 파일로 포워딩(데이터포함)
	}
	
	@GetMapping("/dailyNewUserCnt")  // localhost/admin/dailyNewUserCnt 요청시 매핑(접근제어)
	public String dailyNewUserCnt(Model model) {
		model.addAttribute("dailyNewUserCntMap" , adminService.getDailyNewUserCnt()); // 일자별 신규회원가입 숫자데이터를 전달
		return "postAdvance/admin/dailyNewUserCnt"; // templates/postAdvance/admin/dailyNewUserCnt.html 파일로 포워딩(데이터포함)
	}
	
	@GetMapping("/dailyPostCnt") // localhost/admin/dailyPostCnt 요청시 매핑(접근제어)
	public String dailyPostCnt(Model model) {
		model.addAttribute("dailyPostCntMap" , adminService.getDailyPostCnt());  // 일자별 게시글작성 숫자데이터를 전달
		return "postAdvance/admin/dailyPostCnt"; // templates/postAdvance/admin/dailyPostCnt.html 파일로 포워딩(데이터포함)
	}
	
	@GetMapping("/dailyReplyCnt") // localhost/admin/dailyPostCnt 요청시 매핑(접근제어)
	public String dailyReplyCnt(Model model) {
		model.addAttribute("dailyReplyCntMap" , adminService.getDailyReplyCnt()); // 일자별 댓글작성 숫자데이터를 전달
		return "postAdvance/admin/dailyReplyCnt"; // templates/postAdvance/admin/dailyReplyCnt.html 파일로 포워딩(데이터포함)
	}
	
}
