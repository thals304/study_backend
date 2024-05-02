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

@Controller
@RequestMapping("/th/expression")
public class ExpressionQuestionController {

	@Autowired
	private SupposeDAO supposeDAO;
	
	@GetMapping("/ex04_question")
	public String ex04_question() {
		
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
		
		return "";
		
	}
	
	
	@GetMapping("/ex05_question")
	public String ex05_question() {
		
		/*
		 
		   - expressionEx05_practice.html파일에 아래와같이 데이터를 출력하시오.
		   - 단 WAS 없이 html로 파일을 실행하였을때는 상품명은 '테스트상품' 가격은 '10000원'으로 나와야 한다. 
		  
		   <p>상품명 : 기계식키보드</p>
		   <p>가격 : 38000원</p>
		   
		 */
		
		String productNm = "기계식키보드";
		int price = 38000;
		
		return "";
		
	}
	
	
	@GetMapping("/ex06_question")
	public String ex06_question() {
		
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
		
		return "";
		
	}
	
	
	@GetMapping("/ex07_question")
	public String ex07_question() {
		
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
		
		return "";
		
	}
	
	@GetMapping("/ex08_question")
	public String ex08_question() {

		
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
		
		
		return "";
		
	}
	
	
	@GetMapping("/ex09_question")
	public String ex09_question() {
		
		/*
		 
		  - expressionEx09_practice.html파일에 아래와같이 데이터를 출력하시오.
		  
		  - '(중요)session 객체'에 데이터를 저장하고 화면에 출력하시오.
		  
		  - WAS 없이 html로 파일을 실행하였을때는 데이터가 'default' , 'korea'으로 나와야 한다.
		  
		  <h3>브라우저이름 : chrome</h3>    (<h3>브라우저이름 : default</h3>)
		  <h3>접속위치 : kor</h3>			(<h3>접속위치 : korea</h3>)
		   
		 */
		
		String browserName = "chrome";
		String location  = "seoul";
		
		return "";
		
	}

	
	@GetMapping("/ex10_question")
	public String ex10_question() {
		
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
		
		
		return "";
		
	}
	
}
