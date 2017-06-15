/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG019SearchCond;

/**
 * <p>����:�¼��ͷ����������̻�����ͼDAO�ӿ�</p>
 * <p>����������1.�¼�������������</p>
 * <p>         2.��������������������</p>
 * <p>          3.�¼����������������ȡ��</p>
 * <p>          4.�������������������ȡ��</p>
 * <p>������¼��</p>
 */
public interface IG144DAO extends
		BaseHibernateDAO<IG500Info> {

	/**
	 * ���ܣ��¼�������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500Info> findIncidentByCond(
			final IG019SearchCond cond, final int start,
			final int count);
	
	/**
	 * ���ܣ���������������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500Info> findServiceRequestByCond(
			final IG019SearchCond cond, final int start,
			final int count);
	
	/**
	 * ���ܣ��¼����������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getIncidentSearchCount(final IG019SearchCond cond);
	
	/**
	 * ���ܣ��������������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getServiceRequestSearchCount(final IG019SearchCond cond);

}
