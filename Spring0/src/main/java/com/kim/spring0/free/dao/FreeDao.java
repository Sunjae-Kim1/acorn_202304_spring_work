package com.kim.spring0.free.dao;

import java.util.List;

import com.kim.spring0.free.dto.FreeDto;

public interface FreeDao {
		public List<FreeDto> getList(FreeDto dto);
		public int getCount(FreeDto dto);
		public void insert(FreeDto dto);
		public FreeDto getData(int num);
		public FreeDto getData(FreeDto dto);
		public void addViewCount(int num);
		public void delete(int num);
		public void update(FreeDto dto);
}