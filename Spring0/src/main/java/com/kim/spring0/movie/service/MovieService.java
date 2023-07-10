package com.kim.spring0.movie.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.kim.spring0.movie.dto.MovieDto;

public interface MovieService {
	public void getList(HttpServletRequest request);
	public void saveImage(MovieDto dto , HttpServletRequest request);
	public void getDetail(ModelAndView mView , int num);
	public void delete(int num , HttpServletRequest request);
	public void update(MovieDto dto , HttpServletRequest request);
}