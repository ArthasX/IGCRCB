/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.util.List;

import com.csebank.lom.model.EentertainmentStatistics;
import com.csebank.lom.model.condition.EentertainmentStatisticsSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * �Ӵ�ͳ��DAO�ӿ�
 *
 */
public interface EentertainmentStatisticsDAO extends BaseHibernateDAO<EentertainmentStatistics> {

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EentertainmentStatistics> findByCond(final EentertainmentStatisticsSearchCond cond, final int start, final int count);
	
	


}
