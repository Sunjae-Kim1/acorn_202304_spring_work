package com.example.boot07.api;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

	@PostMapping("/todos")
	public Map<String, Object> insert(TodoDto dto) {
		System.out.println(dto.getId() + "|" + dto.getTitle() + "|" + dto.isComplete());

		Map<String, Object> map = new HashMap<>();
		map.put("isSuccess", true);

		return map;

	}

	@PostMapping("/todos2")
	public Map<String, Object> insert2(@RequestBody String json) {
		System.out.println(json);
		
		/*
		 * JSON 은 {"title": "XXX" , "complete": false} 형식의 문자열이다.
		 */
		JSONObject jsonObj = new JSONObject(json);
		
		// title 추출
		String title = jsonObj.getString("title");
		
		// complte 추출
		Boolean complete = jsonObj.getBoolean("complete");
		
		System.out.println(title + " | " + complete);

		Map<String, Object> map = new HashMap<>();
		map.put("isSuccess", true);

		return map;

	}
}
