/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wim.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.wim.model.WorkDefinitionInfo;
import com.deliverik.infogovernor.wim.model.condition.WorkDefinitionSearchCond;

/**
  * ����: ��������DAO�ӿ�
  * ��������: ��������DAO�ӿ�
  * ������¼: 2017/06/09
  * �޸ļ�¼: 
  */
public interface WorkDefinitionDAO extends BaseHibernateDAO<WorkDefinitionInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<WorkDefinitionInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public WorkDefinitionInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final WorkDefinitionSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<WorkDefinitionInfo> findByCond(
			final WorkDefinitionSearchCond cond, final int start,
			final int count);

}