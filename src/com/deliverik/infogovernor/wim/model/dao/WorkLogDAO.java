/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wim.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.wim.model.WorkLogInfo;
import com.deliverik.infogovernor.wim.model.condition.WorkLogSearchCond;

/**
  * ����: ������־DAO�ӿ�
  * ��������: ������־DAO�ӿ�
  * ������¼: 2017/06/09
  * �޸ļ�¼: 
  */
public interface WorkLogDAO extends BaseHibernateDAO<WorkLogInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<WorkLogInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public WorkLogInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final WorkLogSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<WorkLogInfo> findByCond(
			final WorkLogSearchCond cond, final int start,
			final int count);

}