package com.application.trainingVer2.member.controller;

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

import com.application.trainingVer2.member.dto.MemberDTO;
import com.application.trainingVer2.member.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
/*
 * 24.05.29 time 22:10-23:34
 * 24.05.31 time 14:00-14:40
 * 24.06.01 time 14:00-15:24
 *               16:17-17:00
 * today 소감문
 * 로그인 Service까지 끝냄 > register - Controller, Service, ServiceImpl에서 throws exception이 어떻게 해서 나타난 건지? transferTo에서 생겨남
 * 					  > register - ServiceImpl에서 transferTo가 사용 가능한 이유? MultipartFile
 *                    > login - login.html에서 $().ready가 아닌 &(function(){})으로 표현 (같은 의미) 
 *                    > login - Controller에서 HttpServletRequest request / HttpSession session = request.getSession();
 *                    > ServiceImpl에서 private static Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class); // 얘는 왜 있는거지? 스케쥴링에서 sysout으로 찍기 보다는 파일에도 쓰여질 수 있게끔 
 * update의 Get까지 끝냄  > login - mapper에서 passwd와 activeYn을 보내는데 passwd는 인정인데 activeYn은 왜 전달하지? 비활성화된 회원(=탈퇴 회원)인지 아닌지 체크를 하기 위해
 * 				      > delete - @GetMapping에서 session의 memberId를 html로 보내지 않았어도 html에서 로그인만 되어 있으면 session.memberId 사용이 가능한건가?
 * 					  > delete - html에서 javascript 표현 방법 & keyup -> this.val() 사용이 아직 어색하게 느껴짐
 * */
@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Value("${file.repo.path}")    // application.properties파일의 file.repo.path=c:/spring_member_profile/ 이미지파일 저장경로 주입
    private String fileRepositoryPath; // c:/spring_member_profile
	
	@Autowired 
	private MemberService memberService;
	
	@GetMapping("/main")
	public String main() {
		return "member/main";
	}
	
	@GetMapping("/register")
	public String register() {
		return "member/register";
	}
	
	@PostMapping("/register")
	public String register(@RequestParam("uploadProfile") MultipartFile uploadProfile, @ModelAttribute MemberDTO memberDTO) throws IllegalStateException, IOException {
		memberService.createMember(uploadProfile, memberDTO);
		return "redirect:/member/main";
	}
	
	@PostMapping("/validId") 
	@ResponseBody
	public String validId(@RequestParam("memberId") String memberId) { 
		return memberService.checkValidId(memberId); 
	}
	
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/login")
	public String login(@RequestBody MemberDTO memberDTO , HttpServletRequest request) {
		String isValidMember = "n";
		
		if (memberService.login(memberDTO)) { // 아이디, 비번이 일치하는 회원 존재를 true, false로 받는거로 봐서 serviceImpl이 이 역할을 해주는 것 같음
			
			HttpSession session = request.getSession();
			session.setAttribute("memberId", memberDTO.getMemberId());
			
			isValidMember = "y";
		}
		
		return isValidMember;
	}
	
	@GetMapping("/update")
	public String update(HttpServletRequest request,Model model) {
		
		HttpSession session = request.getSession();
		// session에서 기본 반환 타입이 Object 이므로 필드에 맞는 데이터 타입으로 형변환 해야함
		model.addAttribute("memberDTO", memberService.getMemberDetail((String)session.getAttribute("memberId")));
		
		return "member/update";
	}
	
	@PostMapping("/update")
	public String update(@RequestParam("uploadProfile") MultipartFile uploadProfile , @ModelAttribute MemberDTO memberDTO) throws IllegalStateException, IOException {
		memberService.updateMember(uploadProfile, memberDTO);
		return "redirect:/member/main";
	}
	
	@GetMapping("/thumbnails")
	@ResponseBody
	public Resource thumbnails(@RequestParam("fileName") String fileName) throws MalformedURLException {
		return new UrlResource("file:" + fileRepositoryPath + fileName);
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "redirect:/member/main";
	}
	
	// session에서 memberId 안받아 오는 이유?
	@GetMapping("/delete")
	public String delete(){
		return "member/delete";
	}
	
	@PostMapping("/delete")
	public String delete(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		memberService.updateInactiveMember((String)session.getAttribute("memberId"));
		session.invalidate();
		
		return "redirect:/member/main";
	}
	
	
}
