/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.condition.IG036SearchCond;

/**
 * <p>����:��־��ϢDAO�ӿ�</p>
 * <p>����������1.ȫ������</p>
 * <p>          2.������������</p>
 * <p>          3.������������</p>
 * <p>������¼��</p>
 */
public interface IG036DAO extends BaseHibernateDAO<IG036Info> {

	/**
	 * ���ܣ�ȫ������
	 * @return ���������
	 */
	public List<IG036Info> findAll();

	/**
	 * ���ܣ�������������
	 * @param rlid ����
	 * @return �������
	 */
	public IG036Info findByPK(Serializable rlid);

	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG036Info> findByCond(final IG036SearchCond cond, final int start, final int count);

}
