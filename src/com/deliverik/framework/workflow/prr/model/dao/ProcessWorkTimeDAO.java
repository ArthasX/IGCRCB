/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.ProcessWorkTimeInfo;
import com.deliverik.framework.workflow.prr.model.condition.ProcessWorkTimeSearchCond;


/**
  * ����: �û���Ϣʱ�䶨���DAO�ӿ�
  * ��������: �û���Ϣʱ�䶨���DAO�ӿ�
  * ������¼: 2011/10/08
  * �޸ļ�¼: 
  */
public interface ProcessWorkTimeDAO extends BaseHibernateDAO<ProcessWorkTimeInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ProcessWorkTimeInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ProcessWorkTimeInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final ProcessWorkTimeSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ProcessWorkTimeInfo> findByCond(
			final ProcessWorkTimeSearchCond cond, final int start,
			final int count);

}