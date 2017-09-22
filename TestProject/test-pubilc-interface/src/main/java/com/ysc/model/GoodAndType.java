package com.ysc.model;

public class GoodAndType implements java.io.Serializable{
	private int typeId;//类别
	private String name;//商品名称
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
