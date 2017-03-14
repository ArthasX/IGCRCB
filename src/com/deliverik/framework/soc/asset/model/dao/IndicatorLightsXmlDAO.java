/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.IndicatorLightsXmlInfo;
import com.deliverik.framework.soc.asset.model.condition.IndicatorLightsXmlSearchCond;

/**
  * ����: �澯ϵͳ��ʾ�����DAO�ӿ�
  * ��������: �澯ϵͳ��ʾ�����DAO�ӿ�
  * ������¼: 2014/03/05
  * �޸ļ�¼: 
  */
public interface IndicatorLightsXmlDAO extends BaseHibernateDAO<IndicatorLightsXmlInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IndicatorLightsXmlInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IndicatorLightsXmlInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IndicatorLightsXmlSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IndicatorLightsXmlInfo> findByCond(
			final IndicatorLightsXmlSearchCond cond, final int start,
			final int count);

}