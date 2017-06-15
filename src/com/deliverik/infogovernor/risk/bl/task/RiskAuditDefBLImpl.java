/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.risk.model.RiskAuditDef;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditDefSearchCond;
import com.deliverik.infogovernor.risk.model.dao.RiskAuditDefDAO;

/**
 * 
 * �������Ϣҵ���߼��ӿ�
 * @author liupeng@deliverik.com
 *
 */
public class RiskAuditDefBLImpl extends BaseBLImpl implements RiskAuditDefBL{
	
	/** RiskAuditDef DAO */
	protected RiskAuditDefDAO riskAuditDefDAO;
	
	public void setRiskAuditDefDAO(
			RiskAuditDefDAO riskAuditDefDAO) {
		this.riskAuditDefDAO = riskAuditDefDAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(RiskAuditDefSearchCond cond){
		
		return riskAuditDefDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param radid �������ϢID
	 * @return �������Ϣ
	 */
	public RiskAuditDef searchRiskAuditDefByKey(Integer radid) throws BLException{
		
		return checkExistRiskAuditDef(radid);
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ���������Ϣ��Ϣ
	 */
	public List<RiskAuditDef> searchRiskAuditDefAll(){
		
		return riskAuditDefDAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskAuditDef> searchRiskAuditDef(RiskAuditDefSearchCond cond, int start, int count){
		
		return riskAuditDefDAO.findByCond(cond,start,count);
	}

	/**
	 * ��¼����
	 * 
	 * @param riskAuditDef ��¼����
	 * @return �������Ϣ
	 */
	public RiskAuditDef registRiskAuditDef(RiskAuditDef riskAuditDef) throws BLException{
		
		return riskAuditDefDAO.save(riskAuditDef);
	}

	/**
	 * ɾ������
	 * 
	 * @param radid �������ϢID
	 * @return
	 */
	public void deleteRiskAuditDef(Integer radid) throws BLException{
		
		RiskAuditDef riskAuditDef = checkExistRiskAuditDef(radid);
		
		riskAuditDefDAO.delete(riskAuditDef);
	}

	/**
	 * �������
	 * 
	 * @param riskAuditDef �������
	 * @return �������Ϣ
	 */
	public RiskAuditDef updateRiskAuditDef(RiskAuditDef riskAuditDef) throws BLException{
		checkExistRiskAuditDef(riskAuditDef.getRadid());
		return riskAuditDefDAO.save(riskAuditDef);
	}

	/**
	 * �������Ϣ���ڼ��
	 * 
	 * @param radid �������ϢID
	 * @return �������Ϣ
	 * @throws BLException 
	 */
	protected RiskAuditDef checkExistRiskAuditDef(Integer radid) throws BLException{
		RiskAuditDef info = riskAuditDefDAO.findByPK(radid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","��������");
		}
		return info;
	}
}
