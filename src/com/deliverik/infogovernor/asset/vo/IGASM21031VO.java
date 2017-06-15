/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.asset.model.AuditWaitTaskInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * 概述: 审计控制台任务查看VO
 * 功能描述: 审计控制台任务查看VO
 * 创建记录: 2011/04/29
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGASM21031VO extends BaseVO implements Serializable{
	
	/** 审计控制台任务列表 */
	protected AuditWaitTaskInfo auditWaitTask;
	
	/**
	 * 构造函数
	 * @param auditWaitTask 审计控制台任务列表
	 */
	public IGASM21031VO(AuditWaitTaskInfo auditWaitTask) {
		this.auditWaitTask = auditWaitTask;
	}

	/**
	 * 审计控制台任务取得
	 * @return 审计控制台任务
	 */
	public AuditWaitTaskInfo getAuditWaitTask() {
		return auditWaitTask;
	}
}


