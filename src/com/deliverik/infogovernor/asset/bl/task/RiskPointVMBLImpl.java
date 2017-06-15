/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.model.RiskPointVMInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskPointVMSearchCond;
import com.deliverik.infogovernor.asset.model.dao.RiskPointVMDAO;
import com.deliverik.infogovernor.asset.model.entity.RiskPointVM;

/**
  * ����: ���յ��ѯҵ���߼�ʵ��
  * ��������: ���յ��ѯҵ���߼�ʵ��
  * ������¼: 2014/06/30
  * �޸ļ�¼: 
  */
public class RiskPointVMBLImpl extends BaseBLImpl implements
		RiskPointVMBL {

	/** ���յ��ѯDAO�ӿ� */
	protected RiskPointVMDAO riskPointVMDAO;
	
	/**
	 * ���յ��ѯDAO�ӿ��趨
	 *
	 * @param riskPointVMDAO ���յ��ѯDAO�ӿ�
	 */
	public void setRiskPointVMDAO(RiskPointVMDAO riskPointVMDAO) {
		this.riskPointVMDAO = riskPointVMDAO;
	}

	/**
	 * ���յ��ѯʵ��ȡ��
	 *
	 * @return ���յ��ѯʵ��
	 */
	public RiskPointVM getRiskPointVMTBInstance() {
		return new RiskPointVM();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskPointVMInfo> searchRiskPointVM() {
		return riskPointVMDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskPointVMInfo searchRiskPointVMByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(RiskPointVMSearchCond cond) {
		riskPointVMDAO.findByCond(cond, 0, 0);
		return riskPointVMDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RiskPointVMInfo> searchRiskPointVM(
			RiskPointVMSearchCond cond) {
		return riskPointVMDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return riskPointVMDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public RiskPointVMInfo registRiskPointVM(RiskPointVMInfo instance)
		throws BLException {
		return riskPointVMDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public RiskPointVMInfo updateRiskPointVM(RiskPointVMInfo instance)
		throws BLException {
		checkExistInstance(instance.getEiid());
		return riskPointVMDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteRiskPointVMByPK(Integer pk)
		throws BLException {
		riskPointVMDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteRiskPointVM(RiskPointVMInfo instance)
		throws BLException {
		riskPointVMDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public RiskPointVMInfo checkExistInstance(Integer pk)
		throws BLException {
		RiskPointVMInfo instance = riskPointVMDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}