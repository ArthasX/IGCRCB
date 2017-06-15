/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.plugin.sms.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.plugin.sms.model.SendSmsLogInfo;
import com.deliverik.plugin.sms.model.condition.SendSmsLogSearchCond;

/**
  * ����: ���Ŷ��б�DAO�ӿ�
  * ��������: ���Ŷ��б�DAO�ӿ�
  * ������¼: 2012/10/31
  * �޸ļ�¼: 
  */
public interface SendSmsLogDAO extends BaseHibernateDAO<SendSmsLogInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SendSmsLogInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SendSmsLogInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SendSmsLogSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SendSmsLogInfo> findByCond(
			final SendSmsLogSearchCond cond, final int start,
			final int count);

}