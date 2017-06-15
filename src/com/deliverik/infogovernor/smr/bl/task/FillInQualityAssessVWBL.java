/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.smr.model.FillInQualityAssessInfo;
import com.deliverik.infogovernor.smr.model.ReportDetailVWInfo;
import com.deliverik.infogovernor.smr.model.condition.FillInQualityAssessSearchCond;

/**
 * ����:�����
 * ���������������
 * �����ˣ�����͢
 * ������¼�� 2013-08-30
 * �޸ļ�¼��
 */
public interface FillInQualityAssessVWBL extends BaseBL{

	/**
	 * ����Ա��ѯ
	 *
	 * @return ���������
	 */
	public List<FillInQualityAssessInfo> searchFillInQualityByUser(final FillInQualityAssessSearchCond cond);
	
	/**
	 * ��ѯ(��ܱ�����ϸҳ)
	 *
	 * @return ���������
	 */
	public List<ReportDetailVWInfo> searchListForDetailByUser(final FillInQualityAssessSearchCond cond);
	
}
