/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.risk.model.RiskAudit;

/**
 * 审计版本信息检索结果ＶＯ
 * 
 * @author liupeng@deliverik.com
 *
 */
@SuppressWarnings("serial")
public class IGRIS01011VO extends BaseVO implements Serializable{
	
	/** 审计版本信息检索结果 */
	protected List<RiskAudit> riskAuditList;

	/**
	 * 构造函数
	 * @param riskAudit　审计版本信息检索结果
	 */
	public IGRIS01011VO(List<RiskAudit> riskAuditList) {
		this.riskAuditList = riskAuditList;
	}
	
	/**
	 * 审计版本信息检索结果取得
	 * @return 审计版本信息检索结果
	 */
	public List<RiskAudit> getRiskAuditList() {
		return riskAuditList;
	}

}


