/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * 概述: EntityItemAndConfigItemVW检索条件接口
  * 功能描述: EntityItemAndConfigItemVW检索条件接口
  * 创建记录: 2012/08/03
  * 修改记录: 
  */
public interface IG342SearchCond {

	/**
	 * 获取服务商登记开始时间
	 * @return
	 */
	public String getBeginTime_q();
	
	/**
	 * 获取服务商登记结束时间
	 * @return
	 */
	public String getEndTime_q();
	
}