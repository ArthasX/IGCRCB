/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.plugin.change.model.condition;

/**
  * 概述: 发起变更流程日志检索条件实现
  * 功能描述: 发起变更流程日志检索条件实现
  * 创建记录: 2015/07/02
  * 修改记录: 
  */
public class InitiateChangLogSearchCondImpl implements
		InitiateChangLogSearchCond {

	/**流程ID*/
	protected int prid;

	/**
	 * 流程ID取得
	 * @return prid 流程ID
	 */
	
	public int getPrid() {
		return prid;
	}

	/**
	 * 流程ID设定
	 * @param prid 流程ID
	 */
	public void setPrid(int prid) {
		this.prid = prid;
	}
	
	
}