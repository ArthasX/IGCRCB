/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.AuditTaskInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * 概述: 审计任务信息检索结果ＶＯ
 * 功能描述: 审计任务信息检索结果ＶＯ
 * 创建记录: 2011/05/19
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGASM21071VO extends BaseVO implements Serializable {
	
	/** 审计任务检索结果 */
	protected List<AuditTaskInfo> auditTaskInfoList;

	
	/**
	 * 构造函数
	 * @param auditTaskInfoList审计任务检索结果
	 */
	public IGASM21071VO(List<AuditTaskInfo> auditTaskInfoList) {
		super();
		this.auditTaskInfoList = auditTaskInfoList;
	}

	/**
	 * 审计任务检索结果取得
	 * @return 审计任务检索结果
	 */
	public List<AuditTaskInfo> getAuditTaskInfoList() {
		return auditTaskInfoList;
	}

	/**
	 * 审计任务检索结果设定
	 * @param auditTaskInfoList审计任务检索结果
	 */
	public void setAuditTaskInfoList(List<AuditTaskInfo> auditTaskInfoList) {
		this.auditTaskInfoList = auditTaskInfoList;
	}
	
	
	
	
	
}
