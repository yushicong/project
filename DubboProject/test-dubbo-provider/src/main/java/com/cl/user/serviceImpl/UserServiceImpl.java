package com.cl.user.serviceImpl;

import com.cl.kafka.producer.KafkaProductorService;
import com.cl.task.KafkaProductorServiceTask;
import com.cl.user.dao.UserMapper;
import com.cl.user.entry.User;
import com.cl.user.servicei.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource
	private UserMapper userDao;

	public String sayHello() {
		KafkaProductorService t = new KafkaProductorService();
		t.sendInfo();
		User user = userDao.selectByPrimaryKey(1L);
		System.out.println("hello world----------------------------"+user.getName());
		
		return user.getName();
		
	}
}
