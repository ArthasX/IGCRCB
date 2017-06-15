/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.model.RiskCheckVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskCheckVWSearchCond;
import com.deliverik.infogovernor.asset.model.entity.RiskCheckVW;

/**
  * ����: ��鹤��ͳ�Ʊ���ҵ���߼��ӿ�
  * ��������: ��鹤��ͳ�Ʊ���ҵ���߼��ӿ�
  * ������¼: 2014/07/22
  * �޸ļ�¼: 
  */
public interface RiskCheckVWBL extends BaseBL {

	/**
	 * ��鹤��ͳ�Ʊ���ʵ��ȡ��
	 *
	 * @return ��鹤��ͳ�Ʊ���ʵ��
	 */
	public RiskCheckVW getRiskCheckVWTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskCheckVWInfo> searchRiskCheckVW();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskCheckVWInfo searchRiskCheckVWByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(RiskCheckVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RiskCheckVWInfo> searchRiskCheckVW(
			RiskCheckVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskCheckVWInfo> searchRiskCheckVW(
			RiskCheckVWSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public RiskCheckVWInfo registRiskCheckVW(RiskCheckVWInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public RiskCheckVWInfo updateRiskCheckVW(RiskCheckVWInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteRiskCheckVWByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteRiskCheckVW(RiskCheckVWInfo instance)
		throws BLException;

}