/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.model.RiskCheckVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskCheckVWSearchCond;
import com.deliverik.infogovernor.asset.model.dao.RiskCheckVWDAO;
import com.deliverik.infogovernor.asset.model.entity.RiskCheckVW;

/**
  * ����: ��鹤��ͳ�Ʊ���ҵ���߼�ʵ��
  * ��������: ��鹤��ͳ�Ʊ���ҵ���߼�ʵ��
  * ������¼: 2014/07/22
  * �޸ļ�¼: 
  */
public class RiskCheckVWBLImpl extends BaseBLImpl implements
		RiskCheckVWBL {

	/** ��鹤��ͳ�Ʊ���DAO�ӿ� */
	protected RiskCheckVWDAO riskCheckVWDAO;
	
	/**
	 * ��鹤��ͳ�Ʊ���DAO�ӿ��趨
	 *
	 * @param riskCheckVWDAO ��鹤��ͳ�Ʊ���DAO�ӿ�
	 */
	public void setRiskCheckVWDAO(RiskCheckVWDAO riskCheckVWDAO) {
		this.riskCheckVWDAO = riskCheckVWDAO;
	}

	/**
	 * ��鹤��ͳ�Ʊ���ʵ��ȡ��
	 *
	 * @return ��鹤��ͳ�Ʊ���ʵ��
	 */
	public RiskCheckVW getRiskCheckVWTBInstance() {
		return new RiskCheckVW();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskCheckVWInfo> searchRiskCheckVW() {
		return riskCheckVWDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskCheckVWInfo searchRiskCheckVWByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(RiskCheckVWSearchCond cond) {
		return riskCheckVWDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RiskCheckVWInfo> searchRiskCheckVW(
			RiskCheckVWSearchCond cond) {
		return riskCheckVWDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskCheckVWInfo> searchRiskCheckVW(
			RiskCheckVWSearchCond cond, int start,
			int count) {
		return riskCheckVWDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public RiskCheckVWInfo registRiskCheckVW(RiskCheckVWInfo instance)
		throws BLException {
		return riskCheckVWDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public RiskCheckVWInfo updateRiskCheckVW(RiskCheckVWInfo instance)
		throws BLException {
		checkExistInstance(instance.getEiid());
		return riskCheckVWDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteRiskCheckVWByPK(Integer pk)
		throws BLException {
		riskCheckVWDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteRiskCheckVW(RiskCheckVWInfo instance)
		throws BLException {
		riskCheckVWDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public RiskCheckVWInfo checkExistInstance(Integer pk)
		throws BLException {
		RiskCheckVWInfo instance = riskCheckVWDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}