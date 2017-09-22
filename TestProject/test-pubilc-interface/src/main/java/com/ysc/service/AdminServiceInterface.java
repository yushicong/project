package com.ysc.service;

import com.ysc.model.Admin;

import java.util.List;

public interface AdminServiceInterface {
	public List<Admin> selectAdmin(Admin admin);//查询所有管理员
	public void addAdmin(Admin admin);//插入管理员信息
	public void updateAdmin(Admin admin);//更新
	public void deleteAdmin(Admin admin);//删除
}
