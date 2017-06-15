package com.deliverik.infogovernor.crc.model.condition;

/**
 * 概述: 事件平均解决时间检索条件实例
 *       修改记录 2014-12-25 增加sign标识
 *       zhangq@deliverik.com
 */
public class IGCRC2401CondImpl implements IGCRC2401Cond{

	/** 年份 */
	protected String year;
	/** 月份 */
	protected String month;
	/** 部门 */
	protected String dept;
	
	/** 1.事件   2.告警*/
	protected String sign;
	
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
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
	

	
	
}
