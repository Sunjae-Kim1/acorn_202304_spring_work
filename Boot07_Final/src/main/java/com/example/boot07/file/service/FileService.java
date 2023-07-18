package com.example.boot07.file.service;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;
import com.example.boot07.file.dto.FileDto;

public interface FileService {
	// 파일 목록 가져오기
	public void getList(HttpServletRequest request);
	// 업로드 된 파일 저장
	public void saveFile(FileDto dto , ModelAndView mView , HttpServletRequest request);
	// 다운로드 해줄 파일 하나의 정보 얻어오기
	public ResponseEntity<InputStreamResource> getFileData(int num) throws FileNotFoundException, UnsupportedEncodingException;
	// 파일 삭제
	public void deleteFile(int num , HttpServletRequest request);
}