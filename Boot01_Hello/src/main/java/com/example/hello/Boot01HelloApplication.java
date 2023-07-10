package com.example.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Boot01HelloApplication {

	public static void main(String[] args) {
		/*
		 * Spring Boot Application 의 시작점 , 도입점이 되는 main 메소드
		 */
		SpringApplication.run(Boot01HelloApplication.class, args);
		
		// resources 폴더의 config.xml 문서를 도입해서 bean 을 생성해서 관리하기
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		// 스프링이 관리하는 객체 중에 Car Type 을 얻어와서 사용하기
		Car car1 = ctx.getBean(Car.class);
		car1.drive();
	}
}