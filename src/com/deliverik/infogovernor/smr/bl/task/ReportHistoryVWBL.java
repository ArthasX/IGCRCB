/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.smr.model.ReportHistoryVWInfo;
import com.deliverik.infogovernor.smr.model.condition.ReportHistoryVWSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ������ʷ���¼��ͼBL�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface ReportHistoryVWBL extends BaseBL{

	/**
	 * ��������
	 * @param cond ��������
	 * @return �������
	 */
	public List<ReportHistoryVWInfo> searchReportHistoryVWInfoList(ReportHistoryVWSearchCond cond);
}
