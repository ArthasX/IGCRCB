/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.drm.model.EventssInfo;
import com.deliverik.infogovernor.drm.model.ScopesInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM16021VO extends BaseVO implements Serializable{
	
	/**取得事件所有数据*/
	private  List<EventssInfo> eventssInfoList; 
	
	/**取得事件影响范围所有数据*/
	private  List<ScopesInfo> scopeInfoList; 
	
	/**取得事件一条数据*/
	private EventssInfo eventssInfo; 

	/**取得所有数据*/
	private Map<String,List<ScopesInfo>> eventssScopesMap;
	/**
	 * scopeInfoList 取得
	 * 
	 * @return scopeInfoList scopeInfoList
	 */
	public List<ScopesInfo> getScopeInfoList() {
		return scopeInfoList;
	}
	
	/**
	 * scopeInfoList 设定
	 * 
	 * @return scopeInfoList scopeInfoList
	 */

	public void setScopeInfoList(List<ScopesInfo> scopeInfoList) {
		this.scopeInfoList = scopeInfoList;
	}

	/**
	 * eventssInfo 取得
	 * 
	 * @return eventssInfo eventssInfo
	 */
	public EventssInfo getEventssInfo() {
		return eventssInfo;
	}
	
	/**
	 * eventssInfo 设定
	 * 
	 * @return eventssInfo eventssInfo
	 */

	public void setEventssInfo(EventssInfo eventssInfo) {
		this.eventssInfo = eventssInfo;
	}

	/**
	 * eventssInfoList 取得
	 * 
	 * @return eventssInfoList eventssInfoList
	 */
	public List<EventssInfo> getEventssInfoList() {
		return eventssInfoList;
	}
	
	/**
	 * eventssInfoList 设定
	 * 
	 * @return eventssInfoList eventssInfoList
	 */

	public void setEventssInfoList(List<EventssInfo> eventssInfoList) {
		this.eventssInfoList = eventssInfoList;
	}

	public Map<String, List<ScopesInfo>> getEventssScopesMap() {
		return eventssScopesMap;
	}

	public void setEventssScopesMap(Map<String, List<ScopesInfo>> eventssScopesMap) {
		this.eventssScopesMap = eventssScopesMap;
	}
	
	

}
