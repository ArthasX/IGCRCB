/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.svc.model.IncidentAveSolveTimeVWInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ʱ��ƽ�����ʱ��ͳ��VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSVC06381VO extends BaseVO{

	/** ʱ��ƽ�����ʱ��ͳ������ */
	protected List<IncidentAveSolveTimeVWInfo> incidentAveSolveTimeDate;

	/**
	 * ʱ��ƽ�����ʱ��ͳ������ȡ��
	 * @return incidentAveSolveTimeDate ʱ��ƽ�����ʱ��ͳ������
	 */
	public List<IncidentAveSolveTimeVWInfo> getIncidentAveSolveTimeDate() {
		return incidentAveSolveTimeDate;
	}

	/**
	 * ʱ��ƽ�����ʱ��ͳ�������趨
	 * @param incidentAveSolveTimeDate ʱ��ƽ�����ʱ��ͳ������
	 */
	public void setIncidentAveSolveTimeDate(
			List<IncidentAveSolveTimeVWInfo> incidentAveSolveTimeDate) {
		this.incidentAveSolveTimeDate = incidentAveSolveTimeDate;
	}
}
