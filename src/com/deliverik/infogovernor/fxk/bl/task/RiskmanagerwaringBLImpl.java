/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.fxk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.fxk.model.RiskmanagerwaringInfo;
import com.deliverik.infogovernor.fxk.model.condition.RiskmanagerwaringSearchCond;
import com.deliverik.infogovernor.fxk.model.dao.RiskmanagerwaringDAO;
import com.deliverik.infogovernor.fxk.model.entity.RiskmanagerwaringTB;

/**
  * ����: ���չ�����ʾ���ݱ�ҵ���߼�ʵ��
  * ��������: ���չ�����ʾ���ݱ�ҵ���߼�ʵ��
  * ������¼: 2014/06/17
  * �޸ļ�¼: 
  */
public class RiskmanagerwaringBLImpl extends BaseBLImpl implements
		RiskmanagerwaringBL {

	/** ���չ�����ʾ���ݱ�DAO�ӿ� */
	protected RiskmanagerwaringDAO riskmanagerwaringDAO;
	
	/**
	 * ���չ�����ʾ���ݱ�DAO�ӿ��趨
	 *
	 * @param riskmanagerwaringDAO ���չ�����ʾ���ݱ�DAO�ӿ�
	 */
	public void setRiskmanagerwaringDAO(RiskmanagerwaringDAO riskmanagerwaringDAO) {
		this.riskmanagerwaringDAO = riskmanagerwaringDAO;
	}

	/**
	 * ���չ�����ʾ���ݱ�ʵ��ȡ��
	 *
	 * @return ���չ�����ʾ���ݱ�ʵ��
	 */
	public RiskmanagerwaringTB getRiskmanagerwaringTBInstance() {
		return new RiskmanagerwaringTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskmanagerwaringInfo> searchRiskmanagerwaring() {
		return riskmanagerwaringDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskmanagerwaringInfo searchRiskmanagerwaringByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(RiskmanagerwaringSearchCond cond) {
		return riskmanagerwaringDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RiskmanagerwaringInfo> searchRiskmanagerwaring(
			RiskmanagerwaringSearchCond cond) {
		return riskmanagerwaringDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskmanagerwaringInfo> searchRiskmanagerwaring(
			RiskmanagerwaringSearchCond cond, int start,
			int count) {
		return riskmanagerwaringDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public RiskmanagerwaringInfo registRiskmanagerwaring(RiskmanagerwaringInfo instance)
		throws BLException {
		return riskmanagerwaringDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public RiskmanagerwaringInfo updateRiskmanagerwaring(RiskmanagerwaringInfo instance)
		throws BLException {
		checkExistInstance(instance.getRwid());
		return riskmanagerwaringDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteRiskmanagerwaringByPK(Integer pk)
		throws BLException {
		riskmanagerwaringDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteRiskmanagerwaring(RiskmanagerwaringInfo instance)
		throws BLException {
		riskmanagerwaringDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public RiskmanagerwaringInfo checkExistInstance(Integer pk)
		throws BLException {
		RiskmanagerwaringInfo instance = riskmanagerwaringDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}