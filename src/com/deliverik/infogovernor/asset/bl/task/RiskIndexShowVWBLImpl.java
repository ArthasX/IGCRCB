/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.model.RiskIndexShowVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskIndexShowVWSearchCond;
import com.deliverik.infogovernor.asset.model.dao.RiskIndexShowVWDAO;
import com.deliverik.infogovernor.asset.model.entity.RiskIndexShowVW;

/**
  * ����: ����ָ��չʾ��ѯҵ���߼�ʵ��
  * ��������: ����ָ��չʾ��ѯҵ���߼�ʵ��
  * ������¼: 2014/07/25
  * �޸ļ�¼: 
  */
public class RiskIndexShowVWBLImpl extends BaseBLImpl implements
		RiskIndexShowVWBL {

	/** ����ָ��չʾ��ѯDAO�ӿ� */
	protected RiskIndexShowVWDAO riskIndexShowVWDAO;
	
	/**
	 * ����ָ��չʾ��ѯDAO�ӿ��趨
	 *
	 * @param riskIndexShowVWDAO ����ָ��չʾ��ѯDAO�ӿ�
	 */
	public void setRiskIndexShowVWDAO(RiskIndexShowVWDAO riskIndexShowVWDAO) {
		this.riskIndexShowVWDAO = riskIndexShowVWDAO;
	}

	/**
	 * ����ָ��չʾ��ѯʵ��ȡ��
	 *
	 * @return ����ָ��չʾ��ѯʵ��
	 */
	public RiskIndexShowVW getRiskIndexShowVWTBInstance() {
		return new RiskIndexShowVW();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskIndexShowVWInfo> searchRiskIndexShowVW() {
		return riskIndexShowVWDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskIndexShowVWInfo searchRiskIndexShowVWByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(RiskIndexShowVWSearchCond cond) {
		return riskIndexShowVWDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RiskIndexShowVWInfo> searchRiskIndexShowVW(
			RiskIndexShowVWSearchCond cond) {
		return riskIndexShowVWDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskIndexShowVWInfo> searchRiskIndexShowVW(
			RiskIndexShowVWSearchCond cond, int start,
			int count) {
		return riskIndexShowVWDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public RiskIndexShowVWInfo registRiskIndexShowVW(RiskIndexShowVWInfo instance)
		throws BLException {
		return riskIndexShowVWDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public RiskIndexShowVWInfo updateRiskIndexShowVW(RiskIndexShowVWInfo instance)
		throws BLException {
		checkExistInstance(instance.getEsyscoding());
		return riskIndexShowVWDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteRiskIndexShowVWByPK(String pk)
		throws BLException {
		riskIndexShowVWDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteRiskIndexShowVW(RiskIndexShowVWInfo instance)
		throws BLException {
		riskIndexShowVWDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public RiskIndexShowVWInfo checkExistInstance(String pk)
		throws BLException {
		RiskIndexShowVWInfo instance = riskIndexShowVWDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}