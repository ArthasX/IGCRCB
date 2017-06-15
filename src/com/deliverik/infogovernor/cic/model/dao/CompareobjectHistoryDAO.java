/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.cic.model.CompareobjectHistoryInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareobjectHistorySearchCond;

/**
  * ����: �Աȶ�����ʷ��DAO�ӿ�
  * ��������: �Աȶ�����ʷ��DAO�ӿ�
  * ������¼: 2014/04/24
  * �޸ļ�¼: 
  */
public interface CompareobjectHistoryDAO extends BaseHibernateDAO<CompareobjectHistoryInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CompareobjectHistoryInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CompareobjectHistoryInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CompareobjectHistorySearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CompareobjectHistoryInfo> findByCond(
			final CompareobjectHistorySearchCond cond, final int start,
			final int count);

}