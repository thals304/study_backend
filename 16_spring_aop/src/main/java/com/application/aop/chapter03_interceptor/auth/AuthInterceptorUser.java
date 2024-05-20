package com.application.aop.chapter03_interceptor.auth;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class AuthInterceptorUser implements HandlerInterceptor{
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
		HttpSession session = request.getSession();
		String role = (String)session.getAttribute("role");
		
		if (role == null || !role.equals("user")) { // 로그인을 안했거나 user 권한이 아닐경우
			
			// 1) 다른 화면으로 이동
			//response.sendRedirect("/auth/login");	
			
			// 2) PrintWriter 사용
			/*
			    String jsScript = """
	 				   <script>
	 					   alert('접근 불가능합니다.');
	 					   location.href = '/auth/login';
	 				   </script>"""; 
	        	
	        	response.setContentType("text/html; charset=utf-8");
	        	PrintWriter out = response.getWriter();	
	        	out.print(jsScript); 
	        	*/
	        	
	        // 3) 403 Forbidden 오류	
	        response.sendError(HttpServletResponse.SC_FORBIDDEN);	
			return false;
		
		}
		
		return true;
        
    }
}
