/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.kgm.model.KnowledgeStatisticsInfo;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeStatisticsSearchCond;
import com.deliverik.infogovernor.kgm.model.dao.KnowLedgeStatisticsDAO;

/**
  * ����: ֪ʶ��ͳ��ҵ���߼�ʵ��
  * ��������: ֪ʶ��ͳ��ҵ���߼�ʵ��
  * ������¼: 2014/3/13
  * �޸ļ�¼: 
  */
public class KnowledgeStatisticsBLImpl extends BaseBLImpl implements
	KnowledgeStatisticsBL {

	/** knowLedgeStatisticsDAO�ӿ� */
	protected KnowLedgeStatisticsDAO knowLedgeStatisticsDAO;
	
	/**
	 * knowLedgeStatisticsDAO�ӿ��趨
	 *
	 * @param knowLedgeStatisticsDAO knowLedgeStatisticsDAO�ӿ�
	 */
	public void setKnowLedgeStatisticsDAO(
			KnowLedgeStatisticsDAO knowLedgeStatisticsDAO) {
		this.knowLedgeStatisticsDAO = knowLedgeStatisticsDAO;
	}
	
	/**
	 * ������������(��������)
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<KnowledgeStatisticsInfo> searchKnprofferStatistics(KnowledgeStatisticsSearchCond cond) 
			throws BLException  {
		return knowLedgeStatisticsDAO.findByKnprofferCond(cond, 0, 0);
	}
	
	/**
	 * ������������(������)
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<KnowledgeStatisticsInfo> searchKnclassStatistics(KnowledgeStatisticsSearchCond cond) 
			throws BLException {
		return knowLedgeStatisticsDAO.findByKnclassCond(cond, 0, 0);
	}
}