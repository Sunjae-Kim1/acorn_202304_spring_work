package com.kim.spring0.user.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kim.spring0.user.dto.UserDto;

public interface UserService {
	public void addUser(UserDto dto);
	public void loginProcess(UserDto dto , HttpSession session);
	public void getInfo(HttpSession session, ModelAndView mView);
	public void updateUserPwd(HttpSession session, UserDto dto, ModelAndView mView);
	public Map<String, Object> saveProfileImage(HttpServletRequest request, MultipartFile mFile);
	public void updateUser(UserDto dto, HttpSession session);
	public void deleteUser(HttpSession session, ModelAndView mView);
}