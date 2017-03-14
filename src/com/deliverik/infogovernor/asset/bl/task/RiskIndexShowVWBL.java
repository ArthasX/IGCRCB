/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.model.RiskIndexShowVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskIndexShowVWSearchCond;
import com.deliverik.infogovernor.asset.model.entity.RiskIndexShowVW;

/**
  * ����: ����ָ��չʾ��ѯҵ���߼��ӿ�
  * ��������: ����ָ��չʾ��ѯҵ���߼��ӿ�
  * ������¼: 2014/07/25
  * �޸ļ�¼: 
  */
public interface RiskIndexShowVWBL extends BaseBL {

	/**
	 * ����ָ��չʾ��ѯʵ��ȡ��
	 *
	 * @return ����ָ��չʾ��ѯʵ��
	 */
	public RiskIndexShowVW getRiskIndexShowVWTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskIndexShowVWInfo> searchRiskIndexShowVW();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskIndexShowVWInfo searchRiskIndexShowVWByPK(String pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(RiskIndexShowVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RiskIndexShowVWInfo> searchRiskIndexShowVW(
			RiskIndexShowVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskIndexShowVWInfo> searchRiskIndexShowVW(
			RiskIndexShowVWSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public RiskIndexShowVWInfo registRiskIndexShowVW(RiskIndexShowVWInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public RiskIndexShowVWInfo updateRiskIndexShowVW(RiskIndexShowVWInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteRiskIndexShowVWByPK(String pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteRiskIndexShowVW(RiskIndexShowVWInfo instance)
		throws BLException;

}