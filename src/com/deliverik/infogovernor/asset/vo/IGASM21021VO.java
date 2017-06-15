package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.AuditResultInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * 审计对比结果检索结果ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM21021VO extends BaseVO implements Serializable{
	
	/** 审计对比结果检索结果 */
	protected List<AuditResultInfo> auditResultList;

	/**
	 * 审计对比结果检索结果取得
	 * @return 审计对比结果检索结果
	 */
	public List<AuditResultInfo> getAuditResultList() {
		return auditResultList;
	}

	/**
	 * 审计对比结果检索结果设置
	 * @param auditResultList 审计对比结果检索结果
	 */
	public void setAuditResultList(List<AuditResultInfo> auditResultList) {
		this.auditResultList = auditResultList;
	}
}


