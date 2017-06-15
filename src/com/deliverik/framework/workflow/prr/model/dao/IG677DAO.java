/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.framework.workflow.prr.model.condition.IG677SearchCond;

/**
 * <p>����:���̼�¼��ͼDAO�ӿ�</p>
 * <p>����������1.ȫ������</p>
 * <p>          2.������������</p>
 * <p>          3.������������</p>
 * <p>          4.���������������ȡ��</p>
 * <p>������¼��</p>
 */
public interface IG677DAO extends BaseHibernateDAO<IG677Info> {

	/**
	 * ���ܣ�ȫ������
	 * @return ���������
	 */
	public List<IG677Info> findAll();

	/**
	 * ���ܣ�������������
	 * @param pdaid ����
	 * @return �������
	 */
	public IG677Info findByPK(Serializable processRecordVWPK);

	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG677Info> findByCond(final IG677SearchCond cond, final int start, final int count);
	
	/**
	 * ���ܣ����������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG677SearchCond cond);
}
