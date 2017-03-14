/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 缺省参与者按钮定义表检索条件实现
  * 功能描述: 缺省参与者按钮定义表检索条件实现
  * 创建记录: 2012/04/18
  * 修改记录: 
  */
public class IG725SearchCondImpl implements
		IG725SearchCond {
	
	/** 状态ID */
	public String psdid;
	
	/** 按钮ID */
	public String pbdid;
	
	/** 主键 */
	protected String pdbdid_like;

	/**
	 * 状态ID取得
	 *
	 * @return 状态ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 状态ID设定
	 *
	 *@param psdid 状态ID
	 * @return 状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 按钮ID取得
	 *
	 * @return 按钮ID
	 */
	public String getPbdid() {
		return pbdid;
	}

	/**
	 * 按钮ID设定
	 *
	 *@param pbdid 按钮ID
	 * @return 按钮ID
	 */
	public void setPbdid(String pbdid) {
		this.pbdid = pbdid;
	}

	/**
	 * 主键取得
	 * 
	 * @return 主键
	 */
	public String getPdbdid_like() {
		return pdbdid_like;
	}

	/**
	 * 主键设定
	 * 
	 * @param pdbdid_like 主键
	 */
	public void setPdbdid_like(String pdbdid_like) {
		this.pdbdid_like = pdbdid_like;
	}
	
}