/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ram.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.ram.model.AssessmentScoreVWInfo;
import com.deliverik.infogovernor.ram.model.condition.AssessmentScoreVWSearchCond;
import com.deliverik.infogovernor.ram.model.entity.AssessmentScoreVW;

/**
  * ����: ������ʷ��ѯҵ���߼��ӿ�
  * ��������: ������ʷ��ѯҵ���߼��ӿ�
  * ������¼: 2013/10/10
  * �޸ļ�¼: 
  */
public interface AssessmentScoreVWBL extends BaseBL {

	/**
	 * ������ʷ��ѯʵ��ȡ��
	 *
	 * @return ������ʷ��ѯʵ��
	 */
	public AssessmentScoreVW getAssessmentScoreTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AssessmentScoreVWInfo> searchAssessmentScore();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AssessmentScoreVWInfo searchAssessmentScoreByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(AssessmentScoreVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<AssessmentScoreVWInfo> searchAssessmentScore(
			AssessmentScoreVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AssessmentScoreVWInfo> searchAssessmentScore(
			AssessmentScoreVWSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public AssessmentScoreVWInfo registAssessmentScore(AssessmentScoreVWInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public AssessmentScoreVWInfo updateAssessmentScore(AssessmentScoreVWInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteAssessmentScoreByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteAssessmentScore(AssessmentScoreVWInfo instance)
		throws BLException;
	/**
	 * ������������������
	 * @return ������ȱ���
	 */
	public List<Object[]> getAssessmentYearReport(final AssessmentScoreVWSearchCond cond);
	
	/**
	 * �������������������
	 * @return �������ű���
	 */
	public List<Object[]> getAssessmentOrgReport(final AssessmentScoreVWSearchCond cond);

}