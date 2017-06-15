/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.model.RiskIndexContextVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskIndexContextVWSearchCond;
import com.deliverik.infogovernor.asset.model.entity.RiskIndexContextVW;

/**
  * ����: ����ָ��չʾ���ݲ�ѯҵ���߼��ӿ�
  * ��������: ����ָ��չʾ���ݲ�ѯҵ���߼��ӿ�
  * ������¼: 2014/07/26
  * �޸ļ�¼: 
  */
public interface RiskIndexContextVWBL extends BaseBL {

	/**
	 * ����ָ��չʾ���ݲ�ѯʵ��ȡ��
	 *
	 * @return ����ָ��չʾ���ݲ�ѯʵ��
	 */
	public RiskIndexContextVW getRiskIndexContextVWTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskIndexContextVWInfo> searchRiskIndexContextVW();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskIndexContextVWInfo searchRiskIndexContextVWByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(RiskIndexContextVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RiskIndexContextVWInfo> searchRiskIndexContextVW(
			RiskIndexContextVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskIndexContextVWInfo> searchRiskIndexContextVW(
			RiskIndexContextVWSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public RiskIndexContextVWInfo registRiskIndexContextVW(RiskIndexContextVWInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public RiskIndexContextVWInfo updateRiskIndexContextVW(RiskIndexContextVWInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteRiskIndexContextVWByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteRiskIndexContextVW(RiskIndexContextVWInfo instance)
		throws BLException;

}