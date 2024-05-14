package com.application.trainingVer1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController { 
	
	@GetMapping //localhost로 요청시 아래의 메서드로 매핑된다.
	public String main() {
		return "board/boardMain"; // templates/board/boardMain.html로 이동
	}
}
