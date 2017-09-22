package com.ysc.serviceImpl;


import com.ysc.dao.CityMapper;
import com.ysc.model.City;
import com.ysc.model.Province;
import com.ysc.service.CityServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityServiceInterface {
	@Autowired
	private CityMapper mapper;
	public List<City> selectCityByPId(Province p) {
		// TODO Auto-generated method stub
		return mapper.selectCityByPId(p);
	}

}
