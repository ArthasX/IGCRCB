/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_ͳ��DTO
 * </p>
 * 
 * @author maozhipeng@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSDL07DTO extends BaseDTO implements Serializable {
	
	/**���KPIͳ�Ʋ�ѯBean */
	protected IncidentKpiSearchCond incidentKpiSearchCond;
	
	/**�����ѯ������¼��*/
	protected int maxSearchCount;
	
	/**�¼�KPIͳ����ϢMap*/
	protected Map<String,List<IncidentKpi>> incidentKpiMap;

	/**��ҳBean*/
	protected PagingDTO pagingDto;
	
	/**���KPIͳ����ϢList*/
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
	 * �¼�KPIͳ����ϢMap
	 * @return
	 */
	public Map<String, List<IncidentKpi>> getIncidentKpiMap() {
		return incidentKpiMap;
	}

	/**
	 * �¼�KPIͳ����ϢMap
	 * @param incidentKpiMap
	 */
	public void setIncidentKpiMap(Map<String, List<IncidentKpi>> incidentKpiMap) {
		this.incidentKpiMap = incidentKpiMap;
	}
	
}
