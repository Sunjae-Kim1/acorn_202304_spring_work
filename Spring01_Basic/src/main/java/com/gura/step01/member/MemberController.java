package com.gura.step01.member;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@RequestMapping("/member/delete")
	public String delete(int num) {
		System.out.println(num + " 번 회원을 삭제합니다.");
		/*
		 * 리다이렉트 응답할 시 "redirect: 새로고침할 경로" 형식으로 View Page 정보를 작성한다.
		 */
		return "redirect:/";
	}
	
	// "/member/insertform" 요청을 처리할 메소드
	@RequestMapping("/member/insertform")
	public String insertform() {
		// 응답할 JSP 페이지의 위치를 리턴
		return "member/insertform";
	}
	
	/*
	 * [ 요청 파라미터 추출 방법 ]
	 * 
	 * HttpServletRequest 객체를 Controller 메소드로 전달받아서 직접 추출한다.
	 */
	@RequestMapping("/member/insert")
	public String insert(HttpServletRequest request) throws UnsupportedEncodingException {
		int num = Integer.parseInt(request.getParameter("num"));
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		
		System.out.println(num + " | " + name + " | " + addr);
		return "member/insert";
	}
	
	/*
	 * [ 요청 파라미터 추출 방법2 ]
	 * 
	 * 파라미터 명과 동일하게 메소드의 매게변수를 선언해 놓으면 자동으로 추출한다.
	 * <input num = "num"> 이면 int num or String num ,
	 * <input name = "email"> 이면 String email 형식으로 선언한다.
	 */
	@RequestMapping("/member/insert2")
	public String insert2(int num , String name , String addr) {
		System.out.println(num + " | " + name + " | " + addr);
		return "member/insert";
	}
	
	 /*
     *  [ 요청 파라미터 추출하는 방법 3 ]
     *  
     *  파라미터명과 동일한 필드명을 가지고 있는 dto 클래스 type 을  메소드의 매개변수로 선언해 놓으면
     *  자동으로 추출해서 dto 에  추출한 값을 setter 메소드를 이용해서 넣은 다음  해당 dto 객체의 
     *  참조값이 전달된다.
     *  
     *  pulic class MemberDto{
     *     private int num;  => <input name="num">
     *     private String name; => <input name="name">
     *     private String addr; => <input name="addr">
     *  }
     */
	@RequestMapping("/member/insert3")
	public String insert3(MemberDto dto) {
		System.out.println(dto.getNum() + " | " + dto.getName() + " | " + dto.getAddr());
		return "member/insert";
	}
}