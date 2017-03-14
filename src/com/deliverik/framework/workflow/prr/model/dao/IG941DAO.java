/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG941Info;
import com.deliverik.framework.workflow.prr.model.condition.IG941SearchCond;

/**
 * ���񹤵���־DAO�ӿ�
 */
public interface IG941DAO extends BaseHibernateDAO<IG941Info> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG941Info> findAll();

	/**
	 * ������������
	 * @param sflid ����
	 * @return �������
	 */
	public IG941Info findByPK(Serializable sflid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG941SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG941Info> findByCond(final IG941SearchCond cond, final int start, final int count);
	
}
