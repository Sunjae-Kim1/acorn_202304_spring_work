package com.kim.spring0.free.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kim.spring0.free.dto.FreeDto;
import com.kim.spring0.free.service.FreeService;

@Controller
public class FreeController {

	@Autowired
	private FreeService service;
	
	@RequestMapping("/free/list")
	public String getList(HttpServletRequest request) {
		service.getList(request);
		return "free/list";
	}
	
	@RequestMapping("/free/insert_form")
	public String insertForm() {
		return "free/insert_form";
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/free/insert")
	public String insert(FreeDto dto, HttpSession session , HttpServletRequest request) {
		String writer=(String)session.getAttribute("id");
		dto.setWriter(writer);
		service.saveContent(dto);
		service.getList(request);
		return "free/list";
	}
	
	@RequestMapping("/free/detail")
	public String detail(HttpServletRequest request) {
		service.getDetail(request);
		return "free/detail";
	}
	
	@RequestMapping("/free/delete")
	public String delete(int num , HttpServletRequest request) {
		service.deleteContent(num, request);
		service.getList(request);
		return "redirect:/free/list";
	}
	
	@RequestMapping("/free/update_form")
	public String updateForm(HttpServletRequest request) {
		service.getData(request);
		return "free/update_form";
	}
	
	@RequestMapping("/free/update")
	public String update(FreeDto dto) {
		service.updateContent(dto);
		return "free/update";
	}
}