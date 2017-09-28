package com.ysc.serviceImpl;

import com.ysc.bug.JVMmemory;
import com.ysc.bug.MysqlException;
import com.ysc.dao.UserMapper;
import com.ysc.model.Address;
import com.ysc.model.User;
import com.ysc.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserServiceInterface {
	@Autowired
	private UserMapper mapper;
	public List<User> selectUserAndOrder() {
		// TODO Auto-generated method stub
		return mapper.selectUserAndOrder();
	}

	public List<User> selectUserAndGood() {
		// TODO Auto-generated method stub
		return mapper.selectUserAndGood();
	}

	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		JVMmemory jvMmemory = new JVMmemory();
		try {
			jvMmemory.directMemory();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return mapper.selectAllUser();
	}

	public void insertUser(User user) {
		JVMmemory jvMmemory = new JVMmemory();
		jvMmemory.funcMemory();
		// TODO Auto-generated method stub
		mapper.insertUser(user);
	}

	public Address selectAddressOfUser(User user) {
		// TODO Auto-generated method stub
		return mapper.selectAddressOfUser(user);
	}

}
