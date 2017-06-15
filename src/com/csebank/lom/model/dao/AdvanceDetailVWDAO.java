/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.csebank.lom.model.dao;

import java.util.List;

import com.csebank.lom.model.AdvanceDetail;
import com.csebank.lom.model.condition.AdvanceDetailSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * Ԥ֧��Աͳ��DAO
 * 
 */
public interface AdvanceDetailVWDAO extends BaseHibernateDAO<AdvanceDetail> {

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AdvanceDetail> findByCond(final AdvanceDetailSearchCond cond,
			final int start, final int count);
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final AdvanceDetailSearchCond cond);

}
