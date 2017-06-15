/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dut.model.condition;

/**
  * 概述: 延时解锁信息表检索条件接口
  * 功能描述: 延时解锁信息表检索条件接口
  * 创建记录: 2012/04/05
  * 修改记录: 
  */
public interface DelaySearchCond {
	
	/**
	 * 日期时间从取得
	 * @return
	 */
	public String getDatetime_from();
	
	/**
	 * 日期时间到取得
	 * @return
	 */
	public String getDatetime_to();
	
	/**
	 * 申请单位取得
	 *
	 * @return 申请单位
	 */
	public String getOrgname_eq();
	
	/**
	 * 申请标题取得
	 *
	 * @return 申请标题
	 */
	public String getTitle_like();
}