/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.sdl.model.IncidentKpi;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_事件KPI统计VO
 * </p>
 * 
 * @author maozhipeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSDL07011VO extends BaseVO implements Serializable {
	
	/**事件KPI统计信息List*/
	protected List<IncidentKpi> incidentKpiList;
	
	/**事件KPI统计信息Map*/
	protected Map<String,List<IncidentKpi>> incidentKpiMap;

	/**
	 * 事件KPI统计信息List
	 * @return 事件KPI统计信息List
	 */
	public List<IncidentKpi> getIncidentKpiList() {
		return incidentKpiList;
	}

	/**
	 * 事件KPI统计信息List
	 * @param incidentKpiList 事件KPI统计信息List
	 */
	public void setIncidentKpiList(List<IncidentKpi> incidentKpiList) {
		this.incidentKpiList = incidentKpiList;
	}

	/**
	 * 事件KPI统计信息Map
	 * @return
	 */
	public Map<String, List<IncidentKpi>> getIncidentKpiMap() {
		return incidentKpiMap;
	}

	/**
	 * 事件KPI统计信息Map
	 * @param incidentKpiMap
	 */
	public void setIncidentKpiMap(Map<String, List<IncidentKpi>> incidentKpiMap) {
		this.incidentKpiMap = incidentKpiMap;
	}
	
}
