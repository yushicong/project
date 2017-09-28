package com.ysc.serviceImpl;

import com.ysc.bug.JVMmemory;
import com.ysc.dao.AdsMapper;
import com.ysc.model.Advertise;
import com.ysc.service.AdsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdsServiceImpl implements AdsServiceInterface {
	@Autowired
	private AdsMapper mapper;
	public void insertAds(Advertise ads) {
		// TODO Auto-generated method stub
		mapper.insertAds(ads);
	}

	public List<Advertise> selectAds() {
		// TODO Auto-generated method stub
		return mapper.selectAds();
	}

	public void deleteAds(Advertise ads) {
		// TODO Auto-generated method stub
		mapper.deleteAds(ads);
	}

}
