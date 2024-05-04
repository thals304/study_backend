package com.application.mvc.chapter02_modelAndView;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.application.mvc.data.ProductDTO;

@Controller
@RequestMapping("/v2c")
public class V2C_binding {

	@GetMapping("/view") // localhost/v2c/view
	public String view() {
		return "chapter02_modelAndView/v2c";
	}
	
	/*
	 
		  1) @ModelAttribute
		  
		  - @ModelAttribute 어노테이션을 사용하여 HTML element name 과 DTO property가 일치된 경우에  
		     DTO 형식으로 바인딩(매핑) 된 전달받을 수 있다. 
		    
		  - @ModelAttribute 의 경우 내부적으로 검증(Validation) 작업을 진행하기 때문에 setter 메서드를 이용하여 값을 바인딩하려고 시도하다가 
		   예외를 만날때(데이터 타입 불일치) 작업이 중단되면서 Http 400 Bad Request가 발생한다.
		   
		  - String to Date 데이터 형식의 바인딩은 DTO클래스 property위에 @DateTimeFormat(pattern = "yyyy-MM-dd")을 추가하여 매핑한다.
		  
	 */
	
	@PostMapping("/modelAttribute")
	public String modelAttribute(@ModelAttribute ProductDTO productDTO) {
		
		System.out.println("\n - @ModelAttribute - \n");
		System.out.println(productDTO);
		
		return "redirect:/v2c/view";
		
	}

}
