/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.vo;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.svc.model.IncidentTypeVWInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��������ͳ��vo
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSVC06351VO extends BaseVO{
	
	/** ��������ͳ����Ϣ */
	private IncidentTypeVWInfo incidentType;

	/**
	 * ��������ͳ����Ϣȡ��
	 * @return incidentType ��������ͳ����Ϣ
	 */
	public IncidentTypeVWInfo getIncidentType() {
		return incidentType;
	}

	/**
	 * ��������ͳ����Ϣ�趨
	 * @param incidentType ��������ͳ����Ϣ
	 */
	public void setIncidentType(IncidentTypeVWInfo incidentType) {
		this.incidentType = incidentType;
	}
}
