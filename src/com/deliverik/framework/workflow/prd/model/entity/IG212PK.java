/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * 概述: 流程通知策略实体主键
  * 功能描述: 流程通知策略实体主键
  * 创建记录: 2012/04/24
  * 修改记录: 
  */
@SuppressWarnings("serial")
public class IG212PK extends BasePK implements Serializable {

	/** 状态ID */
	protected String psdid;
	
	/** 是否确认 */
	protected String psdconfirm;

	/**
	 * 构造函数
	 */
	public IG212PK() {

	}

	/**
	 * 构造函数
	 */
	public IG212PK(String psdid, String psdconfirm) {
		super();
		this.psdid = psdid;
		this.psdconfirm = psdconfirm;
	}

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
	 * @param psdid 状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}
	
	/**
	 * 是否确认取得
	 *
	 * @return 是否确认
	 */
	public String getPsdconfirm() {
		return psdconfirm;
	}

	/**
	 * 是否确认设定
	 *
	 * @param psdconfirm 是否确认
	 */
	public void setPsdconfirm(String psdconfirm) {
		this.psdconfirm = psdconfirm;
	}
	
}