package com.kim.spring0.movie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kim.spring0.movie.dto.MovieDto;
import com.kim.spring0.movie.service.MovieService;

@Controller
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	@RequestMapping("/movie/update")
	public ModelAndView update(MovieDto dto , ModelAndView mView , HttpServletRequest request) {
		service.update(dto , request);
		mView.setViewName("movie/update");
		return mView;
	}
	
	@RequestMapping("/movie/update_form")
	public ModelAndView updateForm(int num , ModelAndView mView) {
		service.getDetail(mView, num);
		mView.setViewName("movie/update_form");
		return mView;
	}
	
	@RequestMapping("/movie/delete")
	public String delete(int num , HttpServletRequest request) {
		service.delete(num, request);
		return "redirect:/movie/list";
	}
	
	@RequestMapping("/movie/detail")
	public ModelAndView detail(ModelAndView mView , int num) {
		service.getDetail(mView, num);
		mView.setViewName("movie/detail");
		return mView;
	}
	
	@RequestMapping("movie/upload")
	public String upload(MovieDto dto , HttpServletRequest request) {
		service.saveImage(dto, request);
		return "redirect:/movie/list";
	}
	
	@RequestMapping("/movie/upload_form")
	public String uploadForm() {
		return "movie/upload_form";
	}
	
	@RequestMapping("/movie/list")
	public String getList(HttpServletRequest request) {
		service.getList(request);
		return "movie/list";
	}
}