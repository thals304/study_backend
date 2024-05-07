package com.application.mvc.chapter02_modelAndView;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/v2c")
public class V2C_param {

	/* 
	  	
	  	1) HttpServletRequest
	  
	   - HttpServletRequest인터페이스에서 getParameter메서드를 사용하여 파라메타를 전달받을 수 있다.
	   
	   - JSP HttpServletRequest과 사용방법이 같다.
	  
	 */
	@GetMapping("/httpServletRequest")
	public String httpServletRequest(HttpServletRequest request) {
		
		System.out.println("\n - httpServletRequest -\n");
		
		System.out.println("titleId : " + Long.parseLong(request.getParameter("titleId")));
		System.out.println("tab : " + request.getParameter("tab"));
		System.out.println("no : " + Integer.parseInt(request.getParameter("no")));
		System.out.println();
		
		return "redirect:/v2c/view";
		
	}
	
	
	
	/* 
	 
	 	2) @RequestParam
	 
	 	- @RequestParam 어노테이션을 사용하여 파라메타를 전달받을 수 있다. 
	 	
	 	- @RequestParam 어노테이션을 사용하여 데이터를 전달받는다. 
	 			
	 			 [예시] 
	 			
	 			public String sample(@RequestParam("categoryId") long categoryId , RequestParam("productId") String productId) {
	 				return "";
	 			}
	 	
	 	[ @RequestParam 어노테이션의 속성 ]	
	 	
	 		name 		 : 파라메타의 이름을 지정한다. (다른 옵션을 사용하지 않을 경우 name 키워드생략가능)
	 		required	 : 필수 여부를 지정한다. 기본값은 true이며 요청값이 없으면 익셉션이 발생한다.
	 		defaultValue : 요청 파라메타의 값이 없을때 사용할 값을 지정한다.
	 
	 */
	@GetMapping("/requestParam")
	public String requestParam(@RequestParam(name="titleId" , defaultValue="000") long titleId, 
			                   @RequestParam("tab") String tab,
			                   @RequestParam("no") int no) {
		System.out.println("\n - @RequestParam -\n");
		
		System.out.println("titleId : " + titleId);
		System.out.println("tab : " + tab);
		System.out.println("no : " + no);
		System.out.println();
		
		return "redirect:/v2c/view";
	}
	

	/*
	   
	   3) @PathVariable
	    
	    - 요청 URL과 함께 파라메타를 같이 전달할 수 있다. REST API에서 사용하며 '명사'형태로 전송한다. 
	 
	 		[ 예시 ] 
	 		http://localhost/mvc/v2c/transfer5/yes/no
	 		http://localhost/product/1
	 		http://localhost/category/new/order/1
	 		
	 		
		- @PathVariable 어노테이션을 사용하여 데이터를 전달받는다.
	 			 
			 [예시] 
			 
			 요청) @{sample/{categoryId}/{productId}((titleId=10000 , productId=200)}
			 
			 응답)
			 @GetMapping("/sample/{categoryId}/{productId})
			 public String sample(@PathVariable("categoryId") long categoryId , @PathVariable("categoryId") long categoryId) {
			 		return "";
			 }
	       
	  */
	@GetMapping("/pathVariable/{titleId}/{tab}/{no}")
	public String pathVariable(@PathVariable("titleId") long titleId ,
			                   @PathVariable("tab") String tab,
			                   @PathVariable("no") int no) {
		
		System.out.println("\n - @PathVariable -\n");
		
		System.out.println("titleId : " + titleId);
		System.out.println("tab : " + tab);
		System.out.println("no : " + no);
		System.out.println();
		
		return "redirect:/v2c/view";
	}
	
}
