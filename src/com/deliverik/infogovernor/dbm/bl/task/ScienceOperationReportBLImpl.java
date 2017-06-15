/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dbm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dbm.model.condition.ScienceOperationReportSearchCond;
import com.deliverik.infogovernor.dbm.model.dao.ScienceOperationReportDAO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �Ƽ�����ͳ�Ʒ���BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class ScienceOperationReportBLImpl extends BaseBLImpl implements
		ScienceOperationReportBL {

	/** �Ƽ�����ͳ�Ʒ���DAO */
	protected ScienceOperationReportDAO scienceOperationReportDAO;

	/**
	 * �Ƽ�����ͳ�Ʒ���DAO�趨
	 * @param scienceOperationReportDAO �Ƽ�����ͳ�Ʒ���DAO
	 */
	public void setScienceOperationReportDAO(
			ScienceOperationReportDAO scienceOperationReportDAO) {
		this.scienceOperationReportDAO = scienceOperationReportDAO;
	}
	
	/**
	 * ���ձ�ֵ��ѯ����ֵ��ռ������
	 * @param cond
	 * @return
	 */
	public List<Object[]> getWorkOrderAction(ScienceOperationReportSearchCond cond){
		return scienceOperationReportDAO.getWorkOrderAction(cond);
	}
}
