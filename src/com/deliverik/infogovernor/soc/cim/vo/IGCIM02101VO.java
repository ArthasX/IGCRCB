/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0115Info;

/**
 * 概述: 控制台任务查看VO
 * 功能描述: 控制台任务查看VO
 * 创建记录: 2011/04/29
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGCIM02101VO extends BaseVO implements Serializable{
	
	/** 控制台任务列表 */
	protected SOC0115Info eiWaitTask;
	
	/**
	 * 构造函数
	 * @param eiWaitTask 控制台任务列表
	 */
	public IGCIM02101VO(SOC0115Info eiWaitTask) {
		this.eiWaitTask = eiWaitTask;
	}

	/**
	 * 控制台任务取得
	 * @return 控制台任务
	 */
	public SOC0115Info getEiWaitTask() {
		return eiWaitTask;
	}
}


