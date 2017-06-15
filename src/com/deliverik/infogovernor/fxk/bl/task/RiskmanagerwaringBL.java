/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.fxk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.fxk.model.RiskmanagerwaringInfo;
import com.deliverik.infogovernor.fxk.model.condition.RiskmanagerwaringSearchCond;
import com.deliverik.infogovernor.fxk.model.entity.RiskmanagerwaringTB;

/**
  * ����: ���չ�����ʾ���ݱ�ҵ���߼��ӿ�
  * ��������: ���չ�����ʾ���ݱ�ҵ���߼��ӿ�
  * ������¼: 2014/06/17
  * �޸ļ�¼: 
  */
public interface RiskmanagerwaringBL extends BaseBL {

	/**
	 * ���չ�����ʾ���ݱ�ʵ��ȡ��
	 *
	 * @return ���չ�����ʾ���ݱ�ʵ��
	 */
	public RiskmanagerwaringTB getRiskmanagerwaringTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskmanagerwaringInfo> searchRiskmanagerwaring();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskmanagerwaringInfo searchRiskmanagerwaringByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(RiskmanagerwaringSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RiskmanagerwaringInfo> searchRiskmanagerwaring(
			RiskmanagerwaringSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskmanagerwaringInfo> searchRiskmanagerwaring(
			RiskmanagerwaringSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public RiskmanagerwaringInfo registRiskmanagerwaring(RiskmanagerwaringInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public RiskmanagerwaringInfo updateRiskmanagerwaring(RiskmanagerwaringInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteRiskmanagerwaringByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteRiskmanagerwaring(RiskmanagerwaringInfo instance)
		throws BLException;

}