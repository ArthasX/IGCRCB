/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ven.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.ven.model.RiskStrategyInfo;
import com.deliverik.infogovernor.ven.model.condition.RiskStrategySearchCond;
import com.deliverik.infogovernor.ven.model.entity.RiskStrategyTB;

/**
  * ����: ���ղ��Ա�ҵ���߼��ӿ�
  * ��������: ���ղ��Ա�ҵ���߼��ӿ�
  * ������¼: 2014/12/01
  * �޸ļ�¼: 
  */
public interface RiskStrategyBL extends BaseBL {

	/**
	 * ���ղ��Ա�ʵ��ȡ��
	 *
	 * @return ���ղ��Ա�ʵ��
	 */
	public RiskStrategyTB getRiskStrategyTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskStrategyInfo> searchRiskStrategy();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskStrategyInfo searchRiskStrategyByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(RiskStrategySearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RiskStrategyInfo> searchRiskStrategy(
			RiskStrategySearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskStrategyInfo> searchRiskStrategy(
			RiskStrategySearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public RiskStrategyInfo registRiskStrategy(RiskStrategyInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public RiskStrategyInfo updateRiskStrategy(RiskStrategyInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteRiskStrategyByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteRiskStrategy(RiskStrategyInfo instance)
		throws BLException;

}