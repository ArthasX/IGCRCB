/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.vo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.infogovernor.risk.model.RiskAuditDef;

/**
 * 审计项信息检索结果ＶＯ
 * 
 * @author maozhipeng@deliverik.com
 *
 */
@SuppressWarnings("serial")
public class IGRIS01051VO extends BaseVO implements Serializable{
	
	/** 审计版本信息检索结果 */
	protected List<RiskAuditDef> riskAuditDefList;
	
	/** 审计版本详细信息 */
	protected RiskAuditDef riskAuditDef;
	
	/**审计项树*/
	protected Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();

	public IGRIS01051VO() {
		
	}
	/**
	 * 构造函数
	 * @param riskAuditDef　审计项信息检索结果
	 */
	public IGRIS01051VO(List<RiskAuditDef> riskAuditDefList) {
		this.riskAuditDefList = riskAuditDefList;
	}
	
	
	/**
	 * 审计项信息检索结果取得
	 * @return 审计项信息检索结果
	 */

	public List<RiskAuditDef> getRiskAuditDefList() {
		return riskAuditDefList;
	}
	
	/**
	 * 审计项详细信息取得
	 * @return 审计项详细信息结果
	 */
	public RiskAuditDef getRiskAuditDef() {
		return riskAuditDef;
	}
	/**
	 * 审计项详细信息设定
	 * @param 审计项详细信息结果
	 */
	public void setRiskAuditDef(RiskAuditDef riskAuditDef) {
		this.riskAuditDef = riskAuditDef;
	}
	/**
	 * 审计项树信息检索结果取得
	 * @return 审计项树信息检索结果
	 */
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	/**
	 * 审计项信息检索结果设定
	 * @param treeNodeMap
	 */
	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}

}


