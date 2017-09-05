package com.cl.user.serviceImpl;

import com.cl.user.dao.UserMapper;
import com.cl.user.entry.User;
import org.springframework.stereotype.Service;

import com.cl.user.servicei.UserService;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource
	private UserMapper userDao;


	public String sayHello() {

		User user = userDao.selectByPrimaryKey(1L);
		
		System.out.println("hello world----------------------------"+user.getName());
		
		return user.getName();
		
	}
}
