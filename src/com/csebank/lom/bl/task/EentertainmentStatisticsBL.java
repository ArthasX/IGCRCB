/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.EentertainmentStatistics;
import com.csebank.lom.model.condition.EentertainmentStatisticsSearchCond;
import com.deliverik.framework.base.BaseBL;

/**
 * �Ӵ�ͳ��ҵ���߼��ӿ�
 */
public interface EentertainmentStatisticsBL extends BaseBL {
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EentertainmentStatistics> searchEentertainmentStatistics(EentertainmentStatisticsSearchCond cond, int start, int count);

}
