package com.gura.spring04.gallery.dao;

import java.util.List;

import com.gura.spring04.gallery.dto.GalleryDto;

public interface GalleryDao {
	public List<GalleryDto> getList(GalleryDto dto);		// 갤러리 리스트 가져오기
	public int getCount();									// 모든 Row 갯수
	public void insert(GalleryDto dto);						// 갤러리에 사진 저장
	public GalleryDto getData(int num);					// pk num 에 해당하는 DB 에서 갤러리 게시글 하나의 정보 가져오기
}
