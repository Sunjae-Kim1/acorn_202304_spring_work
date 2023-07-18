package com.example.boot06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
	
	@PostMapping("/member/insert")
	@ResponseBody
	public String insert(int num , String name , String addr) {
		MemberDto dto = new MemberDto(num , name , addr);
		dto.setNum(num);
		dto.setName(name);
		dto.setAddr(addr);
		
		// 실제로 아래가 많이 쓰임
		MemberDto dto2 = MemberDto.builder() // MemberDtoBuilder Type
				.num(num)
				.name(name)
				.addr(addr)
				.build(); // MemberDto Type
		
		return "ok";
	}
}