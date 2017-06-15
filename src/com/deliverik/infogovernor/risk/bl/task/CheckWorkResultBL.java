/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.risk.model.CheckWorkResultInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckWorkResultSearchCond;
import com.deliverik.infogovernor.risk.model.entity.CheckWorkResultTB;

/**
  * ����: �������ҵ���߼��ӿ�
  * ��������: �������ҵ���߼��ӿ�
  * ������¼: 2014/09/02
  * �޸ļ�¼: 
  */
public interface CheckWorkResultBL extends BaseBL {

	/**
	 * �������ʵ��ȡ��
	 *
	 * @return �������ʵ��
	 */
	public CheckWorkResultTB getCheckWorkResultTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CheckWorkResultInfo> searchCheckWorkResult();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CheckWorkResultInfo searchCheckWorkResultByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CheckWorkResultSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CheckWorkResultInfo> searchCheckWorkResult(
			CheckWorkResultSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CheckWorkResultInfo> searchCheckWorkResult(
			CheckWorkResultSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CheckWorkResultInfo registCheckWorkResult(CheckWorkResultInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CheckWorkResultInfo updateCheckWorkResult(CheckWorkResultInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCheckWorkResultByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCheckWorkResult(CheckWorkResultInfo instance)
		throws BLException;

}