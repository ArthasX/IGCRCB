/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 流程查看角色授权表单表检索条件实现
  * 功能描述: 流程查看角色授权表单表检索条件实现
  * 创建记录: 2012/10/15
  * 修改记录: 
  */
public class IG701SearchCondImpl implements
		IG701SearchCond {
	
	/** 流程定义ID */
	protected String pdid;

	/** 角色ID */
	protected Integer roleid;

	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	
	

}