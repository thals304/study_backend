package com.application.mvc.chapter01_thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PathController {

	@GetMapping("/th/path/ex")  // localhost/th/path/ex
	public String path() {
		return "chapter01_thymeleaf/path/pathEx";
	}
	
}
