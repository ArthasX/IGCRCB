/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.util.List;

import com.csebank.lom.model.RecptionOrg;
import com.csebank.lom.model.condition.RecptionOrgVWSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * ���ŽӴ�DAO�ӿ�
 *
 */
public interface RecptionOrgVWDAO extends BaseHibernateDAO<RecptionOrg> {


	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RecptionOrg> findByCond(final RecptionOrgVWSearchCond cond, final int start, final int count);

}
