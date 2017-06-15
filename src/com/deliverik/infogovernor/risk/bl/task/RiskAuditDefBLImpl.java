/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * 审计项信息业务逻辑接口
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
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(RiskAuditDefSearchCond cond){
		
		return riskAuditDefDAO.getSearchCount(cond);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param radid 审计项信息ID
	 * @return 审计项信息
	 */
	public RiskAuditDef searchRiskAuditDefByKey(Integer radid) throws BLException{
		
		return checkExistRiskAuditDef(radid);
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部审计项信息信息
	 */
	public List<RiskAuditDef> searchRiskAuditDefAll(){
		
		return riskAuditDefDAO.findAll();
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskAuditDef> searchRiskAuditDef(RiskAuditDefSearchCond cond, int start, int count){
		
		return riskAuditDefDAO.findByCond(cond,start,count);
	}

	/**
	 * 登录处理
	 * 
	 * @param riskAuditDef 登录数据
	 * @return 审计项信息
	 */
	public RiskAuditDef registRiskAuditDef(RiskAuditDef riskAuditDef) throws BLException{
		
		return riskAuditDefDAO.save(riskAuditDef);
	}

	/**
	 * 删除处理
	 * 
	 * @param radid 审计项信息ID
	 * @return
	 */
	public void deleteRiskAuditDef(Integer radid) throws BLException{
		
		RiskAuditDef riskAuditDef = checkExistRiskAuditDef(radid);
		
		riskAuditDefDAO.delete(riskAuditDef);
	}

	/**
	 * 变更处理
	 * 
	 * @param riskAuditDef 变更数据
	 * @return 审计项信息
	 */
	public RiskAuditDef updateRiskAuditDef(RiskAuditDef riskAuditDef) throws BLException{
		checkExistRiskAuditDef(riskAuditDef.getRadid());
		return riskAuditDefDAO.save(riskAuditDef);
	}

	/**
	 * 审计项信息存在检查
	 * 
	 * @param radid 审计项信息ID
	 * @return 审计项信息
	 * @throws BLException 
	 */
	protected RiskAuditDef checkExistRiskAuditDef(Integer radid) throws BLException{
		RiskAuditDef info = riskAuditDefDAO.findByPK(radid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","审计项基本");
		}
		return info;
	}
}
