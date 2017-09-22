package com.ysc.controller;

import com.google.gson.Gson;
import com.ysc.model.City;
import com.ysc.model.Province;
import com.ysc.service.CityServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("CityController")
public class CityController {
	@Autowired
	private CityServiceInterface service;
	@RequestMapping("selectCityByPId.do")
	public void selectCityByPId(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String id = request.getParameter("id");
		Province p = new Province();
		p.setId(Integer.parseInt(id));
		//查询对应的city
		List<City> cList = service.selectCityByPId(p);
		//转化成json
		Gson json = new Gson();
		String jsonValue = json.toJson(cList);
		//传递
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonValue);
		out.flush();
		out.close();
		
	}
}
