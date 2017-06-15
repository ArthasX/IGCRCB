/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG359Info;
import com.deliverik.framework.workflow.prr.model.condition.IG359SearchCond;

/**
 * <p>����:����ʲ�����ͳ�ƻ���ͳ��DAO�ӿ�</p>
 * <p>����������1.������������</p>
 * <p>������¼��</p>
 */
public interface IG359DAO extends BaseHibernateDAO<IG359Info> {

	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG359Info> findByCond(final IG359SearchCond cond, final int start, final int count);

}
