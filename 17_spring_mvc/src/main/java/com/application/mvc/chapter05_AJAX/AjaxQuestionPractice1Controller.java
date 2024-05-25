package com.application.mvc.chapter05_AJAX;

import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ajax")
public class AjaxQuestionPractice1Controller {


	@GetMapping("/ex03_answerSample")
	public String answerSample03() {
		return "chapter05_AJAX/ajaxEx03_question_practice1";
	}
	
	@PostMapping("/ex03_answerSample")
	@ResponseBody
	public String answerSample03(@RequestBody Map<String, String> map) {
		
		String me = map.get("me");
		String com = map.get("com");
		
		String result = "";
		
		if (com.equals(me)) {
			result = "비겼다";
		}
		else if (me.equals("가위")) {
			result = "내가 졌다";
		}
		else if (me.equals("보")) {
			result = "내가 이겼다";
		}
		
		return result;
	}
	
	
	@GetMapping("/ex04_answerSample")
	public String answerSample04() {
		return "chapter05_AJAX/ajaxEx04_question_practice1";
	}
	
	
	@GetMapping("/ex05_answerSample")
	public String answerSample05() {
		return "chapter05_AJAX/ajaxEx05_question_practice1";
	}
	
	
	@GetMapping("/ex06_answerSample")
	public String answerSample06() {
		return "chapter05_AJAX/ajaxEx06_question_practice1";
	}
	
	
	@GetMapping("/ex07_answerSample")
	public String answerSample07() {
		return "chapter05_AJAX/ajaxEx07_question_practice1";
	}
	
	
	@GetMapping("/ex08_answerSample")
	public String answerSample08() {
		return "chapter05_AJAX/ajaxEx08_question_practice1";
	}
	
	
	@GetMapping("/ex09_answerSample")
	public String answerSample09() {
		return "chapter05_AJAX/ajaxEx09_question_practice1";
	}
	
	
	@GetMapping("/ex10_answerSample")
	public String answerSample10() {
		return "chapter05_AJAX/ajaxEx10_question_practice1";
	}
	
	
	@GetMapping("/ex11_answerSample")
	public String answerSample11() {
		return "chapter05_AJAX/ajaxEx11_question_practice1";
	}
	
	
	@GetMapping("/ex12_answerSample")
	public String answerSample12(Model model) {
		
		Random ran = new Random();
		int authenticationNumber = ran.nextInt(9000) + 1000;
		
		model.addAttribute("authenticationNumber" , authenticationNumber);
		
		return "chapter05_AJAX/ajaxEx12_question_practice1";
		
	}
	
	
	@GetMapping("/ex13_answerSample")
	public String answerSample13() {
		return "chapter05_AJAX/ajaxEx13_question_practice1";
	}
	
	
	@GetMapping("/ex14_answerSample")
	public String answerSample14() {
		return "chapter05_AJAX/ajaxEx14_question_practice1";
	}
	
	@GetMapping("/ex15_answerSample")
	public String answerSample15() {
		return "chapter05_AJAX/ajaxEx15_question_practice1";
	}
	
	
	@GetMapping("/ex16_answerSample")
	public String answerSample16() {
		return "chapter05_AJAX/ajaxEx16_question_practice1";
	}
	
	
	@GetMapping("/ex17_answerSample")
	public String answerSample17() {
		return "chapter05_AJAX/ajaxEx17_question_practice1";
	}
	
}
