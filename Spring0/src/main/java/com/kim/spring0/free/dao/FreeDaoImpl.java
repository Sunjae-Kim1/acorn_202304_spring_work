package com.kim.spring0.free.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kim.spring0.free.dto.FreeDto;

@Repository
public class FreeDaoImpl implements FreeDao{

	@Autowired
	private SqlSession session;
	
	@Override
	public List<FreeDto> getList(FreeDto dto) {
		return session.selectList("free.getList", dto);
	}

	@Override
	public int getCount(FreeDto dto) {
		return session.selectOne("free.getCount" , dto);
	}

	@Override
	public void insert(FreeDto dto) {
		session.insert("free.insert", dto);
	}

	@Override
	public FreeDto getData(int num) {
		return session.selectOne("free.getData", num);
	}

	@Override
	public FreeDto getData(FreeDto dto) {
		return session.selectOne("free.getData2" , dto);
	}

	@Override
	public void addViewCount(int num) {
		session.update("free.addViewCount", num);
	}

	@Override
	public void delete(int num) {
		session.delete("free.delete", num);
	}

	@Override
	public void update(FreeDto dto) {
		session.update("free.update", dto);
	}
}