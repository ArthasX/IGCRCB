/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.condition.IG259SearchCond;

/**
 * <p>����:����ģ��DAO�ӿ�</p>
 * <p>����������1.ȫ������</p>
 * <p>          2.���������������ȡ��</p>
 * <p>          3.������������</p>
 * <p>          4.������������</p>
 * <p>������¼��</p>
 */
public interface IG259DAO extends BaseHibernateDAO<IG259Info> {

	/**
	 * ���ܣ�ȫ������
	 * @return ���������
	 */
	public List<IG259Info> findAll();
	
	/**
	 * ���ܣ����������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG259SearchCond cond);

	/**
	 * ���ܣ�������������
	 * @param prid ����
	 * @return �������
	 */
	public IG259Info findByPK(Serializable prid);

	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG259Info> findByCond(final IG259SearchCond cond, final int start, final int count);

}
