package com.example.boot07.users.service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import com.example.boot07.users.dao.UsersDao;
import com.example.boot07.users.dto.UsersDto;

@Service
public class UsersServiceImpl implements UsersService{
	@Autowired
	private UsersDao dao;
	
	// application.properties 문서에 있는 파일의 저장위치 설정 정보 읽어오기
	@Value("${file.location}")
	private String fileLocation;

	@Override
	public void addUser(UsersDto dto) {
		// 비밀번호 암호화를 해줄 객체를 생성
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		// 암호화된 비밀번호를 알아내서
		String encodedPwd = encoder.encode(dto.getPwd());
		// UserDto 객체에 다시 넣고
		dto.setPwd(encodedPwd);
		// UsersDao  객체를 이용해서 DB 에 저장
		dao.insert(dto);
	}

	@Override
	public void loginProcess(UsersDto dto, HttpSession session) {
		// 입력한 정보가 맞는지 여부
		boolean isValid = false;
		// 아이디를 이용해서 회원정보를 얻는다.
		UsersDto resultDto = dao.getData(dto.getId());
		// 만일 select 된 회원의 정보가 존재하고
		if(resultDto != null) {
			// BCrypt 클래스의 static 메솓를 이용해서 입력한 비밀번호의 암호화해서 저장된 비밀번호 일치 여부를 알아내야 한다.
			isValid = BCrypt.checkpw(dto.getPwd(), resultDto.getPwd());
		}
		
		// 만일 유효한 정보라면
		if(isValid) {
			// 로그인 처리한다.
			session.setAttribute("id", resultDto.getId());
		}
	} // loginProcess()

	@Override
	public void getInfo(HttpSession session, Model model) {
		// 로그인된 아이디를 읽어온다.
		String id = (String)session.getAttribute("id");
		// DB 에서 회원 정보를 얻어와서
		UsersDto dto = dao.getData(id);
		// Model 객체에 담아준다.
		model.addAttribute("dto" , dto);
	}

	@Override
	public void updateUserPwd(HttpSession session, UsersDto dto, Model model) {
		// 세션 영역에서 로그인된 아이디 읽어오기
		String id = (String)session.getAttribute("id");
		// DB 에 저장된 회원정보 읽어오기
		UsersDto resultDto = dao.getData(id);
		// DB 에 저장된 암호화된 비밀번호
		String encodePwd = resultDto.getPwd();
		// 클라이언트가 입력한 비밀번호
		String inputPwd = dto.getPwd();
		// 두 비밀번호가 일치하는지 확인
		boolean isValid = BCrypt.checkpw(inputPwd, encodePwd);
		// 만일 일치 한다면
		if(isValid){
			// 새로운 비밀번호를 암호화한다.
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String encodedNewPwd = encoder.encode(dto.getNewPwd());
			// 암호화된 비밀번호를 dto 에 다시 넣는다.
			dto.setNewPwd(encodedNewPwd);
			// dto 에 로그인된 아이디도 넣는다.
			dto.setId(id);
			// dao 를 이용해서 DB 에 수정 반영
			dao.updatePwd(dto);
			// 로그아웃 처리
			session.removeAttribute("id");
		}
		// 작업의 성공 여부를 Model 객체에 담아 놓는다. ( 결국 HttpServletRequest 에 담긴다. )
		model.addAttribute("isSuccess" , isValid);
		// 로그인된 아이도 담는다.
		model.addAttribute("id" , id);
	}

	@Override
	public Map<String, Object> saveProfileImage(HttpServletRequest request, MultipartFile mFile) {
		 //업로드된 파일에 대한 정보를 MultipartFile 객체를 이용해서 얻어낼수 있다.   
	      
	      //원본 파일명
	      String orgFileName=mFile.getOriginalFilename();
	      //upload 폴더에 저장할 파일명을 직접구성한다.
	      // 1234123424343xxx.jpg
	      // String saveFileName=System.currentTimeMillis()+orgFileName;
	      // 절대로 중복되지 않는 유일한 파일 명을 구성한다.
	      String saveFileName = UUID.randomUUID().toString() + orgFileName;
	      
	      // webapp/upload 폴더까지의 실제 경로 얻어내기 
	      // String realPath=request.getServletContext().getRealPath("/resources/upload");
	      String realPath = fileLocation;
	      // upload 폴더가 존재하지 않을경우 만들기 위한 File 객체 생성
	      File upload=new File(realPath);
	      if(!upload.exists()) {//만일 존재 하지 않으면
	         upload.mkdir(); //만들어준다.
	      }
	      try {
	         //파일을 저장할 전체 경로를 구성한다.  
	         String savePath=realPath+File.separator+saveFileName;
	         //임시폴더에 업로드된 파일을 원하는 파일을 저장할 경로에 전송한다.
	         mFile.transferTo(new File(savePath));
	      }catch(Exception e) {
	         e.printStackTrace();
	      }
	      
	      // json 문자열을 출력하기 위한 Map 객체 생성하고 정보 담기 
	      Map<String, Object> map=new HashMap<String, Object>();
	      // map.put("imagePath", "/resources/upload/"+saveFileName);
	      map.put("imagePath", "/users/images/" + saveFileName);
	      
	      return map;
	}

	@Override
	public void updateUser(UsersDto dto, HttpSession session) {
		// 로그인된 아이디 얻어오기
		String id = (String)session.getAttribute("id");
		// dto 에 아이디 담기
		dto.setId(id);
		// dao 를 이용해서 수정반영
		dao.update(dto);
	}

	@Override
	public void deleteUser(HttpSession session, Model model) {
		// 로그인된 아이디를 불러와서
		String id = (String)session.getAttribute("id");
		// 해당 정보를 DB 에서 삭제하고
		dao.delete(id);
		// 로그아웃 처리
		session.removeAttribute("id");
		// Model 객체에 탈퇴한 회원의 아이디를 담아준다.
		model.addAttribute("id" , id);
	}
}