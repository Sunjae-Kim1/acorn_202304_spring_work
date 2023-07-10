package com.kim.spring0.movie.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kim.spring0.movie.dto.MovieDto;

@Repository
public class MovieDaoImpl implements MovieDao{

	@Autowired
	private SqlSession session;
	
	@Override
	public List<MovieDto> getList(MovieDto dto) {
		return session.selectList("movie.getList", dto);
	}

	@Override
	public int getCount() {
		return session.selectOne("movie.getCount");
	}

	@Override
	public MovieDto getData(int num) {
		return session.selectOne("movie.getData", num);
	}

	@Override
	public void insert(MovieDto dto) {
		session.insert("movie.insert", dto);
	}

	@Override
	public void delete(int num) {
		session.delete("movie.delete", num);
	}

	@Override
	public void update(MovieDto dto) {
		session.update("movie.update", dto);
	}
}