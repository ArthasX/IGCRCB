/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ram.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.ram.model.AssessmentScoreVWInfo;
import com.deliverik.infogovernor.ram.model.condition.AssessmentScoreVWSearchCond;
import com.deliverik.infogovernor.ram.model.dao.AssessmentScoreVWDAO;
import com.deliverik.infogovernor.ram.model.entity.AssessmentScoreVW;

/**
  * ����: ������ʷ��ѯҵ���߼�ʵ��
  * ��������: ������ʷ��ѯҵ���߼�ʵ��
  * ������¼: 2013/10/10
  * �޸ļ�¼: 
  */
public class AssessmentScoreVWBLImpl extends BaseBLImpl implements
		AssessmentScoreVWBL {

	/** ������ʷ��ѯDAO�ӿ� */
	protected AssessmentScoreVWDAO assessmentScoreVWDAO;
	
	/**
	 * ������ʷ��ѯDAO�ӿ��趨
	 *
	 * @param assessmentScoreDAO ������ʷ��ѯDAO�ӿ�
	 */
	public void setAssessmentScoreVWDAO(AssessmentScoreVWDAO assessmentScoreVWDAO) {
		this.assessmentScoreVWDAO = assessmentScoreVWDAO;
	}

	/**
	 * ������ʷ��ѯʵ��ȡ��
	 *
	 * @return ������ʷ��ѯʵ��
	 */
	public AssessmentScoreVW getAssessmentScoreTBInstance() {
		return new AssessmentScoreVW();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AssessmentScoreVWInfo> searchAssessmentScore() {
		return assessmentScoreVWDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AssessmentScoreVWInfo searchAssessmentScoreByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(AssessmentScoreVWSearchCond cond) {
		return assessmentScoreVWDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<AssessmentScoreVWInfo> searchAssessmentScore(
			AssessmentScoreVWSearchCond cond) {
		return assessmentScoreVWDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return assessmentScoreVWDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public AssessmentScoreVWInfo registAssessmentScore(AssessmentScoreVWInfo instance)
		throws BLException {
		return assessmentScoreVWDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public AssessmentScoreVWInfo updateAssessmentScore(AssessmentScoreVWInfo instance)
		throws BLException {
		checkExistInstance(instance.getPpiid());
		return assessmentScoreVWDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteAssessmentScoreByPK(Integer pk)
		throws BLException {
		assessmentScoreVWDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteAssessmentScore(AssessmentScoreVWInfo instance)
		throws BLException {
		assessmentScoreVWDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public AssessmentScoreVWInfo checkExistInstance(Integer pk)
		throws BLException {
		AssessmentScoreVWInfo instance = assessmentScoreVWDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	/**
	 * ���ű���������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Object[]> getAssessmentOrgReport(
			AssessmentScoreVWSearchCond cond) {
		return assessmentScoreVWDAO.assessmentOrganizationReport(cond);
	}
	/**
	 * ��ȱ���������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Object[]> getAssessmentYearReport(
			AssessmentScoreVWSearchCond cond) {
		return assessmentScoreVWDAO.assessmentYearReport(cond);
	}
}