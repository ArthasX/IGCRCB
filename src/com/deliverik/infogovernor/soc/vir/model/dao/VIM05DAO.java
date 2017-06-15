/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.vir.model.VIM05Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM05SearchCond;

/**
  * ����: vim05DAO�ӿ�
  * ��������: vim05DAO�ӿ�
  * ������¼: 2014/02/21
  * �޸ļ�¼: 
  */
public interface VIM05DAO extends BaseHibernateDAO<VIM05Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VIM05Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VIM05Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final VIM05SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<VIM05Info> findByCond(
			final VIM05SearchCond cond, final int start,
			final int count);

}