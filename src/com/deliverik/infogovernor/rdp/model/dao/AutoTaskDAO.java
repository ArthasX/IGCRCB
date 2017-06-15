/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rdp.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.rdp.model.AutoTaskInfo;
import com.deliverik.infogovernor.rdp.model.condition.AutoTaskSearchCond;

/**
  * ����: AutoTaskDAO�ӿ�
  * ��������: AutoTaskDAO�ӿ�
  * ������¼: 2014/04/16
  * �޸ļ�¼: 
  */
public interface AutoTaskDAO extends BaseHibernateDAO<AutoTaskInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AutoTaskInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AutoTaskInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final AutoTaskSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AutoTaskInfo> findByCond(
			final AutoTaskSearchCond cond, final int start,
			final int count);

}