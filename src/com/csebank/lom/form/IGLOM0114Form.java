/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.form;

import com.csebank.lom.model.condition.RecptionGuestInfoCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 
 * 接待客人查询Form
 *
 */
public class IGLOM0114Form extends BaseForm implements RecptionGuestInfoCond {
	
	
	private static final long serialVersionUID = 1L;

	/**
	 * 来宾单位
	 */
	protected String rgunit;
	
	/**
	 * 来宾姓名
	 */
	protected String rgname;
	
	/**
	 * 来宾姓名取得
	 * @return 来宾姓名
	 */
    public String getRgname() {
		
		return rgname;
	}
    
	/**
	 * 来宾姓名设定
	 * @param rgname 来宾姓名
	 */
    public void setRgname(String rgname){
    	this.rgname=rgname;
    }
    
    /**
	 * 来宾单位取得
	 * @return 来宾单位
	 */
	public String getRgunit() {
		
		return rgunit;
	}
	
	/**
	 * 来宾单位设定
	 * @param rgname 来宾单位
	 */
	public void setRgunit(String rgunit){
		this.rgunit=rgunit;
	}

	
	
}
