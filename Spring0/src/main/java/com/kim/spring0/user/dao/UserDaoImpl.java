package com.kim.spring0.user.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kim.spring0.user.dto.UserDto;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SqlSession session;
	
	@Override
	public boolean isExist(String inputId) {
		UserDto dto = session.selectOne("user.getData" , inputId);
		boolean isExist  = dto == null ? false : true;
		return isExist;
	}

	@Override
	public void insert(UserDto dto) {
		session.insert("user.insert" , dto);
	}

	@Override
	public UserDto getData(String id) {
		return session.selectOne("user.getData" , id);
	}

	@Override
	public void updatePwd(UserDto dto) {
		session.update("user.updatePwd", dto);
	}

	@Override
	public void update(UserDto dto) {
		session.update("user.update", dto);
	}

	@Override
	public void delete(String id) {
		session.delete("user.delete" , id);
	}
}