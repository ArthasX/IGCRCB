/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.util.List;

import com.csebank.lom.model.RecptionCost;
import com.csebank.lom.model.condition.RecptionSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * �Ӵ�����DAO�ӿ�
 *
 */
public interface RecptionCostVWDAO extends BaseHibernateDAO<RecptionCost> {


	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RecptionCost> findByCond(final RecptionSearchCond cond, final int start, final int count);
	
	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RecptionSearchCond cond);
}
