package com.nisuniversity.spring.dao;

import com.nisuniversity.spring.entity.UserEntity;

public interface UserDAO {
	
	UserEntity getActiveUser(String username);
}
