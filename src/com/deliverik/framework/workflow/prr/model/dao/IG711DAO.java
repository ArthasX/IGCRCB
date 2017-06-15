/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG711Info;
import com.deliverik.framework.workflow.prr.model.condition.IG711SearchCond;


/**
 * ��Ȩ����DAO�ӿ�
 */
public interface IG711DAO extends BaseHibernateDAO<IG711Info> {

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG711Info> findByCond(final IG711SearchCond cond, final int start, final int count);
	
	/**
	 * ������������
	 * @param paid ����
	 * @return �������
	 */
	public IG711Info findIG711InfoByPK(Integer paid);
}
