/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * 概述: EntityItemRelationVW检索条件接口
  * 功能描述: EntityItemRelationVW检索条件接口
  * 创建记录: 2012/07/12
  * 修改记录: 
  */
public interface IG343SearchCond {

	/**
	 * 获取服务记录开始时间
	 * @return
	 */
	public String getBeginTime_q();
	
	/**
	 * 获取服务记录结束时间
	 * @return
	 */
	public String getEndTime_q();
	
	/**
	 * 获取服务记录的服务商名称
	 * @return
	 */
	public String getEiname_like();
}