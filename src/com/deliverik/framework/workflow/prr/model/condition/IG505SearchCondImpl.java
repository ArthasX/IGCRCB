/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
  * 概述: 流程表单值表检索条件实现
  * 功能描述: 流程表单值表检索条件实现
  * 创建记录: 2013/08/28
  * 修改记录: 
  */
public class IG505SearchCondImpl implements IG505SearchCond {

	/** 流程主键 */
	protected Integer prid;

	/**
	 * 流程主键取得
	 * @return prid 流程主键
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程主键设定
	 * @param prid 流程主键
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
}