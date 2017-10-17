package com.dev.hac.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BaseEntity;
import com.dev.hac.model.HacInfo;


public class HacTB  extends BaseEntity implements Serializable,
Cloneable,HacInfo {
	
	protected String id;
	
	protected String pid;
	
	protected String name;
	
	
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	



	public String getPid() {
		return pid;
	}



	public void setPid(String pid) {
		this.pid = pid;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public Serializable getPK() {
		// TODO Auto-generated method stub
		return null;
	}

}
