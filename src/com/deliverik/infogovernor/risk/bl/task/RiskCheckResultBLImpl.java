/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;
import com.deliverik.infogovernor.risk.model.condition.RiskCheckResultSearchCond;
import com.deliverik.infogovernor.risk.model.condition.RiskCheckResultSearchCondImpl;
import com.deliverik.infogovernor.risk.model.dao.RiskCheckResultDAO;

/**
 * 
 * ���ռ������Ϣҵ���߼��ӿ�
 * @author liupeng@deliverik.com
 *
 */
public class RiskCheckResultBLImpl extends BaseBLImpl implements RiskCheckResultBL{
	
	/** RiskCheckResult DAO */
	protected RiskCheckResultDAO riskCheckResultDAO;
	
	public void setRiskCheckResultDAO(
			RiskCheckResultDAO riskCheckResultDAO) {
		this.riskCheckResultDAO = riskCheckResultDAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(RiskCheckResultSearchCond cond){
		
		return riskCheckResultDAO.getSearchCount(cond);
	}
	
	/**
	 * �����������(�ٷֱ�)����ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCountForRate(RiskCheckResultSearchCond cond){
		
		return riskCheckResultDAO.getSearchCountForRate(cond);
	}

	/**
	 * ������������
	 * 
	 * @param rcrid ���ռ������ϢID
	 * @return ���ռ������Ϣ
	 */
	public RiskCheckResult searchRiskCheckResultByKey(Integer rcrid) throws BLException{
		
		return checkExistRiskCheckResult(rcrid);
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ�����ռ������Ϣ��Ϣ
	 */
	public List<RiskCheckResult> searchRiskCheckResultAll(){
		
		return riskCheckResultDAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskCheckResult> searchRiskCheckResult(RiskCheckResultSearchCond cond, int start, int count){
		
		return riskCheckResultDAO.findByCond(cond,start,count);
	}
	
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskCheckResult> findResultByCond(RiskCheckResultSearchCond cond, int start, int count){
		
		return riskCheckResultDAO.findResultByCond(cond,start,count);
	}

	/**
	 * ��¼����
	 * 
	 * @param riskCheckResult ��¼����
	 * @return ���ռ������Ϣ
	 */
	public RiskCheckResult registRiskCheckResult(RiskCheckResult riskCheckResult) throws BLException{
		
		return riskCheckResultDAO.save(riskCheckResult);
	}

	/**
	 * ɾ������
	 * 
	 * @param rcrid ���ռ������ϢID
	 * @return
	 */
	public void deleteRiskCheckResult(Integer rcrid) throws BLException{
		
		RiskCheckResult riskCheckResult = checkExistRiskCheckResult(rcrid);
		
		riskCheckResultDAO.delete(riskCheckResult);
	}

	/**
	 * �������
	 * 
	 * @param riskCheckResult �������
	 * @return ���ռ������Ϣ
	 */
	public RiskCheckResult updateRiskCheckResult(RiskCheckResult riskCheckResult) throws BLException{
		
		checkExistRiskCheckResult(riskCheckResult.getRcrid());
		return riskCheckResultDAO.save(riskCheckResult);
	}

	/**
	 * ���ռ������Ϣ���ڼ��
	 * 
	 * @param rcrid ���ռ������ϢID
	 * @return ���ռ������Ϣ
	 * @throws BLException 
	 */
	protected RiskCheckResult checkExistRiskCheckResult(Integer rcrid) throws BLException{
		RiskCheckResult info = riskCheckResultDAO.findByPK(rcrid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","���ռ��������");
		}
		return info;
	}
	
	/**
	 * ��ҳ��鹤����ѯ
	 * @param userid ��ѯ�û�ID
	 * @param desc �Ƿ�ʱ�䵹������
	 * @param group �Ƿ��ѯ��ؼ�鹤����Ϣ(true:��;flase:��) 
	 * @return ��������б�
	 */
	public List<RiskCheckResult> riskCheckResultGoup(String userid, boolean desc, boolean group){
		
		return riskCheckResultDAO.riskCheckResultGoup(userid, desc, group);
		
	}
	
	public List<RiskCheckResult> sel(RiskCheckResultSearchCondImpl cond, int start, int count){
		
		return riskCheckResultDAO.sel(cond,start,count);
	}
	public List<RiskCheckResult> dbmrcrsel(String year){
		return riskCheckResultDAO.dbmrcrsel("2014");
	}

	public List<RiskCheckResult> getRiskCheckResult(RiskCheckResultSearchCond cond) {
		return riskCheckResultDAO.getRiskCheckResult(cond);
	}
	
}
