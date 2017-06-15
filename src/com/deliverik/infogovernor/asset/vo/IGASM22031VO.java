/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.asset.model.CIWaitTaskInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * 概述: CI变更控制台任务查看VO
 * 功能描述: CI变更控制台任务查看VO
 * 创建记录: 2011/04/29
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGASM22031VO extends BaseVO implements Serializable{
	
	/** CI变更控制台任务列表 */
	protected CIWaitTaskInfo ciWaitTask;
	
	/**
	 * 构造函数
	 * @param ciWaitTask CI变更控制台任务列表
	 */
	public IGASM22031VO(CIWaitTaskInfo ciWaitTask) {
		this.ciWaitTask = ciWaitTask;
	}

	/**
	 * CI变更控制台任务取得
	 * @return CI变更控制台任务
	 */
	public CIWaitTaskInfo getCiWaitTask() {
		return ciWaitTask;
	}
}


