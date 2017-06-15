/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.kgm.model.KnowledgeStatisticsInfo;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeStatisticsSearchCond;

/**
 * ����:֪ʶ���̹�����Ϣҵ���߼��ӿ�
 * ����������֪ʶ���̹�����Ϣҵ���߼��ӿ�
 * ������¼������ 2010/12/07
 * �޸ļ�¼��
 */
public interface KnowledgeStatisticsBL extends BaseBL {
	
	/**
	 * ������������(��������)
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<KnowledgeStatisticsInfo> searchKnprofferStatistics(KnowledgeStatisticsSearchCond cond)
			throws BLException;

	/**
	 * ������������(������)
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<KnowledgeStatisticsInfo> searchKnclassStatistics(KnowledgeStatisticsSearchCond cond)
			throws BLException  ;

}
