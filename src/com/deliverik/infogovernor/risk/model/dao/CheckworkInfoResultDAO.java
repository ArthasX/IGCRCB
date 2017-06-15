/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.risk.model.CheckworkInfoResultInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckworkInfoResultSearchCond;

/**
  * ����: ��鹤��������������DAO�ӿ�
  * ��������: ��鹤��������������DAO�ӿ�
  * ������¼: 2014/09/02
  * �޸ļ�¼: 
  */
public interface CheckworkInfoResultDAO extends BaseHibernateDAO<CheckworkInfoResultInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CheckworkInfoResultInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CheckworkInfoResultInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CheckworkInfoResultSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CheckworkInfoResultInfo> findByCond(
			final CheckworkInfoResultSearchCond cond, final int start,
			final int count);

}