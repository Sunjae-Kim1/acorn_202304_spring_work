package com.gura.spring04.cafe.dao;

import java.util.List;

import com.gura.spring04.cafe.dto.CafeDto;

public interface CafeDao {
	// 글 목록
	public List<CafeDto> getList(CafeDto dto);
	// 글의 갯수
	public int getCount(CafeDto dto);
	// 글 추가
	public void insert(CafeDto dto);
	// 글 정보 얻어오기
	public CafeDto getData(int num);
	// 키워드를 활용해 글 정보 얻어오기 ( 키워드에 부합되는지 글 중에서 이전 글 , 다음 글의 글 번호도 얻어올 수 있도록 )
	public CafeDto getData(CafeDto dto);
	// 조회 수 증가
	public void addViewCount(int num);
	// 글 삭제
	public void delete(int num);
	// 글 수정
	public void update(CafeDto dto);
}