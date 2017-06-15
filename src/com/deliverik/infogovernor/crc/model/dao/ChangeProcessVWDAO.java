/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.crc.model.ChangeProcessVWInfo;
import com.deliverik.infogovernor.crc.model.condition.ChangeProcessVWSearchCond;

/**
  * ����: �������DAO�ӿ�
  * ��������: �������DAO�ӿ�
  * ������¼: 2015/01/04
  * �޸ļ�¼: 
  */
public interface ChangeProcessVWDAO extends BaseHibernateDAO<ChangeProcessVWInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ChangeProcessVWInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ChangeProcessVWInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final ChangeProcessVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ChangeProcessVWInfo> findByCond(
			final ChangeProcessVWSearchCond cond, final int start,
			final int count);

}