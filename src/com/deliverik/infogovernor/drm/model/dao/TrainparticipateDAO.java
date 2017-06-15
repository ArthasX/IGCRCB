/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.drm.model.TrainparticipateInfo;
import com.deliverik.infogovernor.drm.model.condition.TrainparticipateSearchCond;

/**
  * ����: ��ѵ������DAO�ӿ�
  * ��������: ��ѵ������DAO�ӿ�
  * ������¼: 2015/04/13
  * �޸ļ�¼: 
  */
public interface TrainparticipateDAO extends BaseHibernateDAO<TrainparticipateInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<TrainparticipateInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public TrainparticipateInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final TrainparticipateSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<TrainparticipateInfo> findByCond(
			final TrainparticipateSearchCond cond, final int start,
			final int count);

}