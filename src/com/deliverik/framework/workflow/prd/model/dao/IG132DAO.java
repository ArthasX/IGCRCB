/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG132Info;
import com.deliverik.framework.workflow.prd.model.condition.IG132SearchCond;

/**
  * ����: �����߰�ť������Ϣ��DAO�ӿ�
  * ��������: �����߰�ť������Ϣ��DAO�ӿ�
  * ������¼: 2012/04/18
  * �޸ļ�¼: 
  */
public interface IG132DAO extends BaseHibernateDAO<IG132Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG132Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG132Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG132SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG132Info> findByCond(
			final IG132SearchCond cond, final int start,
			final int count);
	
	public String getPpbdidSequenceNextValue(final String ppdid);
}