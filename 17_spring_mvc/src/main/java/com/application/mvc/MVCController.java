package com.application.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*

	@Controller

	- 스프링 프레임워크에서 @Controller 어노테이션은 클래스 레벨에서 사용되며
	  해당 클래스를 웹 요청을 처리하는 컨트롤러로 지정하는 데 사용한다.
	  
	- @Controller가 붙은 클래스는 스프링 MVC의 웹 레이어의 일부로서 
	   클라이언트의 요청을 받아 처리한 후 적절한 응답을 반환하는 역할을 한다.
	
	
	- [ 주요 기능과 사용 목적 ] 

	1) @Controller 어노테이션이 지정된 클래스는 HTTP 요청을 처리하는 엔드포인트를 정의한다. 
		이러한 클래스 내에서 정의된 메소드들은 특정 요청 경로(URL), HTTP 메소드(GET, POST 등)에 매핑한다.
		
    2) 요청 매핑: @RequestMapping 어노테이션 또는 그와 유사한 어노테이션(@GetMapping, @PostMapping 등)을 사용하여 메소드를 특정 요청에 매핑한다.
				  이러한 메소드들은 요청을 처리하고, 데이터 모델을 준비하며, 뷰 이름을 반환하여 클라이언트에게 응답을 보낸다.
		
	3) 데이터 모델과 뷰: 컨트롤러 메소드는 데이터 모델을 뷰에 전달할 수 있다. 
	  모델 데이터는 Model 객체를 통해 뷰에 전달되며 뷰 템플릿(예: Thymeleaf, JSP 등)에서 이 데이터를 사용하여 동적인 웹 페이지를 생성할 수 있다.
	  
	4) 뷰 리졸버: 스프링 MVC는 컨트롤러가 반환한 뷰 이름을 기반으로 실제 뷰 템플릿의 위치를 찾으며 이 과정은 뷰 리졸버(view resolver)에 의해 수행된다.
	
*/


@Controller
public class MVCController {

	//@RequestMapping(value="/main" , method=RequestMethod.GET) // value에는 url주소를 작성 , method는 요청방식을 작성한다. (method를 생략할 경우 GET, POST를 모두 처리한다.)
	@GetMapping("/main")    // Get요청의 'localhost/main' URL에 매핑
	//@PostMapping("/main") // Post요청의 'localhost/main' URL에 매핑
	public String main() {
		
		/*
		
			- Spring Boot Controller에서 메서드의 return타입은 view(html)를 명시할 String타입을 기본적으로 사용한다.
	  		
	  		- application.properties 파일의 아래의 설정으로 바인딩되어 view(html)화면으로 포워딩 한다.
			
				1) view 파일 위치지정 (src/main/resources/templates 하위 폴더)
				spring.thymeleaf.prefix=classpath:/templates/
			
				2) view 파일 확장자지정
				spring.thymeleaf.suffix=.html
	
				[ 예시 ]
				return "home"		 	 > /templates/home.html 파일로 이동
				return "goods/main"   	 > /templates/goods/main.html 파일로 이동
				return "order/orderList" > /templates/order/orderList.html 파일로 이동
				
		 */
		
		return "main"; // /templates/main.html 파일로 이동한다.
	
	}
	
	
	@GetMapping("/source") // localhost/source
	public String source() {
		
		/*
	  	
	  		# return "redirect:/경로"로 사용할 경우 다른 URL로 리다이렉트(Re Direct)한다. 
	 
	 		예시)
	 		return "redirect:/admin/memberList"	 > @GetMapping("/admin/memberList")으로 이동한다.
	  		return "redirect:/order/modifyOrder" > @GetMapping("/order/modifyOrder")으로 이동한다.
		
		 */
		
		return "redirect:/target"; // @GetMapping("/target")으로 이동한다.
		//return "target"; 		   // /templates/target.html로 이동한다.
	
	}
	
	
	@GetMapping("/target")
	public String target() {

		/*
		  
		 	# html로 이동하는 방법과 URL redirect의 차이점
			 
			1) html로 이동하는 경우 : 단순 페이지만 이동  
			2) redirect하는 경우    : (주로사용하는 방법) url에 포함된 모든 비즈니스 로직(Controller , Service , DAO)을 수행한 후 페이지 이동
			
		*/
		
		System.out.println("SELECT * FROM TABLE");
		System.out.println("request.setAttribute('data1' , data1)");
		System.out.println("request.setAttribute('data2' , data2)");
		System.out.println("request.setAttribute('data3' , data3)");
		System.out.println();
		
		return "target";
		
	}	
	
}
