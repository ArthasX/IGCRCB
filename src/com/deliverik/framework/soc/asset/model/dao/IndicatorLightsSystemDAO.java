/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.IndicatorLightsSystemInfo;
import com.deliverik.framework.soc.asset.model.condition.IndicatorLightsSystemSearchCond;

/**
  * ����: �澯ϵͳ��ʾ��Ϣ��DAO�ӿ�
  * ��������: �澯ϵͳ��ʾ��Ϣ��DAO�ӿ�
  * ������¼: 2014/03/05
  * �޸ļ�¼: 
  */
public interface IndicatorLightsSystemDAO extends BaseHibernateDAO<IndicatorLightsSystemInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IndicatorLightsSystemInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IndicatorLightsSystemInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IndicatorLightsSystemSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IndicatorLightsSystemInfo> findByCond(
			final IndicatorLightsSystemSearchCond cond, final int start,
			final int count);

}