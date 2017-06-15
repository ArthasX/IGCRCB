/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG512Info;
import com.deliverik.framework.workflow.prr.model.condition.IG512SearchCond;

/**
 * ���̹�ϵʵ��DAO�ӿ�
 * 
 */
public interface IG512DAO extends BaseHibernateDAO<IG512Info> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG512Info> findAll();

	/**
	 * ������������
	 * @param prrid ����
	 * @return �������
	 */
	public IG512Info findByPK(Serializable prrid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG512SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG512Info> findByCond(final IG512SearchCond cond, final int start, final int count);

	
}
