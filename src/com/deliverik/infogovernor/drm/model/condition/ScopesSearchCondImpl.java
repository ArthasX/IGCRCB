/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * 概述: 事件影响范围检索条件实现
  * 功能描述: 事件影响范围检索条件实现
  * 创建记录: 2015/03/20
  * 修改记录: 
  */
public class ScopesSearchCondImpl implements
		ScopesSearchCond {
	
	 /** 事件级别ID */
    protected Integer eventid;

    /**
	 * eventid 获取
	 * 
	 * @param eventid  eventid          
	 */
	public Integer getEventid() {
		return eventid;
	}
	
	/**
	 * eventid 设定
	 * 
	 * @param eventid  eventid          
	 */

	public void setEventid(Integer eventid) {
		this.eventid = eventid;
	}
    

}