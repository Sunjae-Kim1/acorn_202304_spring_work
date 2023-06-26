package com.gura.spring03.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/*
 * [ 인터셉터 만들기 ]
 * 
 * 1. HandlerInterceptor 인터페이스를 구현해서 만든다.
 * 2. Servlet context.xml 에Bean 설정을 하고 Interceptor 목록에 등록을 하고 맵핑을 해준다.
 */
public class MyInterceptor implements HandlerInterceptor{
	
	// Controller 실행 이전에 호출되는 메소드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// Request Scope 에 메세지 담기
		request.setAttribute("msg", "나는 인터셉터입니다.");
		System.out.println("preHandle()");
		/*
		 * true 를 리턴하면 계속 흐름을 이어가고 false 를 리턴하면 이어가지 않는다.
		 */
		return true;
	}

	// Controller 실행 이후에 호출되는 메소드
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle()");
	}

	// 응답된 이후에 호출되는 메소드
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion()");
	}
}