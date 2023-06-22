package com.gura.spring02.guest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring02.guest.dto.GuestDto;
import com.gura.spring02.guest.service.GuestService;

@Controller
public class GuestController {
	
	// 컨트롤러는 비즈니스 로직을대신 처리해주는 서비스에 의존한다.
	@Autowired
	private GuestService service;
	
	@RequestMapping("/guest/list")
	public ModelAndView list(ModelAndView mView) {
		// 서비스의 메소드를 호출해서 ModelAndView 객체의 참조값을 전달하면 방명록 목록이 담긴다.
		service.getGuestList(mView);
		
		// View Page 정보를 담고 
		mView.setViewName("guest/list");
		
		// 2개의 정보를 담은 ModelAndView 객체를 리턴하면
		// addObject( key , value ) 를 통해서 담은 정보를 Request Scope 에 담기고
		// setViewName ( View Page 위치 ) 를 통해서 담은 정보를
		// 해당 View Page 로 forward 이동해서 응답 
		return mView;
	}
	
	@RequestMapping("/guest/insertform")
	public String insertform() {
		return "guest/insertform";
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/guest/insert")
	public String insert(GuestDto dto) {
		service.addGuest(dto);
		return "guest/insert";
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/guest/delete")
	public String delete(GuestDto dto) {
		service.deleteGuest(dto);
		return "redirect:/guest/list";
	}
	
	@RequestMapping("guest/updateform")
	public ModelAndView updateform(ModelAndView mView , int num) {
		// 서비스를 이용해서 ModelAndView 객체에 글 하나의 정보를 담아온다.
		service.getGuestInfo(mView , num);
		
		// View Page 로 forward 이동해서 수정폼 응답
		mView.setViewName("guest/updateform");
		
		return mView;
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "guest/update")
	public String update(GuestDto dto) {
		service.updateGuest(dto);
		return "guest/update";
	}
}