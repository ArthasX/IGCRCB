/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.util.List;

import com.csebank.lom.model.WorkLunchEatery;
import com.csebank.lom.model.condition.WorkLunchEaterySearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * �����ͳɱ�ͳ��DAO�ӿ�
 *
 */
public interface WorkLunchEateryDAO extends BaseHibernateDAO<WorkLunchEatery> {

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<WorkLunchEatery> findByCond(final WorkLunchEaterySearchCond cond, final int start, final int count);
	
	


}
