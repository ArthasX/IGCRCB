/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.smr.model.ReportHistoryVWInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ������Ϣvo
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSMR05011VO extends BaseVO{

	/** ������Ϣ���� */
	protected List<ReportHistoryVWInfo> reportHistoryVWInfoList;

	/**
	 * ������Ϣ����ȡ��
	 * @return reportHistoryVWInfoList ������Ϣ����
	 */
	public List<ReportHistoryVWInfo> getReportHistoryVWInfoList() {
		return reportHistoryVWInfoList;
	}

	/**
	 * ������Ϣ�����趨
	 * @param reportHistoryVWInfoList ������Ϣ����
	 */
	public void setReportHistoryVWInfoList(
			List<ReportHistoryVWInfo> reportHistoryVWInfoList) {
		this.reportHistoryVWInfoList = reportHistoryVWInfoList;
	}
	
}
