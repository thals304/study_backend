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
@RequestMapping("/th/script")
public class ScriptController {

	@Autowired
	private SupposeDAO supposeDAO;
	
	@GetMapping("/ex01") 
	public String ex01(Model model , HttpServletRequest request) {
		
		/* 데이터 '표현' 예시 */
		
		// 데이터 예시
		model.addAttribute("string"  , supposeDAO.getString());
		model.addAttribute("int"     , supposeDAO.getInt());
		model.addAttribute("double"  , supposeDAO.getDouble());
		model.addAttribute("boolean" , supposeDAO.getBoolean());
		model.addAttribute("date"    , supposeDAO.getDate());
		model.addAttribute("dto"     , supposeDAO.getDTO());
		model.addAttribute("dtoList" , supposeDAO.getDTOList());
		model.addAttribute("map"     , supposeDAO.getMap());
		model.addAttribute("mapList" , supposeDAO.getMapList());
		 
		// session 예시
		HttpSession session = request.getSession();
		session.setAttribute("userId", "qwer1234");
		session.setAttribute("role", "user");
		
		return "chapter01_thymeleaf/script/scriptEx01";
		
	}
	
	
	@GetMapping("/ex02") 
	public String ex02(Model model , HttpServletRequest request) {
		
		/* 데이터 '사용' 예시 */
		
		// 데이터 예시
		model.addAttribute("string"  , supposeDAO.getString());
		model.addAttribute("int"     , supposeDAO.getInt());
		model.addAttribute("double"  , supposeDAO.getDouble());
		model.addAttribute("boolean" , supposeDAO.getBoolean());
		model.addAttribute("date"    , supposeDAO.getDate());
		model.addAttribute("dto"     , supposeDAO.getDTO());
		model.addAttribute("dtoList" , supposeDAO.getDTOList());
		model.addAttribute("map"     , supposeDAO.getMap());
		model.addAttribute("mapList" , supposeDAO.getMapList());
		 
		// session 예시
		HttpSession session = request.getSession();
		session.setAttribute("userId" , "qwer1234");
		session.setAttribute("role" , "user");
		
		return "chapter01_thymeleaf/script/scriptEx02";
		
	}
	
	
	@GetMapping("/ex03") 
	public String ex03(Model model) {
		
		/* 반복문(for문) 예시 */
		
		model.addAttribute("dtoList" , supposeDAO.getDTOList());
		model.addAttribute("mapList" , supposeDAO.getMapList());
		
		return "chapter01_thymeleaf/script/scriptEx03";
		
	}
	
}
