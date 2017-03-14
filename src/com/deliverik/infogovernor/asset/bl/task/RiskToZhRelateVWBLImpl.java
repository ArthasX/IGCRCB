/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.model.RiskToZhRelateVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskToZhRelateVWSearchCond;
import com.deliverik.infogovernor.asset.model.dao.RiskToZhRelateVWDAO;
import com.deliverik.infogovernor.asset.model.entity.RiskToZhRelateVW;

/**
  * ����: ���յ�ָ���ϵҵ���߼�ʵ��
  * ��������: ���յ�ָ���ϵҵ���߼�ʵ��
  * ������¼: 2014/07/24
  * �޸ļ�¼: 
  */
public class RiskToZhRelateVWBLImpl extends BaseBLImpl implements
		RiskToZhRelateVWBL {

	/** ���յ�ָ���ϵDAO�ӿ� */
	protected RiskToZhRelateVWDAO riskToZhRelateVWDAO;
	
	/**
	 * ���յ�ָ���ϵDAO�ӿ��趨
	 *
	 * @param riskToZhRelateVWDAO ���յ�ָ���ϵDAO�ӿ�
	 */
	public void setRiskToZhRelateVWDAO(RiskToZhRelateVWDAO riskToZhRelateVWDAO) {
		this.riskToZhRelateVWDAO = riskToZhRelateVWDAO;
	}

	/**
	 * ���յ�ָ���ϵʵ��ȡ��
	 *
	 * @return ���յ�ָ���ϵʵ��
	 */
	public RiskToZhRelateVW getRiskToZhRelateVWTBInstance() {
		return new RiskToZhRelateVW();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskToZhRelateVWInfo> searchRiskToZhRelateVW() {
		return riskToZhRelateVWDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskToZhRelateVWInfo searchRiskToZhRelateVWByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(RiskToZhRelateVWSearchCond cond) {
		return riskToZhRelateVWDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RiskToZhRelateVWInfo> searchRiskToZhRelateVW(
			RiskToZhRelateVWSearchCond cond) {
		return riskToZhRelateVWDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskToZhRelateVWInfo> searchRiskToZhRelateVW(
			RiskToZhRelateVWSearchCond cond, int start,
			int count) {
		return riskToZhRelateVWDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public RiskToZhRelateVWInfo registRiskToZhRelateVW(RiskToZhRelateVWInfo instance)
		throws BLException {
		return riskToZhRelateVWDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public RiskToZhRelateVWInfo updateRiskToZhRelateVW(RiskToZhRelateVWInfo instance)
		throws BLException {
		checkExistInstance(instance.getEiid());
		return riskToZhRelateVWDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteRiskToZhRelateVWByPK(Integer pk)
		throws BLException {
		riskToZhRelateVWDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteRiskToZhRelateVW(RiskToZhRelateVWInfo instance)
		throws BLException {
		riskToZhRelateVWDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public RiskToZhRelateVWInfo checkExistInstance(Integer pk)
		throws BLException {
		RiskToZhRelateVWInfo instance = riskToZhRelateVWDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}