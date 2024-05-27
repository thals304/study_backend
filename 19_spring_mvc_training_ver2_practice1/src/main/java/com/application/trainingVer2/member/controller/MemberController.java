package com.application.trainingVer2.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.application.trainingVer2.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired 
	private MemberService memberService;
}
