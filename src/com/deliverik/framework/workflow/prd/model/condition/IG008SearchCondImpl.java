/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 人员表单角色限定检索条件实现
  * 功能描述: 人员表单角色限定检索条件实现
  * 创建记录: 2013/11/27
  * 修改记录: 
  */
public class IG008SearchCondImpl implements IG008SearchCond {

	/** 表单定义主键 */
	protected String pidid;
	
	/** 流程定义主键 */
	protected String pdid;

	/**
	 * 表单定义主键取得
	 * @return pidid 表单定义主键
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * 表单定义主键设定
	 * @param pidid 表单定义主键
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * 流程定义主键取得
	 * @return pdid 流程定义主键
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义主键设定
	 * @param pdid 流程定义主键
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
}