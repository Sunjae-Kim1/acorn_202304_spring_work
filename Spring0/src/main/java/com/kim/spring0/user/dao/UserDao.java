package com.kim.spring0.user.dao;

import com.kim.spring0.user.dto.UserDto;

public interface UserDao {
	public boolean isExist(String inputId);
	public void insert(UserDto dto);
	public UserDto getData(String id);
	public void updatePwd(UserDto dto);
	public void update(UserDto dto);
	public void delete(String id);
}