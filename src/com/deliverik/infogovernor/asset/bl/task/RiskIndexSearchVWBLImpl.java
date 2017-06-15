/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.model.RiskIndexSearchVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskIndexSearchVWSearchCond;
import com.deliverik.infogovernor.asset.model.dao.RiskIndexSearchVWDAO;
import com.deliverik.infogovernor.asset.model.entity.RiskIndexSearchVW;

/**
  * ����: ����ָ���ѯҵ���߼�ʵ��
  * ��������: ����ָ���ѯҵ���߼�ʵ��
  * ������¼: 2014/07/25
  * �޸ļ�¼: 
  */
public class RiskIndexSearchVWBLImpl extends BaseBLImpl implements
		RiskIndexSearchVWBL {

	/** ����ָ���ѯDAO�ӿ� */
	protected RiskIndexSearchVWDAO riskIndexSearchVWDAO;
	
	/**
	 * ����ָ���ѯDAO�ӿ��趨
	 *
	 * @param riskIndexSearchVWDAO ����ָ���ѯDAO�ӿ�
	 */
	public void setRiskIndexSearchVWDAO(RiskIndexSearchVWDAO riskIndexSearchVWDAO) {
		this.riskIndexSearchVWDAO = riskIndexSearchVWDAO;
	}

	/**
	 * ����ָ���ѯʵ��ȡ��
	 *
	 * @return ����ָ���ѯʵ��
	 */
	public RiskIndexSearchVW getRiskIndexSearchVWTBInstance() {
		return new RiskIndexSearchVW();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskIndexSearchVWInfo> searchRiskIndexSearchVW() {
		return riskIndexSearchVWDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskIndexSearchVWInfo searchRiskIndexSearchVWByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(RiskIndexSearchVWSearchCond cond) {
		return riskIndexSearchVWDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RiskIndexSearchVWInfo> searchRiskIndexSearchVW(
			RiskIndexSearchVWSearchCond cond) {
		return riskIndexSearchVWDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskIndexSearchVWInfo> searchRiskIndexSearchVW(
			RiskIndexSearchVWSearchCond cond, int start,
			int count) {
		return riskIndexSearchVWDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public RiskIndexSearchVWInfo registRiskIndexSearchVW(RiskIndexSearchVWInfo instance)
		throws BLException {
		return riskIndexSearchVWDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public RiskIndexSearchVWInfo updateRiskIndexSearchVW(RiskIndexSearchVWInfo instance)
		throws BLException {
		checkExistInstance(instance.getEiid());
		return riskIndexSearchVWDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteRiskIndexSearchVWByPK(Integer pk)
		throws BLException {
		riskIndexSearchVWDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteRiskIndexSearchVW(RiskIndexSearchVWInfo instance)
		throws BLException {
		riskIndexSearchVWDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public RiskIndexSearchVWInfo checkExistInstance(Integer pk)
		throws BLException {
		RiskIndexSearchVWInfo instance = riskIndexSearchVWDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}