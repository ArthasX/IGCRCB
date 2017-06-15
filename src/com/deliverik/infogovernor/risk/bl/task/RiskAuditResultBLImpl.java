/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.risk.model.RiskAuditResult;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditResultSearchCond;
import com.deliverik.infogovernor.risk.model.dao.RiskAuditResultDAO;

/**
 * 
 * ��ƽ����Ϣҵ���߼��ӿ�
 * @author liupeng@deliverik.com
 *
 */
public class RiskAuditResultBLImpl extends BaseBLImpl implements RiskAuditResultBL{
	
	/** RiskAuditResult DAO */
	protected RiskAuditResultDAO riskAuditResultDAO;
	
	public void setRiskAuditResultDAO(
			RiskAuditResultDAO riskAuditResultDAO) {
		this.riskAuditResultDAO = riskAuditResultDAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(RiskAuditResultSearchCond cond){
		
		return riskAuditResultDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param rarid ��ƽ����ϢID
	 * @return ��ƽ����Ϣ
	 */
	public RiskAuditResult searchRiskAuditResultByKey(Integer rarid) throws BLException{
		
		return checkExistRiskAuditResult(rarid);
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ����ƽ����Ϣ��Ϣ
	 */
	public List<RiskAuditResult> searchRiskAuditResultAll(){
		
		return riskAuditResultDAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskAuditResult> searchRiskAuditResult(RiskAuditResultSearchCond cond, int start, int count){
		
		return riskAuditResultDAO.findByCond(cond,start,count);
	}

	/**
	 * ��¼����
	 * 
	 * @param riskAuditResult ��¼����
	 * @return ��ƽ����Ϣ
	 */
	public RiskAuditResult registRiskAuditResult(RiskAuditResult riskAuditResult) throws BLException{
		
		return riskAuditResultDAO.save(riskAuditResult);
	}

	/**
	 * ɾ������
	 * 
	 * @param rarid ��ƽ����ϢID
	 * @return
	 */
	public void deleteRiskAuditResult(Integer rarid) throws BLException{
		
		RiskAuditResult riskAuditResult = checkExistRiskAuditResult(rarid);
		
		riskAuditResultDAO.delete(riskAuditResult);
	}

	/**
	 * �������
	 * 
	 * @param riskAuditResult �������
	 * @return ��ƽ����Ϣ
	 */
	public RiskAuditResult updateRiskAuditResult(RiskAuditResult riskAuditResult) throws BLException{
		
		checkExistRiskAuditResult(riskAuditResult.getRarid());
		return riskAuditResultDAO.save(riskAuditResult);
	}

	/**
	 * ��ƽ����Ϣ���ڼ��
	 * 
	 * @param rarid ��ƽ����ϢID
	 * @return ��ƽ����Ϣ
	 * @throws BLException 
	 */
	protected RiskAuditResult checkExistRiskAuditResult(Integer rarid) throws BLException{
		RiskAuditResult info = riskAuditResultDAO.findByPK(rarid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","��ƽ������");
		}
		return info;
	}
}
