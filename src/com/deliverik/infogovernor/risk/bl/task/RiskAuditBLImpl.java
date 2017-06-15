/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.risk.bl.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.risk.bl.IGRISCONSTANTS;
import com.deliverik.infogovernor.risk.model.RiskAudit;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditSearchCond;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditSearchCondImpl;
import com.deliverik.infogovernor.risk.model.dao.RiskAuditDAO;

/**
 * 
 * 审计信息业务逻辑接口
 * @author liupeng@deliverik.com
 *
 */
public class RiskAuditBLImpl extends BaseBLImpl implements RiskAuditBL{
	
	/** RiskAudit DAO */
	protected RiskAuditDAO riskAuditDAO;
	
	public void setRiskAuditDAO(
			RiskAuditDAO riskAuditDAO) {
		this.riskAuditDAO = riskAuditDAO;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(RiskAuditSearchCond cond){
		
		return riskAuditDAO.getSearchCount(cond);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param raid 审计信息ID
	 * @return 审计信息
	 */
	public RiskAudit searchRiskAuditByKey(Integer raid) throws BLException{
		
		return checkExistRiskAudit(raid);
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部审计信息信息
	 */
	public List<RiskAudit> searchRiskAuditAll(){
		
		return riskAuditDAO.findAll();
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskAudit> searchRiskAudit(RiskAuditSearchCond cond, int start, int count){
		
		return riskAuditDAO.findByCond(cond,start,count);
	}

	/**
	 * 登录处理
	 * 
	 * @param riskAudit 登录数据
	 * @return 审计信息
	 */
	public RiskAudit registRiskAudit(RiskAudit riskAudit) throws BLException{
		
		checkNotExistRiskAudit(riskAudit.getRaversion());
		
		return riskAuditDAO.save(riskAudit);
	}

	/**
	 * 删除处理
	 * 
	 * @param raid 审计信息ID
	 * @return
	 */
	public void deleteRiskAudit(Integer raid) throws BLException{
		
		RiskAudit riskAudit = checkExistRiskAudit(raid);
		
		riskAuditDAO.delete(riskAudit);
	}

	/**
	 * 变更处理
	 * 
	 * @param riskAudit 变更数据
	 * @return 审计信息
	 */
	public RiskAudit updateRiskAudit(RiskAudit riskAudit) throws BLException{
		
		checkExistRiskAudit(riskAudit.getRaid());
		return riskAuditDAO.save(riskAudit);
	}

	/**
	 * 审计信息存在检查
	 * 
	 * @param raid 审计信息ID
	 * @return 审计信息
	 * @throws BLException 
	 */
	protected RiskAudit checkExistRiskAudit(Integer raid) throws BLException{
		RiskAudit info = riskAuditDAO.findByPK(raid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","审计基本");
		}
		return info;
	}
	
	/**
	 * 校验版本名称是否存在
	 * 
	 * @param raversion 版本名称
	 * @return
	 * @throws BLException 
	 */
	private void checkNotExistRiskAudit(String raversion) throws BLException{
		RiskAuditSearchCondImpl cond = new RiskAuditSearchCondImpl();
		
		cond.setRaversion(raversion);
		
		List<RiskAudit> raList = riskAuditDAO.findByCond(cond, 0, 0);
		if( raList != null && raList.size()>0 ) {
			throw new BLException("IGRIS0102.E001");
		}
	}
	
	/**
	 * 版本下拉列表查询
	 * 
	 * @return 版本下拉列表
	 */
	public List<LabelValueBean> searchRiskAuditLabelInUse() {
		RiskAuditSearchCondImpl cond = new RiskAuditSearchCondImpl();
		
		cond.setRastatus(IGRISCONSTANTS.RISKAUDIT_STATUS_ENABLE);
		
		List<RiskAudit> raList = riskAuditDAO.findByCond(cond,0,0);
		
		List<LabelValueBean> labelList= new ArrayList<LabelValueBean>();
		
		labelList.add(new LabelValueBean("",""));
		
		for(RiskAudit ra : raList) {
			labelList.add(new LabelValueBean(ra.getRaversion(),ra.getRaid().toString()));
		}
		
		return labelList;
	}
	
	/**
	 * 获取当前最大版本根标识
	 * @return 最大版本根标识
	 */
	
	public String getMaxRacode() {
		return riskAuditDAO.getMaxRacode();
	}
}
