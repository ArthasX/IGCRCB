package com.csebank.lom.model.condition;

public class RecptionGuestInfoCondImpl implements RecptionGuestInfoCond{
   
	
	/**
	 * ������λ
	 */
	protected String rgunit;
	
	/**
	 * ��������
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
