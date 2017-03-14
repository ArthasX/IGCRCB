/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.CITaskInfo;
import com.deliverik.framework.asset.model.CIWaitTaskInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * 概述: CI变更控制台显示VO
 * 功能描述: CI变更控制台显示VO
 * 创建记录: 2011/04/29
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGASM22011VO extends BaseVO implements Serializable{
	
	/** 配置导入任务列表 */
	protected List<CIWaitTaskInfo> ciWaitTaskList;
	
	/** 更新任务 */
	protected CITaskInfo ciTask;
	
	/**
	 * 构造函数
	 * @param ciWaitTaskList 配置导入任务列表
	 * @param ciTask 更新任务
	 */
	public IGASM22011VO(List<CIWaitTaskInfo> ciWaitTaskList, CITaskInfo ciTask) {
		this.ciWaitTaskList = ciWaitTaskList;
		this.ciTask = ciTask;
	}

	/**
	 * 配置导入任务列表取得
	 * @return 配置导入任务列表
	 */
	public List<CIWaitTaskInfo> getCiWaitTaskList() {
		return ciWaitTaskList;
	}

	/**
	 * 更新任务取得
	 * 
	 * @return 更新任务
	 */
	public CITaskInfo getCiTask() {
		return ciTask;
	}
	
	
}


