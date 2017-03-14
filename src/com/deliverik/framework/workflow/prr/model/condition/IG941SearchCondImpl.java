/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
 * 服务工单日志查询条件实现
 */
public class IG941SearchCondImpl implements IG941SearchCond {
	
	/** 服务工单ID */
	protected Integer sfid;
	
	/**
	 * 服务工单ID取得
	 * 
	 * @return 服务工单ID
	 */
	public Integer getSfid() {
		return sfid;
	}

	/**
	 * 服务工单ID设定
	 * @param sfid 服务工单ID
	 */
	public void setSfid(Integer sfid) {
		this.sfid = sfid;
	}
}
