/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.model.RiskIndexSearchVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskIndexSearchVWSearchCond;
import com.deliverik.infogovernor.asset.model.entity.RiskIndexSearchVW;

/**
  * ����: ����ָ���ѯҵ���߼��ӿ�
  * ��������: ����ָ���ѯҵ���߼��ӿ�
  * ������¼: 2014/07/25
  * �޸ļ�¼: 
  */
public interface RiskIndexSearchVWBL extends BaseBL {

	/**
	 * ����ָ���ѯʵ��ȡ��
	 *
	 * @return ����ָ���ѯʵ��
	 */
	public RiskIndexSearchVW getRiskIndexSearchVWTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskIndexSearchVWInfo> searchRiskIndexSearchVW();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskIndexSearchVWInfo searchRiskIndexSearchVWByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(RiskIndexSearchVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RiskIndexSearchVWInfo> searchRiskIndexSearchVW(
			RiskIndexSearchVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskIndexSearchVWInfo> searchRiskIndexSearchVW(
			RiskIndexSearchVWSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public RiskIndexSearchVWInfo registRiskIndexSearchVW(RiskIndexSearchVWInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public RiskIndexSearchVWInfo updateRiskIndexSearchVW(RiskIndexSearchVWInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteRiskIndexSearchVWByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteRiskIndexSearchVW(RiskIndexSearchVWInfo instance)
		throws BLException;

}