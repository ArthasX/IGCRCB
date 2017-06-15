/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sta.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.prr.model.entity.DispatchStatisticsVW;
import com.deliverik.infogovernor.sta.model.RiskCheckProblemSuperviseVWInfo;
import com.deliverik.infogovernor.sta.model.condition.RiskCheckProblemSuperviseVWSearchCond;
import com.deliverik.infogovernor.sta.model.dao.RiskCheckProblemSuperviseVWDAO;

/**
  * ����: �������ļලҵ���߼�ʵ��
  * ��������: �������ļලҵ���߼�ʵ��
  * ������¼: 2013/02/27
  * �޸ļ�¼: 
  */
public class RiskCheckProblemSuperviseVWBLImpl extends BaseBLImpl implements
	RiskCheckProblemSuperviseVWBL {

	/** ��������ͳ��DAO�ӿ� */
	protected RiskCheckProblemSuperviseVWDAO riskcheckproblemsuperviseVWDAO;
	
	/**
	 * ��������ͳ��DAO�ӿ��趨
	 *
	 * @param riskcheckproblemsuperviseVWDAO ��������ͳ��DAO�ӿ�
	 */
	public void setriskcheckproblemsuperviseVWDAO(RiskCheckProblemSuperviseVWDAO riskcheckproblemsuperviseVWDAO) {
		this.riskcheckproblemsuperviseVWDAO = riskcheckproblemsuperviseVWDAO;
	}

	/**
	 * ��������ͳ��ʵ��ȡ��
	 *
	 * @return ��������ͳ��ʵ��
	 */
	public DispatchStatisticsVW getDispatchStatisticsVWTBInstance() {
		return new DispatchStatisticsVW();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskCheckProblemSuperviseVWInfo> searchDispatchStatisticsVW() {
		return riskcheckproblemsuperviseVWDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskCheckProblemSuperviseVWInfo searchDispatchStatisticsVWByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(RiskCheckProblemSuperviseVWSearchCond cond) {
		return riskcheckproblemsuperviseVWDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RiskCheckProblemSuperviseVWInfo> searchDispatchStatisticsVW(
			RiskCheckProblemSuperviseVWSearchCond cond) {
		return riskcheckproblemsuperviseVWDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskCheckProblemSuperviseVWInfo> searchDispatchStatisticsVW(
			RiskCheckProblemSuperviseVWSearchCond cond, int start,
			int count) {
		return riskcheckproblemsuperviseVWDAO.findByCond(cond, start, count);
	}
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskCheckProblemSuperviseVWInfo> findDispatchStatisticsVW(
			RiskCheckProblemSuperviseVWSearchCond cond, int start,
			int count) {
		return riskcheckproblemsuperviseVWDAO.findRiskCheckProblemSupervise(cond, start, count);
	}
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getRiskCheckProblemSuperviseSearchCount(RiskCheckProblemSuperviseVWSearchCond cond) {
		return riskcheckproblemsuperviseVWDAO.findRiskCheckProblemSuperviseSearchCount(cond);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public RiskCheckProblemSuperviseVWInfo checkExistInstance(String pk)
		throws BLException {
		RiskCheckProblemSuperviseVWInfo instance = riskcheckproblemsuperviseVWDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}