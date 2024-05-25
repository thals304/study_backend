package com.application.mvc.chapter05_AJAX;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.mvc.data.ProductDTO;

@Controller
@RequestMapping("/a2c")
public class A2C {
	
	
	@GetMapping("/main")
	public String main() {
		return "chapter05_AJAX/ajaxEx02_a2c";
	}

 	/*
	  
	    # AJAX TO Controller 데이터 전송

	    - 과거에는 jackson , gson등 JSON과 자바의 매핑관련 기능 의존성을 추가하여 사용하였으나 
	       (예시 : implementation 'com.fasterxml.jackson.core:jackson-databind:2.14.1')
	      
	      현재는 스프링 부트에서 컨버터 기능을 자동으로 적용시켜주어 @RequestBody 어노테이션을 사용하여 간편하게 구현할 수 있다.
	 
		- @RequestBody는 Spring Framework에서 사용하는 어노테이션으로 
		   HTTP 요청의 본문(body)에 있는 데이터(JSON,XML, 등)를 Java 객체로 변환해주는 역할을 한다. 
		
		- 주로 RESTful 웹 서비스에서 클라이언트가 서버에 데이터를 전송할 때 사용된다.
		 
	*/
	
	
	// 1) 단일 데이터 전송
	@PostMapping("/ex01")
	@ResponseBody
	public String ex01(@RequestParam("productId") long productId) { // @RequestParam 어노테이션으로 데이터를 전송받는다.
		
		System.out.println("\n --- single data --- \n");
		System.out.println("productId : " + productId);
		
		return "";
		
	}
		
	
	// 2) DTO 전송
	@PostMapping("/ex02")
	@ResponseBody
	public String ex02(@RequestBody ProductDTO productDTO )  { // @RequestBody 애너테이션을 사용하여 JSON 데이터를 자바 객체로 변환하여 전송받는다.
		
		System.out.println("\n --- DTO --- \n");
		System.out.println(productDTO);
		
		return "";
	
	}

	
	// 3) List<DTO> 전송
	@PostMapping("/ex03")
	@ResponseBody
	public String ex03(@RequestBody List<ProductDTO> productList) { // @RequestBody 애너테이션을 사용하여 JSON 데이터를 자바 객체로 변환하여 전송받는다.
		
		System.out.println("\n --- DTO List --- \n");
		
		for (ProductDTO productDTO : productList) {
			System.out.println(productDTO);
		}
		
		return "";
		
	}
	
	
	// 4) map 전송
	@PostMapping("/ex04")
	@ResponseBody 
	// 전송되는 데이터의 타입이 다양할 경우 Object 타입으로 받는다.
	public String ex04(@RequestBody Map<String, Object> map) { // @RequestBody 애너테이션을 사용하여 JSON 데이터를 자바 객체로 변환하여 전송받는다.

		System.out.println("\n --- Map --- \n");
		System.out.println(map);
		
		/*
		 
	 	# Object로 데이터를 받은 이후 형변환하는 방법 예시
	 	
	 	1) String : map.get("key").toString() , 
	 			 map.get("key").toString() + ""
	 	2) int    : Integer.parseInt(map.get("key").toString);
	 	3) long   : Long.parseLong(map.get("key").toString);
	 	4) double : Double.parseDouble(map.get("key").toString);
	 
	 */

		String orderId = map.get("orderId").toString();
		int orederQty = Integer.parseInt(map.get("orderQty").toString());
		String cartId = map.get("cartId") + "";
		long cartQty = Long.parseLong(map.get("cartQty")+ "");
		
		return "";
		
	}
	

	// 5) List<Map> 전송
	@PostMapping("/ex05")
	@ResponseBody
	public String ex05(@RequestBody List<Map<String, Object>> mapList) { // @RequestBody 애너테이션을 사용하여 JSON 데이터를 자바 객체로 변환하여 전송받는다.

		System.out.println("\n --- Map List --- \n");
		for (Map<String, Object> map : mapList) {
			System.out.println(map);
		}
		
		return "";
		
	}
	
}
