/*
 * 北京递蓝科软件技术有限公司版权所有,保留所有权利.
 */
package com.deliverik.infogovernor.dut.model;

import com.deliverik.framework.base.BaseModel;
/**
 * 
 * 值班检查项检查时间接口
 *
 */
public interface DutyAuditTime  extends BaseModel{
	/**
	 * 
	 * 检查时间ID取得
	 * @return 检查时间ID
	 */
	public  Integer getDatid();
	
	/**
	 * 
	 * 检查项ID取得
	 * @return 检查项ID
	 */
	public  Integer getDadid();
	
	/**
	 * 
	 * 检查时间取得
	 * @return 检查时间
	 */
	public  String getDattime ();
	
	/**
	 * 
	 * 限制时间取得
	 * @return 限制时间
	 */
	public String getDatlimtime();
	
}