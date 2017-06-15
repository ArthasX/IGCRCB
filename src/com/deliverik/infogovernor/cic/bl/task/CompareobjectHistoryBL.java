/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.cic.model.CompareobjectHistoryInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareobjectHistorySearchCond;
import com.deliverik.infogovernor.cic.model.entity.CompareobjectHistoryTB;

/**
  * ����: �Աȶ�����ʷ��ҵ���߼��ӿ�
  * ��������: �Աȶ�����ʷ��ҵ���߼��ӿ�
  * ������¼: 2014/04/24
  * �޸ļ�¼: 
  */
public interface CompareobjectHistoryBL extends BaseBL {

	/**
	 * �Աȶ�����ʷ��ʵ��ȡ��
	 *
	 * @return �Աȶ�����ʷ��ʵ��
	 */
	public CompareobjectHistoryTB getCompareobjectHistoryTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CompareobjectHistoryInfo> searchCompareobjectHistory();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CompareobjectHistoryInfo searchCompareobjectHistoryByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CompareobjectHistorySearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CompareobjectHistoryInfo> searchCompareobjectHistory(
			CompareobjectHistorySearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CompareobjectHistoryInfo> searchCompareobjectHistory(
			CompareobjectHistorySearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CompareobjectHistoryInfo registCompareobjectHistory(CompareobjectHistoryInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CompareobjectHistoryInfo updateCompareobjectHistory(CompareobjectHistoryInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCompareobjectHistoryByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCompareobjectHistory(CompareobjectHistoryInfo instance)
		throws BLException;

}