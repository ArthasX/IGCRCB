/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.AuditTaskInfo;
import com.deliverik.framework.asset.model.AuditWaitTaskInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * 概述: 审计控制台显示VO
 * 功能描述: 审计控制台显示VO
 * 创建记录: 2011/04/29
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGASM21011VO extends BaseVO implements Serializable{
	
	/** 配置导入任务列表 */
	protected List<AuditWaitTaskInfo> auditWaitTaskList;
	
	/** 审计任务 */
	protected AuditTaskInfo auditTask;
	
	/**
	 * 构造函数
	 * @param auditWaitTaskList 配置导入任务列表
	 * @param auditTask 审计任务
	 */
	public IGASM21011VO(List<AuditWaitTaskInfo> auditWaitTaskList,
			AuditTaskInfo auditTask) {
		this.auditWaitTaskList = auditWaitTaskList;
		this.auditTask = auditTask;
	}

	/**
	 * 配置导入任务列表取得
	 * @return 配置导入任务列表
	 */
	public List<AuditWaitTaskInfo> getAuditWaitTaskList() {
		return auditWaitTaskList;
	}

	/**
	 * 审计任务
	 * @return 审计任务
	 */
	public AuditTaskInfo getAuditTask() {
		return auditTask;
	}
	
}


