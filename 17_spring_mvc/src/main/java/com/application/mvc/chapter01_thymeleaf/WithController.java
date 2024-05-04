package com.application.mvc.chapter01_thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WithController {

	@GetMapping("/th/with/ex")  // localhost/th/with/ex
	public String with(Model model) {
		
		model.addAttribute("price" , 10000);
		model.addAttribute("orderQty" , 3);
		model.addAttribute("deliveryPrice", 3000);
		model.addAttribute("usePoint" , 5000);
		
		return "chapter01_thymeleaf/with/withEx";
		
	}
	
}
