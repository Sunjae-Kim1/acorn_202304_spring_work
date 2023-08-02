package com.example.boot07.android;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.boot07.cafe.dao.CafeDao;
import com.example.boot07.cafe.dto.CafeDto;
import com.example.boot07.gallery.dao.GalleryDao;
import com.example.boot07.gallery.dto.GalleryDto;


// 컨트롤러 케소드에서 리턴하는 데이터가 바로 클라이언트에게 응답되는 컨트롤러
@RestController
public class AndroidController {
	
	@Autowired
	private GalleryDao galleryDao;
	
	@GetMapping("/android/fortue")
    public Map<String, Object> fortune(){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("fortuneToday", "동쪽으로 가면 귀인을 만나요");
        return map;
    }
   
    private List<String> names=new ArrayList();
   
    @PostMapping("/android/insert")
    public List<String> insert(String name){
        names.add(name);
        return names;
    }
	
	@GetMapping("/android/gallery/list")
	public List<GalleryDto> galleryList(){
		
		// 20 개면 select 해오도록 GalleryDto 에 정보 담기
		GalleryDto dto = new GalleryDto();
		dto.setStartRowNum(1);
		dto.setEndRowNum(20);
		
		// GalleryDao 객체가 리턴해주는 데이터를 바로 리턴하기
		return galleryDao.getList(dto);
	}
	
	/*
	 * String Type 을 리턴하면 리턴된 String 의 내용이 그대로 응답한다.
	 */
	
	@GetMapping("/android/tweet")
	public String tweet(String msg) {
		System.out.println("안드로이드에서 전송된 문자열: " + msg);
		return "success!";
	}
	
	// Map Type 을 리턴하면 Map 에 담긴 내용이 {} 형식의 JSON 문자열로 응답
	
	@GetMapping("/android/tweet2")
	public Map<String , Object> tweet2(String msg){
		System.out.println("안드로이드에서 전송된 문자열: " + msg);
		Map<String , Object> map = new HashMap<>();
		map.put("isSuccess", true);
		return map;
	}
	
	// List Type 을 리턴하면 List 에 담긴 내용이 [] 형식의 JSON 문자열로 응답
	
	@GetMapping("/android/tweet3")
	public List<String> tweet3(String msg){
		System.out.println("안드로이드에서 전송된 문자열: " + msg);
		
		List<String> names = new ArrayList<String>();
		
		names.add("김구라");
		names.add("해골");
		names.add("원숭이");
		return names;
	}
	
	// 테스트를 위해서 CAfeDao 주입 받기
	@Autowired
	private CafeDao dao;
	
	@GetMapping("/android/list")
	public List<CafeDto> list(){
		
		// 1 Page 의 내용을 select 해오기 위한 CafeDto 객체 준비
		CafeDto dto = new CafeDto();
		dto.setStartRowNum(1);
		dto.setEndRowNum(10);
		
		List<CafeDto> list = dao.getList(dto);
		return list;
	}
}