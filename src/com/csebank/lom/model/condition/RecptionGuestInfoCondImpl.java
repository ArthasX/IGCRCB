package com.csebank.lom.model.condition;

public class RecptionGuestInfoCondImpl implements RecptionGuestInfoCond{
   
	
	/**
	 * 来宾单位
	 */
	protected String rgunit;
	
	/**
	 * 来宾姓名
	 */
	protected String rgname;
	
	
	public String getRgname() {
		
		return rgname;
	}
	
    public void setRgname(String rgname){
    	this.rgname=rgname;
    }
	
	public String getRgunit() {
		
		return rgunit;
	}
	
	public void setRgunit(String rgunit){
		this.rgunit=rgunit;
	}

}
