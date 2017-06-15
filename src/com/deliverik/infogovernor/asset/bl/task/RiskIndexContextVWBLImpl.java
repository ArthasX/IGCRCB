/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.model.RiskIndexContextVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskIndexContextVWSearchCond;
import com.deliverik.infogovernor.asset.model.dao.RiskIndexContextVWDAO;
import com.deliverik.infogovernor.asset.model.entity.RiskIndexContextVW;

/**
  * ����: ����ָ��չʾ���ݲ�ѯҵ���߼�ʵ��
  * ��������: ����ָ��չʾ���ݲ�ѯҵ���߼�ʵ��
  * ������¼: 2014/07/26
  * �޸ļ�¼: 
  */
public class RiskIndexContextVWBLImpl extends BaseBLImpl implements
		RiskIndexContextVWBL {

	/** ����ָ��չʾ���ݲ�ѯDAO�ӿ� */
	protected RiskIndexContextVWDAO riskIndexContextVWDAO;
	
	/**
	 * ����ָ��չʾ���ݲ�ѯDAO�ӿ��趨
	 *
	 * @param riskIndexContextVWDAO ����ָ��չʾ���ݲ�ѯDAO�ӿ�
	 */
	public void setRiskIndexContextVWDAO(RiskIndexContextVWDAO riskIndexContextVWDAO) {
		this.riskIndexContextVWDAO = riskIndexContextVWDAO;
	}

	/**
	 * ����ָ��չʾ���ݲ�ѯʵ��ȡ��
	 *
	 * @return ����ָ��չʾ���ݲ�ѯʵ��
	 */
	public RiskIndexContextVW getRiskIndexContextVWTBInstance() {
		return new RiskIndexContextVW();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskIndexContextVWInfo> searchRiskIndexContextVW() {
		return riskIndexContextVWDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskIndexContextVWInfo searchRiskIndexContextVWByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(RiskIndexContextVWSearchCond cond) {
		return riskIndexContextVWDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RiskIndexContextVWInfo> searchRiskIndexContextVW(
			RiskIndexContextVWSearchCond cond) {
		return riskIndexContextVWDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskIndexContextVWInfo> searchRiskIndexContextVW(
			RiskIndexContextVWSearchCond cond, int start,
			int count) {
		return riskIndexContextVWDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public RiskIndexContextVWInfo registRiskIndexContextVW(RiskIndexContextVWInfo instance)
		throws BLException {
		return riskIndexContextVWDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public RiskIndexContextVWInfo updateRiskIndexContextVW(RiskIndexContextVWInfo instance)
		throws BLException {
		checkExistInstance(instance.getRimid());
		return riskIndexContextVWDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteRiskIndexContextVWByPK(Integer pk)
		throws BLException {
		riskIndexContextVWDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteRiskIndexContextVW(RiskIndexContextVWInfo instance)
		throws BLException {
		riskIndexContextVWDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public RiskIndexContextVWInfo checkExistInstance(Integer pk)
		throws BLException {
		RiskIndexContextVWInfo instance = riskIndexContextVWDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}