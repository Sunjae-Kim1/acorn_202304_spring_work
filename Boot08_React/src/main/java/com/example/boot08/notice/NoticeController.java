package com.example.boot08.notice;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @Controller
@RestController // Rest API 를 좀 더 편하게 만들기 위한 어노테이션
public class NoticeController {
	
	// 공지사항을 JSON 문자열 ["xxx" , "xxx" , ... ] 을 출력시키기 위한 컨트롤러 메소드
	@GetMapping("/notice")
	public List<String> getNotice(){
		// DB 에서 읽어온 공지사항 가정
		List<String> list = new ArrayList<String>();
		list.add("React 수업 중");
		list.add("Build Test");
		list.add("어쩌구 저쩌구");
		return list;
	}
}