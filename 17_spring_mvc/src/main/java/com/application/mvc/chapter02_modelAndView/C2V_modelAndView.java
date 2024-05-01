package com.application.mvc.chapter02_modelAndView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.application.mvc.data.SupposeDAO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class C2V_modelAndView {

	//SupposeDAO supposeDAO = new SupposeDAO(); 
	
	@Autowired
	private SupposeDAO supposeDAO;
	
	/*
	
		1) HttpServeletRequest
		
		- 컨트롤러 클래스 메서드의 파라메타로 HttpServletRequest를 추가하여 사용한다.
		- setAttribute("속성명", 데이터) 메서드를 사용하여 데이터를 뷰로 전송 한다.
	
	*/
	
	@GetMapping("/request") //localhost/request
	public String request(HttpServletRequest request) {
		
		// 데이터 전송
		request.setAttribute("string"  , supposeDAO.getString());
		request.setAttribute("int"     , supposeDAO.getInt());
		request.setAttribute("double"  , supposeDAO.getDouble());
		request.setAttribute("boolean" , supposeDAO.getBoolean());
		request.setAttribute("date"    , supposeDAO.getDate());
		request.setAttribute("dto"     , supposeDAO.getDTO());
		request.setAttribute("dtoList" , supposeDAO.getDTOList());
		request.setAttribute("map"     , supposeDAO.getMap());
		request.setAttribute("mapList" , supposeDAO.getMapList());
		
		return "chapter02_modelAndView/c2v"; // /templates/chapter02_modelAndView/c2v.html 파일로 이동
	
	}
	
	
	/*
	 
	   2) Model
	  
	   - 컨트롤러 클래스 메서드의 파라메타로 Model을 추가하여 사용한다. 
	   - addAttribute("속성명", 데이터) 메서드를 사용하여 데이터를 뷰로 전송 한다.
	 
	 */
	
	@GetMapping("/model") //localhost/model
	public String model(Model model) {
		
		// 데이터 전송
		model.addAttribute("string"  , supposeDAO.getString());
		model.addAttribute("int"     , supposeDAO.getInt());
		model.addAttribute("double"  , supposeDAO.getDouble());
		model.addAttribute("boolean" , supposeDAO.getBoolean());
		model.addAttribute("date"    , supposeDAO.getDate());
		model.addAttribute("dto"     , supposeDAO.getDTO());
		model.addAttribute("dtoList" , supposeDAO.getDTOList());
		model.addAttribute("map"     , supposeDAO.getMap());
		model.addAttribute("mapList" , supposeDAO.getMapList());
		
		return "chapter02_modelAndView/c2v"; // /templates/chapter02_modelAndView/c2v.html 파일로 이동
	
	}
	
	/*
	
		3) ModelAndView
		
		- ModelAndView 객체를 메서드에서 생성한다.
		
		- setViewName("뷰 경로"); 메서드를 사용하여 뷰 경로를 지정한다.
		- setViewName(); 메서드 대신 생성자의 인수로 뷰 경로를 지정할 수 있다.
		
		- addObject("속성명", 데이터); 메서드를 사용하여 데이터를 뷰로 전송 한다.
		
		- ModelAndView 객체를 return한다.
	
		- 관례적으로 객체명은 mv 혹은 mav로 사용한다.

	 */
	
	@GetMapping("/modelAndView") //localhost/modelAndView
	public ModelAndView modelAndView() { // return 타입은 String(html경로)가 아닌 ModelAndView 클래스를 작성한다.
		
		/*
			ModelAndView mv = new ModelAndView();
			mv.setViewName("chapter02_modelAndView/c2v"); // 1) view 경로를 작성한다.
		*/
		
		// 2) 생성자에 view 경로를 작성한다.
		ModelAndView mv = new ModelAndView("chapter02_modelAndView/c2v");
		
		// view로 전송할 데이터를 작성한다.
		mv.addObject("string"  , supposeDAO.getString());
		mv.addObject("int"     , supposeDAO.getInt());
		mv.addObject("double"  , supposeDAO.getDouble());
		mv.addObject("boolean" , supposeDAO.getBoolean());
		mv.addObject("date"    , supposeDAO.getDate());
		mv.addObject("dto"     , supposeDAO.getDTO());
		mv.addObject("dtoList" , supposeDAO.getDTOList());
		mv.addObject("map"     , supposeDAO.getMap());
		mv.addObject("mapList" , supposeDAO.getMapList());
		
		return mv; // ModelAndView 객체를 반환한다. (페이지이동 + 데이터전송)
		
	}
	
	
}
