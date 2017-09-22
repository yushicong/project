package com.ysc.dao;


import com.ysc.model.Advertise;

import java.util.List;

public interface AdsMapper {
	public void insertAds(Advertise ads);//插入
	public List<Advertise> selectAds();
	public void deleteAds(Advertise ads);//删除
}
