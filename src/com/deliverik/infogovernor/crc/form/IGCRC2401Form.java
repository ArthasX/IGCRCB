package com.deliverik.infogovernor.crc.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 
 * 功能：事件平均解决时间Form
 *       修改记录 2014-12-25 增加sign标识
 *       zhangq@deliverik.com
 */
public class IGCRC2401Form extends BaseForm{
	
	/**   */	
	private static final long serialVersionUID = 1L;

	/** 年 */	
	protected String year;
	
	/**月*/
	protected String month;
	
	/**部门*/
	protected String dept;
	
	/** 流程主键集合*/
	protected String prid_In;
	/**
	 *1.事件
	 *2.告警 
	 */
	protected String sign;
	
	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * 流程主键集合获取
	 * @return the prid_In
	 */
	public String getPrid_In() {
		return prid_In;
	}

	/**
	 * 流程主键集合设定
	 * @param prid_In
	 */
	public void setPrid_In(String prid_In) {
		this.prid_In = prid_In;
	}
}
