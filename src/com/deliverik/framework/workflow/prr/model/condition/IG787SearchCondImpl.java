/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.condition;

/**
 * <p>概述:流程共通变量视图查询条件实现</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */
public class IG787SearchCondImpl implements IG787SearchCond {


	/**
	 * 流程记录ID
	 */
	protected Integer prid;
	
	/**
	 * 共通变量ID
	 */
	protected Integer pidgid;
	
	/**
	 * 功能：流程记录ID取得
	 * @return 流程记录ID
	 */
	public Integer getPidgid() {
		return pidgid;
	}
	
	/**
	 * 功能：流程记录ID设置
	 * @param pidgid
	 */
	public void setPidgid(Integer pidgid) {
		this.pidgid = pidgid;
	}

	/**
	 * 功能：共通变量ID取得
	 * @return 共通变量ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 功能：共通变量ID设置
	 * @param prid
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	
	
	
}
