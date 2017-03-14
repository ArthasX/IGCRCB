/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ven.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.ven.model.RiskMonitoringInfo;
import com.deliverik.infogovernor.ven.model.condition.RiskMonitoringSearchCond;
import com.deliverik.infogovernor.ven.model.dao.RiskMonitoringDAO;
import com.deliverik.infogovernor.ven.model.entity.RiskMonitoringTB;

/**
  * ����: ���ռ���ҵ���߼�ʵ��
  * ��������: ���ռ���ҵ���߼�ʵ��
  * ������¼: 2014/12/01
  * �޸ļ�¼: 
  */
public class RiskMonitoringBLImpl extends BaseBLImpl implements
		RiskMonitoringBL {

	/** ���ռ���DAO�ӿ� */
	protected RiskMonitoringDAO riskMonitoringDAO;
	
	/**
	 * ���ռ���DAO�ӿ��趨
	 *
	 * @param riskMonitoringDAO ���ռ���DAO�ӿ�
	 */
	public void setRiskMonitoringDAO(RiskMonitoringDAO riskMonitoringDAO) {
		this.riskMonitoringDAO = riskMonitoringDAO;
	}

	/**
	 * ���ռ���ʵ��ȡ��
	 *
	 * @return ���ռ���ʵ��
	 */
	public RiskMonitoringTB getRiskMonitoringTBInstance() {
		return new RiskMonitoringTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskMonitoringInfo> searchRiskMonitoring() {
		return riskMonitoringDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskMonitoringInfo searchRiskMonitoringByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(RiskMonitoringSearchCond cond) {
		return riskMonitoringDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RiskMonitoringInfo> searchRiskMonitoring(
			RiskMonitoringSearchCond cond) {
		return riskMonitoringDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskMonitoringInfo> searchRiskMonitoring(
			RiskMonitoringSearchCond cond, int start,
			int count) {
		return riskMonitoringDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public RiskMonitoringInfo registRiskMonitoring(RiskMonitoringInfo instance)
		throws BLException {
		return riskMonitoringDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public RiskMonitoringInfo updateRiskMonitoring(RiskMonitoringInfo instance)
		throws BLException {
		checkExistInstance(instance.getRmid());
		return riskMonitoringDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteRiskMonitoringByPK(Integer pk)
		throws BLException {
		riskMonitoringDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteRiskMonitoring(RiskMonitoringInfo instance)
		throws BLException {
		riskMonitoringDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public RiskMonitoringInfo checkExistInstance(Integer pk)
		throws BLException {
		RiskMonitoringInfo instance = riskMonitoringDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}