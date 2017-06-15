/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.model.EvaluationContentInfo;
import com.deliverik.infogovernor.drm.model.condition.EvaluationContentSearchCond;
import com.deliverik.infogovernor.drm.model.entity.EvaluationContentTB;

/**
  * ����: ��Ŀ�ܱ���Ա������ҵ���߼��ӿ�
  * ��������: ��Ŀ�ܱ���Ա������ҵ���߼��ӿ�
  * ������¼: 2016/08/11
  * �޸ļ�¼: 
  */
public interface EvaluationContentBL extends BaseBL {

	/**
	 * ��Ŀ�ܱ���Ա������ʵ��ȡ��
	 *
	 * @return ��Ŀ�ܱ���Ա������ʵ��
	 */
	public EvaluationContentTB getEvaluationContentTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EvaluationContentInfo> searchEvaluationContent();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public EvaluationContentInfo searchEvaluationContentByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(EvaluationContentSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<EvaluationContentInfo> searchEvaluationContent(
			EvaluationContentSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EvaluationContentInfo> searchEvaluationContent(
			EvaluationContentSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public EvaluationContentInfo registEvaluationContent(EvaluationContentInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public EvaluationContentInfo updateEvaluationContent(EvaluationContentInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteEvaluationContentByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteEvaluationContent(EvaluationContentInfo instance)
		throws BLException;

	public List<EvaluationContentInfo> saveEvaluationContent(EvaluationContentTB evaluationContentTB)throws BLException;
}