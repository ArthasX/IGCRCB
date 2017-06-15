/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.fxk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.fxk.model.RiskprojectvwInfo;
import com.deliverik.infogovernor.fxk.model.condition.RiskprojectvwSearchCond;
import com.deliverik.infogovernor.fxk.model.dao.RiskprojectvwDAO;
import com.deliverik.infogovernor.fxk.model.entity.RiskprojectvwTB;

/**
  * ����: ͨѶ¼ҵ���߼�ʵ��
  * ��������: ͨѶ¼ҵ���߼�ʵ��
  * ������¼: 2014/07/24
  * �޸ļ�¼: 
  */
public class RiskprojectvwBLImpl extends BaseBLImpl implements
		RiskprojectvwBL {

	/** ͨѶ¼DAO�ӿ� */
	protected RiskprojectvwDAO riskprojectvwDAO;
	
	/**
	 * ͨѶ¼DAO�ӿ��趨
	 *
	 * @param riskprojectvwDAO ͨѶ¼DAO�ӿ�
	 */
	public void setRiskprojectvwDAO(RiskprojectvwDAO riskprojectvwDAO) {
		this.riskprojectvwDAO = riskprojectvwDAO;
	}

	/**
	 * ͨѶ¼ʵ��ȡ��
	 *
	 * @return ͨѶ¼ʵ��
	 */
	public RiskprojectvwTB getRiskprojectvwTBInstance() {
		return new RiskprojectvwTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskprojectvwInfo> searchRiskprojectvw() {
		return riskprojectvwDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskprojectvwInfo searchRiskprojectvwByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(RiskprojectvwSearchCond cond) {
		return riskprojectvwDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RiskprojectvwInfo> searchRiskprojectvw(
			RiskprojectvwSearchCond cond) {
		return riskprojectvwDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskprojectvwInfo> searchRiskprojectvw(
			RiskprojectvwSearchCond cond, int start,
			int count) {
		return riskprojectvwDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public RiskprojectvwInfo registRiskprojectvw(RiskprojectvwInfo instance)
		throws BLException {
		return riskprojectvwDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public RiskprojectvwInfo updateRiskprojectvw(RiskprojectvwInfo instance)
		throws BLException {
		checkExistInstance(instance.getPrid ());
		return riskprojectvwDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteRiskprojectvwByPK(Integer pk)
		throws BLException {
		riskprojectvwDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteRiskprojectvw(RiskprojectvwInfo instance)
		throws BLException {
		riskprojectvwDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public RiskprojectvwInfo checkExistInstance(Integer pk)
		throws BLException {
		RiskprojectvwInfo instance = riskprojectvwDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}