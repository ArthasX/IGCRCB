/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.plugin.mail.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.plugin.mail.model.AlermSendMailQueueInfo;
import com.deliverik.plugin.mail.model.condition.AlermSendMailQueueSearchCond;

/**
  * ����: �ʼ����б�DAO�ӿ�
  * ��������: �ʼ����б�DAO�ӿ�
  * ������¼: 2013/08/05
  * �޸ļ�¼: 
  */
public interface AlermSendMailQueueDAO extends BaseHibernateDAO<AlermSendMailQueueInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AlermSendMailQueueInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AlermSendMailQueueInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final AlermSendMailQueueSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AlermSendMailQueueInfo> findByCond(
			final AlermSendMailQueueSearchCond cond, final int start,
			final int count);

}