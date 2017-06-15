/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.asset.model.EiWaitTaskInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * 概述: 控制台任务查看VO
 * 功能描述: 控制台任务查看VO
 * 创建记录: 2011/04/29
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGASM20101VO extends BaseVO implements Serializable{
	
	/** 控制台任务列表 */
	protected EiWaitTaskInfo eiWaitTask;
	
	/**
	 * 构造函数
	 * @param eiWaitTask 控制台任务列表
	 */
	public IGASM20101VO(EiWaitTaskInfo eiWaitTask) {
		this.eiWaitTask = eiWaitTask;
	}

	/**
	 * 控制台任务取得
	 * @return 控制台任务
	 */
	public EiWaitTaskInfo getEiWaitTask() {
		return eiWaitTask;
	}
}


