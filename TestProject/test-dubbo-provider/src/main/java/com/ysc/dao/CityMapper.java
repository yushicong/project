package com.ysc.dao;

import com.ysc.model.City;
import com.ysc.model.Province;

import java.util.List;

public interface CityMapper {
	public List<City> selectCityByPId(Province p);
}
