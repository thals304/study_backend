package com.application.mvc.chapter05_AJAX;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.mvc.data.ProductDTO;
import com.application.mvc.data.SupposeDAO;

@Controller
@RequestMapping("/c2a")
public class C2A {

	@Autowired
	private SupposeDAO supposeDAO;
	
	@GetMapping("/main")
	public String main() {
		return "chapter05_AJAX/ajaxEx01_c2a";
	}
	
	
	/*
	  
	    # Controller TO AJAX 데이터 전송
	
	    - 과거에는 jackson , gson등 JSON과 자바의 매핑관련 기능 의존성을 추가하여 사용하였으나 
	       (예시 : implementation 'com.fasterxml.jackson.core:jackson-databind:2.14.1')
	    
	      현재는 스프링 부트에서 컨버터 기능을 자동으로 적용시켜주어 @ResponseBody 어노테이션을 사용하여 
	      다양한 데이터 타입을 간편하게 전송할 수 있다.
		
	*/
	
	// 1) 단일데이터 return
	@PostMapping("/ex01")
	@ResponseBody
	public String ex01() {
		return supposeDAO.getString();
	}

	
	// 2) DTO return
	@PostMapping("/ex02")
	@ResponseBody
	public ProductDTO ex02() {
		return supposeDAO.getDTO();
	}
	
	
	// 3) List<DTO> return
	@PostMapping("/ex03")
	@ResponseBody
	public List<ProductDTO> ex03() {
		return supposeDAO.getDTOList();
	}
	
	
	// 4) Map return 
	@PostMapping("/ex04")
	@ResponseBody
	public Map<String, Object> ex04() {
		return supposeDAO.getMap();
	}

	
	// 5) List<Map> return
	@PostMapping("/ex05")
	@ResponseBody
	public List<Map<String, Object>> ex05() {
		return supposeDAO.getMapList();
	}
	
	
}
