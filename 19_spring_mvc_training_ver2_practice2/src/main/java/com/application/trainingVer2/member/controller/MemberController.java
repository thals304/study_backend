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
 * 24.06.03 time
 * today 소감문
 * PostMapping에서 @ResponseBody가 있어야 되는 경우? 없어도 되는 경우?
 * redirect:/ url로 이동하는 경우? -> 필요 없음
 * 다시 html에 data를 보내야 하는 경우?  return jsScript과 같다고 보나?
 * 
 * */
@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Value("${file.repo.path}")
	private String fileRepositoryPath;
	
	@GetMapping("/main")
	public String main() {
		return "member/main";
	}
	
	// 회원가입
	@GetMapping("/register")
	public String register() {
		return "member/register";
	}
	
	@PostMapping("/register")
	public String register(@RequestParam("uploadFile") MultipartFile uploadProFile, @ModelAttribute MemberDTO memberDTO) throws IllegalStateException, IOException  {
		
		memberService.createMember(uploadProFile, memberDTO);
		
		return "redirect:/member/main";
	}
	
	// 아이디 중복 확인
	@PostMapping("/validId")
	@ResponseBody //다시 html로 데이터를 보낼 때도 이게 있어야 되나?
	public String validId(@RequestParam("memberId") String memberId) {
		return memberService.checkValidId(memberId);
	}
	
	// 로그인
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("login")
	@ResponseBody
	public String login(@RequestBody MemberDTO memberDTO, HttpServletRequest request) {
		
		String isValidMember = "n";	
		
		if (memberService.login(memberDTO)) {
			HttpSession session = request.getSession();
			session.setAttribute("memberId", memberDTO.getMemberId());
			isValidMember = "y";
		}
		
		return isValidMember;
	}
	
	@GetMapping("/update")
	public String update(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		
		model.addAttribute("memberDTO", memberService.getMemberDetail((String)session.getAttribute("memberId")) );
		
		return "member/update";
	}
	
	@PostMapping("/update")
	public String update(@RequestParam("uploadProfile") MultipartFile uploadProfile, @ModelAttribute MemberDTO memberDTO) throws IllegalStateException, IOException {
		
		memberService.updateMember(uploadProfile, memberDTO);
		
		return "redirect:/member/main";
	}
	
	// 수정하기 - 썸네일 사진
	@GetMapping("/thumbnails")
	public Resource thumbnails(@RequestParam("fileName") String fileName) throws MalformedURLException {
		return new UrlResource("file:" + fileRepositoryPath + fileName);
	}
	
	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "redirect:/member/main";
	}
	
	// 회원탈퇴
	@GetMapping("/delete")
	public String delete() {
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
