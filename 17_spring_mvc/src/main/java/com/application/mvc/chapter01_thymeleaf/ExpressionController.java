package com.application.mvc.chapter01_thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.application.mvc.data.SupposeDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
// 클래스에 @RequestMapping을 사용할 수 잇으며 해당 클래스의 모든 메서드가 /th/expression 경로로 매핑됨
@RequestMapping("/th/expression/")
public class ExpressionController {
	
	// SupposeDAO supposeDAO = new SupposeDAO();
	
	@Autowired
	SupposeDAO supposeDAO;
	
	@GetMapping("/ex01") // localhost/th/expression/ex01
	public String ex01(Model model) {
		// 데이터 전송 예시
		model.addAttribute("string"  , supposeDAO.getString());
		model.addAttribute("int"     , supposeDAO.getInt());
		model.addAttribute("double"  , supposeDAO.getDouble());
		model.addAttribute("boolean" , supposeDAO.getBoolean());
		model.addAttribute("date"    , supposeDAO.getDate());
		model.addAttribute("dto"     , supposeDAO.getDTO());
		model.addAttribute("dtoList" , supposeDAO.getDTOList());
		model.addAttribute("map"     , supposeDAO.getMap());
		model.addAttribute("mapList" , supposeDAO.getMapList());

		return "chapter01_thymeleaf/expression/expressionEx01";
	}
	
	@GetMapping("/ex02") // localhost/th/expression/ex02
	public String ex02(HttpServletRequest request) {
		
		// session 예시
		HttpSession session = request.getSession();
		
		session.setAttribute("id", "qwer1234");
		session.setAttribute("userRole", "admin");
		
		return "chapter01_thymeleaf/expression/expressionEx02";
	
	}
	
	@GetMapping("/ex03") // localhost/th/expression/ex03
	public String ex03(Model model) {
		
		// unescape 예시
		model.addAttribute("data1", "<h6 style='color:red;'>unescape 테스트 데이터1</h6>");
		model.addAttribute("data2", "<div align='center'>unescape 테스트 데이터2</div>");
		
		return "chapter01_thymeleaf/expression/expressionEx03";
		
	}


}
