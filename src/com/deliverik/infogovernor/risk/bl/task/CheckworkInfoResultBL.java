/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.risk.model.CheckworkInfoResultInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckworkInfoResultSearchCond;
import com.deliverik.infogovernor.risk.model.entity.CheckworkInfoResultTB;

/**
  * ����: ��鹤��������������ҵ���߼��ӿ�
  * ��������: ��鹤��������������ҵ���߼��ӿ�
  * ������¼: 2014/09/02
  * �޸ļ�¼: 
  */
public interface CheckworkInfoResultBL extends BaseBL {

	/**
	 * ��鹤��������������ʵ��ȡ��
	 *
	 * @return ��鹤��������������ʵ��
	 */
	public CheckworkInfoResultTB getCheckworkInfoResultTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CheckworkInfoResultInfo> searchCheckworkInfoResult();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CheckworkInfoResultInfo searchCheckworkInfoResultByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CheckworkInfoResultSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CheckworkInfoResultInfo> searchCheckworkInfoResult(
			CheckworkInfoResultSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CheckworkInfoResultInfo> searchCheckworkInfoResult(
			CheckworkInfoResultSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CheckworkInfoResultInfo registCheckworkInfoResult(CheckworkInfoResultInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CheckworkInfoResultInfo updateCheckworkInfoResult(CheckworkInfoResultInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCheckworkInfoResultByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCheckworkInfoResult(CheckworkInfoResultInfo instance)
		throws BLException;

}