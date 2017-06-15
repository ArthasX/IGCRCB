/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.vir.model.VIM06Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM06SearchCond;

/**
  * ����: vim06DAO�ӿ�
  * ��������: vim06DAO�ӿ�
  * ������¼: 2014/02/21
  * �޸ļ�¼: 
  */
public interface VIM06DAO extends BaseHibernateDAO<VIM06Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VIM06Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VIM06Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final VIM06SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<VIM06Info> findByCond(
			final VIM06SearchCond cond, final int start,
			final int count);

}