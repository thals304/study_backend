package com.application.mvc.chapter05_AJAX;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ajax")
public class AjaxQuestionController {

/*
	@GetMapping("/ex03_answerSample")
	public String answerSample03() {
		return "chapter05_AJAX/ajaxEx03_answerSample";
	}
	
	
	@GetMapping("/ex04_answerSample")
	public String answerSample04() {
		return "chapter05_AJAX/ajaxEx04_answerSample";
	}
	
	
	@GetMapping("/ex05_answerSample")
	public String answerSample05() {
		return "chapter05_AJAX/ajaxEx05_answerSample";
	}
	
	
	@GetMapping("/ex06_answerSample")
	public String answerSample06() {
		return "chapter05_AJAX/ajaxEx06_answerSample";
	}
	
	
	@GetMapping("/ex07_answerSample")
	public String answerSample07() {
		return "chapter05_AJAX/ajaxEx07_answerSample";
	}
	
	
	@GetMapping("/ex08_answerSample")
	public String answerSample08() {
		return "chapter05_AJAX/ajaxEx08_answerSample";
	}
	
	
	@GetMapping("/ex09_answerSample")
	public String answerSample09() {
		return "chapter05_AJAX/ajaxEx09_answerSample";
	}
	
	
	@GetMapping("/ex10_answerSample")
	public String answerSample10() {
		return "chapter05_AJAX/ajaxEx10_answerSample";
	}
	
	
	@GetMapping("/ex11_answerSample")
	public String answerSample11() {
		return "chapter05_AJAX/ajaxEx11_answerSample";
	}
	
	
	@GetMapping("/ex12_answerSample")
	public String answerSample12(Model model) {
		
		Random ran = new Random();
		int authenticationNumber = ran.nextInt(9000) + 1000;
		
		model.addAttribute("authenticationNumber" , authenticationNumber);
		
		return "chapter05_AJAX/ajaxEx12_answerSample";
		
	}
	
	
	@GetMapping("/ex13_answerSample")
	public String answerSample13() {
		return "chapter05_AJAX/ajaxEx13_answerSample";
	}
	
	
	@GetMapping("/ex14_answerSample")
	public String answerSample14() {
		return "chapter05_AJAX/ajaxEx14_answerSample";
	}
	
	@GetMapping("/ex15_answerSample")
	public String answerSample15() {
		return "chapter05_AJAX/ajaxEx15_answerSample";
	}
	
	
	@GetMapping("/ex16_answerSample")
	public String answerSample16() {
		return "chapter05_AJAX/ajaxEx16_answerSample";
	}
	
	
	@GetMapping("/ex17_answerSample")
	public String answerSample17() {
		return "chapter05_AJAX/ajaxEx17_answerSample";
	}
	*/
}
