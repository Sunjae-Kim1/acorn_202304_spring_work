package com.example.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.aop.aspect.MessengerAspect;
import com.example.aop.util.MemberService;
import com.example.aop.util.Messenger;

@Configuration
public class JavaConfig {
	
	// Messenger 객체를 Bean 으로 만들기
	@Bean
	public Messenger myMessenger() {
		return new Messenger();
	}
	
	//MessengerAspect 를 Bean 으로 만들기
	@Bean
	public MessengerAspect msa() {
		return new MessengerAspect();
	}
	
	//MemberService 를 Bean 으로 만들기
	@Bean
	public MemberService memberService() {
		return new MemberService();
	}
}