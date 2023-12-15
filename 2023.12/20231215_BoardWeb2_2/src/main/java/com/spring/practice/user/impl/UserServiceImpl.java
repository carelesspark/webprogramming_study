package com.spring.practice.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.practice.user.UserService;
import com.spring.practice.user.UserVO;

import lombok.Setter;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}

}
