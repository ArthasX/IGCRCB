/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dbm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.dbm.model.WorkmanagerInfo;
import com.deliverik.infogovernor.dbm.model.condition.WorkmanagerSearchCond;
import com.deliverik.infogovernor.dbm.model.entity.WorkmanagerVW;

/**
  * ����: ��������DAO�ӿ�
  * ��������: ��������DAO�ӿ�
  * ������¼: 2016/04/19
  * �޸ļ�¼: 
  */
public interface WorkmanagerDAO extends BaseHibernateDAO<WorkmanagerInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<WorkmanagerInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public WorkmanagerInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final WorkmanagerSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<WorkmanagerInfo> findByCond(
			final WorkmanagerSearchCond cond, final int start,
			final int count);

	/**
	 * ͳ�ƴ�������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<WorkmanagerVW> searchSumByCond(final WorkmanagerSearchCond cond);
}