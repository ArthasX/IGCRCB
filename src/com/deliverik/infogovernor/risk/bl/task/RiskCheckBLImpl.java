/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.risk.model.RiskCheck;
import com.deliverik.infogovernor.risk.model.condition.RiskCheckSearchCond;
import com.deliverik.infogovernor.risk.model.dao.RiskCheckDAO;

/**
 * 
 * ���ռ����Ϣҵ���߼��ӿ�
 * @author liupeng@deliverik.com
 *
 */
public class RiskCheckBLImpl extends BaseBLImpl implements RiskCheckBL{
	
	/** RiskCheck DAO */
	protected RiskCheckDAO riskCheckDAO;
	
	public void setRiskCheckDAO(
			RiskCheckDAO riskCheckDAO) {
		this.riskCheckDAO = riskCheckDAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(RiskCheckSearchCond cond){
		
		return riskCheckDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param rcid ���ռ����ϢID
	 * @return ���ռ����Ϣ
	 */
	public RiskCheck searchRiskCheckByKey(Integer rcid) throws BLException{
		
		return checkExistRiskCheck(rcid);
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ�����ռ����Ϣ��Ϣ
	 */
	public List<RiskCheck> searchRiskCheckAll(){
		
		return riskCheckDAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskCheck> searchRiskCheck(RiskCheckSearchCond cond, int start, int count){
		
		return riskCheckDAO.findByCond(cond,start,count);
	}

	/**
	 * ��¼����
	 * 
	 * @param riskCheck ��¼����
	 * @return ���ռ����Ϣ
	 */
	public RiskCheck registRiskCheck(RiskCheck riskCheck) throws BLException{
		
		return riskCheckDAO.save(riskCheck);
	}

	/**
	 * ɾ������
	 * 
	 * @param rcid ���ռ����ϢID
	 * @return
	 */
	public void deleteRiskCheck(Integer rcid) throws BLException{
		
		RiskCheck riskCheck = checkExistRiskCheck(rcid);
		
		riskCheckDAO.delete(riskCheck);
	}

	/**
	 * �������
	 * 
	 * @param riskCheck �������
	 * @return ���ռ����Ϣ
	 */
	public RiskCheck updateRiskCheck(RiskCheck riskCheck) throws BLException{
		
		checkExistRiskCheck(riskCheck.getRcid());
		return riskCheckDAO.save(riskCheck);
	}

	/**
	 * ���ռ����Ϣ���ڼ��
	 * 
	 * @param rcid ���ռ����ϢID
	 * @return ���ռ����Ϣ
	 * @throws BLException 
	 */
	protected RiskCheck checkExistRiskCheck(Integer rcid) throws BLException{
		RiskCheck info = riskCheckDAO.findByPK(rcid);
//		if( info == null) {
//			throw new BLException("IGCO10000.E004","���ռ�����");
//		}
		return info;
	}

	public List<RiskCheck> dbmselByrcclass() throws BLException {
		return riskCheckDAO.dbmselByrcclass();
	}

	public List<RiskCheck> getRcclassByMonth(final RiskCheckSearchCond cond) throws BLException {
		// TODO Auto-generated method stub
		return riskCheckDAO.getRcclassByMonth(cond);
	}

	public List<RiskCheck> getRcTestMode(RiskCheckSearchCond cond)
			throws BLException {
		// TODO Auto-generated method stub
		return riskCheckDAO.getRcTestMode(cond);
	}

	
}
