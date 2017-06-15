/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.model.CheckToRiskRelateVWInfo;
import com.deliverik.infogovernor.asset.model.condition.CheckToRiskRelateVWSearchCond;
import com.deliverik.infogovernor.asset.model.entity.CheckToRiskRelateVW;

/**
  * ����: �������յ��ϵģ��ҵ���߼��ӿ�
  * ��������: �������յ��ϵģ��ҵ���߼��ӿ�
  * ������¼: 2014/07/23
  * �޸ļ�¼: 
  */
public interface CheckToRiskRelateVWBL extends BaseBL {

	/**
	 * �������յ��ϵģ��ʵ��ȡ��
	 *
	 * @return �������յ��ϵģ��ʵ��
	 */
	public CheckToRiskRelateVW getCheckToRiskRelateVWInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CheckToRiskRelateVWInfo> searchCheckToRiskRelateVW();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CheckToRiskRelateVWInfo searchCheckToRiskRelateVWByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CheckToRiskRelateVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CheckToRiskRelateVWInfo> searchCheckToRiskRelateVW(
			CheckToRiskRelateVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CheckToRiskRelateVWInfo> searchCheckToRiskRelateVW(
			CheckToRiskRelateVWSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CheckToRiskRelateVWInfo registCheckToRiskRelateVW(CheckToRiskRelateVWInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CheckToRiskRelateVWInfo updateCheckToRiskRelateVW(CheckToRiskRelateVWInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCheckToRiskRelateVWByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCheckToRiskRelateVW(CheckToRiskRelateVWInfo instance)
		throws BLException;

}