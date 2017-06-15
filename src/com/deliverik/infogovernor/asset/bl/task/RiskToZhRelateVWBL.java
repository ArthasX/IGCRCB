/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.model.RiskToZhRelateVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskToZhRelateVWSearchCond;
import com.deliverik.infogovernor.asset.model.entity.RiskToZhRelateVW;

/**
  * ����: ���յ�ָ���ϵҵ���߼��ӿ�
  * ��������: ���յ�ָ���ϵҵ���߼��ӿ�
  * ������¼: 2014/07/24
  * �޸ļ�¼: 
  */
public interface RiskToZhRelateVWBL extends BaseBL {

	/**
	 * ���յ�ָ���ϵʵ��ȡ��
	 *
	 * @return ���յ�ָ���ϵʵ��
	 */
	public RiskToZhRelateVW getRiskToZhRelateVWTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskToZhRelateVWInfo> searchRiskToZhRelateVW();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskToZhRelateVWInfo searchRiskToZhRelateVWByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(RiskToZhRelateVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RiskToZhRelateVWInfo> searchRiskToZhRelateVW(
			RiskToZhRelateVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskToZhRelateVWInfo> searchRiskToZhRelateVW(
			RiskToZhRelateVWSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public RiskToZhRelateVWInfo registRiskToZhRelateVW(RiskToZhRelateVWInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public RiskToZhRelateVWInfo updateRiskToZhRelateVW(RiskToZhRelateVWInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteRiskToZhRelateVWByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteRiskToZhRelateVW(RiskToZhRelateVWInfo instance)
		throws BLException;

}