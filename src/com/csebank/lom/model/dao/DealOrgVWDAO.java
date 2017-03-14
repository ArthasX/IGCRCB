/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.util.List;

import com.csebank.lom.model.DealOrg;
import com.csebank.lom.model.condition.DealOrgVWSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * ģ�飺���ڹ���-�Ӵ������
 * ˵������������Ͳ�ͳ�ƻ���DAO�ӿ�
 * ���ߣ�������
 */
public interface DealOrgVWDAO extends BaseHibernateDAO<DealOrg> {


	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DealOrg> findByCond(final DealOrgVWSearchCond cond, final int start, final int count);

}
