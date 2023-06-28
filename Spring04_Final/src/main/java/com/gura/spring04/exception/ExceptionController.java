package com.gura.spring04.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/*
 * Spring MVC 가 동작 중에 특정 Type 의 예외가 발생하면 해당 예외를 여기서 처리할 수 있다.
 */
@ControllerAdvice
public class ExceptionController {
	// Spring FrameWork 가 동작하는 중에 NotDeleteException Type 의
	// 예외가  발생하면 호출되는 메소드
	@ExceptionHandler(NotDeleteException.class)
	public ModelAndView notDelete(NotDeleteException nde) { // 메소드의 인자로 예외 객체가 전달된다.
		ModelAndView mView = new ModelAndView();
		// exception 이라는 키 값으로 예외 객체를 담고
		mView.addObject("exception", nde);
		// View Page ( /WEB-INF/views/error/info.jsp ) 로 forward 이동해서 예외 정보 응답
		mView.setViewName("error/info");
		return mView;
	}
}