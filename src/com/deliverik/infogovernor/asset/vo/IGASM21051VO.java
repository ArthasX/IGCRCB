/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.asset.model.AuditTaskInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * 概述: 审计任务信息添加后信息VO
 * 功能描述: 审计任务信息添加后信息VO
 * 创建记录: 2011/05/019
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGASM21051VO extends BaseVO implements Serializable {
	
	/**审计任务添加后信息*/
	protected AuditTaskInfo auditTaskInfo;
	
	
	
	/**
	 * 构造函数
	 * @param auditTaskInfo审计任务添加后信息
	 */
	public IGASM21051VO(AuditTaskInfo auditTaskInfo) {
		super();
		this.auditTaskInfo = auditTaskInfo;
	}

	/**
	 * 审计任务添加后信息取得
	 * @return 审计任务添加后信息
	 */
	public AuditTaskInfo getAuditTaskInfo() {
		return auditTaskInfo;
	}

	/**
	 * 审计任务添加后信息设定
	 * @param auditTaskInfo审计任务添加后信息
	 */
	public void setAuditTaskInfo(AuditTaskInfo auditTaskInfo) {
		this.auditTaskInfo = auditTaskInfo;
	}
	
	

}
