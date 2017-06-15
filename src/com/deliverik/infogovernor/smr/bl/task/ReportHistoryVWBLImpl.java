/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.bl.task;

import java.util.List;

import com.deliverik.infogovernor.smr.model.ReportHistoryVWInfo;
import com.deliverik.infogovernor.smr.model.condition.ReportHistoryVWSearchCond;
import com.deliverik.infogovernor.smr.model.dao.ReportHistoryVWDAO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ������ʷ���¼��ͼBLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class ReportHistoryVWBLImpl implements ReportHistoryVWBL{

	/** ������ʷ���¼��ͼ */
	protected ReportHistoryVWDAO reportHistoryVWDAO;

	/**
	 * ������ʷ���¼��ͼ�趨
	 * @param reportHistoryVWDAO ������ʷ���¼��ͼ
	 */
	public void setReportHistoryVWDAO(ReportHistoryVWDAO reportHistoryVWDAO) {
		this.reportHistoryVWDAO = reportHistoryVWDAO;
	}
	
	/**
	 * ��������
	 * @param cond ��������
	 * @return �������
	 */
	public List<ReportHistoryVWInfo> searchReportHistoryVWInfoList(ReportHistoryVWSearchCond cond){
		return reportHistoryVWDAO.findByCond(cond);
	}
}
