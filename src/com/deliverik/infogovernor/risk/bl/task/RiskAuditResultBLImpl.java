/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * 审计结果信息业务逻辑接口
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
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(RiskAuditResultSearchCond cond){
		
		return riskAuditResultDAO.getSearchCount(cond);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param rarid 审计结果信息ID
	 * @return 审计结果信息
	 */
	public RiskAuditResult searchRiskAuditResultByKey(Integer rarid) throws BLException{
		
		return checkExistRiskAuditResult(rarid);
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部审计结果信息信息
	 */
	public List<RiskAuditResult> searchRiskAuditResultAll(){
		
		return riskAuditResultDAO.findAll();
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskAuditResult> searchRiskAuditResult(RiskAuditResultSearchCond cond, int start, int count){
		
		return riskAuditResultDAO.findByCond(cond,start,count);
	}

	/**
	 * 登录处理
	 * 
	 * @param riskAuditResult 登录数据
	 * @return 审计结果信息
	 */
	public RiskAuditResult registRiskAuditResult(RiskAuditResult riskAuditResult) throws BLException{
		
		return riskAuditResultDAO.save(riskAuditResult);
	}

	/**
	 * 删除处理
	 * 
	 * @param rarid 审计结果信息ID
	 * @return
	 */
	public void deleteRiskAuditResult(Integer rarid) throws BLException{
		
		RiskAuditResult riskAuditResult = checkExistRiskAuditResult(rarid);
		
		riskAuditResultDAO.delete(riskAuditResult);
	}

	/**
	 * 变更处理
	 * 
	 * @param riskAuditResult 变更数据
	 * @return 审计结果信息
	 */
	public RiskAuditResult updateRiskAuditResult(RiskAuditResult riskAuditResult) throws BLException{
		
		checkExistRiskAuditResult(riskAuditResult.getRarid());
		return riskAuditResultDAO.save(riskAuditResult);
	}

	/**
	 * 审计结果信息存在检查
	 * 
	 * @param rarid 审计结果信息ID
	 * @return 审计结果信息
	 * @throws BLException 
	 */
	protected RiskAuditResult checkExistRiskAuditResult(Integer rarid) throws BLException{
		RiskAuditResult info = riskAuditResultDAO.findByPK(rarid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","审计结果基本");
		}
		return info;
	}
}
