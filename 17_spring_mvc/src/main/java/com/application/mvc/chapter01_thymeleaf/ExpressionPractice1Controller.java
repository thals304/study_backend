package com.application.mvc.chapter01_thymeleaf;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.application.mvc.data.ProductDTO;
import com.application.mvc.data.SupposeDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
/*
 * 24.05.02 time 12:42-13:18
 * today 소감문
 * 일단 
 * 컨트롤러 return에서 단순히 html 파일이름만 쓰면 되는 것이 아닌 templates 다음에 파일명부터 적어줘야 한다는 점!
 * Model model에서 데이터 전송할 때 model.addAttribute("data이름",data);
 * HttpServletRequest request의 session은 HttpSession session = request.getSession();를
 * 써줘야 사용 가능 하며 , session.setAttriebute("data이름",data); 
 * 객체 , map, list는 변수명을 보내서 html에서 변수명.필드명을 해주면 됨 
 * */
@Controller
@RequestMapping("/th/expression")
public class ExpressionPractice1Controller {

	@Autowired
	private SupposeDAO supposeDAO;
	
	@GetMapping("/ex04_practice1")
	public String ex04_practice1(Model model) {
		
		/*
		 
		   - expressionEx04_practice.html파일에 아래와같이 데이터를 출력하시오.
		  
		   <h1>관리자 유저관리</h1>
		   <h3>유저전체조회</h3>
		   <h3>유저추가</h3>
		   <h3>유저수정</h3>
		   <h3>유저삭제</h3>
		   
		 */
		
		String title       = "관리자 유저관리";
		String getUserList = "유저전체조회";
		String createUser  = "유저추가";
		String updateUser  = "유저수정";
		String deleteUser  = "유저삭제";
		
		model.addAttribute("title" , title);
		model.addAttribute("getUserList" , getUserList);
		model.addAttribute("createUser" , createUser);
		model.addAttribute("updateUser" , updateUser);
		model.addAttribute("deleteUser" , deleteUser);
		
		return "chapter01_thymeleaf/expression/expressionEx04_practice1";
		
	}
	
	
	@GetMapping("/ex05_practice1")
	public String ex05_practice1(Model model) {
		
		/*
		 
		   - expressionEx05_practice.html파일에 아래와같이 데이터를 출력하시오.
		   - 단 WAS 없이 html로 파일을 실행하였을때는 상품명은 '테스트상품' 가격은 '10000원'으로 나와야 한다. 
		  
		   <p>상품명 : 기계식키보드</p>
		   <p>가격 : 38000원</p>
		   
		 */
		
		String productNm = "기계식키보드";
		int price = 38000;
		
		model.addAttribute("productNm" , productNm);
		model.addAttribute("price" , price);
		
		return "chapter01_thymeleaf/expression/expressionEx05_practice1";
		
	}
	
	
	@GetMapping("/ex06_practice1")
	public String ex06_practice1(Model model) {
		
		/*
		 
		   - expressionEx06_practice.html파일에 아래와같이 데이터를 출력하시오.
		  
		   <table border="1">
		   	  <caption>상품정보</caption>
		   	  <tr>
		   	  	<td>상품 ID</td>
		   	  	<td>100</td>
		   	  </tr>
		   	  <tr>
		   	  	<td>상품명</td>
		   	  	<td>스마트 TV</td>
		   	  </tr>
		   	  <tr>
		   	  	<td>가격</td>
		   	  	<td>3000000원</td>
		   	  </tr>
		   	  <tr>
		   	  	<td>배송비</td>
		   	  	<td>3000원</td>
		   	  </tr>
		   </table>
		   
		 */
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setBrandId(100);
		productDTO.setProductNm("스마트 TV");
		productDTO.setPrice(3000000);
		productDTO.setDeliveryPrice(3000);
		
		// 내가 처음에 쓴 방법 > brandId가 출력이 안됨
		model.addAttribute("brandId", productDTO.getBrandId());
		model.addAttribute("productNm", productDTO.getProductNm());
		model.addAttribute("price", productDTO.getPrice());
		model.addAttribute("deliveryPrice", productDTO.getDeliveryPrice());
		
		// 정답예시 - 객체를 보내서 html에서 객체명.필드명으로 함
		// model.addAttribute("productDTO" , productDTO);
		return "chapter01_thymeleaf/expression/expressionEx06_practice1";
		
	}
	
	
	@GetMapping("/ex07_practice1")
	public String ex07_practice1(Model model) {
		
		/*
		 
		  - expressionEx07_practice.html파일에 아래와같이 데이터를 출력하시오.
		  - 단 WAS 없이 html로 파일을 실행하였을때는 금액이 모두 0원으로 나와야 한다.
		  
		   <table border="1">
		   	  <caption>결제정보</caption>
		   	  <tr>
		   	  	<td>금액</td>
		   	  	<td>1000000원</td>      (<td>0원</td>)
		   	  </tr>
		   	  <tr>
		   	  	<td>부가세</td>
		   	  	<td>100000원</td>		 (<td>0원</td>)
		   	  </tr>
		   	  <tr>
		   	  	<td>결제 금액</td>
		   	  	<td>110000원</td>		 (<td>0원</td>)
		   	  </tr>
		   </table>
		   
		 */
		
		HashMap<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("price", 1000000);
		dataMap.put("tax", 100000);
		dataMap.put("totalPrice", 110000);
		
		model.addAttribute("dataMap" , dataMap);
		
		return "chapter01_thymeleaf/expression/expressionEx07_practice1";
		
	}
	
	@GetMapping("/ex08_practice1")
	public String ex08_practice1(Model model) {

		
		/*
		 
		  - expressionEx08_practice.html파일에 아래와같이 데이터를 출력하시오.
		  
		  <table border="1">
		   	  <caption>DTO</caption>
		   	  <tr>
		   	  	<td>productId</td>
		   	  	<td>1</td>      
		   	  </tr>
		   	  <tr>
		   	  	<td>productNm</td>
		   	  	<td>노트북1</td>		
		   	  </tr>
		   	  <tr>
		   	  	<td>price</td>
		   	  	<td>1000000</td>		
		   	  </tr>
		   	  <tr>
		   	  	<td>deliveryPrice</td>
		   	  	<td>2500</td>		
		   	  </tr>
		   </table>
		   
		   <hr/>

		   <table border="1">
		   	  <caption>Map</caption>
		   	  <tr>
		   	  	<td>productNm</td>
		   	  	<td>노트북1</td>      
		   	  </tr>
		   	  <tr>
		   	  	<td>price</td>
		   	  	<td>10000</td>      
		   	  </tr>
		   	  <tr>
		   	  	<td>addTax</td>
		   	  	<td>1000.0</td>      
		   	  </tr>
		   	  <tr>
		   	  	<td>totalPrice</td>
		   	  	<td>11000.0</td>		
		   	  </tr>
		   	  <tr>
		   	  	<td>brandNm</td>
		   	  	<td>브랜드1</td>		
		   	  </tr>
		   	  <tr>
		   	  	<td>atctiveYn</td>
		   	  	<td>Y</td>		
		   	  </tr>
		   </table>
		   
		 */
		ProductDTO productDTO = supposeDAO.getDTO();
		Map<String,Object> map = supposeDAO.getMap();
		
		model.addAttribute("productDTO", productDTO);
		model.addAttribute("map" , map);
		
		return "chapter01_thymeleaf/expression/expressionEx08_practice1";
		
	}
	
	
	@GetMapping("/ex09_practice1")
	public String ex09_practice1(HttpServletRequest request) {
		
		/*
		 
		  - expressionEx09_practice.html파일에 아래와같이 데이터를 출력하시오.
		  
		  - '(중요)session 객체'에 데이터를 저장하고 화면에 출력하시오.
		  
		  - WAS 없이 html로 파일을 실행하였을때는 데이터가 'default' , 'korea'으로 나와야 한다.
		  
		  <h3>브라우저이름 : chrome</h3>    (<h3>브라우저이름 : default</h3>)
		  <h3>접속위치 : kor</h3>			(<h3>접속위치 : korea</h3>)
		   
		 */
		
		String browserName = "chrome";
		String location  = "seoul";
		
		HttpSession session = request.getSession();
		session.setAttribute("browserNams", browserName);
		session.setAttribute("location", location);
		
		return "chapter01_thymeleaf/expression/expressionEx09_practice1";
		
	}

	
	@GetMapping("/ex10_practice1")
	public String ex10_practice1(Model model) {
		
		/*
		 
		  - expressionEx10_practice.html파일에 아래와같이 데이터를 출력하시오.
		  
		  - 단 HTML 태그가 적용된 상태로 출력되어야 한다.
		  
		  <div>
		  	<h1>testData1</h1>
		  </div>
		  <div>
		  	<p style='color:red;'>testData2</p>
		  </div>
		  
		 */
		
		String data1 = "<h1>testData1</h1>";
		String data2 = "<p style='color:red;'>testData2</p>";
		
		model.addAttribute("data1", data1);
		model.addAttribute("data2", data2);
		
		return "chapter01_thymeleaf/expression/expressionEx10_practice1";
		
	}
	
}
