/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.model.RiskPointVMInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskPointVMSearchCond;
import com.deliverik.infogovernor.asset.model.entity.RiskPointVM;

/**
  * ����: ���յ��ѯҵ���߼��ӿ�
  * ��������: ���յ��ѯҵ���߼��ӿ�
  * ������¼: 2014/06/30
  * �޸ļ�¼: 
  */
public interface RiskPointVMBL extends BaseBL {

	/**
	 * ���յ��ѯʵ��ȡ��
	 *
	 * @return ���յ��ѯʵ��
	 */
	public RiskPointVM getRiskPointVMTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskPointVMInfo> searchRiskPointVM();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskPointVMInfo searchRiskPointVMByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(RiskPointVMSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RiskPointVMInfo> searchRiskPointVM(
			RiskPointVMSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskPointVMInfo> searchRiskPointVM(
			RiskPointVMSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public RiskPointVMInfo registRiskPointVM(RiskPointVMInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public RiskPointVMInfo updateRiskPointVM(RiskPointVMInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteRiskPointVMByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteRiskPointVM(RiskPointVMInfo instance)
		throws BLException;

}