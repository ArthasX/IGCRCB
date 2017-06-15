/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.prr.model.DispatchStatisticsVWInfo;
import com.deliverik.infogovernor.prr.model.condition.CopyReadUserSearchCond;
import com.deliverik.infogovernor.prr.model.condition.DispatchStatisticsVWSearchCond;

/**
  * ����: ��������ͳ��DAO�ӿ�
  * ��������: ��������ͳ��DAO�ӿ�
  * ������¼: 2013/02/27
  * �޸ļ�¼: 
  */
public interface DispatchStatisticsVWDAO extends BaseHibernateDAO<DispatchStatisticsVWInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<DispatchStatisticsVWInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public DispatchStatisticsVWInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final DispatchStatisticsVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DispatchStatisticsVWInfo> findByCond(
			final DispatchStatisticsVWSearchCond cond, final int start,
			final int count);
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	public List<DispatchStatisticsVWInfo> findDispatchStatistics(
			final DispatchStatisticsVWSearchCond cond, final int start,final int count);
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	public int findDispatchStatisticsSearchCount(
			final DispatchStatisticsVWSearchCond cond);

}