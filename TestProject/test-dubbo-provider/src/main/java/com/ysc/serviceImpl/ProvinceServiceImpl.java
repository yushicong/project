package com.ysc.serviceImpl;

import com.ysc.dao.ProvinceMapper;
import com.ysc.model.Province;
import com.ysc.service.ProvinceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceServiceInterface {
	@Autowired
	ProvinceMapper mapper;
	public List<Province> selectAllProvince() {
		// TODO Auto-generated method stub
		return mapper.selectAllProvince();
	}

}
