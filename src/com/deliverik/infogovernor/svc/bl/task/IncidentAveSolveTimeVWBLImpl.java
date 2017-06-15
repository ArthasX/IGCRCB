/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.svc.model.IncidentAveSolveTimeVWInfo;
import com.deliverik.infogovernor.svc.model.condition.IncidentAveSolveTimeSearchCond;
import com.deliverik.infogovernor.svc.model.dao.IncidentAveSolveTimeVWDAO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �¼�ƽ�����ʱ��BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IncidentAveSolveTimeVWBLImpl extends BaseBLImpl implements IncidentAveSolveTimeVWBL{

	/** �¼�ƽ�����ʱ��ͳ��DAO */
	protected IncidentAveSolveTimeVWDAO incidentAveSolveTimeVWDAO;

	/**
	 * �¼�ƽ�����ʱ��ͳ��DAO�趨
	 * @param incidentAveSolveTimeVWDAO �¼�ƽ�����ʱ��ͳ��DAO
	 */
	public void setIncidentAveSolveTimeVWDAO(
			IncidentAveSolveTimeVWDAO incidentAveSolveTimeVWDAO) {
		this.incidentAveSolveTimeVWDAO = incidentAveSolveTimeVWDAO;
	}
	
	/**
	 * ͳ�����ݲ�ѯ
	 * @param cond
	 * @return
	 */
	public List<IncidentAveSolveTimeVWInfo> searchSolveTimeData(IncidentAveSolveTimeSearchCond cond){
		return incidentAveSolveTimeVWDAO.searchSolveTimeData(cond);
	}
}
