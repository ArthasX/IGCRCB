/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sym.model.SmsMessageLogInfo;
import com.deliverik.infogovernor.sym.model.condition.SmsMessageLogSearchCond;

/**
  * ����: ������־��Ϣ��DAO�ӿ�
  * ��������: ������־��Ϣ��DAO�ӿ�
  * ������¼: 2012/02/20
  * �޸ļ�¼: 
  */
public interface SmsMessageLogDAO extends BaseHibernateDAO<SmsMessageLogInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SmsMessageLogInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SmsMessageLogInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SmsMessageLogSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SmsMessageLogInfo> findByCond(
			final SmsMessageLogSearchCond cond, final int start,
			final int count);

}