/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * 概述: 事件级别表检索条件接口
  * 功能描述: 事件级别表检索条件接口
  * 创建记录: 2015/03/18
  * 修改记录: 
  */
public interface EventssSearchCond {
	
	/**获取eventssId*/
	public Integer getEventssid();
	
	/**获取eventssname*/
	public String getEventssname();
	
	/**获取labels*/
	public Integer getLabels();
	
	/**获取flag*/
	public String getFlag();
	
	/**获取eventDes*/
	public String getEventDes();
	/**
	 * @return the orderBy
	 */
	public String getOrderBy();
	/**
	 * @return the order
	 */
	public String getOrder();
	

}