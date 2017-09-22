package com.ysc.model;
//广告的图片类
public class Advertise implements java.io.Serializable{
	private int id;//广告id
	private String name;//图片名称
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Advertise [id=" + id + ", name=" + name + "]";
	}
	
}
