/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.drm.model.TrainmissionInfo;
import com.deliverik.infogovernor.drm.model.condition.TrainmissionSearchCond;

/**
  * ����: ��ѵ�����DAO�ӿ�
  * ��������: ��ѵ�����DAO�ӿ�
  * ������¼: 2015/04/10
  * �޸ļ�¼: 
  */
public interface TrainmissionDAO extends BaseHibernateDAO<TrainmissionInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<TrainmissionInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public TrainmissionInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final TrainmissionSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<TrainmissionInfo> findByCond(
			final TrainmissionSearchCond cond, final int start,
			final int count);
	public List<Map<String, Object>> getList(final String [] sqlKeys, final Map<String, String> paramMap);
}