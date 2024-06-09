package com.application.trainingVer2.postAdvance.controller;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.application.trainingVer2.postAdvance.dto.UserDTO;
import com.application.trainingVer2.postAdvance.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

	@Value("${file.repo.path}")        // application.properties파일의 file.repo.path=c:/spring_member_profile/ 이미지파일 저장경로 주입
    private String fileRepositoryPath; // c:/spring_member_profile

	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/signUp")  // localhost/user/signUp 요청시 매핑
	public String signUp() {
		return "postAdvance/user/signUp"; // templates/postAdvance/user/signUp.html 파일로 포워딩
	}
	
	
	@PostMapping("/signUp") //signUp.html 파일에서 회원가입 진행할 때 매핑
						    // 파일은 MultipartFile로 받는다.								 // DTO관련 데이터는 DTO로 전송받는다.
	@ResponseBody
	public String signUp(@RequestParam("uploadProfile") MultipartFile uploadProfile , @ModelAttribute UserDTO userDTO) throws IllegalStateException, IOException  {
		
		userService.signUp(uploadProfile, userDTO); // 관련 로직은 서비스에서 처리하기 위하여 포워딩한다.
		
		// 응답(로그인화면으로 이동)
		String jsScript = """
				<script>
					alert('회원가입 되었습니다.');
					location.href = '/user/signIn';
				</script>""";
			
		return jsScript;
		
	}
	
	
	@PostMapping("/validId") // localhost/user/validId 요청시 매핑
	@ResponseBody
	public String validId(@RequestParam("userId") String userId) { 
		return userService.checkValidId(userId); // userId를 전달받아 중복체크한 결과 ('y' or 'n')을 signUp.html파일의 AJAX success 콜백함수로 반환
	}
	
	
	@PostMapping("/validNickName") // localhost/user/validNickName 요청시 매핑
	@ResponseBody
	public String validNickName(@RequestParam("nickname") String nickname) { 
		return userService.checkValidNickName(nickname); // nickname를 전달받아 중복체크한 결과 ('y' or 'n')을 signUp.html파일의 AJAX success 콜백함수로 반환
	}
	
	@GetMapping("/signIn") // localhost/user/signIn 요청시 매핑
	public String signIn()  {
		return "postAdvance/user/signIn"; // templates/postAdvance/user/signIn.html 파일로 포워딩
	}
	
	
	@PostMapping("/signIn") //signIn.html 파일에서 로그인 진행할 때 매핑
	@ResponseBody		    // 전송된 데이터를 받는다.	  session에 등록하기 위해 작성한다.
	public String signIn(@RequestBody UserDTO userDTO , HttpServletRequest request) {
		
		String isValidUser = "n";					// 초기값 : 인증 x
		UserDTO resultDTO = userService.signIn(userDTO);	// 로그인 관련 데이터 DTO를 받아온다.
		if (resultDTO != null) {		// userService에서 인증여부를 확인한 후 인증이 되었을 경우
			
			HttpSession session = request.getSession();				   // session 객체를 생성한다.			
			session.setAttribute("userId", resultDTO.getUserId());     // session 객체에 userId를 저장한다.
			session.setAttribute("nickname", resultDTO.getNickname()); // session 객체에 nickname를 저장한다.
			
			isValidUser = "y";  // 인증 o
			
		} 
		
		return isValidUser; // 로그인 여부 ('y' or 'n')을 signIn.html파일의 AJAX success 콜백함수로 반환
		
	}
	
	
	@GetMapping("/signOut") // localhost/user/signOut 요청시 매핑
	@ResponseBody
	public String signOut(HttpServletRequest request) {
		
		HttpSession session = request.getSession(); // 세션 객체 생성
		session.invalidate(); // 세션 삭제
		
		// 응답(postList)로 이동
		String jsScript = """
				<script>
					alert('로그아웃 되었습니다.');
					location.href = '/post/postList';
				</script>""";
			
		return jsScript;
		
		
	}
	
	
	@GetMapping("/updateUser") // localhost/user/updateUser 요청시 매핑
	public String updateUser(HttpServletRequest request , Model model) {
		
		HttpSession session = request.getSession();	
		// Session에서 userId정보를 가져와 userDTO를 조회한다.
		model.addAttribute("userDTO" , userService.getUserDetail((String)session.getAttribute("userId")));
		
		return "postAdvance/user/updateUser"; // templates/postAdvance/user/update 화면으로 포워딩(userDTO 데이터포함)
		
	}	
	
	
	@PostMapping("/updateUser") // updateUser.html 파일에서 수정을 진행할 때 매핑
	@ResponseBody
								// 파일은 MultipartFile로 받는다.						    // DTO관련 데이터는 DTO로 전송받는다.
	public String updateUser(@RequestParam("uploadProfile") MultipartFile uploadProfile , @ModelAttribute UserDTO userDTO) throws IllegalStateException, IOException  {
		
		userService.updateUser(uploadProfile , userDTO); // 관련 로직은 서비스에서 처리하기 위하여 포워딩한다.
		
		// 응답(myPage로 이동)
		String jsScript = """
				<script>
					alert('수정 되었습니다.');
					location.href = '/user/myPage';
				</script>""";
			
		return jsScript;
		 
	}
	
	
	@GetMapping("/thumbnails") // localhost/user/thumbnails 요청시 매핑
    @ResponseBody
    public Resource thumbnails(@RequestParam("fileName") String fileName) throws MalformedURLException{
        return new UrlResource("file:" + fileRepositoryPath + fileName); // 전달된 파일명으로 썸네일 객체를 반환한다.
    }
	
	@GetMapping("/myPage") // localhost/user/myPage 요청시 매핑
	public String myPage(Model model , HttpServletRequest request) {
		
		HttpSession session = request.getSession();				// 세션객체를 생성한다.
		String userId = (String)session.getAttribute("userId");	// 세션정보를 조회한다.
		
		model.addAttribute("userDTO"  , userService.getUserDetail(userId)); // 유저정보 데이터를 전달한다.
		model.addAttribute("myPostCnt"  , userService.myPostCnt(userId)); 	// 내가 작성한 게시글 개수를 전달한다.
		model.addAttribute("myReplyCnt" , userService.myReplyCnt(userId));	// 내가 작성한 댓글 개수를 전달한다.
		
		return "postAdvance/user/myPage";  // templates/postAdvance/user/myPage.html 포워딩(데이터포함)
	
	}
	
	@GetMapping("/updatePasswd")  // localhost/user/updatePasswd 요청시 매핑
	public String updatePasswd() {
		return "postAdvance/user/updatePasswd";  // templates/postAdvance/user/updatePasswd.html 포워딩
	}
	
	@PostMapping("/updatePasswd")  // myPage.html 파일에서 수정을 진행할 때 매핑
	@ResponseBody
	public String updatePasswd(@ModelAttribute UserDTO userDTO) { // 아이디와 패스워드를 전달받는다.
		
		userService.updatePasswd(userDTO); // 전달받은 데이터를 서비스로 전송한다.
		
		// 응답(myPage로 이동)
		String jsScript = """
				<script>
					location.href = '/user/myPage';
				</script>""";
			
		return jsScript;
		
	}
	
	@GetMapping("/deleteUser")  // localhost/user/deleteUser 요청시 매핑
	public String deleteUser() {
		return "postAdvance/user/deleteUser"; // templates/postAdvance/user/deleteUser.html 파일로 이동
	}
	
	@PostMapping("/deleteUser") // deleteUser.html 파일에서 삭제를 진행할 때 매핑
	@ResponseBody
	public String deleteUser(HttpServletRequest request)  {
		
		HttpSession session = request.getSession();
		userService.deleteUser((String)session.getAttribute("userId")); // Session 객체에서 userId를 조회하여 Service로 전달한다.
		session.invalidate(); // 세션 삭제
		
		// 응답(게시글리스트로 이동)
		String jsScript = """
				<script>
					alert('탈퇴 되었습니다.');
					location.href = '/post/postList';
				</script>""";
			
		return jsScript;
		
	}
	
}
