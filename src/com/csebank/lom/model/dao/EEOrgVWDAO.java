/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.util.List;

import com.csebank.lom.model.EEOrg;
import com.csebank.lom.model.condition.EEOrgVWSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * ģ�飺���ڹ���-ʳ�ù���
 * ˵����ʳ���д����Ż���DAO�ӿ�
 * ���ߣ�������
 */
public interface EEOrgVWDAO extends BaseHibernateDAO<EEOrg> {


	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EEOrg> findByCond(final EEOrgVWSearchCond cond, final int start, final int count);
	
	
	

}
