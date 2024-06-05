package com.application.jpa.chapter02_mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BrandController {
	
	
	@GetMapping("/jpa/brand/view")
	public String view() {
		return "brand";
	}
}
