package com.ysc.serviceImpl;


import com.ysc.bug.JVMmemory;
import com.ysc.dao.OrderMapper;
import com.ysc.model.*;
import com.ysc.service.OrderServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderServiceInterface {
	@Autowired
	private OrderMapper mapper;
	public void insertOrder(Cart cart) {
		// TODO Auto-generated method stub
		mapper.insertOrder(cart);
	}

	public void insertOrderDetail(Cart cart) {
		JVMmemory jvMmemory = new JVMmemory();
		jvMmemory.heap();
		// TODO Auto-generated method stub
		mapper.insertOrderDetail(cart);
	}

	public int selectMaxOrderId() {
		// TODO Auto-generated method stub
		return mapper.selectMaxOrderId();
	}

	public void payOrder(int id) {
		// TODO Auto-generated method stub
		mapper.payOrder(id);
	}

	public List<Order> selectAllOrderAndUser(Page page) {
		// TODO Auto-generated method stub
		return mapper.selectAllOrderAndUser(page);
	}

	public List<SaleInfo> selectSalesByYear(int year) {
		// TODO Auto-generated method stub
		return mapper.selectSalesByYear(year);
	}

	public List<Order> selectOrderByTime(TimeInfo info) {
		// TODO Auto-generated method stub
		return mapper.selectOrderByTime(info);
	}

}
