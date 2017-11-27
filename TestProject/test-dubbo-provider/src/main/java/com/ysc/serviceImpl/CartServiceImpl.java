package com.ysc.serviceImpl;


import com.ysc.bug.JVMmemory;
import com.ysc.bug.ThreadException;
import com.ysc.dao.CartMapper;
import com.ysc.model.Cart;
import com.ysc.model.SimpleCart;
import com.ysc.model.User;
import com.ysc.service.CartServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartServiceInterface {
	@Autowired
	private CartMapper mapper;
	public void insertCart(SimpleCart cart) {
		// TODO Auto-generated method stub
		mapper.insertCart(cart);
	}
	public Cart selectCartOfUser(User user) {
		// TODO Auto-generated method stub
		return mapper.selectCartOfUser(user);
	}
	public int isHaveGoodOfCart(SimpleCart cart) {
		JVMmemory jvMmemory = new JVMmemory();
		jvMmemory.stackBreathMemory();

		ThreadException threadException = new ThreadException();
		try {
			threadException.deadLock();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return mapper.isHaveGoodOfCart(cart);
	}
	public void cartNumberAdd1(SimpleCart cart) {
		// TODO Auto-generated method stub
		mapper.cartNumberAdd1(cart);
	}
	public void cartNumberSub1(SimpleCart cart) {
		// TODO Auto-generated method stub
		mapper.cartNumberSub1(cart);
	}
	public void removreGoodOfCart(SimpleCart cart) {
		// TODO Auto-generated method stub
		mapper.removreGoodOfCart(cart);
	}
	public void confirmGoodOfCart(SimpleCart cart) {
		// TODO Auto-generated method stub
		mapper.confirmGoodOfCart(cart);
	}
	public void cancelGoodOfCart(SimpleCart cart) {
		// TODO Auto-generated method stub
		mapper.cancelGoodOfCart(cart);
	}
	public Cart selectRealCartOfUser(User user) {
		// TODO Auto-generated method stub
		return mapper.selectRealCartOfUser(user);
	}
	public void removreGoodOfCartAfterOrder(Cart cart) {
		// TODO Auto-generated method stub
		mapper.removreGoodOfCartAfterOrder(cart);
	}
}
