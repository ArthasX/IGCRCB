/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ven.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.ven.model.RiskStrategyInfo;
import com.deliverik.infogovernor.ven.model.condition.RiskStrategySearchCond;
import com.deliverik.infogovernor.ven.model.dao.RiskStrategyDAO;
import com.deliverik.infogovernor.ven.model.entity.RiskStrategyTB;

/**
  * ����: ���ղ��Ա�ҵ���߼�ʵ��
  * ��������: ���ղ��Ա�ҵ���߼�ʵ��
  * ������¼: 2014/12/01
  * �޸ļ�¼: 
  */
public class RiskStrategyBLImpl extends BaseBLImpl implements
		RiskStrategyBL {

	/** ���ղ��Ա�DAO�ӿ� */
	protected RiskStrategyDAO riskStrategyDAO;
	
	/**
	 * ���ղ��Ա�DAO�ӿ��趨
	 *
	 * @param riskStrategyDAO ���ղ��Ա�DAO�ӿ�
	 */
	public void setRiskStrategyDAO(RiskStrategyDAO riskStrategyDAO) {
		this.riskStrategyDAO = riskStrategyDAO;
	}

	/**
	 * ���ղ��Ա�ʵ��ȡ��
	 *
	 * @return ���ղ��Ա�ʵ��
	 */
	public RiskStrategyTB getRiskStrategyTBInstance() {
		return new RiskStrategyTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskStrategyInfo> searchRiskStrategy() {
		return riskStrategyDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskStrategyInfo searchRiskStrategyByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(RiskStrategySearchCond cond) {
		return riskStrategyDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RiskStrategyInfo> searchRiskStrategy(
			RiskStrategySearchCond cond) {
		return riskStrategyDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return riskStrategyDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public RiskStrategyInfo registRiskStrategy(RiskStrategyInfo instance)
		throws BLException {
		return riskStrategyDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public RiskStrategyInfo updateRiskStrategy(RiskStrategyInfo instance)
		throws BLException {
		checkExistInstance(instance.getRsid());
		return riskStrategyDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteRiskStrategyByPK(Integer pk)
		throws BLException {
		riskStrategyDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteRiskStrategy(RiskStrategyInfo instance)
		throws BLException {
		riskStrategyDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public RiskStrategyInfo checkExistInstance(Integer pk)
		throws BLException {
		RiskStrategyInfo instance = riskStrategyDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}