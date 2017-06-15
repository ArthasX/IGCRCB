/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.vir.model.VIM01Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM01SearchCond;

/**
  * ����: vCenter ServiceInstanceDAO�ӿ�
  * ��������: vCenter ServiceInstanceDAO�ӿ�
  * ������¼: 2014/02/12
  * �޸ļ�¼: 
  */
public interface VIM01DAO extends BaseHibernateDAO<VIM01Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VIM01Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VIM01Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final VIM01SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<VIM01Info> findByCond(
			final VIM01SearchCond cond, final int start,
			final int count);

}