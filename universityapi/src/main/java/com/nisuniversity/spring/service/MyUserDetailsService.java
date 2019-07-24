package com.nisuniversity.spring.service;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.nisuniversity.spring.dao.UserDAO;
import com.nisuniversity.spring.entity.UserEntity;
@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private UserDAO userDAO;
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		UserEntity activeUserInfo = userDAO.getActiveUser(userName);
		GrantedAuthority authority = new SimpleGrantedAuthority(activeUserInfo.getRole());
		UserDetails userDetails = (UserDetails)new User(activeUserInfo.getUsername(),
				activeUserInfo.getPassword(), Arrays.asList(authority));
		return userDetails;
	}
} 