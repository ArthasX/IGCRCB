/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sym.model.QueueInfo;
import com.deliverik.infogovernor.sym.model.condition.QueueSearchCond;

/**
  * ����: ���Ŷ��б�DAO�ӿ�
  * ��������: ���Ŷ��б�DAO�ӿ�
  * ������¼: 2012/11/13
  * �޸ļ�¼: 
  */
public interface QueueDAO extends BaseHibernateDAO<QueueInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<QueueInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public QueueInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final QueueSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<QueueInfo> findByCond(
			final QueueSearchCond cond, final int start,
			final int count);

}