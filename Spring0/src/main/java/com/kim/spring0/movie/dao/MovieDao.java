package com.kim.spring0.movie.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.kim.spring0.movie.dto.MovieDto;

public interface MovieDao {
	public List<MovieDto> getList(MovieDto dto);
	public int getCount();
	public void insert(MovieDto dto);
	public MovieDto getData(int num);
	public void delete(int num);
	public void update(MovieDto dto);
}