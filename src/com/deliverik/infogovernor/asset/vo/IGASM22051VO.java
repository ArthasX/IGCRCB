/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.asset.model.CITaskInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * 概述: CI变更任务信息添加后信息VO
 * 功能描述: CI变更任务信息添加后信息VO
 * 创建记录: 2011/05/019
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGASM22051VO extends BaseVO implements Serializable {
	
	/**CI变更任务添加后信息*/
	protected CITaskInfo ciTaskInfo;
	
	
	
	/**
	 * 构造函数
	 * @param ciTaskInfoCI变更任务添加后信息
	 */
	public IGASM22051VO(CITaskInfo ciTaskInfo) {
		super();
		this.ciTaskInfo = ciTaskInfo;
	}

	/**
	 * CI变更任务添加后信息取得
	 * @return CI变更任务添加后信息
	 */
	public CITaskInfo getCiTaskInfo() {
		return ciTaskInfo;
	}

	/**
	 * CI变更任务添加后信息设定
	 * @param ciTaskInfoCI变更任务添加后信息
	 */
	public void setCITaskInfo(CITaskInfo ciTaskInfo) {
		this.ciTaskInfo = ciTaskInfo;
	}
	
	

}
