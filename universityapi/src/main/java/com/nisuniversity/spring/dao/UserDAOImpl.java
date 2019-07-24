package com.nisuniversity.spring.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nisuniversity.spring.entity.UserEntity;
@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Override
	public UserEntity getActiveUser(String username) {
		UserEntity activeUser = new UserEntity();
		int enabled = 1;
		List<?> list = hibernateTemplate.find("FROM UserEntity WHERE username=? and enabled=?",
			       username, enabled);
		if(!list.isEmpty()) {
			activeUser = (UserEntity)list.get(0);
		}
		return activeUser;
	}
} 