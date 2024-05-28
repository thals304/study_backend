package com.application.trainingVer2.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.application.trainingVer2.member.service.MemberService;
/*
 * 24.05.28 time 14:30-
 * today 소감문
 * 
 * */
@Controller
@RequestMapping("/member")
public class MemberController {
	
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
}
