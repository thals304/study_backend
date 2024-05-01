package com.application.mvc.chapter01_thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.application.mvc.data.SupposeDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ExpressionController {
	
	// SupposeDAO supposeDAO = new SupposeDAO();
	
	@Autowired
	SupposeDAO supposeDAO;
	
	@GetMapping("/ex01")
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
	
	@GetMapping("/ex02")
	public String ex02(HttpServletRequest request) {
		
		// session 예시
		HttpSession session = request.getSession();
		
		session.setAttribute("id", "qwer1234");
		session.setAttribute("userRole", "admin");
		
		return "chapter01_thymeleaf/expression/expressionEx02";
	
	}

}
