/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.bl.task;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.svc.model.IncidentTypeVWInfo;
import com.deliverik.infogovernor.svc.model.condition.IncidentTypeSearchCond;
import com.deliverik.infogovernor.svc.model.dao.IncidentTypeDAO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��������ͳ��BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IncidentTypeBLImpl extends BaseBLImpl implements IncidentTypeBL{

	/** ��������ͳ��DAO */
	protected IncidentTypeDAO incidentTypeDAO;

	/**
	 * ��������ͳ��DAO�趨
	 * @param incidentTypeDAO ��������ͳ��DAO
	 */
	public void setIncidentTypeDAO(IncidentTypeDAO incidentTypeDAO) {
		this.incidentTypeDAO = incidentTypeDAO;
	}
	
	/**
	 * ͳ�����ݼ���
	 * @param cond ��������
	 * @return
	 */
	public IncidentTypeVWInfo searchIncidentTypeData(IncidentTypeSearchCond cond){
		return incidentTypeDAO.searchIncidentTypeData(cond);
	}
}
