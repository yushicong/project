package com.ysc.service;


import com.ysc.model.City;
import com.ysc.model.Province;

import java.util.List;

public interface CityServiceInterface {
	public List<City> selectCityByPId(Province p);//根据省份查找城市
}
