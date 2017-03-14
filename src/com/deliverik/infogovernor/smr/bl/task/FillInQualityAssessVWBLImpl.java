/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.smr.model.FillInQualityAssessInfo;
import com.deliverik.infogovernor.smr.model.ReportDetailVWInfo;
import com.deliverik.infogovernor.smr.model.condition.FillInQualityAssessSearchCond;
import com.deliverik.infogovernor.smr.model.dao.FillInQualityAssessVWDAO;

/**
 * ����:�����
 * ���������������
 * �����ˣ�����͢
 * ������¼�� 2013-08-30
 * �޸ļ�¼��
 */
public class FillInQualityAssessVWBLImpl extends BaseBLImpl implements
		FillInQualityAssessVWBL {

	/** �����DAO*/
	protected FillInQualityAssessVWDAO fillInQualityAssessVWDAO;
	
	/**
	 * �����DAO�趨
	 *
	 * @param fillInQualityAssessVWDAO �����DAO
	 */
	public void setFillInQualityAssessVWDAO(
			FillInQualityAssessVWDAO fillInQualityAssessVWDAO) {
		this.fillInQualityAssessVWDAO = fillInQualityAssessVWDAO;
	}

	public List<FillInQualityAssessInfo> searchFillInQualityByUser(
			FillInQualityAssessSearchCond cond) {
		
		return fillInQualityAssessVWDAO.searchFillInQualityByUser(cond);
	}
	
	public List<ReportDetailVWInfo> searchListForDetailByUser(
			FillInQualityAssessSearchCond cond) {
		
		return fillInQualityAssessVWDAO.searchListForDetailByUser(cond);
	}


}
