/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.ProcessTimeInfo;
import com.deliverik.framework.workflow.prr.model.condition.ProcessTimeSearchCond;



/**
  * ����: ���̼�ʱ��DAO�ӿ�
  * ��������: ���̼�ʱ��DAO�ӿ�
  * ������¼: 2011/10/08
  * �޸ļ�¼: 
  */
public interface ProcessTimeDAO extends BaseHibernateDAO<ProcessTimeInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ProcessTimeInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ProcessTimeInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final ProcessTimeSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ProcessTimeInfo> findByCond(
			final ProcessTimeSearchCond cond, final int start,
			final int count);

}