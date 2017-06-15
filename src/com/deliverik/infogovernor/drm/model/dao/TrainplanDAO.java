/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.drm.model.TrainplanInfo;
import com.deliverik.infogovernor.drm.model.condition.TrainplanSearchCond;

/**
  * ����: ��ѵ�ƻ���DAO�ӿ�
  * ��������: ��ѵ�ƻ���DAO�ӿ�
  * ������¼: 2015/04/10
  * �޸ļ�¼: 
  */
public interface TrainplanDAO extends BaseHibernateDAO<TrainplanInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<TrainplanInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public TrainplanInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final TrainplanSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<TrainplanInfo> findByCond(
			final TrainplanSearchCond cond, final int start,
			final int count);

}