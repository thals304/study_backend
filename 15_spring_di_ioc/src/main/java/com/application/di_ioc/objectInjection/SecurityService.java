package com.application.di_ioc.objectInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

	// before
	// 테스트 코드 및 기타 로직 구현 불가능
	// private PasswordEncoder encoder = new BCryptPasswordEncoder();
	
	// after
	@Autowired
	private PasswordEncoder encoder;
}
