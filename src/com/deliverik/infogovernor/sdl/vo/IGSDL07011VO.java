/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_�¼�KPIͳ��VO
 * </p>
 * 
 * @author maozhipeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSDL07011VO extends BaseVO implements Serializable {
	
	/**�¼�KPIͳ����ϢList*/
	protected List<IncidentKpi> incidentKpiList;
	
	/**�¼�KPIͳ����ϢMap*/
	protected Map<String,List<IncidentKpi>> incidentKpiMap;

	/**
	 * �¼�KPIͳ����ϢList
	 * @return �¼�KPIͳ����ϢList
	 */
	public List<IncidentKpi> getIncidentKpiList() {
		return incidentKpiList;
	}

	/**
	 * �¼�KPIͳ����ϢList
	 * @param incidentKpiList �¼�KPIͳ����ϢList
	 */
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
