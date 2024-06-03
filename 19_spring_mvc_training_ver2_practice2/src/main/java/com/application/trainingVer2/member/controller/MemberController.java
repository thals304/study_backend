package com.application.trainingVer2.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import com.application.trainingVer2.member.service.MemberService;
/*
 * 24.06.03 time
 * today 소감문
 * */
@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Value("${file.repo.path}")
	private String fileRepositoryPath;
}
