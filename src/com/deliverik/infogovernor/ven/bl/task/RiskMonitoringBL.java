/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ven.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.ven.model.RiskMonitoringInfo;
import com.deliverik.infogovernor.ven.model.condition.RiskMonitoringSearchCond;
import com.deliverik.infogovernor.ven.model.entity.RiskMonitoringTB;

/**
 * ����: ���ռ���ҵ���߼��ӿ� ��������: ���ռ���ҵ���߼��ӿ� ������¼: 2014/12/01 �޸ļ�¼:
 */
public interface RiskMonitoringBL extends BaseBL {

	/**
	 * ���ռ���ʵ��ȡ��
	 * 
	 * @return ���ռ���ʵ��
	 */
	public RiskMonitoringTB getRiskMonitoringTBInstance();

	/**
	 * ȫ������
	 * 
	 * @return ���������
	 */
	public List<RiskMonitoringInfo> searchRiskMonitoring();

	/**
	 * ������������
	 * 
	 * @param pk
	 *            ����
	 * @return �������
	 */
	public RiskMonitoringInfo searchRiskMonitoringByPK(Integer pk)
			throws BLException;

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond
	 *            ��������
	 * @return �����������
	 */
	public int getSearchCount(RiskMonitoringSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param cond
	 *            ��������
	 * @return ��������б�
	 */
	public List<RiskMonitoringInfo> searchRiskMonitoring(
			RiskMonitoringSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param cond
	 *            ��������
	 * @param start
	 *            ������¼��ʼ�к�
	 * @param count
	 *            ������¼����
	 * @return ��������б�
	 */
	public List<RiskMonitoringInfo> searchRiskMonitoring(
			RiskMonitoringSearchCond cond, int start, int count);

	/**
	 * ��������
	 * 
	 * @param instance
	 *            ����ʵ��
	 * @return ����ʵ��
	 */
	public RiskMonitoringInfo registRiskMonitoring(RiskMonitoringInfo instance)
			throws BLException;

	/**
	 * �޸Ĵ���
	 * 
	 * @param instance
	 *            �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public RiskMonitoringInfo updateRiskMonitoring(RiskMonitoringInfo instance)
			throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param pk
	 *            ����
	 */
	public void deleteRiskMonitoringByPK(Integer pk) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param instance
	 *            ɾ��ʵ��
	 */
	public void deleteRiskMonitoring(RiskMonitoringInfo instance)
			throws BLException;

}