/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
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
	
	/**ȡ���¼���������*/
	private  List<EventssInfo> eventssInfoList; 
	
	/**ȡ���¼�Ӱ�췶Χ��������*/
	private  List<ScopesInfo> scopeInfoList; 
	
	/**ȡ���¼�һ������*/
	private EventssInfo eventssInfo; 

	/**ȡ����������*/
	private Map<String,List<ScopesInfo>> eventssScopesMap;
	/**
	 * scopeInfoList ȡ��
	 * 
	 * @return scopeInfoList scopeInfoList
	 */
	public List<ScopesInfo> getScopeInfoList() {
		return scopeInfoList;
	}
	
	/**
	 * scopeInfoList �趨
	 * 
	 * @return scopeInfoList scopeInfoList
	 */

	public void setScopeInfoList(List<ScopesInfo> scopeInfoList) {
		this.scopeInfoList = scopeInfoList;
	}

	/**
	 * eventssInfo ȡ��
	 * 
	 * @return eventssInfo eventssInfo
	 */
	public EventssInfo getEventssInfo() {
		return eventssInfo;
	}
	
	/**
	 * eventssInfo �趨
	 * 
	 * @return eventssInfo eventssInfo
	 */

	public void setEventssInfo(EventssInfo eventssInfo) {
		this.eventssInfo = eventssInfo;
	}

	/**
	 * eventssInfoList ȡ��
	 * 
	 * @return eventssInfoList eventssInfoList
	 */
	public List<EventssInfo> getEventssInfoList() {
		return eventssInfoList;
	}
	
	/**
	 * eventssInfoList �趨
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
