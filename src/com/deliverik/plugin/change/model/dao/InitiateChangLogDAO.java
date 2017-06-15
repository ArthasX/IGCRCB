/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.plugin.change.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.plugin.change.model.InitiateChangLogInfo;
import com.deliverik.plugin.change.model.condition.InitiateChangLogSearchCond;

/**
  * ����: ������������־DAO�ӿ�
  * ��������: ������������־DAO�ӿ�
  * ������¼: 2015/07/02
  * �޸ļ�¼: 
  */
public interface InitiateChangLogDAO extends BaseHibernateDAO<InitiateChangLogInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<InitiateChangLogInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public InitiateChangLogInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final InitiateChangLogSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<InitiateChangLogInfo> findByCond(
			final InitiateChangLogSearchCond cond, final int start,
			final int count);

}