/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG229Info;
import com.deliverik.framework.workflow.prd.model.condition.IG229SearchCond;


 /**
  * ����:����������ϸ��¼��dao�ӿ�
  * �����������������������ϸ��¼��ʵ����в���
  *           
  * ������¼��wangxiaoqiang    2010/11/29
  */
public interface IG229DAO extends
		BaseHibernateDAO<IG229Info> {
	/**
	 * ȫ������
	 * 
	 * @return ���������
	 */
	public List<IG229Info> findAll();

	/**
	 * ������������
	 * 
	 * @param id ����
	 * @return �������
	 */
	public IG229Info findByPK(Serializable id);

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG229SearchCond cond);

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG229Info> findByCond(
			final IG229SearchCond cond, final int start,
			final int count);
}

