package com.ysc.dao;

import com.ysc.model.*;
import java.util.List;

public interface OrderMapper {
	public void insertOrder(Cart cart);//插入订单
	public void insertOrderDetail(Cart cart);//插入订单详情
	public int selectMaxOrderId();
	public void payOrder(int id);
	public List<Order> selectAllOrderAndUser(Page page);//查询订单
	public List<SaleInfo> selectSalesByYear(int year);//查询该年每月销售额
	public List<Order> selectOrderByTime(TimeInfo info);//按时间查询
}
