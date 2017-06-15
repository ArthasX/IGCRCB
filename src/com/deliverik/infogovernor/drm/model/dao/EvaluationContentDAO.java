/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.drm.model.EvaluationContentInfo;
import com.deliverik.infogovernor.drm.model.condition.EvaluationContentSearchCond;

/**
  * ����: ��Ŀ�ܱ���Ա������DAO�ӿ�
  * ��������: ��Ŀ�ܱ���Ա������DAO�ӿ�
  * ������¼: 2016/08/11
  * �޸ļ�¼: 
  */
public interface EvaluationContentDAO extends BaseHibernateDAO<EvaluationContentInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EvaluationContentInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public EvaluationContentInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final EvaluationContentSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EvaluationContentInfo> findByCond(
			final EvaluationContentSearchCond cond, final int start,
			final int count);

}