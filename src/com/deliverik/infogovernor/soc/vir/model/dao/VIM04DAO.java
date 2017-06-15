/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.vir.model.VIM04Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM04SearchCond;

/**
  * ����: ��־��DAO�ӿ�
  * ��������: ��־��DAO�ӿ�
  * ������¼: 2014/02/19
  * �޸ļ�¼: 
  */
public interface VIM04DAO extends BaseHibernateDAO<VIM04Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VIM04Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VIM04Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final VIM04SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<VIM04Info> findByCond(
			final VIM04SearchCond cond, final int start,
			final int count);

}