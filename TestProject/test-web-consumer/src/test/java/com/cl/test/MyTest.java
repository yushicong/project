package com.cl.test;

import com.ysc.model.User;
import com.ysc.service.UserServiceInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "spring/*.xml" });
		UserServiceInterface service = (UserServiceInterface) context.getBean("userServiceInterface");
		List<User> list = service.selectAllUser();
		for(User user : list ){
			System.out.println(user.getPersonName());
		}
	}
}
