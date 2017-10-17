package com.dev.hac.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.dev.hac.form.IGHAC0101Form;
import com.dev.hac.model.entity.HacTB;

@SuppressWarnings("serial")
public class IGHAC01DTO extends BaseDTO implements Serializable  {

	protected IGHAC0101Form ighac0101form;

	protected List<HacTB> hacList; 
	
	public IGHAC0101Form getIghac0101form() {
		return ighac0101form;
	}

	public void setIghac0101form(IGHAC0101Form ighac0101form) {
		this.ighac0101form = ighac0101form;
	}

	public List<HacTB> getHacList() {
		return hacList;
	}

	public void setHacList(List<HacTB> hacList) {
		this.hacList = hacList;
	}
	
	
	
	
	
	

}
