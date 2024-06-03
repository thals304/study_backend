package com.application.trainingVer2.postAdvance.auth;

import org.springframework.stereotype.Component;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@Component
public class AuthAdminInterceptor implements HandlerInterceptor{

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       
		HttpSession session = request.getSession(); 		// 세션객체를 생성한다.
        String role = (String)session.getAttribute("role");	// 권한정보를 반환한다.

        if (role == null || !role.equals("admin") ) { // 로그인을 하지 않았거나 , 권한이 admin이 아닐때
        	response.sendError(HttpServletResponse.SC_FORBIDDEN); // 403오류를 반환한다.
        }

        return true; // admin권한으로 로그인하였을 경우 url로 포워딩한다.
    }
	
	
}
