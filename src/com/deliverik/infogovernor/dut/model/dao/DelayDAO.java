/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dut.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.dut.model.DelayInfo;
import com.deliverik.infogovernor.dut.model.condition.DelaySearchCond;

/**
  * ����: ��ʱ������Ϣ��DAO�ӿ�
  * ��������: ��ʱ������Ϣ��DAO�ӿ�
  * ������¼: 2012/04/05
  * �޸ļ�¼: 
  */
public interface DelayDAO extends BaseHibernateDAO<DelayInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<DelayInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public DelayInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final DelaySearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DelayInfo> findByCond(
			final DelaySearchCond cond, final int start,
			final int count);

}