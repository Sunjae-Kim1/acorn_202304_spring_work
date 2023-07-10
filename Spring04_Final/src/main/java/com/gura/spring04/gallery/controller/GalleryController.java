package com.gura.spring04.gallery.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring04.gallery.dto.GalleryDto;
import com.gura.spring04.gallery.service.GalleryService;

import oracle.jdbc.proxy.annotation.Post;

@Controller
public class GalleryController {
	
	@Autowired
	private GalleryService service;
	
	@RequestMapping(method = RequestMethod.POST , value = "/gallery/ajax_upload")
	@ResponseBody
	public Map<String , Object> ajaxUpload(GalleryDto dto , HttpServletRequest request){
		// 서비스를 이용해서 업로드된 이미지를 저장하고
		service.saveImage(dto, request);
		// {"isSuccess": true} 형식의 JSON 문자열 응답
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("isSuccess", true);
		return map;
	}
	
	@RequestMapping("/gallery/upload_form3")
	public String uploadform3(){
		return "gallery/upload_form3";
	}
	
	@RequestMapping("/gallery/upload_form2")
	public String uploadform2(){
		return "gallery/upload_form2";
	}
	
	@RequestMapping(method = RequestMethod.GET , value = "/gallery/detail")
	public ModelAndView detail(ModelAndView mView , int num) {
		service.getDetail(mView, num);
		mView.setViewName("gallery/detail");
		return mView;
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/gallery/upload")
	public String upload(GalleryDto dto , HttpServletRequest request) {
		// form 에서 dto 로 데이터를 받아옴
		// dto : caption , MultipartFile image 를 가지고 있다.
		// request : imagePath 만드는데 사용 , session 영역의 id 가 가져오는데 사용
		service.saveImage(dto, request);
		return "gallery/upload";
	}
	
	@RequestMapping("/gallery/upload_form")
	public String uploadform(){
		return "gallery/upload_form";
	}

	@RequestMapping("/gallery/list")
	public String getList(HttpServletRequest request) {
		service.getList(request);
		return "gallery/list";
	}
}