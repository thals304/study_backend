package com.application.mvc.chapter01_thymeleaf;
/*
 * 24.05.07 time 

 * today 소감문
 * 9  > #numbers.sequence(,) 사용 방법 익숙해지기 
 * 10 > jsp 공부 다시 필요
 * 12 > th:id stat count 사용방법 
 * 13 > list 객체를 html에 보내고 html에서 사용하는 방법 겍체명.필드명
 * 14
 * */
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.application.mvc.data.ProductDTO;
import com.application.mvc.data.SupposeDAO;

@Controller
@RequestMapping("/th/control")
public class ControlStatementPractice1Controller {

	@Autowired
	private SupposeDAO supposeDAO;
	
	@GetMapping("/ex05_practice1")
	public String ex05_practice1(Model model) {
		
		/*
		  
			# 권한
		
			1. admin , user중 하나의 데이터를 controlEx05_practice.html파일로 전송한다.
			2. 데이터에 따라아래와 같이 출력한다.
				 admin일경우 > 관리자 화면입니다.
				 user일 경우 > 유저 화면입니다.
		*/
		
		String role = "admin"; // admin , user
		model.addAttribute("role", role);

		return "chapter01_thymeleaf/controlStatment/controlEx05_pracitce1";
		
	}
	
	@GetMapping("/ex06_practice1")
	public String ex06_practice1(Model model) {
		
		/*
			# 가위 바위 보
			
			1. com은 바위만 낼 수 있다.
			2. me는 가위 바위 보 중에 하나의 데이터를 controlEx06_practice.html파일로 전송한다.
			3. me의 데이터에 따라
				1) 비겼다.
				2) 내가 이겼다.
				3) 내가 졌다.			를 출력한다.
			
		*/
		
		// 나는 com은 고정되어 있다고 생각해서 html에서 me가 가위, 바위, 보 일 때만 조건을 썼는데 정답예시는 com의 조건도 같이 써줌 
		String com = "바위";
		String me = "바위"; // 가위 , 바위 , 보
		
		model.addAttribute("com" , com);
		model.addAttribute("me" , me);
		
		return "chapter01_thymeleaf/controlStatment/controlEx06_pracitce1";
		
	}
	
	
	@GetMapping("/ex07_practice1")
	public String ex07_practice1(Model model) {
		
		/*
		
			# Up & Down 게임
			
			1. com은 77이다.
			2. me에 숫자 데이터를 controlEx07_practice.html파일로 전송한다.
			3. 다음과 같은 메세지를 출력한다.
				1) me < com	: Up!
				2) me == com : Bingo!
				3) me > com  : Down!
	
		*/
		
		int com = 77;
		int me = 0;    // 50 ,77, 100
		
		model.addAttribute("com", com);
		model.addAttribute("me", me);
		
		
		return "chapter01_thymeleaf/controlStatment/controlEx07_pracitce1";
		
	}

	
	@GetMapping("/ex08_practice1")
	public String ex08_practice1(Model model) {
		
		/*
	
			# 로그인
			
			1. dbId와 dbPasswd를 controlEx08_practice.html파일에 전송한다.
			2. inputId와 inputPasswd데이터도 같이 전송하여 일치할 경우 '로그인 되었습니다.' 를 출력한다.
			3. 일치하지 않을 경우 '로그인에 실패하였습니다.' 를 출력한다.
	
		*/
		String dbId        = "qwer1234";
		String dbPasswd    = "1234";
		String inputId     = "qwer1234"; // qwer1234 , qwer
		String inputPasswd = "1234";     // 1234 , 1111
		
		// 정답예시에서는 아이디가 같거나 비밀번호가 같을 때 로그인 성공으로 조건식을 쓴 것일까? && 인 줄 알았는데 왜 ||인 것인가?
		model.addAttribute("dbId", dbId);
		model.addAttribute("dbPasswd", dbPasswd);
		model.addAttribute("inputId", inputId);
		model.addAttribute("inputPasswd", inputPasswd);
		
		return "chapter01_thymeleaf/controlStatment/controlEx08_pracitce1";
		
	}

	
	@GetMapping("/ex09_practice1")
	public String ex09_practice1() {
		
		/*

			- controlEx09_practice.html파일에서 반복문을 사용하여
			1) 2024년부터 ~ 1900년까지	select태그에 구현해보시오.
			2) 1월부터 12월까지			select태그에 구현해보시오.
			3) 1일부터 31일까지			select태그에 구현해보시오.
	
		*/
		
		return "chapter01_thymeleaf/controlStatment/controlEx09_pracitce1";
		
	}
	
	
	@GetMapping("/ex10_practice1")
	public String ex10_practice1() {
		
		/*

			- controlEx10_practice.html파일에서 반복문을 사용하여
		
			(1~12)월별로 말일부터 1일까지 select태그에 구현해보시오.
			
			[ 예시 ]
			1월 : [31일] (select태그로 31일부터 ~ 1일까지)
			2월 : [28일] (select태그로 28일부터 ~ 1일까지)
			3월 : [31일] (select태그로 31일부터 ~ 1일까지)
			4월 : [30일] (select태그로 30일부터 ~ 1일까지)
			...
			...
			...
			
		*/
		

		return "chapter01_thymeleaf/controlStatment/controlEx10_pracitce1";
		
	}
	
	
	@GetMapping("/ex11_practice1")
	public String ex11_practice1(Model model) {
		
		/*
		  
			- controlEx11_practice.html파일에 productIds 데이터를 전달하여 아래와같이 데이터를 출력하시오.
			
			 <table border="1">
		   	  <tr>
		   	  	<td>0x001</td>
		   	  </tr>
		   	  <tr>
		   	  	<td>0x002</td>
		   	  </tr>
		   	  <tr>
		   	  	<td>0x003</td>
		   	  </tr>
		   	  <tr>
		   	  	<td>0x004</td>
		   	  </tr>
		   	  <tr>
		   	  	<td>0x005</td>
		   	  </tr>
		   	  <tr>
		   	  	<td>0x006</td>
		   	  </tr>
		   	  <tr>
		   	  	<td>0x007</td>
		   	  </tr>
		   </table>
			
			
		*/
		String[] productIds = {"0x001", "0x002", "0x003", "0x004", "0x005", "0x006", "0x007"};

		model.addAttribute("productIds", productIds);
		
		return "chapter01_thymeleaf/controlStatment/controlEx11_pracitce1";
		
	}
	
	
	@GetMapping("/ex12_practice1")
	public String ex12_practice1(Model model) {
		
		/*
		  
			- controlEx12_practice.html파일에 productIds 데이터를 전달하여 아래와같이 데이터를 출력하시오.
			
			 <table border="1">
		   	  <tr>
		   	  	<td id="pd1">0x001</td>
		   	  </tr>
		   	  <tr>
		   	  	<td id="pd2">0x002</td>
		   	  </tr>
		   	  <tr>
		   	  	<td id="pd3">0x003</td>
		   	  </tr>
		   	  <tr>
		   	  	<td id="pd4">0x004</td>
		   	  </tr>
		   	  <tr>
		   	  	<td id="pd5">0x005</td>
		   	  </tr>
		   	  <tr>
		   	  	<td id="pd6">0x006</td>
		   	  </tr>
		   	  <tr>
		   	  	<td id="pd7">0x007</td>
		   	  </tr>
		   </table>
			
			
		*/
		String[] productIds = {"0x001", "0x002", "0x003", "0x004", "0x005", "0x006", "0x007"};
		
		model.addAttribute("productIds", productIds);

		return "chapter01_thymeleaf/controlStatment/controlEx12_pracitce1";
		
	}
	
	
	@GetMapping("/ex13_practice1")
	public String ex13_practice1(Model model) {
		
		/*
		  
		  - controlEx13_practice.html파일에 productList 데이터를 전달하여 아래와같이 데이터를 출력하시오.
			
		  <table border="1">
		   	  <tr>
		   	  	<th>productId</th>
		   	  	<th>productNm</th>
		   	  	<th>price</th>
		   	  	<th>deliveryPrice</th>
		   	  </tr>
		   	  <tr>
		   	  	<td>1</td>
		   	  	<td>노트북1</td>      
		   	  	<td>100000</td>      
		   	  	<td>2500</td>      
		   	  </tr>
		   	  ...
		   	  ...
		   	  ..
		   </table>
			
			
		*/
		
		List<ProductDTO> productList = supposeDAO.getDTOList();
		
		model.addAttribute("productList", productList);
		
		return "chapter01_thymeleaf/controlStatment/controlEx13_pracitce1";
		
	}
	
	
	@GetMapping("/ex14_practice1")
	public String ex14_practice1(Model model) {
		
		/*
		  
		  - controlEx14_practice.html파일에 productList 데이터를 전달하여 아래와같이 데이터를 출력하시오.
			
		  <table border="1">
		   	  <tr>
		   	  	<th>productId</th>
		   	  	<th>productNm</th>
		   	  	<th>price</th>
		   	  	<th>deliveryPrice</th>
		   	  </tr>
		   	  <tr>
		   	  	<td id="productId1" name="productId1">1</td>
		   	  	<td id="productNm1" name="productNm1">노트북1</td>      
		   	  	<td id="price1" name="price1">100000</td>      
		   	  	<td id="deliveryPrice1" name="deliveryPrice1">2500</td>      
		   	  </tr>
		   	  ...
		   	  ...
		   	  ..
		   </table>
			
			
		*/
		
		List<ProductDTO> productList = supposeDAO.getDTOList();

		model.addAttribute("productList", productList);
		
		return "chapter01_thymeleaf/controlStatment/controlEx14_pracitce1";
		
	}
	
	
	@GetMapping("/ex15_practice1")
	public String ex15_practice1(Model model) {
		
		/*
		  
		 - controlEx15_practice.html파일에 productMapList 데이터를 전달하여 아래와같이 데이터를 출력하시오.
			
		  <table border="1">
		   	  <tr>
		   	  	<th>productNm</th>
		   	  	<th>price</th>
		   	  	<th>addTax</th>
		   	  	<th>totalPrice</th>
		   	  	<th>brandNm</th>
		   	  </tr>
		   	  <tr>
		   	  	<td>노트북1</td>
		   	  	<td>10000</td>      
		   	  	<td>1000.0</td>      
		   	  	<td>11000.0</td>      
		   	  	<td>"브랜드1</td>      
		   	  </tr>
		   	  ...
		   	  ...
		   	  ..
		   </table>
			
			
		*/
		
		List<Map<String,Object>> productMapList = supposeDAO.getMapList();
		
		model.addAttribute("productMapList", productMapList);
		
		return "chapter01_thymeleaf/controlStatment/controlEx15_pracitce1";
		
	}
	
	
	@GetMapping("/ex16_practice1")
	public String ex16_practice1(Model model) {
		/*
		  
		  - controlEx16_practice.html파일에 productMapList 데이터를 전달하여 아래와같이 데이터를 출력하시오.
			
		  <table border="1">
		   	  <tr>
		   	  	<th>productNm</th>
		   	  	<th>price</th>
		   	  	<th>addTax</th>
		   	  	<th>totalPrice</th>
		   	  	<th>brandNm</th>
		   	  </tr>
		   	  <tr>
		   	  	<td id="productNm0" name="productNm0">노트북1</td>
		   	  	<td id="price0" name="price0">10000</td>      
		   	  	<td id="addTax0" name="addTax0">1000.0</td>      
		   	  	<td id="totalPrice0" name="totalPrice0">11000.0</td>      
		   	  	<td id="brandNm0" name="brandNm0">"브랜드1</td>      
		   	  </tr>
		   	  ...
		   	  ...
		   	  ..
		   </table>
			
			
		*/

		
		List<Map<String,Object>> productMapList = supposeDAO.getMapList();
		
		model.addAttribute("productMapList", productMapList);
		
		return "chapter01_thymeleaf/controlStatment/controlEx16_pracitce1";
		
	}
	
}
