/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.drm.model.ResponseStrategyInfo;
import com.deliverik.infogovernor.drm.model.condition.ResponseStrategySearchCond;

/**
  * ����: ������Ӧ����DAO�ӿ�
  * ��������: ������Ӧ����DAO�ӿ�
  * ������¼: 2016/09/20
  * �޸ļ�¼: 
  */
public interface ResponseStrategyDAO extends BaseHibernateDAO<ResponseStrategyInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ResponseStrategyInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ResponseStrategyInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final ResponseStrategySearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ResponseStrategyInfo> findByCond(
			final ResponseStrategySearchCond cond, final int start,
			final int count);

}