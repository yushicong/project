package com.cl.user.serviceImpl;

import com.cl.kafka.producer.KafkaProductorService;
import com.cl.user.dao.UserMapper;
import com.cl.user.entry.User;
import com.cl.user.servicei.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource
	private UserMapper userDao;
	@Resource
	KafkaProductorService kafkaProductorService;

	public String sayHello() {

		kafkaProductorService.sendInfo("baoy-topic", "hello world");
		User user = userDao.selectByPrimaryKey(1L);
		System.out.println("hello world----------------------------"+user.getName());

		return user.getName();

	}
}
