package com.example.boot07.users.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.example.boot07.users.dto.UsersDto;
import com.example.boot07.users.service.UsersService;

@Controller
public class UsersController {
	
	// 의존객체 주입 받기
	@Autowired
	private UsersService service;
		
	@Value("${file.location}")
	private String fileLocation;
	
	@GetMapping(value = "/users/images/{imageName}" , 
				produces = {MediaType.IMAGE_GIF_VALUE , MediaType.IMAGE_JPEG_VALUE , MediaType.IMAGE_PNG_VALUE}
			)
	@ResponseBody
	public byte[] getImage(@PathVariable("imageName") String imageName) throws IOException {
		// imageName 에는 응답해줄 이미지의 이름이 들어있다.
		
		// 읽어들일 파일의 경로
		// C:/acorn2023/upload/kim1.png 형식의 경로
		String absolutePath = fileLocation + File.separator + imageName;
		
		// 파일에서 읽어들일 InputStream
		InputStream is = new FileInputStream(absolutePath);
		
		// fileLocation 필드에는 파일이 저장되어 있는 서버의 파일 시스템에서의 위치가 들어있다.
		return IOUtils.toByteArray(is);
	}
		
	// 회원 탈퇴 요청 처리
	@GetMapping("/users/delete")
	public String delete(HttpSession session , Model model) {
		/*
		* 컨트롤러의 메소드로 전달받은 Model 객체를 서비스 객체에 전달해서
		* View Page 에 전달할 Data ( 모델 ) 이 담기도록 해야한다.
		* Model 객체에 addAttribute() 해서 담은 Data 는 Spring 프레임워크가
		* HttpServetRequest 객체에 setAttribute() 해서 대신 담아준다.
		* 따라서 forward 이동된 ( 응답을 위임 받은 ) JSP 페이지에서 해당 Data 를 사용할 수 있는 것이다.
		*/
		service.deleteUser(session, model);
			
		// View Page 의 정보를 리턴 ( forward 이동될 JSP 페이지의 위치 ) 
		return "users/delete";
	}
		
	@PostMapping("/users/update")
	public String update(UsersDto dto , HttpSession session , Model model) {
			// 서비스를 이용해서 개인정보를 수정하고
			service.updateUser(dto, session);
			// 개인정보 보기로 리다이렉트 이동한다.
			return "redirect:/users/info";
		}
		
		// AJAX 프로필 사진 업로드 요청 처리
		@PostMapping("/users/profile_upload")
		@ResponseBody
		public Map<String , Object> profileUpload(HttpServletRequest request , MultipartFile image){
			// 서비스를 이용해서 이미지를 upload 폴더에 저장하고 리턴되는 Map 을 리턴해서 JSON 문자열 응답하기
			return service.saveProfileImage(request, image);
		}
		
		// 개인정보 수정 폼 요청 처리
		@GetMapping("/users/updateform")
		public String updateform(HttpSession session , Model model) {
			service.getInfo(session, model);
			return "users/updateform";
		}
		
		// 비밀번호 수정 요청 처리
		@PostMapping("/users/pwd_update")
		public String pwdUpdate(UsersDto dto , Model model , HttpSession session) {
			// 서비스에 필요한 객체의 참조값을 전달해서 비밀번호 수정 로직을 처리한다.
			service.updateUserPwd(session, dto, model);
			//View Page 로 forward 이동해서 응답한다.
			return "users/pwd_update";
		}
		
		// 비밀번호 수정 폼 요청 처리
		@GetMapping("/users/pwd_updateform")
		public String pwdUpdateForm() {
			return "users/pwd_updateform";
		}
		
		// 개인 정보 보기 요청 처리
		@GetMapping("/users/info")
		public String info(HttpSession session , Model model) {
			service.getInfo(session , model);
			return "users/info";
		}
		
		@GetMapping("/users/logout")
		public String logout(HttpSession session) {
			// 세션에서 id 라는 키값으로 저장된 값 삭제
			session.removeAttribute("id");
			return "users/logout";
		}
		
		// 로그인 폼 요청 처리
		@PostMapping("/users/login")
		public String login(Model model , UsersDto dto , String url , HttpSession session) {
			/*
			* 서비스에서 비즈니스 로직을 처리할때 필요로 하는 객체를 컨트롤러에서 직접 전달해 주어야 한다.
			* 주로 , HttpServletRequest , HttpServletResponse , HttpSession , ModelAndView
			* 등등의 객체이다.
			*/
			service.loginProcess(dto, session);
				
			// 로그인 후에 가야할 목적지 정보를 인코딩하지 않은 것과 인코딩 한 것 모두 ModelAndView 객체에 담고
			String encodedUrl = URLEncoder.encode(url);
			model.addAttribute("url" , url);
			model.addAttribute("encodedUrl" , encodedUrl);
				
			// View Page 로 forward 이동해서 응답
			return "users/login";
		}
		
		// 로그인 폼 요청 처리
		@GetMapping("/users/loginform")
		public String loginform() {
			return "users/loginform";
		}
		
		// 회원가입 요청처리
		@PostMapping("/users/signup")
		public String signup(Model model , UsersDto dto) {
			// 서비스를 이용하여 DB 에 저장하고
			service.addUser(dto);
			// View Page 로 forward 이동해서 응답
			return "users/signup";
		}
		
		/*
		 * GET 방식 /users/signup_form 요청을 처리할 메소드
		 * - 요청방식이 다르면 실행 X
		 */
		@GetMapping("/users/signup_form")
		public String signupForm() {
			return "users/signup_form";
		}
}