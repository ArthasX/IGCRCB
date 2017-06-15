/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.EiWaitTaskInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * 概述: 控制台显示VO
 * 功能描述: 控制台显示VO
 * 创建记录: 2011/04/29
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGASM20011VO extends BaseVO implements Serializable{
	
	/** 配置导入任务列表 */
	protected List<EiWaitTaskInfo> eiWaitTaskList;
	
	/**
	 * 构造函数
	 * @param eiWaitTaskList 配置导入任务列表
	 */
	public IGASM20011VO(List<EiWaitTaskInfo> eiWaitTaskList) {
		this.eiWaitTaskList = eiWaitTaskList;
	}

	/**
	 * 配置导入任务列表取得
	 * @return 配置导入任务列表
	 */
	public List<EiWaitTaskInfo> getEiWaitTaskList() {
		return eiWaitTaskList;
	}
}


