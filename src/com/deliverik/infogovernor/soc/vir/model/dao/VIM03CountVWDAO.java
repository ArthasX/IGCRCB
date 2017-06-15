/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.model.dao;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountVWSearchCond;
/**
 * ���⻯ͳ�Ʒ���
 *
 */
public interface VIM03CountVWDAO extends BaseHibernateDAO<Integer> {

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public Integer getCount(final VIM03CountVWSearchCond cond);
	/**
	 * ��������ȡ��
	 *
	 * @param cond ��������
	 * @return ��������
	 */
	public Integer getCountByCond(final VIM03CountVWSearchCond cond);
}
