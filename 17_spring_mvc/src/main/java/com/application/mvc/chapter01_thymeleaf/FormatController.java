package com.application.mvc.chapter01_thymeleaf;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormatController {

	@GetMapping("/th/format/ex") // localhost/th/format/ex
	public String format(Model model) {
		
		// 날짜 (Date)
		model.addAttribute("date1" , new Date());
		model.addAttribute("date2" , System.currentTimeMillis());
		
		// 정수 (Integer)
		model.addAttribute("intVar" , 1000000000); // 1 , 10 , 100 , 1000000000
		
		// 소수점 (Decimal)
		model.addAttribute("doubleVar" , 3.141592); // 3.141592 , 30000.141592
		
		return "chapter01_thymeleaf/format/formatEx";
		
	}
	
}
