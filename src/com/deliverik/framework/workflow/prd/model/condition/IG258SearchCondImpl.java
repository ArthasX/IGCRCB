/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 流程状态参与者调整检索条件实现
  * 功能描述: 流程状态参与者调整检索条件实现
  * 创建记录: 2012/05/09
  * 修改记录: 
  */
public class IG258SearchCondImpl implements
		IG258SearchCond {
	/** 主键 */
	protected String pspcdid;

	/** 当前状态ID */
	protected String psdid;

	/** 可改变状态ID */
	protected String pspcdpsdid;
	
	/** 可改变状态ID */
	protected String pspcdid_like;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public String getPspcdid() {
		return pspcdid;
	}

	/**
	 * 主键设定
	 *
	 * @param pspcdid 主键
	 */
	public void setPspcdid(String pspcdid) {
		this.pspcdid = pspcdid;
	}

	/**
	 * 当前状态ID取得
	 *
	 * @return 当前状态ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 当前状态ID设定
	 *
	 * @param psdid 当前状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 可改变状态ID取得
	 *
	 * @return 可改变状态ID
	 */
	public String getPspcdpsdid() {
		return pspcdpsdid;
	}

	/**
	 * 可改变状态ID设定
	 *
	 * @param pspcdpsdid 可改变状态id
	 */
	public void setPspcdpsdid(String pspcdpsdid) {
		this.pspcdpsdid = pspcdpsdid;
	}

	/**
	 * 主键取得
	 * 
	 * @return 主键
	 */
	public String getPspcdid_like() {
		return pspcdid_like;
	}

	/**
	 * 主键设定
	 * 
	 * @param pspcdid_like 主键
	 */
	public void setPspcdid_like(String pspcdid_like) {
		this.pspcdid_like = pspcdid_like;
	}
	
}