/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.asset.model.CIResultInfo;
import com.deliverik.framework.asset.model.condition.CIResultSearchCond;
import com.deliverik.framework.asset.model.entity.CIResultTB;

/**
  * ����: CI����ԱȽ����Ϣ��ҵ���߼��ӿ�
  * ��������: CI����ԱȽ����Ϣ��ҵ���߼��ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface CIResultBL extends BaseBL {

	/**
	 * CI����ԱȽ����Ϣ��ʵ��ȡ��
	 *
	 * @return CI����ԱȽ����Ϣ��ʵ��
	 */
	public CIResultTB getCIResultTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CIResultInfo> searchCIResult();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CIResultInfo searchCIResultByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CIResultSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CIResultInfo> searchCIResult(
			CIResultSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CIResultInfo> searchCIResult(
			CIResultSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CIResultInfo registCIResult(CIResultInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CIResultInfo updateCIResult(CIResultInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCIResultByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCIResult(CIResultInfo instance)
		throws BLException;

	/**
	 * ���µ�ǰ����Ϊ������
	 *
	 * @param cond ��������
	 */
	public Integer updateCIResultWithout(CIResultSearchCond cond)
		throws BLException;

}