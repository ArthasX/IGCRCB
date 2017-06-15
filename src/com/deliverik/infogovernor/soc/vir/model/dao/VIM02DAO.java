/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.vir.model.VIM02Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM02SearchCond;

/**
  * ����: ������Դ��Ŀ��Ϣ��DAO�ӿ�
  * ��������: ������Դ��Ŀ��Ϣ��DAO�ӿ�
  * ������¼: 2014/02/13
  * �޸ļ�¼: 
  */
public interface VIM02DAO extends BaseHibernateDAO<VIM02Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VIM02Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VIM02Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final VIM02SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<VIM02Info> findByCond(
			final VIM02SearchCond cond, final int start,
			final int count);

}