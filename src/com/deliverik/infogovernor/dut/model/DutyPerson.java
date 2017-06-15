/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dut.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 值班人管理实体接口
 */
public interface DutyPerson extends BaseModel {	
	
	/**
	 * 检查项ID
	 */
	public Integer getDperid();

	/**
	 * 值班计划ID
	 */
	public Integer getDpid();
	
	/**
	 * 值班日期
	 */
	public String getDpertime();
	
	/**
	 * 白班/夜班
	 */
	public String getDptype();
	
	/**
	 * 值班人ID
	 */
	public String getDperuserid();
	
	/**
	 * 值班人姓名
	 */
	public String getDperusername();

}
