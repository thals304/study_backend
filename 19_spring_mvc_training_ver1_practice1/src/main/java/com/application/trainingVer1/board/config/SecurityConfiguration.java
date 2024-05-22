package com.application.trainingVer1.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Bean // @Bean 어노테이션은 메소드 레벨에서 사용되며 메소드가 반환하는 객체를 스프링 컨테이너의 빈으로 등록하도록 한다.
	  public PasswordEncoder passwordEncoder(){
		      return new BCryptPasswordEncoder(); // PasswordEncoder는 스프링 시큐리티에서 비밀번호를 안전하게 인코딩하거나 검증할 때 사용하는 인터페이스이다.
		}
		
	@Bean // 위에 PasswordEncoder와 세트로 사용 -> JWT에서 설명 가능
	  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			http.cors().disable()			  //cors 방지
				.csrf().disable()			  //csrf 방지
				.formLogin().disable()		  //기본 로그인페이지 없애기
				.headers().frameOptions().disable();
	 
			return http.build();
		}
}
