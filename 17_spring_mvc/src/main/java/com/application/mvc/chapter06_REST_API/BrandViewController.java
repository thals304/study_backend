package com.application.mvc.chapter06_REST_API;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BrandViewController {

	@GetMapping("/brand/view")
	public String view() {
		return "chapter06_REST_API/brand";
	}
}
