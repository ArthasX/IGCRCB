/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.EentertainmentStatistics;
import com.csebank.lom.model.condition.EentertainmentStatisticsSearchCond;
import com.csebank.lom.model.dao.EentertainmentStatisticsDAO;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * ʳ�ýӴ�ͳ��ҵ���߼��ӿ�ʵ��
 */
public class EentertainmentStatisticsBLImpl extends BaseBLImpl implements EentertainmentStatisticsBL {
	
	/** EentertainmentStatistics DAO */
	protected EentertainmentStatisticsDAO eentertainmentStatisticsDAO;
	
	public void setEentertainmentStatisticsDAO(
			EentertainmentStatisticsDAO eentertainmentStatisticsDAO) {
		this.eentertainmentStatisticsDAO = eentertainmentStatisticsDAO;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EentertainmentStatistics> searchEentertainmentStatistics(EentertainmentStatisticsSearchCond cond, int start, int count){
		
		return eentertainmentStatisticsDAO.findByCond(cond,start,count);
	}

}
