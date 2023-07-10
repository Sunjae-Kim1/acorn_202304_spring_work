package com.example.aop.util;

import org.springframework.stereotype.Component;

@Component
public class WritingUtil {
	// 생성자
	public WritingUtil() {
		System.out.println("WritingUtil 생성자");
	}
	
	public void writeLetter() {
		System.out.println("편지를 작성합니다.");
	}
	
	public void writeReport() {
		System.out.println("보고서를 작성합니다.");
	}
	
	public void writeDiary() {
		System.out.println("일기를 작성합니다.");
	}
}