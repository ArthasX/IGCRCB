/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ram.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.ram.model.AssessmentScoreVWInfo;
import com.deliverik.infogovernor.ram.model.condition.AssessmentScoreVWSearchCond;

/**
  * ����: ������ʷ��ѯDAO�ӿ�
  * ��������: ������ʷ��ѯDAO�ӿ�
  * ������¼: 2013/10/10
  * �޸ļ�¼: 
  */
public interface AssessmentScoreVWDAO extends BaseHibernateDAO<AssessmentScoreVWInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AssessmentScoreVWInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AssessmentScoreVWInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final AssessmentScoreVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AssessmentScoreVWInfo> findByCond(
			final AssessmentScoreVWSearchCond cond, final int start,
			final int count);
	/**
	 * ������������
	 * @return ������ȱ���
	 */
	public List<Object[]> assessmentYearReport(final AssessmentScoreVWSearchCond cond);
	
	/**
	 * �������������������
	 * @return ������ȱ���
	 */
	public List<Object[]> assessmentOrganizationReport(final AssessmentScoreVWSearchCond cond);

}