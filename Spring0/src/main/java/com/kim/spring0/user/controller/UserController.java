package com.kim.spring0.user.controller;

import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kim.spring0.user.dto.UserDto;
import com.kim.spring0.user.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	// 회원 탈퇴 요청 처리
		@RequestMapping("/user/delete")
		public ModelAndView delete(HttpSession session , ModelAndView mView) {
			service.deleteUser(session, mView);
			mView.setViewName("user/delete");
			return mView;
		}
		
		@RequestMapping(method = RequestMethod.POST , value = "/user/update")
		public ModelAndView update(UserDto dto , HttpSession session , ModelAndView mView) {
			// 서비스를 이용해서 개인정보를 수정하고
			service.updateUser(dto, session);
			// 개인정보 보기로 리다이렉트 이동한다.
			mView.setViewName("redirect:/user/info");
			return mView;
		}
		
		// AJAX 프로필 사진 업로드 요청 처리
		@RequestMapping(method = RequestMethod.POST , value = "/user/profile_upload")
		@ResponseBody
		public Map<String , Object> profileUpload(HttpServletRequest request , MultipartFile image){
			// 서비스를 이용해서 이미지를 upload 폴더에 저장하고 리턴되는 Map 을 리턴해서 JSON 문자열 응답하기
			return service.saveProfileImage(request, image);
		}
		
		// 개인정보 수정 폼 요청 처리
		@RequestMapping("/user/update_form")
		public ModelAndView updateform(HttpSession session , ModelAndView mView) {
			service.getInfo(session, mView);
			mView.setViewName("user/update_form");
			return mView;
		}
		
		// 비밀번호 수정 요청 처리
		@RequestMapping("/user/pwd_update")
		public ModelAndView pwdUpdate(UserDto dto , ModelAndView mView , HttpSession session) {
			// 서비스에 필요한 객체의 참조값을 전달해서 비밀번호 수정 로직을 처리한다.
			service.updateUserPwd(session, dto, mView);
			//View Page 로 forward 이동해서 응답한다.
			mView.setViewName("user/pwd_update");
			return mView;
		}
		
		// 비밀번호 수정 폼 요청 처리
		@RequestMapping("/user/pwd_update_form")
		public String pwdUpdateForm() {
			return "user/pwd_update_form";
		}
		
		// 개인 정보 보기 요청 처리
		@RequestMapping("/user/info")
		public ModelAndView info(HttpSession session , ModelAndView mView) {
			service.getInfo(session , mView);
			
			mView.setViewName("user/info");
			return mView;
		}
		
		@RequestMapping("/user/logout")
		public String logout(HttpSession session) {
			// 세션에서 id 라는 키값으로 저장된 값 삭제
			session.removeAttribute("id");
			return "user/logout";
		}
		
		// 로그인 폼 요청 처리
			@RequestMapping("/user/login")
			public ModelAndView login(ModelAndView mView , UserDto dto , String url , HttpSession session) {
				/*
				 * 서비스에서 비즈니스 로직을 처리할때 필요로 하는 객체를 컨트롤러에서 직접 전달해 주어야 한다.
				 * 주로 , HttpServletRequest , HttpServletResponse , HttpSession , ModelAndView
				 * 등등의 객체이다.
				 */
				service.loginProcess(dto, session);
				
				// 로그인 후에 가야할 목적지 정보를 인코딩하지 않은 것과 인코딩 한 것 모두 ModelAndView 객체에 담고
				String encodedUrl = URLEncoder.encode(url);
				mView.addObject("url" , url);
				mView.addObject("encodedUrl" , encodedUrl);
				
				// View Page 로 forward 이동해서 응답
				mView.setViewName("user/login");
				return mView;
			}
		
		// 로그인 폼 요청 처리
		@RequestMapping(method = RequestMethod.GET , value = "/user/login_form")
		public String loginForm() {
			return "user/login_form";
		}
		
		// 회원가입 요청처리
		@RequestMapping(method = RequestMethod.POST , value = "/user/signup")
		public ModelAndView signup(ModelAndView mView , UserDto dto) {
			// 서비스를 이용하여 DB 에 저장하고
			service.addUser(dto);
			// View Page 로 forward 이동해서 응답
			mView.setViewName("redirect:/user/login_form");
			return mView;
		}
		
		/*
		 * GET 방식 /users/signup_form 요청을 처리할 메소드
		 * - 요청방식이 다르면 실행 X
		 */
		@RequestMapping(method = RequestMethod.GET , value = "/user/signup_form")
		public String signupForm() {
			return "user/signup_form";
		}
}