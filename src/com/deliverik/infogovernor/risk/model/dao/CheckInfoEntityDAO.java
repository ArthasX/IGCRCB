/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.risk.model.CheckInfoEntityInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckInfoEntitySearchCond;

/**
  * ����: �����Թ����ʲ���DAO�ӿ�
  * ��������: �����Թ����ʲ���DAO�ӿ�
  * ������¼: 2014/09/02
  * �޸ļ�¼: 
  */
public interface CheckInfoEntityDAO extends BaseHibernateDAO<CheckInfoEntityInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CheckInfoEntityInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CheckInfoEntityInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CheckInfoEntitySearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CheckInfoEntityInfo> findByCond(
			final CheckInfoEntitySearchCond cond, final int start,
			final int count);

}