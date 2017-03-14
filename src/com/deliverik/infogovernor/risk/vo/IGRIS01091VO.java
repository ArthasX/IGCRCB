/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.risk.model.RiskAuditIns;

/**
 * 审计发起信息检索结果ＶＯ
 * 
 * @author liupeng@deliverik.com
 *
 */
@SuppressWarnings("serial")
public class IGRIS01091VO extends BaseVO implements Serializable{
	
	/** 审计发起信息检索结果 */
	protected List<RiskAuditIns> riskAuditInsList;

	/**
	 * 构造函数
	 * @param riskAuditIns　审计发起信息检索结果
	 */
	public IGRIS01091VO(List<RiskAuditIns> riskAuditInsList) {
		this.riskAuditInsList = riskAuditInsList;
	}
	
	/**
	 * 审计发起信息检索结果取得
	 * @return 审计发起信息检索结果
	 */
	public List<RiskAuditIns> getRiskAuditInsList() {
		return riskAuditInsList;
	}

}


