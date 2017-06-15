/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rdp.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rdp.model.ExcuteResultInfo;
import com.deliverik.infogovernor.rdp.model.condition.ExcuteResultSearchCond;
import com.deliverik.infogovernor.rdp.model.entity.ExcuteResultPK;
import com.deliverik.infogovernor.rdp.model.entity.ExcuteResultTB;

/**
  * ����: ExcuteResultҵ���߼��ӿ�
  * ��������: ExcuteResultҵ���߼��ӿ�
  * ������¼: 2014/04/16
  * �޸ļ�¼: 
  */
public interface ExcuteResultBL extends BaseBL {

	/**
	 * ExcuteResultʵ��ȡ��
	 *
	 * @return ExcuteResultʵ��
	 */
	public ExcuteResultTB getExcuteResultTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ExcuteResultInfo> searchExcuteResult();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ExcuteResultInfo searchExcuteResultByPK(ExcuteResultPK pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(ExcuteResultSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<ExcuteResultInfo> searchExcuteResult(
			ExcuteResultSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ExcuteResultInfo> searchExcuteResult(
			ExcuteResultSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public ExcuteResultInfo registExcuteResult(ExcuteResultInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public ExcuteResultInfo updateExcuteResult(ExcuteResultInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteExcuteResultByPK(ExcuteResultPK pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteExcuteResult(ExcuteResultInfo instance)
		throws BLException;

}