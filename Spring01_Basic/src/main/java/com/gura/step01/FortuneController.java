package com.gura.step01;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FortuneController {
	
	@RequestMapping("/fortune")
	public String fortune(HttpServletRequest request) {
		// 오늘의 운세
		String fortuneToday = "동쪽으로 가면 귀인을 만나요.";
		// Request Scope 에 응답이 필요한 데이터를 담는다.
		request.setAttribute("fortuneToday", fortuneToday);
		
		// /WEB-INF/views/fortune.jsp 페이지로 forward 이동해서 응답
		return "fortune";
	}
	
	@RequestMapping("/fortune2")
	public ModelAndView fortune2() {
		// 오늘의 운세
		String fortuneToday = "동쪽으로 가면 귀인을 만나요.";
		
		// HttpServletRequest 객체 대신에 ModelAndView 객체를 생성해서
		ModelAndView mView = new ModelAndView();
		
		// View Page 에 전달할 내용을 담는다.
		mView.addObject("fortuneToday" , fortuneToday);
		
		// View Page 위치
		mView.setViewName("fortune");
		
		// 모델과 View Page 정보가 모두 담겨있는 ModelAndView 객체를 리턴하면 똑같이 동작한다.
		return mView;
	}
	
	// ModelAndView 을 매개변수로 선언하면 스프링 프레임워크가 알아서 객체 생성 후 참조값을 넣어준다
	@RequestMapping("/fortune3")
	public ModelAndView fortune3(ModelAndView mView) {
		// 오늘의 운세
		String fortuneToday = "동쪽으로 가면 귀인을 만나요.";
		
		// View Page 에 전달할 내용을 담는다.
		mView.addObject("fortuneToday" , fortuneToday);
		
		// View Page 위치
		mView.setViewName("fortune");
		
		// 모델과 View Page 정보가 모두 담겨있는 ModelAndView 객체를 리턴하면 똑같이 동작한다.
		return mView;
	}
}