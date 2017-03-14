/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * 概述: 事件级别表检索条件实现
  * 功能描述: 事件级别表检索条件实现
  * 创建记录: 2015/03/18
  * 修改记录: 
  */
public class EventssSearchCondImpl implements
		EventssSearchCond {
	
	/** 事件ID	 */
	protected Integer eventssid;
	
	/** 事件名称	 */
	protected String eventssname;
	
	/** 事件级别	 */
	protected Integer labels;
	
	/** 事件级别	 */
	protected String eventDes;
	
	/** 事件级别修改标志	 */
	protected String flag;
	
	/** 排序字段*/
	protected String orderBy;
	
	/** 排序顺序*/
	protected String order;
	
	/**
	 * @return the orderBy
	 */
	public String getOrderBy() {
		return orderBy;
	}

	/**
	 * @param orderBy the orderBy to set
	 */
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	/**
	 * @return the order
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * eventid 获取
	 * 
	 * @param eventid  eventid          
	 */

	public Integer getEventssid() {
		return eventssid;
	}

	/**
	 * eventid 设定
	 * 
	 * @param eventid  eventid          
	 */
	public void setEventssid(Integer eventssid) {
		this.eventssid = eventssid;
	}
	
	/**
	 * eventssname 获取
	 * 
	 * @param eventssname  eventssname          
	 */

	public String getEventssname() {
		return eventssname;
	}
	
	/**
	 * eventssname 设定
	 * 
	 * @param eventssname  eventssname          
	 */

	public void setEventssname(String eventssname) {
		this.eventssname = eventssname;
	}
	
	/**
	 * labels 获取
	 * 
	 * @param labels  labels          
	 */

	public Integer getLabels() {
		return labels;
	}
	
	/**
	 * labels 设定
	 * 
	 * @param labels  labels          
	 */

	public void setLabels(Integer labels) {
		this.labels = labels;
	}

	/**
	 * flag 获取
	 * 
	 * @param flag  flag          
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * flag 设定
	 * 
	 * @param flag  flag          
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * eventDes 获取
	 * 
	 * @param eventDes  eventDes          
	 */
	public String getEventDes() {
		return eventDes;
	}

	/**
	 * eventDes 设定
	 * 
	 * @param eventDes  eventDes          
	 */
	public void setEventDes(String eventDes) {
		this.eventDes = eventDes;
	}
	
	

}