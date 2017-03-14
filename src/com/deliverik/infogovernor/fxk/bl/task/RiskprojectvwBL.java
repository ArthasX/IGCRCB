/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.fxk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.fxk.model.RiskprojectvwInfo;
import com.deliverik.infogovernor.fxk.model.condition.RiskprojectvwSearchCond;
import com.deliverik.infogovernor.fxk.model.entity.RiskprojectvwTB;

/**
  * ����: ͨѶ¼ҵ���߼��ӿ�
  * ��������: ͨѶ¼ҵ���߼��ӿ�
  * ������¼: 2014/07/24
  * �޸ļ�¼: 
  */
public interface RiskprojectvwBL extends BaseBL {

	/**
	 * ͨѶ¼ʵ��ȡ��
	 *
	 * @return ͨѶ¼ʵ��
	 */
	public RiskprojectvwTB getRiskprojectvwTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskprojectvwInfo> searchRiskprojectvw();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskprojectvwInfo searchRiskprojectvwByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(RiskprojectvwSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RiskprojectvwInfo> searchRiskprojectvw(
			RiskprojectvwSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskprojectvwInfo> searchRiskprojectvw(
			RiskprojectvwSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public RiskprojectvwInfo registRiskprojectvw(RiskprojectvwInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public RiskprojectvwInfo updateRiskprojectvw(RiskprojectvwInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteRiskprojectvwByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteRiskprojectvw(RiskprojectvwInfo instance)
		throws BLException;

}