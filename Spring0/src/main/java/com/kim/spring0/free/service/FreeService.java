package com.kim.spring0.free.service;

import javax.servlet.http.HttpServletRequest;

import com.kim.spring0.free.dto.FreeDto;

public interface FreeService {
	public void getList(HttpServletRequest request);
	public void getDetail(HttpServletRequest request);
	public void saveContent(FreeDto dto);
	public void updateContent(FreeDto dto);
	public void deleteContent(int num , HttpServletRequest request);
	public void getData(HttpServletRequest request); 
}