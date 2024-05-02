package com.application.mvc.chapter01_thymeleaf;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.application.mvc.data.ProductDTO;
import com.application.mvc.data.SupposeDAO;

@Controller
@RequestMapping("/th/control")
public class ControlStatementController {

	@Autowired
	private SupposeDAO supposeDAO;
	
	@GetMapping("/ex01") // localhost/th/control/ex01
	public String ex01(Model model) {
	
		// th:if , th:unless 예시
		String menu = "일정관리"; // 권한관리 , 일정관리 , 위험관리
		String role = "admin";    // admin , user
		int deliveryPrice = 3000; // 0 , 3000
		int grade = 75; 		  // 75 , 85 , 95
		
		model.addAttribute("menu" , menu);
		model.addAttribute("role" , role);
		model.addAttribute("deliveryPrice" , deliveryPrice);
		model.addAttribute("grade" , grade);
		
		return "chapter01_thymeleaf/controlStatment/controlEx01";
		
	}
	
	
	@GetMapping("/ex02")
	public String ex02(Model model) {
	
		// th:switch , th:case 예시
		String menu = "일정관리"; // 권한관리 , 일정관리 , 위험관리
		model.addAttribute("menu" , menu);
		
		return "chapter01_thymeleaf/controlStatment/controlEx02";
		
	}
	
	
	@GetMapping("/ex03")
	public String ex03(Model model) {
		
		// 반복문 예시
		List<ProductDTO> dtoList         = supposeDAO.getDTOList();
		List<Map<String,Object>> mapList = supposeDAO.getMapList();
		
		model.addAttribute("dtoList" , dtoList);
		model.addAttribute("mapList" , mapList);
		
		return "chapter01_thymeleaf/controlStatment/controlEx03";
		
	}
	
	
	@GetMapping("/ex04")
	public String ex04(Model model) {
		
		// 반복문 + Status 예시
		List<ProductDTO> dtoList = supposeDAO.getDTOList();
		
		model.addAttribute("dtoList", dtoList);
		
		return "chapter01_thymeleaf/controlStatment/controlEx04";
		
	}
	
	
	
}
