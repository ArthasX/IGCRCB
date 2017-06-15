/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.sdl.model.IncidentKpi;
import com.deliverik.infogovernor.sdl.model.condition.IncidentKpiSearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_统计DTO
 * </p>
 * 
 * @author maozhipeng@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSDL07DTO extends BaseDTO implements Serializable {
	
	/**变更KPI统计查询Bean */
	protected IncidentKpiSearchCond incidentKpiSearchCond;
	
	/**允许查询的最大记录数*/
	protected int maxSearchCount;
	
	/**事件KPI统计信息Map*/
	protected Map<String,List<IncidentKpi>> incidentKpiMap;

	/**分页Bean*/
	protected PagingDTO pagingDto;
	
	/**变更KPI统计信息List*/
	protected List<IncidentKpi> incidentKpiList;

	public IncidentKpiSearchCond getIncidentKpiSearchCond() {
		return incidentKpiSearchCond;
	}

	public void setIncidentKpiSearchCond(IncidentKpiSearchCond incidentKpiSearchCond) {
		this.incidentKpiSearchCond = incidentKpiSearchCond;
	}

	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	public List<IncidentKpi> getIncidentKpiList() {
		return incidentKpiList;
	}

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
