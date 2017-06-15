/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.plugin.sms.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.plugin.sms.model.SmsQueueInfo;
import com.deliverik.plugin.sms.model.condition.SmsQueueSearchCond;

/**
  * ����: ���Ŷ��б�DAO�ӿ�
  * ��������: ���Ŷ��б�DAO�ӿ�
  * ������¼: 2012/10/31
  * �޸ļ�¼: 
  */
public interface SmsQueueDAO extends BaseHibernateDAO<SmsQueueInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SmsQueueInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SmsQueueInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SmsQueueSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SmsQueueInfo> findByCond(
			final SmsQueueSearchCond cond, final int start,
			final int count);

}