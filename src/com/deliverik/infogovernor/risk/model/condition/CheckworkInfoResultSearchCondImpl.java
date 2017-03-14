/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.risk.model.condition;

import java.io.Serializable;

/**
  * 概述: 检查工作检查任务关联表检索条件实现
  * 功能描述: 检查工作检查任务关联表检索条件实现
  * 创建记录: 2014/09/02
  * 修改记录: 
  */
public class CheckworkInfoResultSearchCondImpl implements
		CheckworkInfoResultSearchCond {

	
	protected Integer cwirid;

	/** 检查任务id */
	protected Integer cwrid;

	/** 检查工作id */
	protected Integer rcrid;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getCwirid() {
		return cwirid;
	}

	/**
	 * 主键设定
	 *
	 * @param cwirid 主键
	 */
	public void setCwirid(Integer cwirid) {
		this.cwirid = cwirid;
	}

	/**
	 * 检查任务id取得
	 *
	 * @return 检查任务id
	 */
	public Integer getCwrid() {
		return cwrid;
	}

	/**
	 * 检查任务id设定
	 *
	 * @param cwrid 检查任务id
	 */
	public void setCwrid(Integer cwrid) {
		this.cwrid = cwrid;
	}

	/**
	 * 检查工作id取得
	 *
	 * @return 检查工作id
	 */
	public Integer getRcrid() {
		return rcrid;
	}

	/**
	 * 检查工作id设定
	 *
	 * @param rcrid 检查工作id
	 */
	public void setRcrid(Integer rcrid) {
		this.rcrid = rcrid;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return cwirid;
	}

	
}