/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.svc.model.AnnualTrendVWInfo;
import com.deliverik.infogovernor.svc.model.condition.AnnualTrendVWSearchCond;
import com.deliverik.infogovernor.svc.model.dao.AnnualTrendVWDAO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��ȹ�������ͳ��BLʵ��
 * </p>
 * 
 * @author wanglei@deliverik.com
 * @version 1.0
 */
public class AnnualTrendVWBLImpl extends BaseBLImpl implements AnnualTrendVWBL{

	/** ��ȹ�������ͳ��DAO */
	protected AnnualTrendVWDAO annualTrendVWDAO;

	/**
	 * ��ȹ�������ͳ��DAO�趨
	 * @param incidentTypeDAO ��ȹ�������ͳ��DAO
	 */
	public void setAnnualTrendVWDAO(AnnualTrendVWDAO annualTrendVWDAO) {
		this.annualTrendVWDAO = annualTrendVWDAO;
	}
	
	/**
	 * ͳ�����ݼ���
	 * @param cond ��������
	 * @return
	 */
	public List<AnnualTrendVWInfo> searchIncidentTypeData(AnnualTrendVWSearchCond cond){
		return annualTrendVWDAO.searchAnnualTrendVW(cond);
	}
}
