/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * 风险检查信息业务逻辑接口
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
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(RiskCheckSearchCond cond){
		
		return riskCheckDAO.getSearchCount(cond);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param rcid 风险检查信息ID
	 * @return 风险检查信息
	 */
	public RiskCheck searchRiskCheckByKey(Integer rcid) throws BLException{
		
		return checkExistRiskCheck(rcid);
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部风险检查信息信息
	 */
	public List<RiskCheck> searchRiskCheckAll(){
		
		return riskCheckDAO.findAll();
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskCheck> searchRiskCheck(RiskCheckSearchCond cond, int start, int count){
		
		return riskCheckDAO.findByCond(cond,start,count);
	}

	/**
	 * 登录处理
	 * 
	 * @param riskCheck 登录数据
	 * @return 风险检查信息
	 */
	public RiskCheck registRiskCheck(RiskCheck riskCheck) throws BLException{
		
		return riskCheckDAO.save(riskCheck);
	}

	/**
	 * 删除处理
	 * 
	 * @param rcid 风险检查信息ID
	 * @return
	 */
	public void deleteRiskCheck(Integer rcid) throws BLException{
		
		RiskCheck riskCheck = checkExistRiskCheck(rcid);
		
		riskCheckDAO.delete(riskCheck);
	}

	/**
	 * 变更处理
	 * 
	 * @param riskCheck 变更数据
	 * @return 风险检查信息
	 */
	public RiskCheck updateRiskCheck(RiskCheck riskCheck) throws BLException{
		
		checkExistRiskCheck(riskCheck.getRcid());
		return riskCheckDAO.save(riskCheck);
	}

	/**
	 * 风险检查信息存在检查
	 * 
	 * @param rcid 风险检查信息ID
	 * @return 风险检查信息
	 * @throws BLException 
	 */
	protected RiskCheck checkExistRiskCheck(Integer rcid) throws BLException{
		RiskCheck info = riskCheckDAO.findByPK(rcid);
//		if( info == null) {
//			throw new BLException("IGCO10000.E004","风险检查基本");
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
