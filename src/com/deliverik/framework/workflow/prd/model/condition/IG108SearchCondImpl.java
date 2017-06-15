/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 自定义流程表单查询条件定义表检索条件实现
  * 功能描述: 自定义流程表单查询条件定义表检索条件实现
  * 创建记录: 2013/03/13
  * 修改记录: 
  */
public class IG108SearchCondImpl implements IG108SearchCond {

	/** 流程类型主键 */
	protected String pdid;

	/**
	 * 流程类型主键取得
	 * @return 流程类型主键
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程类型主键设定
	 * @param pdid 流程类型主键
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
}