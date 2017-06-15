/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.risk.model.RiskCheck;
import com.deliverik.infogovernor.risk.model.condition.RiskCheckSearchCond;

/**
 * 
 * ���ռ����Ϣҵ���߼��ӿ�
 * @author liupeng@deliverik.com
 *
 */
public interface RiskCheckBL extends BaseBL{
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(RiskCheckSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param rcid ���ռ����ϢID
	 * @return ���ռ����Ϣ
	 */
	public RiskCheck searchRiskCheckByKey(Integer rcid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ�����ռ����Ϣ��Ϣ
	 */
	public List<RiskCheck> searchRiskCheckAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskCheck> searchRiskCheck(RiskCheckSearchCond cond, int start, int count);

	/**
	 * ��¼����
	 * 
	 * @param RiskCheck ��¼����
	 * @return ���ռ����Ϣ
	 */
	public RiskCheck registRiskCheck(RiskCheck riskCheck) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param rcid ���ռ����ϢID
	 * @return
	 */
	public void deleteRiskCheck(Integer rcid) throws BLException;

	/**
	 * �������
	 * 
	 * @param riskCheck �������
	 * @return ���ռ����Ϣ
	 */
	public RiskCheck updateRiskCheck(RiskCheck riskCheck) throws BLException;
	public List<RiskCheck> dbmselByrcclass() throws BLException;
	public List<RiskCheck> getRcclassByMonth(final RiskCheckSearchCond cond)  throws BLException;
	public List<RiskCheck> getRcTestMode (final RiskCheckSearchCond cond)  throws BLException;
}
