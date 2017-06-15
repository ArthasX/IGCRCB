/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG113Info;
import com.deliverik.framework.workflow.prr.model.condition.IG113SearchCond;


/**
 * <p>����:����־��Ϣ����DAO�ӿ�</p>
 * <p>����������1.ȫ������</p>
 * <p>          2.������������</p>
 * <p>������¼��</p>
 */
public interface IG113DAO extends BaseHibernateDAO<IG113Info> {
	
	/**
	 * ���ܣ�ȫ������
	 * @return ���������
	 */
	public List<IG113Info> findAll();

	/**
	 * ���ܣ�������������
	 * @param piid ����
	 * @return �������
	 */
	public IG113Info findByPK(Serializable piid);

	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG113Info> findByCond(final IG113SearchCond cond, final int start, final int count);

}
