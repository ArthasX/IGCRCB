/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG560Info;
import com.deliverik.framework.workflow.prd.model.IG560VWInfo;
import com.deliverik.framework.workflow.prd.model.condition.IG560SearchCond;

/**
  * ����: ����״̬��˽�б�Ĭ��ֵ��DAO�ӿ�
  * ��������: ����״̬��˽�б�Ĭ��ֵ��DAO�ӿ�
  * ������¼: 2015/02/07
  * �޸ļ�¼: 
  */
public interface IG560DAO extends BaseHibernateDAO<IG560Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG560Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG560Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG560SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG560Info> findByCond(
			final IG560SearchCond cond, final int start,
			final int count);

	public List<IG560VWInfo> searchIG560VW(final IG560SearchCond cond);

}