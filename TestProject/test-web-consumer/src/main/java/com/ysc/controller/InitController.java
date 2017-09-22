package com.ysc.controller;


import com.ysc.model.Advertise;
import com.ysc.model.Good;
import com.ysc.model.Province;
import com.ysc.model.Type;
import com.ysc.service.AdsServiceInterface;
import com.ysc.service.GoodServiceInterface;
import com.ysc.service.ProvinceServiceInterface;
import com.ysc.service.TypeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("InitController")
public class InitController {
	@Autowired
	private ProvinceServiceInterface service;
	@Autowired
	private TypeServiceInterface typeService;
	@Autowired
	private GoodServiceInterface goodService;
	@Autowired
	private AdsServiceInterface AdsService;
	@RequestMapping("initRegister.do")
	public ModelAndView initRegister(){
		//查询出省份
		List<Province> pList =service.selectAllProvince();
		//传值
		ModelAndView andView= new ModelAndView();
		andView.addObject("pList", pList);
		andView.setViewName("../front/register.jsp");
		return andView;
	}
	@RequestMapping("initIndex.do")
	//查询初始数据,给index.jsp显示
	public ModelAndView initIndex(HttpSession session){
		//查询出所有的类别信息
		List<Type> tList = typeService.selectTypeById(new Type());
		//查询最新的商品
		List<Good> gList = goodService.selectLatestGood();
		//查询特色的商品
		List<Good> fList = goodService.selectFeaturedGood();
		//查询顶部的广告图片
		List<Advertise> aList = AdsService.selectAds();
		ModelAndView andView = new ModelAndView();
		andView.addObject("tList", tList);
		andView.addObject("gList", gList);
		andView.addObject("fList", fList);
		andView.addObject("fListSize", fList.size());
		andView.addObject("aList", aList);
		//将类别信息存入session中，用于侧边栏的显示
		session.setAttribute("tList",tList);
		andView.setViewName("../front/index.jsp");
		return andView;
	}
}
