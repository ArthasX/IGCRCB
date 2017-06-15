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
import com.deliverik.infogovernor.risk.model.RiskAuditIns;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditInsSearchCond;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditInsSearchCondImpl;
import com.deliverik.infogovernor.risk.model.dao.RiskAuditInsDAO;

/**
 * 
 * 审计发起信息业务逻辑接口
 * @author liupeng@deliverik.com
 *
 */
public class RiskAuditInsBLImpl extends BaseBLImpl implements RiskAuditInsBL{
	
	/** RiskAuditIns DAO */
	protected RiskAuditInsDAO riskAuditInsDAO;
	
	public void setRiskAuditInsDAO(
			RiskAuditInsDAO riskAuditInsDAO) {
		this.riskAuditInsDAO = riskAuditInsDAO;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(RiskAuditInsSearchCond cond){
		
		return riskAuditInsDAO.getSearchCount(cond);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param raiid 审计发起信息ID
	 * @return 审计发起信息
	 */
	public RiskAuditIns searchRiskAuditInsByKey(Integer raiid) throws BLException{
		
		return checkExistRiskAuditIns(raiid);
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部审计发起信息信息
	 */
	public List<RiskAuditIns> searchRiskAuditInsAll(){
		
		return riskAuditInsDAO.findAll();
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskAuditIns> searchRiskAuditIns(RiskAuditInsSearchCond cond, int start, int count){
		
		return riskAuditInsDAO.findByCond(cond,start,count);
	}

	/**
	 * 登录处理
	 * 
	 * @param riskAuditIns 登录数据
	 * @return 审计发起信息
	 */
	public RiskAuditIns registRiskAuditIns(RiskAuditIns riskAuditIns) throws BLException{
		
		checkNotExistRiskAuditIns(riskAuditIns.getRaicode());
		
		return riskAuditInsDAO.save(riskAuditIns);
	}

	/**
	 * 删除处理
	 * 
	 * @param raiid 审计发起信息ID
	 * @return
	 */
	public void deleteRiskAuditIns(Integer raiid) throws BLException{
		
		RiskAuditIns riskAuditIns = checkExistRiskAuditIns(raiid);
		
		riskAuditInsDAO.delete(riskAuditIns);
	}

	/**
	 * 变更处理
	 * 
	 * @param riskAuditIns 变更数据
	 * @return 审计发起信息
	 */
	public RiskAuditIns updateRiskAuditIns(RiskAuditIns riskAuditIns) throws BLException{
		
		checkExistRiskAuditIns(riskAuditIns.getRaiid());
		return riskAuditInsDAO.save(riskAuditIns);
	}

	/**
	 * 审计发起信息存在检查
	 * 
	 * @param raiid 审计发起信息ID
	 * @return 审计发起信息
	 * @throws BLException 
	 */
	protected RiskAuditIns checkExistRiskAuditIns(Integer raiid) throws BLException{
		RiskAuditIns info = riskAuditInsDAO.findByPK(raiid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","审计发起基本");
		}
		return info;
	}
	
	/**
	 * 校验编号是否存在
	 * 
	 * @param raicode 编号
	 * @return
	 * @throws BLException 
	 */
	private void checkNotExistRiskAuditIns(String raicode) throws BLException{
		RiskAuditInsSearchCondImpl cond = new RiskAuditInsSearchCondImpl();
		
		cond.setRaicode(raicode);
		
		List<RiskAuditIns> raiList = riskAuditInsDAO.findByCond(cond, 0, 0);
		if( raiList != null && raiList.size()>0 ) {
			throw new BLException("IGRIS0110.E001");
		}
	}

	/**
	 * 版本下拉列表查询
	 * 
	 * @return 版本下拉列表
	 */
	public List<LabelValueBean> searchRiskAuditInsLabelInUse() {
		RiskAuditInsSearchCondImpl cond = new RiskAuditInsSearchCondImpl();
		
		cond.setRaistatus(IGRISCONSTANTS.RISKAUDITINS_STATUS_ENABLE);
		
		List<RiskAuditIns> raiList = riskAuditInsDAO.findByCond(cond,0,0);
		List<LabelValueBean> labelList= new ArrayList<LabelValueBean>();
		
		labelList.add(new LabelValueBean("",""));
		
		for (RiskAuditIns riskAuditIns : raiList) {
			labelList.add(new LabelValueBean(riskAuditIns.getRaicode(),riskAuditIns.getRaiid().toString()));
			
		}		
		return labelList;
	}
}
