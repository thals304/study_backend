package com.application.aop.chapter03_interceptor.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class AuthInterceptorController {
	
	@GetMapping("/login") // localhost/auth/login으로 요청시 매핑
	public String login() {
		return "login";
	}
	
	@PostMapping("/login") // login.html파일에서 submit실행시 매핑
	public String login(@RequestParam("role") String role , HttpServletRequest request) {
		
		HttpSession session = request.getSession(); // session객체를 생성
		
		if (role.equals("user")) {				  // 전달된 데이터가 user이면
			session.setAttribute("role", "user"); // session객체의 권한 속성에 user데이터 저장
		}
		else if (role.equals("admin")) {		   // 전달된 데이터가 admin이면
			session.setAttribute("role", "admin"); // session객체의 권한 속성에 admin데이터 저장
		}
		
		System.out.println("(session role)" + (String)session.getAttribute("role"));
		
		return "redirect:/auth/main"; // /auth/main으로 이동
	}
	
	@GetMapping("/logout") // localhost/auth/logout으로 요청시 매핑
	public String logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession(); // session객체를 생성
		session.invalidate();						// session객체의 권한 속성 삭제
		
		return "redirect:/auth/login";  // 로그인페이지로 이동
	
	}
	
	@GetMapping("/main")
	public String main() {
		return "main";
	}
	
}
