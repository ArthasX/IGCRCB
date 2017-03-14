/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG003Info;
import com.deliverik.framework.workflow.prr.model.condition.IG003SearchCond;

/**
 * <p>����:������Ȼ���ͳ��DAO�ӿ�</p>
 * <p>����������1.������������</p>
 * <p>������¼��</p>
 */
public interface IG003DAO extends BaseHibernateDAO<IG003Info> {

	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG003Info> findByCond(final IG003SearchCond cond, final int start, final int count);

}
