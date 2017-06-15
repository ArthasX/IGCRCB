/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.drm.model.TrainrecordInfo;
import com.deliverik.infogovernor.drm.model.condition.TrainrecordSearchCond;

/**
  * ����: ��ѵ��¼DAO�ӿ�
  * ��������: ��ѵ��¼DAO�ӿ�
  * ������¼: 2015/04/13
  * �޸ļ�¼: 
  */
public interface TrainrecordDAO extends BaseHibernateDAO<TrainrecordInfo> {

	
	
	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<TrainrecordInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public TrainrecordInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final TrainrecordSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<TrainrecordInfo> findByCond(
			final TrainrecordSearchCond cond, final int start,
			final int count);

}