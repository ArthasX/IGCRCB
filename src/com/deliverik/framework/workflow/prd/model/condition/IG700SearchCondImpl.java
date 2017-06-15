/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 流程查看角色配置表检索条件实现
  * 功能描述: 流程查看角色配置表检索条件实现
  * 创建记录: 2012/10/15
  * 修改记录: 
  */
public class IG700SearchCondImpl implements
		IG700SearchCond {
	
	/** 流程定义ID */
	private String pdid;

	/**
	 * 流程定义ID取得
	 * @return
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 * @return
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
	
	

}